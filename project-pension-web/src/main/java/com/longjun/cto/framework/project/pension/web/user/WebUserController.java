package com.longjun.cto.framework.project.pension.web.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.common.utils.pojoconverter.PojoConverter;
import com.longjun.cto.framework.common.utils.security.AESUtil;
import com.longjun.cto.framework.project.pension.base.CqcWebBaseController;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.EnterpriseRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.ForgetPasswordDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.PersonalRegistrationDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.SendVerificationCodeDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UserLoginDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.model.UsersModel;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;
import com.longjun.cto.framework.project.pension.userManagement.service.IUsersService;
import com.longjun.cto.framework.sm.sys.entity.dto.VerificationCodeSmsRetDto;
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

import me.zhyd.oauth.utils.IpUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 登录界面
 *
 * @author carson deng
 * @date 2019/11/9 15:06
 */
@RequestMapping("/web/user")
@Controller
public class WebUserController extends CqcWebBaseController {

    @Resource
    private IUsersService iUsersService;

    @Resource
    private PojoConverter pojoConverter;

    @Resource
    private ICommonVerificationService iCommonVerificationService;

    @Resource
    private ICommonWorldMapService iCommonWorldMapService;

    @Resource
    private ICommonProvinceService iCommonProvinceService;

    @Resource
    private ICommonCityService iCommonCityService;

    @Resource
    private ICommonAreaService iCommonAreaService;


