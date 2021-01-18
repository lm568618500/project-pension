package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchNotifyDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchNotifyModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchNotifyView;
import com.longjun.cto.framework.sm.pay.service.IPayMchNotifyService;

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
 * PayMchNotify Coontroller
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
@RequestMapping("/mgn/sm/pay/payMchNotify")
@Controller
public class PayMchNotifyController extends StandardBaseController {

	@Autowired
	IPayMchNotifyService iPayMchNotifyService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchNotifyListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchNotifyListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchNotify/payMchNotifyListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchNotifyAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchNotifyAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchNotify/payMchNotifyAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchNotifyEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchNotifyEditInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchNotify/payMchNotifyEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchNotifyShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchNotifyShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchNotify/payMchNotifyShowInit");
		PayMchNotifyView ret = this.iPayMchNotifyService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayMchNotifyView>> getByPage(PayMchNotifyDto dto){
		PageUtils<PayMchNotifyView> ret = this.iPayMchNotifyService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayMchNotifyView> getViewById(long id){
		PayMchNotifyView ret = this.iPayMchNotifyService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayMchNotifyModel> findModelById(long id){
		PayMchNotifyModel ret = this.iPayMchNotifyService.findModelById(id);
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
		Boolean ret = this.iPayMchNotifyService.stop(id);
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
		Boolean ret = this.iPayMchNotifyService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayMchNotifyModel model){
		this.iPayMchNotifyService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayMchNotifyModifyDto model){
		this.iPayMchNotifyService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
