package com.longjun.cto.framework.sm.pay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelDictView;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelView;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
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
 * PayChannel Coontroller
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
@RequestMapping("/mgn/sm/pay/payChannel")
@Controller
public class PayChannelController extends StandardBaseController {

	@Autowired
	IPayChannelService iPayChannelService;
	

	@Autowired
	IPayChannelDictService iPayChannelDictService;
	
	@Autowired
	IPayMchInfoService iPayMchInfoService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannel/payChannelListInit");
		List<PayChannelDictView> channels = this.iPayChannelDictService.listByLimitStatus(1, 1000);
		model.addObject("channels", channels);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannel/payChannelAddInit");
		List<PayChannelDictView> channels = this.iPayChannelDictService.listByLimitStatus(1, 1000);
		model.addObject("channels", channels);
		List<PayMchInfoModel> mchInfos = this.iPayMchInfoService.listByLimitStatus(1, 999);
		model.addObject("mchInfos", mchInfos);
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannel/payChannelEditInit");
		PayChannelView ret = this.iPayChannelService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/payChannelShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView payChannelShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payChannel/payChannelShowInit");
		PayChannelView ret = this.iPayChannelService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<PayChannelView>> getByPage(PayChannelDto dto){
		PageUtils<PayChannelView> ret = this.iPayChannelService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelView> getViewById(long id){
		PayChannelView ret = this.iPayChannelService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<PayChannelModel> findModelById(long id){
		PayChannelModel ret = this.iPayChannelService.findModelById(id);
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
		Boolean ret = this.iPayChannelService.stop(id);
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
		Boolean ret = this.iPayChannelService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(PayChannelModel model){
		this.iPayChannelService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(PayChannelModifyDto model){
		this.iPayChannelService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
