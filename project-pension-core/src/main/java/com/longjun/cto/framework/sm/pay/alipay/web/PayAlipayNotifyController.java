package com.longjun.cto.framework.sm.pay.alipay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayNotifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayNotifyModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayNotifyView;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayNotifyService;

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
 * PayAlipayNotify Controller
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
@RequestMapping("/mgn/sm/pay/alipay/payAlipayNotify")
@Controller
public class PayAlipayNotifyController extends StandardBaseController {

	@Autowired
	IPayAlipayNotifyService iPayAlipayNotifyService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayNotifyListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayNotifyListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayNotify/payAlipayNotifyListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayNotifyAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayNotifyAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayNotify/payAlipayNotifyAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayNotifyEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayNotifyEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayNotify/payAlipayNotifyEditInit");
		PayAlipayNotifyView ret = this.iPayAlipayNotifyService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayNotifyShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayNotifyShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayNotify/payAlipayNotifyShowInit");
		PayAlipayNotifyView ret = this.iPayAlipayNotifyService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayAlipayNotifyView>> getByPage(PayAlipayNotifyDto dto){
		PageUtils<PayAlipayNotifyView> ret = this.iPayAlipayNotifyService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayNotifyView> getViewById(Long id){
		PayAlipayNotifyView ret = this.iPayAlipayNotifyService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayNotifyModel> findModelById(Long id){
		PayAlipayNotifyModel ret = this.iPayAlipayNotifyService.findModelById(id);
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
		Boolean ret = this.iPayAlipayNotifyService.stop(id);
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
		Boolean ret = this.iPayAlipayNotifyService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayAlipayNotifyModel model){
		this.iPayAlipayNotifyService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayAlipayNotifyModifyDto model){
		this.iPayAlipayNotifyService.modify(model);
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
		Boolean ret = this.iPayAlipayNotifyService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
