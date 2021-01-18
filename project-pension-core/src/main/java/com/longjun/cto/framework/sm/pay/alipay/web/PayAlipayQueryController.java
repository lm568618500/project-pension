package com.longjun.cto.framework.sm.pay.alipay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayQueryModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayQueryView;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayQueryService;

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
 * PayAlipayQuery Controller
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
@RequestMapping("/mgn/sm/pay/alipay/payAlipayQuery")
@Controller
public class PayAlipayQueryController extends StandardBaseController {

	@Autowired
	IPayAlipayQueryService iPayAlipayQueryService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayQueryListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayQueryListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayQuery/payAlipayQueryListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayQueryAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayQueryAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayQuery/payAlipayQueryAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayQueryEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayQueryEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayQuery/payAlipayQueryEditInit");
		PayAlipayQueryView ret = this.iPayAlipayQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payAlipayQueryShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payAlipayQueryShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/alipay/payAlipayQuery/payAlipayQueryShowInit");
		PayAlipayQueryView ret = this.iPayAlipayQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayAlipayQueryView>> getByPage(PayAlipayQueryDto dto){
		PageUtils<PayAlipayQueryView> ret = this.iPayAlipayQueryService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayQueryView> getViewById(Long id){
		PayAlipayQueryView ret = this.iPayAlipayQueryService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayAlipayQueryModel> findModelById(Long id){
		PayAlipayQueryModel ret = this.iPayAlipayQueryService.findModelById(id);
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
		Boolean ret = this.iPayAlipayQueryService.stop(id);
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
		Boolean ret = this.iPayAlipayQueryService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayAlipayQueryModel model){
		this.iPayAlipayQueryService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayAlipayQueryModifyDto model){
		this.iPayAlipayQueryService.modify(model);
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
		Boolean ret = this.iPayAlipayQueryService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
