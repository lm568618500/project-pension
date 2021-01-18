package com.longjun.cto.framework.sm.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonCityModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonAreaView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonCityView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProvinceView;
import com.longjun.cto.framework.sm.sys.service.ICommonAreaService;
import com.longjun.cto.framework.sm.sys.service.ICommonCityService;
import com.longjun.cto.framework.sm.sys.service.ICommonProvinceService;
import com.longjun.cto.framework.sm.users.entity.dto.UserAddressDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserAddressModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAddressModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAddressView;
import com.longjun.cto.framework.sm.users.service.IUserAddressService;

/**
 * UserAddress Controller
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
@RequestMapping("/mgn/sm/users/userAddress")
@Controller
public class UserAddressController extends StandardBaseController {

	@Autowired
	IUserAddressService iUserAddressService;
	@Autowired
	ICommonProvinceService iCommonProvinceService;
	@Autowired
	ICommonCityService iCommonCityService;
	@Autowired
	ICommonAreaService iCommonAreaService;
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAddressListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAddressListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAddress/userAddressListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAddressAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAddressAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAddress/userAddressAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAddressEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAddressEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAddress/userAddressEditInit");
		UserAddressView ret = this.iUserAddressService.findViewById(id);
		List<CommonProvinceModel> provincelist = this.iCommonProvinceService.listByUse();
		model.addObject("provincelist", provincelist);
		List<CommonCityModel> citylist = this.iCommonCityService.listByUseProvinceId(ret.getProvinceId());
		model.addObject("citylist", citylist);
		List<CommonAreaModel> arealist = this.iCommonAreaService.listByUseCityId(ret.getCityId());
		model.addObject("arealist", arealist);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAddressShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAddressShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAddress/userAddressShowInit");
		UserAddressView ret = this.iUserAddressService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserAddressView>> getByPage(UserAddressDto dto){
		PageUtils<UserAddressView> ret = this.iUserAddressService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserAddressView> getViewById(Long id){
		UserAddressView ret = this.iUserAddressService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserAddressModel> findModelById(Long id){
		UserAddressModel ret = this.iUserAddressService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(Long id){
		Boolean ret = this.iUserAddressService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(Long id ){
		Boolean ret = this.iUserAddressService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserAddressModel model){
		this.iUserAddressService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UserAddressModifyDto model){
		if(model.getIsDefault() ==1 ) {//设置默认地址
			UserAddressDto userAddressDto = new UserAddressDto();
			userAddressDto.setPageNum(1);
			userAddressDto.setPageSize(10);
			userAddressDto.setC_user_id(String.valueOf(model.getUserId()));
			List<UserAddressView> userAddressList =  iUserAddressService.getByPage(userAddressDto).getList();
			for (UserAddressView userAddressView : userAddressList) {
				if(userAddressView.getId() != model.getId()) {
					UserAddressModifyDto dto = new UserAddressModifyDto();
					dto.setId(userAddressView.getId());
					dto.setIsDefault(0);
					this.iUserAddressService.modify(dto);
				}
				
			}
		}
		this.iUserAddressService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(Long id){
		Boolean ret = this.iUserAddressService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
