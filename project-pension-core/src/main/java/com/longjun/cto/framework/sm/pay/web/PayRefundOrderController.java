package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayRefundOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayRefundOrderView;
import com.longjun.cto.framework.sm.pay.service.IPayRefundOrderService;

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
 * PayRefundOrder Controller
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@RequestMapping("/mgn/sm/pay/payRefundOrder")
@Controller
public class PayRefundOrderController extends StandardBaseController {

	@Autowired
	IPayRefundOrderService iPayRefundOrderService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payRefundOrderListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payRefundOrderListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payRefundOrder/payRefundOrderListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payRefundOrderAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payRefundOrderAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payRefundOrder/payRefundOrderAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payRefundOrderEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payRefundOrderEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payRefundOrder/payRefundOrderEditInit");
		PayRefundOrderView ret = this.iPayRefundOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payRefundOrderShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payRefundOrderShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payRefundOrder/payRefundOrderShowInit");
		PayRefundOrderView ret = this.iPayRefundOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayRefundOrderView>> getByPage(PayRefundOrderDto dto){
		PageUtils<PayRefundOrderView> ret = this.iPayRefundOrderService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayRefundOrderView> getViewById(long id){
		PayRefundOrderView ret = this.iPayRefundOrderService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayRefundOrderModel> findModelById(long id){
		PayRefundOrderModel ret = this.iPayRefundOrderService.findModelById(id);
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
		Boolean ret = this.iPayRefundOrderService.stop(id);
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
		Boolean ret = this.iPayRefundOrderService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayRefundOrderModel model){
		this.iPayRefundOrderService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayRefundOrderModifyDto model){
		this.iPayRefundOrderService.modify(model);
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
		Boolean ret = this.iPayRefundOrderService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
