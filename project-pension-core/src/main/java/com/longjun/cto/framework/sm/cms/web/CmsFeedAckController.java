package com.longjun.cto.framework.sm.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedAckModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedAckView;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedAckService;

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
 * CmsFeedAck Controller
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@RequestMapping("/mgn/sm/cms//cmsFeedAck")
@Controller
public class CmsFeedAckController extends StandardBaseController {

	@Autowired
	ICmsFeedAckService iCmsFeedAckService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedAckListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsFeedAckListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms//cmsFeedAck/cmsFeedAckListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedAckAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsFeedAckAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms//cmsFeedAck/cmsFeedAckAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedAckEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsFeedAckEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms//cmsFeedAck/cmsFeedAckEditInit");
		CmsFeedAckView ret = this.iCmsFeedAckService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedAckShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView cmsFeedAckShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms//cmsFeedAck/cmsFeedAckShowInit");
		CmsFeedAckView ret = this.iCmsFeedAckService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CmsFeedAckView>> getByPage(CmsFeedAckDto dto){
		PageUtils<CmsFeedAckView> ret = this.iCmsFeedAckService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CmsFeedAckView> getViewById(Long id){
		CmsFeedAckView ret = this.iCmsFeedAckService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CmsFeedAckModel> findModelById(Long id){
		CmsFeedAckModel ret = this.iCmsFeedAckService.findModelById(id);
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
		Boolean ret = this.iCmsFeedAckService.stop(id);
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
		Boolean ret = this.iCmsFeedAckService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CmsFeedAckModel model){
		this.iCmsFeedAckService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CmsFeedAckModifyDto model){
		this.iCmsFeedAckService.modify(model);
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
		Boolean ret = this.iCmsFeedAckService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
