package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempView;
import com.longjun.cto.framework.sm.message.service.IMessageTempService;

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
 * MessageTemp Controller
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@RequestMapping("/mgn/message/messageTemp")
@Controller
public class MessageTempController extends StandardBaseController {

	@Autowired
	IMessageTempService iMessageTempService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageTempListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTemp/messageTempListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/messageTempAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTemp/messageTempAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/messageTempEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempEditInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageTemp/messageTempEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/messageTempShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageTempShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageTemp/messageTempShowInit");
		MessageTempView ret = this.iMessageTempService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageTempView>> getByPage(MessageTempDto dto){
		PageUtils<MessageTempView> ret = this.iMessageTempService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempView> getViewById(long id){
		MessageTempView ret = this.iMessageTempService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageTempModel> findModelById(long id){
		MessageTempModel ret = this.iMessageTempService.findModelById(id);
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
		Boolean ret = this.iMessageTempService.stop(id);
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
		Boolean ret = this.iMessageTempService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageTempModel model){
		this.iMessageTempService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageTempModifyDto model){
		this.iMessageTempService.modify(model);
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
		Boolean ret = this.iMessageTempService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
