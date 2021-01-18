package com.longjun.cto.framework.sm.pay.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatNotifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatNotifyModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatNotifyView;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatNotifyService;

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
 * PayWechatNotify Controller
 * @author yangxuan
 * @date 2019-11-07 02:51:58
 */
@RequestMapping("/mgn/sm/pay/wechat/payWechatNotify")
@Controller
public class PayWechatNotifyController extends StandardBaseController {

	@Autowired
	IPayWechatNotifyService iPayWechatNotifyService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatNotifyListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatNotifyListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatNotify/payWechatNotifyListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatNotifyAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatNotifyAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatNotify/payWechatNotifyAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatNotifyEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatNotifyEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatNotify/payWechatNotifyEditInit");
		PayWechatNotifyView ret = this.iPayWechatNotifyService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatNotifyShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatNotifyShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatNotify/payWechatNotifyShowInit");
		PayWechatNotifyView ret = this.iPayWechatNotifyService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayWechatNotifyView>> getByPage(PayWechatNotifyDto dto){
		PageUtils<PayWechatNotifyView> ret = this.iPayWechatNotifyService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatNotifyView> getViewById(Long id){
		PayWechatNotifyView ret = this.iPayWechatNotifyService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatNotifyModel> findModelById(Long id){
		PayWechatNotifyModel ret = this.iPayWechatNotifyService.findModelById(id);
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
		Boolean ret = this.iPayWechatNotifyService.stop(id);
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
		Boolean ret = this.iPayWechatNotifyService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayWechatNotifyModel model){
		this.iPayWechatNotifyService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayWechatNotifyModifyDto model){
		this.iPayWechatNotifyService.modify(model);
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
		Boolean ret = this.iPayWechatNotifyService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
