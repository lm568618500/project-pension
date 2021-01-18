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
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageSettingModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageGatwayView;
import com.longjun.cto.framework.sm.message.entity.view.MessageMechView;
import com.longjun.cto.framework.sm.message.entity.view.MessageSettingView;
import com.longjun.cto.framework.sm.message.service.IMessageGatwayService;
import com.longjun.cto.framework.sm.message.service.IMessageMechService;
import com.longjun.cto.framework.sm.message.service.IMessageSettingService;

/**
 * MessageSetting Controller
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
@RequestMapping("/mgn/message/messageSetting")
@Controller
public class MessageSettingController extends StandardBaseController {

	@Autowired
	IMessageSettingService iMessageSettingService;
	
	@Autowired
	IMessageGatwayService iMessageGatwayService;
	
	@Autowired
	IMessageMechService iMessageMechService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSettingListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSettingListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageSetting/messageSettingListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/messageSettingAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSettingAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageSetting/messageSettingAddInit");
		List<MessageGatwayView> gayways = this.iMessageGatwayService.listAll();
		List<MessageMechView> mechs = iMessageMechService.listAll();
		model.addObject("gayways", gayways);
		model.addObject("mechs", mechs);
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSettingEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSettingEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageSetting/messageSettingEditInit");
		List<MessageGatwayView> gayways = this.iMessageGatwayService.listAll();
		List<MessageMechView> mechs = iMessageMechService.listAll();
		model.addObject("gayways", gayways);
		model.addObject("mechs", mechs);
		MessageSettingView ret = this.iMessageSettingService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageSettingShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageSettingShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageSetting/messageSettingShowInit");
		MessageSettingView ret = this.iMessageSettingService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageSettingView>> getByPage(MessageSettingDto dto){
		PageUtils<MessageSettingView> ret = this.iMessageSettingService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageSettingView> getViewById(long id){
		MessageSettingView ret = this.iMessageSettingService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageSettingModel> findModelById(long id){
		MessageSettingModel ret = this.iMessageSettingService.findModelById(id);
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
		Boolean ret = this.iMessageSettingService.stop(id);
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
		Boolean ret = this.iMessageSettingService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageSettingModel model){
		this.iMessageSettingService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageSettingModifyDto model){
		this.iMessageSettingService.modify(model);
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
		Boolean ret = this.iMessageSettingService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
