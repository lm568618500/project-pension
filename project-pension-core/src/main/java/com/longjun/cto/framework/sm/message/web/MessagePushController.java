package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.view.MessagePushView;
import com.longjun.cto.framework.sm.message.service.IMessagePushService;

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
 * MessagePush Controller
 * @author yangxuan
 * @date 2019-05-30 09:21:36
 */
@RequestMapping("/mgn/sm/message/messagePush")
@Controller
public class MessagePushController extends StandardBaseController {

	@Autowired
	IMessagePushService iMessagePushService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messagePushListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messagePushListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/message/messagePush/messagePushListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messagePushAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messagePushAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/message/messagePush/messagePushAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messagePushEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messagePushEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/message/messagePush/messagePushEditInit");
		MessagePushView ret = this.iMessagePushService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messagePushShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messagePushShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/message/messagePush/messagePushShowInit");
		MessagePushView ret = this.iMessagePushService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessagePushView>> getByPage(MessagePushDto dto){
		PageUtils<MessagePushView> ret = this.iMessagePushService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessagePushView> getViewById(long id){
		MessagePushView ret = this.iMessagePushService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessagePushModel> findModelById(long id){
		MessagePushModel ret = this.iMessagePushService.findModelById(id);
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
		Boolean ret = this.iMessagePushService.stop(id);
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
		Boolean ret = this.iMessagePushService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessagePushModel model){
		this.iMessagePushService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessagePushModifyDto model){
		this.iMessagePushService.modify(model);
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
		Boolean ret = this.iMessagePushService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
