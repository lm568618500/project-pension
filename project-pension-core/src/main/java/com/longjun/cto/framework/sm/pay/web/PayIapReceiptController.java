package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayIapReceiptModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayIapReceiptView;
import com.longjun.cto.framework.sm.pay.service.IPayIapReceiptService;

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
 * PayIapReceipt Coontroller
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
@RequestMapping("/mgn/sm/pay/payIapReceipt")
@Controller
public class PayIapReceiptController extends StandardBaseController {

	@Autowired
	IPayIapReceiptService iPayIapReceiptService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payIapReceiptListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payIapReceiptListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payIapReceipt/payIapReceiptListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payIapReceiptAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payIapReceiptAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payIapReceipt/payIapReceiptAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payIapReceiptEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payIapReceiptEditInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payIapReceipt/payIapReceiptEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payIapReceiptShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payIapReceiptShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payIapReceipt/payIapReceiptShowInit");
		PayIapReceiptView ret = this.iPayIapReceiptService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayIapReceiptView>> getByPage(PayIapReceiptDto dto){
		PageUtils<PayIapReceiptView> ret = this.iPayIapReceiptService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayIapReceiptView> getViewById(long id){
		PayIapReceiptView ret = this.iPayIapReceiptService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayIapReceiptModel> findModelById(long id){
		PayIapReceiptModel ret = this.iPayIapReceiptService.findModelById(id);
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
		Boolean ret = this.iPayIapReceiptService.stop(id);
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
		Boolean ret = this.iPayIapReceiptService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayIapReceiptModel model){
		this.iPayIapReceiptService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayIapReceiptModifyDto model){
		this.iPayIapReceiptService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
