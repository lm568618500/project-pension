package com.longjun.cto.framework.sm.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerView;
import com.longjun.cto.framework.sm.cms.service.ICmsBannerService;

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
 * CmsBanner Controller
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
@RequestMapping("/mgn/sm/cms/cmsBanner")
@Controller
public class CmsBannerController extends StandardBaseController {

	@Autowired
	ICmsBannerService iCmsBannerService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsBannerListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBanner/cmsBannerListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsBannerAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBanner/cmsBannerAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsBannerEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBanner/cmsBannerEditInit");
		CmsBannerView ret = this.iCmsBannerService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsBannerShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBanner/cmsBannerShowInit");
		CmsBannerView ret = this.iCmsBannerService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CmsBannerView>> getByPage(CmsBannerDto dto){
		PageUtils<CmsBannerView> ret = this.iCmsBannerService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CmsBannerView> getViewById(Long id){
		CmsBannerView ret = this.iCmsBannerService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CmsBannerModel> findModelById(Long id){
		CmsBannerModel ret = this.iCmsBannerService.findModelById(id);
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
		Boolean ret = this.iCmsBannerService.stop(id);
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
		Boolean ret = this.iCmsBannerService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CmsBannerModel model){
		this.iCmsBannerService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CmsBannerModifyDto model){
		this.iCmsBannerService.modify(model);
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
		Boolean ret = this.iCmsBannerService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
