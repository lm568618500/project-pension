package com.longjun.cto.framework.sm.sys.web;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import com.longjun.cto.framework.sm.cms.service.IImageService;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminLoginDto;
import com.longjun.cto.framework.sm.sys.entity.es.CommonVerificationRetEnums;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.service.IAdminService;
import com.longjun.cto.framework.sm.sys.service.IAdminTokenService;
import com.longjun.cto.framework.sm.sys.service.IAuthResourcesService;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationService;

/**
 * 管理员平台登陆鉴权
 * 
 * @author yangxuan
 * @date 2018年11月6日 上午11:19:13
 */
@Controller
public class AdminLoginInitController extends SmBaseController {

	static String VALIDATE_CODE = "validateCode";

	@Autowired
	IAdminService iAdminService;
	
	@Autowired
	IAuthResourcesService iAuthResourcesService;
	
	@Autowired
	IAdminTokenService iAdminTokenService;
	
	@Autowired
	ICommonVerificationService iCommonVerificationService;
	
	@Autowired
	IImageService iImageService;

	/**
	 * 登陆页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/mgn/login")
	public ModelAndView loginInit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = getModelAndView("/common/mgn/login");
		//request.getSession().invalidate();//清空session
		//Cookie cookie = request.getCookies()[0];//获取cookie
		//cookie.setMaxAge(0);//让cookie过期
		return model;
	}

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@GetMapping("/mgn/genCaptcha")
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 将验证码放到HttpSession里面
//		request.getSession().setAttribute(VALIDATE_CODE, verifyCode);
		
		String codeVal = this.iCommonVerificationService.createVerificationCode(10000L, request.getSession().getId());
		
		log.info("本次生成的验证码为[" + codeVal + "],已存放到HttpSession中");
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(codeVal, 116, 36, 5, true,
				new Color(249, 205, 173), null, null);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

	@RequestMapping(value = "/403", method = { RequestMethod.GET })
	public ModelAndView login403(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = getModelAndView("/403");
		return model;
	}
	/**
	   * 响应图片
	   * @param request
	   * @param response
	   * @param model
	   * @param imageId
	   */
	  @RequestMapping(value = "/common/image", method = RequestMethod.GET)
	  public void image(WebRequest webRequest, HttpServletRequest request, HttpServletResponse response, 
	                    Long id, String uuid){
	    if(id == null && StringUtils.isBlank(uuid)){
	      return;
	    }
	    ImageModel image = null;
	    if(id != null){
	      image = iImageService.selectById(id);
	    }
	    if(StringUtils.isNotBlank(uuid)){
	      EntityWrapper<ImageModel> wrapper=new EntityWrapper<ImageModel>();
	      wrapper.eq("uuid", uuid);
	      image = iImageService.selectOne(wrapper);
	    }
	    File imageFile = new File(image.getStorePath());
	    //如下API会检查图片文件最后修改时间，并与请求头中的If-Modified-Since比对，如果相符会设置响应为304，且后续读取图片文件的代码就没必要再执行，提高性能
	    if(webRequest.checkNotModified(imageFile.lastModified())){
	      return;
	    }
	    try {
	      renderImage(response,new FileInputStream(imageFile),image.getContentType());
	    } catch (FileNotFoundException e) {
	    	 return;
	    }
	  }
	/**
	 * 登陆操作
	 * 
	 * @param uName
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mgn/login", method = { RequestMethod.POST })
	public ApiResult login(AdminLoginDto dto, HttpServletRequest request, HttpServletResponse response) {
		//验证码校验
		CommonVerificationRetEnums e = this.iCommonVerificationService.vlidate(10000L, request.getSession().getId(), dto.getCode().toLowerCase(), false);
		switch (e) {
		case FAIL:
			return ApiResult.instance().error("验证码错误");
		case EXPRIRE:
			return ApiResult.instance().error("验证码超时");
		}
		AdminModel ret = this.iAdminService.loginAction(dto);
		if (ret == null) {
			return ApiResult.instance().error("账号/密码错误");
		}
		if (ret.getStatus().intValue() == 0) {
			return ApiResult.instance().error("该账号已被锁定，请联系管理员");
		}
		//保存token
		String token = request.getSession().getId();
		iAdminTokenService.createToken(ret.getId(), token);
		return ApiResult.instance().ok("redirectUrl", "/mgn/index");
	}

	/**
	 * 后台首页main
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/mgn/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		AdminView admin = currentAdmin();
		ModelAndView model = getModelAndView("/common/mgn/main");
		model.addObject("admin", admin);
		List<AuthResourcesModel> topMenus = iAuthResourcesService.topMenus(admin.getId());
		model.addObject("topMenus", topMenus);
		return model;
	}
	
	/**
	 * 后台首页main
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/mgn/welcome")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
		AdminView admin = currentAdmin();
		ModelAndView model = getModelAndView("/common/mgn/welcome");
		return model;
	}


	/**
	 * 登出
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mgn/logout", method = { RequestMethod.GET })
	public String logout() {
		String key = webKit.getRequest().getSession().getId();
		long userId = 0;
		if (currentAdmin() != null) {
			userId = currentAdmin().getId();
		}
		this.iAdminService.logOut(key, userId);
		return "redirect:/mgn/login";
	}

}
