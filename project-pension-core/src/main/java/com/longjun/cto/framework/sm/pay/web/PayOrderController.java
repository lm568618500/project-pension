package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayOrderView;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;

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
 * PayOrder Controller
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@RequestMapping("/mgn/sm/pay/payOrder")
@Controller
public class PayOrderController extends StandardBaseController {

	@Autowired
	IPayOrderService iPayOrderService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/payOrderListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView payOrderListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payOrder/payOrderListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	//@RequestMapping(value = "/payOrderAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView payOrderAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payOrder/payOrderAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	// @RequestMapping(value = "/payOrderEditInit" , method = {RequestMethod.POST ,
	// RequestMethod.GET})
	public ModelAndView payOrderEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payOrder/payOrderEditInit");
		PayOrderView ret = this.iPayOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/payOrderShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView payOrderShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payOrder/payOrderShowInit");
		PayOrderView ret = this.iPayOrderService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<PayOrderView>> getByPage(PayOrderDto dto) {
		PageUtils<PayOrderView> ret = this.iPayOrderService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<PayOrderView> getViewById(long id) {
		PayOrderView ret = this.iPayOrderService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<PayOrderModel> findModelById(long id) {
		PayOrderModel ret = this.iPayOrderService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(long id) {
		Boolean ret = this.iPayOrderService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(long id) {
		Boolean ret = this.iPayOrderService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayOrderModel model) {
		this.iPayOrderService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayOrderModifyDto model) {
		this.iPayOrderService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id) {
		Boolean ret = this.iPayOrderService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 业务通知
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/orderNotify", method = { RequestMethod.POST })
	public ApiResult orderNotify(long id) {
//		Boolean ret = this.iPayOrderService.del(id);
		boolean ret = true;
		return ApiResult.instance().ok("ret", ret);
	}

}
