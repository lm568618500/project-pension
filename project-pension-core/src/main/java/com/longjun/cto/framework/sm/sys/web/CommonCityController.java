package com.longjun.cto.framework.sm.sys.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonCityModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonCityView;
import com.longjun.cto.framework.sm.sys.service.ICommonCityService;

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
 * CommonCity Controller
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@RequestMapping("/mgn/sys/common/city")
@Controller
public class CommonCityController extends StandardBaseController {

	@Autowired
	ICommonCityService iCommonCityService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonCityListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonCityListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/city/commonCityListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonCityAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonCityAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/city/commonCityAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonCityEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonCityEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/city/commonCityEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonCityShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonCityShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/city/commonCityShowInit");
		CommonCityView ret = this.iCommonCityService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonCityView>> getByPage(CommonCityDto dto){
		PageUtils<CommonCityView> ret = this.iCommonCityService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonCityView> getViewById(long id){
		CommonCityView ret = this.iCommonCityService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonCityModel> findModelById(long id){
		CommonCityModel ret = this.iCommonCityService.findModelById(id);
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
		Boolean ret = this.iCommonCityService.stop(id);
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
		Boolean ret = this.iCommonCityService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonCityModel model){
		this.iCommonCityService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonCityModifyDto model){
		this.iCommonCityService.modify(model);
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
		Boolean ret = this.iCommonCityService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 通用API接口查询-根据省Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCityByPId" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<Map<String,Object>>> getCityByPId(String proviceId){
		List<Map<String,Object>> ret = this.iCommonCityService.getCityByPId(proviceId);
		return ActionResult.ok(ret); 
	}
	
}
