package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempEmailDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempEmailModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempEmailView;
import com.longjun.cto.framework.sm.message.service.IMessageTempEmailService;

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
 * MessageTempEmail Controller
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@RequestMapping("/mgn/message/messageTempEmail")
@Controller
public class MessageTempEmailController extends StandardBaseController {

	@Autowired
	IMessageTempEmailService iMessageTempEmailService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempEmailListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempEmailListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTempEmail/messageTempEmailListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempEmailAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempEmailAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTempEmail/messageTempEmailAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempEmailEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempEmailEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageTempEmail/messageTempEmailEditInit");
		MessageTempEmailView ret = this.iMessageTempEmailService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempEmailShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempEmailShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageTempEmail/messageTempEmailShowInit");
		MessageTempEmailView ret = this.iMessageTempEmailService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageTempEmailView>> getByPage(MessageTempEmailDto dto){
		PageUtils<MessageTempEmailView> ret = this.iMessageTempEmailService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempEmailView> getViewById(long id){
		MessageTempEmailView ret = this.iMessageTempEmailService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempEmailModel> findModelById(long id){
		MessageTempEmailModel ret = this.iMessageTempEmailService.findModelById(id);
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
		Boolean ret = this.iMessageTempEmailService.stop(id);
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
		Boolean ret = this.iMessageTempEmailService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageTempEmailModel model){
		this.iMessageTempEmailService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageTempEmailModifyDto model){
		this.iMessageTempEmailService.modify(model);
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
		Boolean ret = this.iMessageTempEmailService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
