package com.longjun.cto.framework.sm.pay.union.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayView;
import com.longjun.cto.framework.sm.pay.union.service.IUnionPayService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;

import java.lang.Long;

/**
 * UnionPay Controller
 * 
 * @author yangxuan
 * @date 2019-10-30 04:21:52
 */
@RequestMapping("/mgn/sm/pay/union/unionPay")
@Controller
public class UnionPayController extends StandardBaseController {

	@Autowired
	IUnionPayService iUnionPayService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unionPayListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView unionPayListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionPay/unionPayListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unionPayAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView unionPayAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionPay/unionPayAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unionPayEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView unionPayEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionPay/unionPayEditInit");
		UnionPayView ret = this.iUnionPayService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unionPayShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView unionPayShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionPay/unionPayShowInit");
		UnionPayView ret = this.iUnionPayService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<UnionPayView>> getByPage(UnionPayDto dto) {
		PageUtils<UnionPayView> ret = this.iUnionPayService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<UnionPayView> getViewById(Long id) {
		UnionPayView ret = this.iUnionPayService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<UnionPayModel> findModelById(Long id) {
		UnionPayModel ret = this.iUnionPayService.findModelById(id);
		return ActionResult.ok(ret);
	}

}