    /**
     * 省份
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getProvince", method = {RequestMethod.POST})
    public ApiResult getProvince() {

        EntityWrapper<CommonProvinceModel> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        List<CommonProvinceModel> lstCommonProvinceModel = this.iCommonProvinceService.selectList(wrapper);

        Map<Long, Object> mapProvince = lstCommonProvinceModel.stream().collect(Collectors.toMap(CommonProvinceModel::getUseId, CommonProvinceModel::getName, (k1, k2) -> k1));

        return ApiResult.instance().ok("province", mapProvince);
    }

    /**
     * 城市
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCity", method = {RequestMethod.POST})
    public ApiResult getCity(@RequestBody Long provinceId) {

        EntityWrapper<CommonCityModel> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        wrapper.eq("province_id", provinceId);

        List<CommonCityModel> lstCommonCityModel = this.iCommonCityService.selectList(wrapper);

        Map<Long, Object> mapCity = lstCommonCityModel.stream().collect(Collectors.toMap(CommonCityModel::getUseId, CommonCityModel::getName, (k1, k2) -> k1));

        return ApiResult.instance().ok("city", mapCity);
    }

    /**
     * 区域
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getArea", method = {RequestMethod.POST})
    public ApiResult getArea(@RequestBody Long provinceId) {

        EntityWrapper<CommonAreaModel> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 1);
        wrapper.eq("city_id", provinceId);

        List<CommonAreaModel> lstCommonAreaModel = this.iCommonAreaService.selectList(wrapper);

        Map<Long, Object> mapCity = lstCommonAreaModel.stream().collect(Collectors.toMap(CommonAreaModel::getUseId, CommonAreaModel::getName, (k1, k2) -> k1));

        return ApiResult.instance().ok("area", mapCity);
    }


    /**
     * 登陆操作
     *
     * @param dto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ApiResult login(UserLoginDto dto, HttpServletRequest request) {

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("login_name", dto.getUserName());
        UsersModel ret = iUsersService.selectOne(ew);
        if (ret == null) {
            return ApiResult.instance().error("用户名错误");
        }

        //密码是否正确
        if (!ret.getPassword().equalsIgnoreCase(AESUtil.encrypt(dto.getPassword()))) {
            return ApiResult.instance().error("密码错误");
        }
        //帐号待审核中
        if (0 == ret.getAuditStatus()) {
            return ApiResult.instance().error("帐号待审核中");
        }
        //帐号审核不通过
        if (2 == ret.getAuditStatus()) {
            return ApiResult.instance().error("帐号审核不通过");
        }

        //是否禁用
        if (0 != ret.getStatus()) {
            return ApiResult.instance().error("帐号已禁止使用");
        }

        HttpSession httpSession = request.getSession();
        if (httpSession != null) {
            Object object = request.getSession().getAttribute(SESSION_KEY);

            if (object != null) {
                httpSession.removeAttribute(SESSION_KEY);
            }

            httpSession.setAttribute(SESSION_KEY, pojoConverter.convert(ret, UsersView.class));

            return ApiResult.instance().ok("redirectUrl", "/index");

        }

        return ApiResult.instance().error("登录失败");

    }

    /**
     * 个人注册
     *
     * @return
     */
    @RequestMapping(value = "/personalRegistrationInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView personalRegistrationInit() {

        ModelAndView mav = getModelAndView("/web/user/personalRegistration");

        return mav;
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @RequestMapping(value = "/forgetPasswordInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView forgetPasswordInit() {

        ModelAndView mav = getModelAndView("/web/user/forgetPassword");

        return mav;
    }


    /**
     * 企业注册
     *
     * @return
     */
    @RequestMapping(value = "/enterpriseRegistrationInit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView enterpriseRegistrationInit() {

        ModelAndView mav = getModelAndView("/web/user/enterpriseRegistration");

        EntityWrapper<CommonWorldMapModel> worldWrapper = new EntityWrapper<CommonWorldMapModel>();
        worldWrapper.eq("status", 1);
        List<CommonWorldMapModel> world = this.iCommonWorldMapService.selectList(worldWrapper);

        mav.addObject("world", world);
        return mav;
    }


    /**
     * 发送验证码
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sendVerificationCode", method = {RequestMethod.POST})
    public ApiResult sendVerificationCode(@RequestBody SendVerificationCodeDto sendVerificationCodeDto) {

        Integer codeType;
        if ("p".equals(sendVerificationCodeDto.getType())) {
            codeType = 20000;
        } else if ("e".equals(sendVerificationCodeDto.getType())) {
            codeType = 30000;
        } else if ("m".equals(sendVerificationCodeDto.getType())) {
            codeType = 40000;
        } else if ("x".equals(sendVerificationCodeDto.getType())) {
            codeType = 50000;
        } else {
            return ApiResult.instance().error("验证码码类型不正确");
        }

        VerificationCodeSmsRetDto verificationCodeSmsRetDto = iCommonVerificationService.createVerificationCodeSms(codeType, sendVerificationCodeDto.getMobile(), IpUtils.getIp());

        //TODO 调用短信接口
        return ApiResult.instance().ok("发送成功");

    }

    /**
     * 验证帐号是否存在
     *
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verificationAccount", method = {RequestMethod.POST})
    public ApiResult verificationAccount(@RequestBody String account) {

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("login_name", account);
        UsersModel ret = iUsersService.selectOne(ew);

        if (ret != null) {
            return ApiResult.instance().error("此账户已被注册");
        }

        return ApiResult.instance().ok("此账户可以注册");
    }


    /**
     * 验证手机是否存在
     *
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verificationMobile", method = {RequestMethod.POST})
    public ApiResult verificationMobile(@RequestBody String mobile) {

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("mobile", mobile);
        UsersModel ret = iUsersService.selectOne(ew);

        if (ret != null) {
            return ApiResult.instance().error("此手机已被注册");
        }

        return ApiResult.instance().ok("此手机可以注册");
    }


    /**
     * 个人用户注册
     *
     * @param personalRegistrationDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/personalRegistration", method = {RequestMethod.POST})
    public ApiResult personalRegistration(PersonalRegistrationDto personalRegistrationDto) {


        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("mobile", personalRegistrationDto.getMobile());
        UsersModel ret1 = iUsersService.selectOne(ew);

        if (ret1 != null) {
            log.error("个人注册,手机号已被注册 -> {}", personalRegistrationDto);
            return ApiResult.instance().error("此手机已被注册");
        }

        CommonVerificationRetEnums e = iCommonVerificationService.vlidateSms(20000, personalRegistrationDto.getMobile(), personalRegistrationDto.getVerificationCode());
        switch (e) {
            case FAIL:
                return ApiResult.instance().error(e.getMsg());
            case EXPRIRE:
                return ApiResult.instance().error(e.getMsg());
        }

        boolean result = iUsersService.register(personalRegistrationDto);

        if (result) {
            return ApiResult.instance().ok("redirectUrl", "/login");
        }

        return ApiResult.instance().error("注册失败");
    }


    /**
     * 企业用户注册
     *
     * @param enterpriseRegistrationDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/enterpriseRegistration", method = {RequestMethod.POST})
    public ApiResult enterpriseRegistration(EnterpriseRegistrationDto enterpriseRegistrationDto) {

        EntityWrapper ew = new EntityWrapper<>();
        ew.eq("is_del", 0);
        ew.eq("mobile", enterpriseRegistrationDto.getMobile());
        UsersModel ret1 = iUsersService.selectOne(ew);

        if (ret1 != null) {
            log.error("企业用户注册,手机号已被注册 -> {}", enterpriseRegistrationDto);
            return ApiResult.instance().error("此手机已被注册");
        }

        CommonVerificationRetEnums e = iCommonVerificationService.vlidateSms(30000, enterpriseRegistrationDto.getMobile(), enterpriseRegistrationDto.getVerificationCode());
        switch (e) {
            case FAIL:
                return ApiResult.instance().error(e.getMsg());
            case EXPRIRE:
                return ApiResult.instance().error(e.getMsg());
        }

        boolean result = iUsersService.register(enterpriseRegistrationDto);

        if (result) {
            return ApiResult.instance().ok("redirectUrl", "/login");
        }

        return ApiResult.instance().error("注册失败");
    }


    /**
     * 忘记密码
     *
     * @param forgetPasswordDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/forgetPassword", method = {RequestMethod.POST})
    public ApiResult forgetPassword(ForgetPasswordDto forgetPasswordDto) {


        CommonVerificationRetEnums e = iCommonVerificationService.vlidateSms(40000, forgetPasswordDto.getMobile(), forgetPasswordDto.getVerificationCode());
        switch (e) {
            case FAIL:
                return ApiResult.instance().error(e.getMsg());
            case EXPRIRE:
                return ApiResult.instance().error(e.getMsg());
        }

        boolean result = iUsersService.forgetPassword(forgetPasswordDto);

        if (result) {
            return ApiResult.instance().ok("redirectUrl", "/login");
        }

        return ApiResult.instance().error("修改密码失败");
    }

}
