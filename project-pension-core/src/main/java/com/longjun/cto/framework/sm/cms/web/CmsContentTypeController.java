package com.longjun.cto.framework.sm.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentTypeModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentTypeView;
import com.longjun.cto.framework.sm.cms.service.ICmsContentTypeService;

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

import java.lang.Long;

/**
 * CmsContentType Controller
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@RequestMapping("/mgn/sm/cms/cmsContentType")
@Controller
public class CmsContentTypeController extends StandardBaseController {

	@Autowired
	ICmsContentTypeService iCmsContentTypeService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsContentTypeListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsContentTypeListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContentType/cmsContentTypeListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsContentTypeAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsContentTypeAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContentType/cmsContentTypeAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsContentTypeEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsContentTypeEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContentType/cmsContentTypeEditInit");
		CmsContentTypeView ret = this.iCmsContentTypeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsContentTypeShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsContentTypeShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContentType/cmsContentTypeShowInit");
		CmsContentTypeView ret = this.iCmsContentTypeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CmsContentTypeView>> getByPage(CmsContentTypeDto dto){
		PageUtils<CmsContentTypeView> ret = this.iCmsContentTypeService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CmsContentTypeView> getViewById(Long id){
		CmsContentTypeView ret = this.iCmsContentTypeService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CmsContentTypeModel> findModelById(Long id){
		CmsContentTypeModel ret = this.iCmsContentTypeService.findModelById(id);
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
		Boolean ret = this.iCmsContentTypeService.stop(id);
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
		Boolean ret = this.iCmsContentTypeService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CmsContentTypeModel model){
		this.iCmsContentTypeService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CmsContentTypeModifyDto model){
		this.iCmsContentTypeService.modify(model);
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
		Boolean ret = this.iCmsContentTypeService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
