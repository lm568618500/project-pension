package com.longjun.cto.framework.sm.message.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageEmailDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageEmailModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageEmailView;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempEmailView;
import com.longjun.cto.framework.sm.message.service.IMessageEmailService;
import com.longjun.cto.framework.sm.message.service.IMessageTempEmailService;
import com.longjun.cto.framework.sm.message.service.IMessageTempSmsService;

/**
 * MessageEmail Controller
 * 
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@RequestMapping("/mgn/message/messageEmail")
@Controller
public class MessageEmailController extends StandardBaseController {

	@Autowired
	private IMessageEmailService iMessageEmailService;

	@Autowired
	private IMessageTempSmsService iMessageTempSmsService;
	
	@Autowired
	private IMessageTempEmailService iMessageTempEmailService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageEmailListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageEmailListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageEmail/messageEmailListInit");
		List<MessageTempEmailView> tempEmail = this.iMessageTempEmailService.listByLimitStatus(1, 999);
		model.addObject("tempEmail", tempEmail);
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	 @RequestMapping(value = "/messageEmailAddInit" , method = {RequestMethod.POST
	 , RequestMethod.GET})
	public ModelAndView messageEmailAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageEmail/messageEmailAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/messageEmailEditInit" , method =
	// {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageEmailEditInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageEmail/messageEmailEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/messageEmailShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView messageEmailShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageEmail/messageEmailShowInit");
		MessageEmailView ret = this.iMessageEmailService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<MessageEmailView>> getByPage(MessageEmailDto dto) {
		PageUtils<MessageEmailView> ret = this.iMessageEmailService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<MessageEmailView> getViewById(long id) {
		MessageEmailView ret = this.iMessageEmailService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<MessageEmailModel> findModelById(long id) {
		MessageEmailModel ret = this.iMessageEmailService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(long id) {
		Boolean ret = this.iMessageEmailService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(long id) {
		Boolean ret = this.iMessageEmailService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageEmailModel model) {
		this.iMessageEmailService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageEmailModifyDto model) {
		this.iMessageEmailService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id) {
		Boolean ret = this.iMessageEmailService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

}
