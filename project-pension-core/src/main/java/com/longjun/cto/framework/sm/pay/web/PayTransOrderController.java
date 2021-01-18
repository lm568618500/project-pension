package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayTransOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayTransOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayTransOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayTransOrderView;
import com.longjun.cto.framework.sm.pay.service.IPayTransOrderService;

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
 * PayTransOrder Controller
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@RequestMapping("/mgn/sm/pay/payTransOrder")
@Controller
public class PayTransOrderController extends StandardBaseController {

	@Autowired
	IPayTransOrderService iPayTransOrderService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payTransOrderListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payTransOrderListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payTransOrder/payTransOrderListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payTransOrderAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payTransOrderAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payTransOrder/payTransOrderAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payTransOrderEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payTransOrderEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payTransOrder/payTransOrderEditInit");
		PayTransOrderView ret = this.iPayTransOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payTransOrderShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payTransOrderShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payTransOrder/payTransOrderShowInit");
		PayTransOrderView ret = this.iPayTransOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayTransOrderView>> getByPage(PayTransOrderDto dto){
		PageUtils<PayTransOrderView> ret = this.iPayTransOrderService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayTransOrderView> getViewById(long id){
		PayTransOrderView ret = this.iPayTransOrderService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayTransOrderModel> findModelById(long id){
		PayTransOrderModel ret = this.iPayTransOrderService.findModelById(id);
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
		Boolean ret = this.iPayTransOrderService.stop(id);
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
		Boolean ret = this.iPayTransOrderService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayTransOrderModel model){
		this.iPayTransOrderService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayTransOrderModifyDto model){
		this.iPayTransOrderService.modify(model);
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
		Boolean ret = this.iPayTransOrderService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
