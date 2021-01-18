package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageMechDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageMechModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageMechModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageMechView;
import com.longjun.cto.framework.sm.message.service.IMessageMechService;

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
 * MessageMech Controller
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
@RequestMapping("/mgn/message/messageMech")
@Controller
public class MessageMechController extends StandardBaseController {

	@Autowired
	IMessageMechService iMessageMechService;
	
	/**
	 * 商户信息介绍
	 * @return
	 */
	@RequestMapping(value = "/messageMechInfoInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageMechInfoInit() {
		MessageMechModel ret = this.iMessageMechService.getByOneUse();
		ModelAndView model = getModelAndView("/mgn/message/messageMech/messageMechInfoInit");
		model.addObject("ret", ret);
		return model;
	}
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageMechListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageMechListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageMech/messageMechListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageMechAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageMechAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageMech/messageMechAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageMechEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageMechEditInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageMech/messageMechEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageMechShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageMechShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageMech/messageMechShowInit");
		MessageMechView ret = this.iMessageMechService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageMechView>> getByPage(MessageMechDto dto){
		PageUtils<MessageMechView> ret = this.iMessageMechService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageMechView> getViewById(long id){
		MessageMechView ret = this.iMessageMechService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageMechModel> findModelById(long id){
		MessageMechModel ret = this.iMessageMechService.findModelById(id);
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
		Boolean ret = this.iMessageMechService.stop(id);
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
		Boolean ret = this.iMessageMechService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageMechModel model){
		this.iMessageMechService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageMechModifyDto model){
		this.iMessageMechService.modify(model);
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
		Boolean ret = this.iMessageMechService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
