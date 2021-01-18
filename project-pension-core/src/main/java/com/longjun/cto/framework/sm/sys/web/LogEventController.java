package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.LogEventDto;
import com.longjun.cto.framework.sm.sys.entity.dto.LogEventModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogEventView;
import com.longjun.cto.framework.sm.sys.service.ILogEventService;

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
 * LogEvent Controller
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
@RequestMapping("/mgn/sys/logEvent")
@Controller
public class LogEventController extends StandardBaseController {

	@Autowired
	ILogEventService iLogEventService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/logEventListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView logEventListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/logEvent/logEventListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/logEventAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView logEventAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/logEvent/logEventAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/logEventEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView logEventEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/logEvent/logEventEditInit");
		LogEventView ret = this.iLogEventService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/logEventShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView logEventShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/logEvent/logEventShowInit");
		LogEventView ret = this.iLogEventService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<LogEventView>> getByPage(LogEventDto dto){
		PageUtils<LogEventView> ret = this.iLogEventService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<LogEventView> getViewById(long id){
		LogEventView ret = this.iLogEventService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<LogEventModel> findModelById(long id){
		LogEventModel ret = this.iLogEventService.findModelById(id);
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
		Boolean ret = this.iLogEventService.stop(id);
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
		Boolean ret = this.iLogEventService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(LogEventModel model){
		this.iLogEventService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(LogEventModifyDto model){
		this.iLogEventService.modify(model);
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
		Boolean ret = this.iLogEventService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
