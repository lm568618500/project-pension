package com.longjun.cto.framework.sm.pay.union.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionRefundModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionRefundView;
import com.longjun.cto.framework.sm.pay.union.service.IUnionRefundService;

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
 * UnionRefund Controller
 * @author yangxuan
 * @date 2019-11-02 10:59:36
 */
@RequestMapping("/mgn/sm/pay/union/unionRefund")
@Controller
public class UnionRefundController extends StandardBaseController {

	@Autowired
	IUnionRefundService iUnionRefundService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionRefundListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionRefundListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionRefund/unionRefundListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionRefundAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionRefundAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionRefund/unionRefundAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionRefundEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionRefundEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionRefund/unionRefundEditInit");
		UnionRefundView ret = this.iUnionRefundService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionRefundShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionRefundShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionRefund/unionRefundShowInit");
		UnionRefundView ret = this.iUnionRefundService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UnionRefundView>> getByPage(UnionRefundDto dto){
		PageUtils<UnionRefundView> ret = this.iUnionRefundService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UnionRefundView> getViewById(Long id){
		UnionRefundView ret = this.iUnionRefundService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UnionRefundModel> findModelById(Long id){
		UnionRefundModel ret = this.iUnionRefundService.findModelById(id);
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
		Boolean ret = this.iUnionRefundService.stop(id);
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
		Boolean ret = this.iUnionRefundService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UnionRefundModel model){
		this.iUnionRefundService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UnionRefundModifyDto model){
		this.iUnionRefundService.modify(model);
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
		Boolean ret = this.iUnionRefundService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
