package com.longjun.cto.framework.sm.pay.web;

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
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelDictView;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelItemDictView;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;

/**
 * PayChannelItemDict Controller
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
@RequestMapping("/mgn/pay/payChannelItemDict")
@Controller
public class PayChannelItemDictController extends StandardBaseController {

	@Autowired
	IPayChannelItemDictService iPayChannelItemDictService;
	
	@Autowired
	IPayChannelDictService iPayChannelDictService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelItemDictListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelItemDictListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannelItemDict/payChannelItemDictListInit");
		List<PayChannelDictView> channels = this.iPayChannelDictService.listByLimitStatus(1, 1000);
		model.addObject("channels", channels);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/payChannelItemDictAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelItemDictAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannelItemDict/payChannelItemDictAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/payChannelItemDictEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelItemDictEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannelItemDict/payChannelItemDictEditInit");
		PayChannelItemDictView ret = this.iPayChannelItemDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	//@RequestMapping(value = "/payChannelItemDictShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelItemDictShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannelItemDict/payChannelItemDictShowInit");
		PayChannelItemDictView ret = this.iPayChannelItemDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayChannelItemDictView>> getByPage(PayChannelItemDictDto dto){
		PageUtils<PayChannelItemDictView> ret = this.iPayChannelItemDictService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelItemDictView> getViewById(long id){
		PayChannelItemDictView ret = this.iPayChannelItemDictService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelItemDictModel> findModelById(long id){
		PayChannelItemDictModel ret = this.iPayChannelItemDictService.findModelById(id);
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
		Boolean ret = this.iPayChannelItemDictService.stop(id);
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
		Boolean ret = this.iPayChannelItemDictService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayChannelItemDictModel model){
		this.iPayChannelItemDictService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayChannelItemDictModifyDto model){
		this.iPayChannelItemDictService.modify(model);
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
		Boolean ret = this.iPayChannelItemDictService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 通过渠道ID查询支付方式列表
	 * @param channelId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listByChannelId" , method = {RequestMethod.POST})
	public ApiResult listByChannelId(long channelId){
		List<PayChannelItemDictModel> rets = this.iPayChannelItemDictService.listByChannelId(channelId);
		return ApiResult.instance().ok("rets" , rets); 
	}
	
	
}
