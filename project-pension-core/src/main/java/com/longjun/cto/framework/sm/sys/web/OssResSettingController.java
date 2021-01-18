package com.longjun.cto.framework.sm.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResSettingDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResSettingModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResSettingModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSettingView;
import com.longjun.cto.framework.sm.sys.service.IOssResSettingService;

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
 * OssResSetting Controller
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
@RequestMapping("/mgn/sys/ossResSetting")
@Controller
public class OssResSettingController extends StandardBaseController {

	@Autowired
	IOssResSettingService iOssResSettingService;
	
	
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResSettingListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResSettingListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/ossResSetting/ossResSettingListInit");
		List<OssResSettingModel> firstSettings = this.iOssResSettingService.listByPid(0L);//顶级分类
		model.addObject("firstSettings", firstSettings);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResSettingAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResSettingAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/ossResSetting/ossResSettingAddInit");
		List<OssResSettingModel> firstSettings = this.iOssResSettingService.listByPid(0L);//顶级分类
		model.addObject("firstSettings", firstSettings);
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResSettingEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResSettingEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/ossResSetting/ossResSettingEditInit");
		OssResSettingView ret = this.iOssResSettingService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResSettingShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResSettingShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/ossResSetting/ossResSettingShowInit");
		OssResSettingView ret = this.iOssResSettingService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<OssResSettingView>> getByPage(OssResSettingDto dto){
		PageUtils<OssResSettingView> ret = this.iOssResSettingService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<OssResSettingView> getViewById(long id){
		OssResSettingView ret = this.iOssResSettingService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<OssResSettingModel> findModelById(long id){
		OssResSettingModel ret = this.iOssResSettingService.findModelById(id);
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
		Boolean ret = this.iOssResSettingService.stop(id);
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
		Boolean ret = this.iOssResSettingService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(OssResSettingModel model){
		this.iOssResSettingService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(OssResSettingModifyDto model){
		this.iOssResSettingService.modify(model);
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
		Boolean ret = this.iOssResSettingService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 通过PID查询
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listByPid" , method = {RequestMethod.POST , RequestMethod.GET})
	public ApiResult listByPid(long pId) {
		List<OssResSettingModel> rets = this.iOssResSettingService.listByPid(pId);
		return ApiResult.instance().ok("rets" , rets);
	}
	
}
