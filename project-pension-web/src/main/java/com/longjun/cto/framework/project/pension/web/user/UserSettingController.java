package com.longjun.cto.framework.project.pension.web.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.common.utils.security.AESUtil;
import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import com.longjun.cto.framework.project.pension.userManagement.entity.model.UsersModel;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;
import com.longjun.cto.framework.project.pension.userManagement.service.IUsersService;
import com.longjun.cto.framework.sm.sys.entity.es.CommonVerificationRetEnums;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonCityModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonWorldMapModel;
import com.longjun.cto.framework.sm.sys.service.ICommonAreaService;
import com.longjun.cto.framework.sm.sys.service.ICommonCityService;
import com.longjun.cto.framework.sm.sys.service.ICommonProvinceService;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationService;
import com.longjun.cto.framework.sm.sys.service.ICommonWorldMapService;

/**
 * 个人设置
 *
 */
@RequestMapping("/user")
@Controller
public class UserSettingController extends CqcWebBaseController {

	@Autowired
    private IUsersService iUsersService;
    @Autowired
    private ICommonWorldMapService iCommonWorldMapService;
    @Autowired
    private ICommonProvinceService iCommonProvinceService;
    @Autowired
    private ICommonCityService iCommonCityService;
    @Autowired
    private ICommonAreaService iCommonAreaService;
    @Autowired
    private ICommonVerificationService iCommonVerificationService;

    /**
     * 修改个人信息
     *
     * @return
     */
    @RequestMapping(value = "/editUserinfoInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView enterpriseRegistrationInit() {

        ModelAndView mav = getModelAndView("/web/user/editUserinfoInit");
        
        UsersView usersView = this.iUsersService.findViewById(this.currentUser().getId());
        mav.addObject("usersView",usersView);
        EntityWrapper<CommonWorldMapModel> worldWrapper = new EntityWrapper<CommonWorldMapModel>();
        worldWrapper.eq("status", 1);
        List<CommonWorldMapModel> world = this.iCommonWorldMapService.selectList(worldWrapper);
        mav.addObject("world", world);
        if(usersView.getCountry().equals("CHN")){//中国
        	Wrapper<CommonProvinceModel> provinceWrapper = new EntityWrapper<CommonProvinceModel>();
        	provinceWrapper.eq("status", 1);
        	List<CommonProvinceModel> commonProvinces  = this.iCommonProvinceService.selectList(provinceWrapper);
        	mav.addObject("commonProvinces", commonProvinces);
        	
        	Wrapper<CommonCityModel> cityWrapper = new EntityWrapper<CommonCityModel>();
        	cityWrapper.eq("status", 1);
        	cityWrapper.eq("province_id", usersView.getProvince());
        	List<CommonCityModel> commonCitys  = this.iCommonCityService.selectList(cityWrapper);
        	mav.addObject("commonCitys", commonCitys);
        	
        	Wrapper<CommonAreaModel> areaWrapper = new EntityWrapper<CommonAreaModel>();
        	areaWrapper.eq("status", 1);
        	areaWrapper.eq("city_id", usersView.getCity());
        	List<CommonAreaModel> commonAreas  = this.iCommonAreaService.selectList(areaWrapper);
        	mav.addObject("commonAreas", commonAreas);
        }else{
        	mav.addObject("disabled", "disabled");
        	mav.addObject("commonProvinces", new ArrayList<CommonProvinceModel>());
        	mav.addObject("commonCitys", new ArrayList<CommonCityModel>());
        	mav.addObject("commonAreas", new ArrayList<CommonAreaModel>());
        }
        return mav;
    }

    /**
     * 修改用户
     * @param editUserinfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUserinfo", method = {RequestMethod.POST})
    public ApiResult editUserinfo(UsersModel usersModel) {
    	usersModel.setId(this.currentUser().getId());
        boolean result = iUsersService.updateById(usersModel);
        if (result) {
            return ApiResult.instance().ok("修改成功");
        }
        return ApiResult.instance().error("修改失败");
    }


    /**
     * 修改手机号码
     *
     * @return
     */
    @RequestMapping(value = "/editUserMobileInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editUserMobileInit() {
        ModelAndView mav = getModelAndView("/web/user/editUserMobileInit");
        return mav;
    }
    
    /**
     * 修改手机号码
     * @param mobile
     * @param verificationCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUserMobile", method = {RequestMethod.POST})
    public ApiResult editUserMobile(String mobile,String verificationCode) {
    	 CommonVerificationRetEnums e = iCommonVerificationService.vlidateSms(50000,mobile,verificationCode);
         switch (e) {
             case FAIL:
                 return ApiResult.instance().error(e.getMsg());
             case EXPRIRE:
                 return ApiResult.instance().error(e.getMsg());
         }
        UsersModel usersModel = new UsersModel();
    	usersModel.setId(this.currentUser().getId());
    	usersModel.setMobile(mobile);
        boolean result = iUsersService.updateById(usersModel);
        if (result) {
            return ApiResult.instance().ok("修改成功");
        }
        return ApiResult.instance().error("修改失败");
    }
    
    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/editUserPwdInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editUserPwdInit() {
        ModelAndView mav = getModelAndView("/web/user/editUserPwdInit");
    	mav.addObject("loginName", this.currentUser().getLoginName());
        return mav;
    }
    
    /**
     * 修改密码
     * @param oldPwd
     * @param pwd
     * @param confirmPwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUserPwd", method = {RequestMethod.POST})
    public ApiResult editUserPwd(String oldPwd,String pwd,String confirmPwd) {
    	if(!pwd.equals(confirmPwd)){
            return ApiResult.instance().error("确认密码和密码不一致");
    	}
    	if(!currentUser().getPassword().equalsIgnoreCase(AESUtil.encrypt(oldPwd))){
            return ApiResult.instance().error("原始密码错误");
    	}
        UsersModel usersModel = new UsersModel();
    	usersModel.setId(this.currentUser().getId());
    	usersModel.setPassword(AESUtil.encrypt(pwd));
        boolean result = iUsersService.updateById(usersModel);
        if (result) {
            return ApiResult.instance().ok("修改成功");
        }
        return ApiResult.instance().error("修改失败");
    }
    
    
    /**
     * 修改邮箱
     *
     * @return
     */
    @RequestMapping(value = "/editUserEmailInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editUserEmailInit() {
        ModelAndView mav = getModelAndView("/web/user/editUserEmailInit");
    	mav.addObject("loginName", this.currentUser().getLoginName());
        return mav;
    }
    
    /**
     * 修改邮箱
     * @param oldPwd
     * @param pwd
     * @param confirmPwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUserEmail", method = {RequestMethod.POST})
    public ApiResult editUserEmail(String email) {
        UsersModel usersModel = new UsersModel();
    	usersModel.setId(this.currentUser().getId());
    	usersModel.setUserEmail(email);
        boolean result = iUsersService.updateById(usersModel);
        if (result) {
            return ApiResult.instance().ok("修改成功");
        }
        return ApiResult.instance().error("修改失败");
    }
    
}
