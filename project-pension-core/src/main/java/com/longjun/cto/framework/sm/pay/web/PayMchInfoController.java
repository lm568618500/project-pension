package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchInfoView;
import com.longjun.cto.framework.sm.pay.service.IPayMchInfoService;

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
 * PayMchInfo Coontroller
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
@RequestMapping("/mgn/sm/pay/payMchInfo")
@Controller
public class PayMchInfoController extends StandardBaseController {

	@Autowired
	IPayMchInfoService iPayMchInfoService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchInfoListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchInfoListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchInfo/payMchInfoListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchInfoAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchInfoAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchInfo/payMchInfoAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchInfoEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchInfoEditInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchInfo/payMchInfoEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payMchInfoShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payMchInfoShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payMchInfo/payMchInfoShowInit");
		PayMchInfoView ret = this.iPayMchInfoService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayMchInfoView>> getByPage(PayMchInfoDto dto){
		PageUtils<PayMchInfoView> ret = this.iPayMchInfoService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayMchInfoView> getViewById(long id){
		PayMchInfoView ret = this.iPayMchInfoService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayMchInfoModel> findModelById(long id){
		PayMchInfoModel ret = this.iPayMchInfoService.findModelById(id);
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
		Boolean ret = this.iPayMchInfoService.stop(id);
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
		Boolean ret = this.iPayMchInfoService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	//@ResponseBody
	//@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayMchInfoModel model){
		this.iPayMchInfoService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayMchInfoModifyDto model){
		this.iPayMchInfoService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
