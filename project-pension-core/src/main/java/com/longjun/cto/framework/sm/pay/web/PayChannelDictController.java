package com.longjun.cto.framework.sm.pay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDictDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDictModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelDictModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelDictView;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;

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
 * PayChannelDict Controller
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
@RequestMapping("/mgn/pay/payChannelDict")
@Controller
public class PayChannelDictController extends StandardBaseController {

	@Autowired
	IPayChannelDictService iPayChannelDictService;
	
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelDictListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelDictListInit() {
		ModelAndView model = getModelAndView("/mgn/pay/payChannelDict/payChannelDictListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelDictAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelDictAddInit() {
		ModelAndView model = getModelAndView("/mgn/pay/payChannelDict/payChannelDictAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelDictEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelDictEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/pay/payChannelDict/payChannelDictEditInit");
		PayChannelDictView ret = this.iPayChannelDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelDictShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelDictShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/pay/payChannelDict/payChannelDictShowInit");
		PayChannelDictView ret = this.iPayChannelDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayChannelDictView>> getByPage(PayChannelDictDto dto){
		PageUtils<PayChannelDictView> ret = this.iPayChannelDictService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelDictView> getViewById(long id){
		PayChannelDictView ret = this.iPayChannelDictService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelDictModel> findModelById(long id){
		PayChannelDictModel ret = this.iPayChannelDictService.findModelById(id);
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
		Boolean ret = this.iPayChannelDictService.stop(id);
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
		Boolean ret = this.iPayChannelDictService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayChannelDictModel model){
		this.iPayChannelDictService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayChannelDictModifyDto model){
		this.iPayChannelDictService.modify(model);
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
		Boolean ret = this.iPayChannelDictService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
