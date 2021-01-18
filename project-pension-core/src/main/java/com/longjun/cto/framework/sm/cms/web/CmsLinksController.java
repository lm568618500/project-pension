package com.longjun.cto.framework.sm.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsLinksModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsLinksView;
import com.longjun.cto.framework.sm.cms.service.ICmsLinksService;
import com.longjun.cto.framework.sm.sys.annotation.Log;

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
 * CmsLinks Controller
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
@RequestMapping("/mgn/sm/cms/cmsLinks")
@Controller
public class CmsLinksController extends StandardBaseController {

	@Autowired
	ICmsLinksService iCmsLinksService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsLinksListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsLinksListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsLinks/cmsLinksListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsLinksAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsLinksAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsLinks/cmsLinksAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsLinksEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsLinksEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsLinks/cmsLinksEditInit");
		CmsLinksView ret = this.iCmsLinksService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsLinksShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsLinksShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsLinks/cmsLinksShowInit");
		CmsLinksView ret = this.iCmsLinksService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CmsLinksView>> getByPage(CmsLinksDto dto){
		PageUtils<CmsLinksView> ret = this.iCmsLinksService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CmsLinksView> getViewById(Long id){
		CmsLinksView ret = this.iCmsLinksService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CmsLinksModel> findModelById(Long id){
		CmsLinksModel ret = this.iCmsLinksService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1000001L)
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(Long id){
		Boolean ret = this.iCmsLinksService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1000002L)
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(Long id ){
		Boolean ret = this.iCmsLinksService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1000003L)
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CmsLinksModel model){
		this.iCmsLinksService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1000004L)
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CmsLinksModifyDto model){
		this.iCmsLinksService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1000005L)
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(Long id){
		Boolean ret = this.iCmsLinksService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
