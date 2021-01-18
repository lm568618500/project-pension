package com.longjun.cto.framework.sm.pay.wechat.web;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatView;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * PayWechat Controller
 * @author yangxuan
 * @date 2019-11-07 02:13:18
 */
@RequestMapping("/mgn/sm/pay/wechat/payWechat")
@Controller
public class PayWechatController extends StandardBaseController {

	@Autowired
	IPayWechatService iPayWechatService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechat/payWechatListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechat/payWechatAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechat/payWechatEditInit");
		PayWechatView ret = this.iPayWechatService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payWechatShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payWechatShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/wechat/payWechat/payWechatShowInit");
		PayWechatView ret = this.iPayWechatService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayWechatView>> getByPage(PayWechatDto dto){
		PageUtils<PayWechatView> ret = this.iPayWechatService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatView> getViewById(Long id){
		PayWechatView ret = this.iPayWechatService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayWechatModel> findModelById(Long id){
		PayWechatModel ret = this.iPayWechatService.findModelById(id);
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
		Boolean ret = this.iPayWechatService.stop(id);
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
		Boolean ret = this.iPayWechatService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayWechatModel model){
		this.iPayWechatService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayWechatModifyDto model){
		this.iPayWechatService.modify(model);
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
		Boolean ret = this.iPayWechatService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
