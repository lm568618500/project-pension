package com.longjun.cto.framework.sm.sys.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProvinceView;
import com.longjun.cto.framework.sm.sys.service.ICommonProvinceService;

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
 * CommonProvince Controller
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@RequestMapping("/mgn/sys/common/province")
@Controller
public class CommonProvinceController extends StandardBaseController {

	@Autowired
	ICommonProvinceService iCommonProvinceService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonProvinceListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonProvinceListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/province/commonProvinceListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonProvinceAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonProvinceAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/province/commonProvinceAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonProvinceEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonProvinceEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/province/commonProvinceEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonProvinceShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonProvinceShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/province/commonProvinceShowInit");
		CommonProvinceView ret = this.iCommonProvinceService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonProvinceView>> getByPage(CommonProvinceDto dto){
		PageUtils<CommonProvinceView> ret = this.iCommonProvinceService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonProvinceView> getViewById(long id){
		CommonProvinceView ret = this.iCommonProvinceService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonProvinceModel> findModelById(long id){
		CommonProvinceModel ret = this.iCommonProvinceService.findModelById(id);
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
		Boolean ret = this.iCommonProvinceService.stop(id);
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
		Boolean ret = this.iCommonProvinceService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonProvinceModel model){
		this.iCommonProvinceService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonProvinceModifyDto model){
		this.iCommonProvinceService.modify(model);
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
		Boolean ret = this.iCommonProvinceService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 通用API接口查询全部
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getProvice" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<Map<String,Object>>> getProvice(CommonProvinceDto dto){
		List<Map<String,Object>> ret = this.iCommonProvinceService.getProvice(dto);
		return ActionResult.ok(ret); 
	}
	
}
