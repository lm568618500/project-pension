package com.longjun.cto.framework.sm.message.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSmsDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSmsModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageSmsModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSmsView;
import com.longjun.cto.framework.sm.message.service.IMessageSmsService;
import com.longjun.cto.framework.sm.message.service.IMessageTempSmsService;

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
 * MessageSms Controller
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@RequestMapping("/mgn/message/messageSms")
@Controller
public class MessageSmsController extends StandardBaseController {

	@Autowired
	IMessageSmsService iMessageSmsService;
	
	@Autowired
	IMessageTempSmsService iMessageTempSmsService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSmsListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSmsListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageSms/messageSmsListInit");
		List<MessageTempSmsModel> tempSms = this.iMessageTempSmsService.listByLimitStatus(1, 999);
		model.addObject("tempSms", tempSms);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSmsAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSmsAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageSms/messageSmsAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSmsEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSmsEditInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageSms/messageSmsEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSmsShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSmsShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageSms/messageSmsShowInit");
		MessageSmsView ret = this.iMessageSmsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageSmsView>> getByPage(MessageSmsDto dto){
		PageUtils<MessageSmsView> ret = this.iMessageSmsService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageSmsView> getViewById(long id){
		MessageSmsView ret = this.iMessageSmsService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageSmsModel> findModelById(long id){
		MessageSmsModel ret = this.iMessageSmsService.findModelById(id);
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
		Boolean ret = this.iMessageSmsService.stop(id);
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
		Boolean ret = this.iMessageSmsService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageSmsModel model){
		this.iMessageSmsService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageSmsModifyDto model){
		this.iMessageSmsService.modify(model);
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
		Boolean ret = this.iMessageSmsService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
