package com.longjun.cto.framework.sm.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageGatwayModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageGatwayView;
import com.longjun.cto.framework.sm.message.service.IMessageGatwayService;

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
 * MessageGatway Controller
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
@RequestMapping("/mgn/message/messageGatway")
@Controller
public class MessageGatwayController extends StandardBaseController {

	@Autowired
	IMessageGatwayService iMessageGatwayService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageGatwayListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageGatwayListInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageGatway/messageGatwayListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageGatwayAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageGatwayAddInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageGatway/messageGatwayAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageGatwayEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageGatwayEditInit() {
		ModelAndView model = getModelAndView("/mgn/message/messageGatway/messageGatwayEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/messageGatwayShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView messageGatwayShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/message/messageGatway/messageGatwayShowInit");
		MessageGatwayView ret = this.iMessageGatwayService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<MessageGatwayView>> getByPage(MessageGatwayDto dto){
		PageUtils<MessageGatwayView> ret = this.iMessageGatwayService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<MessageGatwayView> getViewById(long id){
		MessageGatwayView ret = this.iMessageGatwayService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<MessageGatwayModel> findModelById(long id){
		MessageGatwayModel ret = this.iMessageGatwayService.findModelById(id);
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
		Boolean ret = this.iMessageGatwayService.stop(id);
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
		Boolean ret = this.iMessageGatwayService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(MessageGatwayModel model){
		this.iMessageGatwayService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(MessageGatwayModifyDto model){
		this.iMessageGatwayService.modify(model);
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
		Boolean ret = this.iMessageGatwayService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
