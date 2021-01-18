package com.longjun.cto.framework.sm.pay.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatQueryView;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatQueryService;

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
 * PayWechatQuery Controller
 * @author yangxuan
 * @date 2019-11-07 04:30:51
 */
@RequestMapping("/mgn/sm/pay/wechat/payWechatQuery")
@Controller
public class PayWechatQueryController extends StandardBaseController {

	@Autowired
	IPayWechatQueryService iPayWechatQueryService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatQueryListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatQueryListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatQuery/payWechatQueryListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatQueryAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatQueryAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatQuery/payWechatQueryAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatQueryEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatQueryEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatQuery/payWechatQueryEditInit");
		PayWechatQueryView ret = this.iPayWechatQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatQueryShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatQueryShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechatQuery/payWechatQueryShowInit");
		PayWechatQueryView ret = this.iPayWechatQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayWechatQueryView>> getByPage(PayWechatQueryDto dto){
		PageUtils<PayWechatQueryView> ret = this.iPayWechatQueryService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatQueryView> getViewById(Long id){
		PayWechatQueryView ret = this.iPayWechatQueryService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatQueryModel> findModelById(Long id){
		PayWechatQueryModel ret = this.iPayWechatQueryService.findModelById(id);
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
		Boolean ret = this.iPayWechatQueryService.stop(id);
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
		Boolean ret = this.iPayWechatQueryService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayWechatQueryModel model){
		this.iPayWechatQueryService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayWechatQueryModifyDto model){
		this.iPayWechatQueryService.modify(model);
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
		Boolean ret = this.iPayWechatQueryService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
