package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempSmsView;
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
 * MessageTempSms Controller
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@RequestMapping("/mgn/message/messageTempSms")
@Controller
public class MessageTempSmsController extends StandardBaseController {

	@Autowired
	IMessageTempSmsService iMessageTempSmsService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempSmsListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempSmsListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTempSms/messageTempSmsListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/messageTempSmsAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempSmsAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTempSms/messageTempSmsAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempSmsEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempSmsEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageTempSms/messageTempSmsEditInit");
		MessageTempSmsView ret = this.iMessageTempSmsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempSmsShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempSmsShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageTempSms/messageTempSmsShowInit");
		MessageTempSmsView ret = this.iMessageTempSmsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageTempSmsView>> getByPage(MessageTempSmsDto dto){
		PageUtils<MessageTempSmsView> ret = this.iMessageTempSmsService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempSmsView> getViewById(long id){
		MessageTempSmsView ret = this.iMessageTempSmsService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempSmsModel> findModelById(long id){
		MessageTempSmsModel ret = this.iMessageTempSmsService.findModelById(id);
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
		Boolean ret = this.iMessageTempSmsService.stop(id);
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
		Boolean ret = this.iMessageTempSmsService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageTempSmsModel model){
		this.iMessageTempSmsService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageTempSmsModifyDto model){
		this.iMessageTempSmsService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id){
		Boolean ret = this.iMessageTempSmsService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
