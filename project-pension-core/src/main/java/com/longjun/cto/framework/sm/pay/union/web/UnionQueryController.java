package com.longjun.cto.framework.sm.pay.union.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionQueryDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionQueryModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionQueryModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionQueryView;
import com.longjun.cto.framework.sm.pay.union.service.IUnionQueryService;

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
 * UnionQuery Controller
 * @author yangxuan
 * @date 2019-11-02 02:52:27
 */
@RequestMapping("/mgn/sm/pay/union/unionQuery")
@Controller
public class UnionQueryController extends StandardBaseController {

	@Autowired
	IUnionQueryService iUnionQueryService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionQueryListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionQueryListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionQuery/unionQueryListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionQueryAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionQueryAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionQuery/unionQueryAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionQueryEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionQueryEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionQuery/unionQueryEditInit");
		UnionQueryView ret = this.iUnionQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/unionQueryShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView unionQueryShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/pay/union/unionQuery/unionQueryShowInit");
		UnionQueryView ret = this.iUnionQueryService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UnionQueryView>> getByPage(UnionQueryDto dto){
		PageUtils<UnionQueryView> ret = this.iUnionQueryService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UnionQueryView> getViewById(Long id){
		UnionQueryView ret = this.iUnionQueryService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UnionQueryModel> findModelById(Long id){
		UnionQueryModel ret = this.iUnionQueryService.findModelById(id);
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
		Boolean ret = this.iUnionQueryService.stop(id);
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
		Boolean ret = this.iUnionQueryService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UnionQueryModel model){
		this.iUnionQueryService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UnionQueryModifyDto model){
		this.iUnionQueryService.modify(model);
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
		Boolean ret = this.iUnionQueryService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
