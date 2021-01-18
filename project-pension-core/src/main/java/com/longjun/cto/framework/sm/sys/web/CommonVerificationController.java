package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationView;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationService;

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
 * CommonVerification Controller
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
@RequestMapping("/mgn/sys/common/commonVerification")
@Controller
public class CommonVerificationController extends StandardBaseController {

	@Autowired
	ICommonVerificationService iCommonVerificationService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonVerificationListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonVerificationListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/commonVerification/commonVerificationListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonVerificationAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonVerificationAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/commonVerification/commonVerificationAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonVerificationEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonVerificationEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/commonVerification/commonVerificationEditInit");
		CommonVerificationView ret = this.iCommonVerificationService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonVerificationShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonVerificationShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/commonVerification/commonVerificationShowInit");
		CommonVerificationView ret = this.iCommonVerificationService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonVerificationView>> getByPage(CommonVerificationDto dto){
		PageUtils<CommonVerificationView> ret = this.iCommonVerificationService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonVerificationView> getViewById(Long id){
		CommonVerificationView ret = this.iCommonVerificationService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonVerificationModel> findModelById(Long id){
		CommonVerificationModel ret = this.iCommonVerificationService.findModelById(id);
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
		Boolean ret = this.iCommonVerificationService.stop(id);
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
		Boolean ret = this.iCommonVerificationService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonVerificationModel model){
		this.iCommonVerificationService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonVerificationModifyDto model){
		this.iCommonVerificationService.modify(model);
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
		Boolean ret = this.iCommonVerificationService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
