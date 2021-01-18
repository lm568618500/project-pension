package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserTokenDto;
import com.longjun.cto.framework.sm.users.entity.model.UserTokenModel;
import com.longjun.cto.framework.sm.users.entity.view.UserTokenView;
import com.longjun.cto.framework.sm.users.service.IUserTokenService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;

/**
 * UserToken Controller
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
@RequestMapping("/mgn/users/token/userToken")
@Controller
public class UserTokenController extends StandardBaseController {

	@Autowired
	IUserTokenService iUserTokenService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userTokenListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userTokenListInit() {
		ModelAndView model = getModelAndView("/mgn/users/token/userToken/userTokenListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userTokenAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userTokenAddInit() {
		ModelAndView model = getModelAndView("/mgn/users/token/userToken/userTokenAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userTokenEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userTokenEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/users/token/userToken/userTokenEditInit");
		UserTokenView ret = this.iUserTokenService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userTokenShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userTokenShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/users/token/userToken/userTokenShowInit");
		UserTokenView ret = this.iUserTokenService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserTokenView>> getByPage(UserTokenDto dto){
		PageUtils<UserTokenView> ret = this.iUserTokenService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserTokenView> getViewById(long id){
		UserTokenView ret = this.iUserTokenService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserTokenModel> findModelById(long id){
		UserTokenModel ret = this.iUserTokenService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(long id){
		Boolean ret = this.iUserTokenService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(long id ){
		Boolean ret = this.iUserTokenService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserTokenModel model){
		this.iUserTokenService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id){
		Boolean ret = this.iUserTokenService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
