package com.longjun.cto.framework.sm.pay.alipay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayOrderModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayOrderView;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayOrderService;

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

import java.lang.Long;

/**
 * PayAlipayOrder Controller
 * @author yangxuan
 * @date 2019-11-07 05:39:27
 */
@RequestMapping("/mgn/sm/pay/alipay/payAlipayOrder")
@Controller
public class PayAlipayOrderController extends StandardBaseController {

	@Autowired
	IPayAlipayOrderService iPayAlipayOrderService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayOrderListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayOrderListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayOrder/payAlipayOrderListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayOrderAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayOrderAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayOrder/payAlipayOrderAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayOrderEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayOrderEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayOrder/payAlipayOrderEditInit");
		PayAlipayOrderView ret = this.iPayAlipayOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayOrderShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayOrderShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayOrder/payAlipayOrderShowInit");
		PayAlipayOrderView ret = this.iPayAlipayOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayAlipayOrderView>> getByPage(PayAlipayOrderDto dto){
		PageUtils<PayAlipayOrderView> ret = this.iPayAlipayOrderService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayOrderView> getViewById(Long id){
		PayAlipayOrderView ret = this.iPayAlipayOrderService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayOrderModel> findModelById(Long id){
		PayAlipayOrderModel ret = this.iPayAlipayOrderService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(Long id){
		Boolean ret = this.iPayAlipayOrderService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(Long id ){
		Boolean ret = this.iPayAlipayOrderService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayAlipayOrderModel model){
		this.iPayAlipayOrderService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayAlipayOrderModifyDto model){
		this.iPayAlipayOrderService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(Long id){
		Boolean ret = this.iPayAlipayOrderService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
