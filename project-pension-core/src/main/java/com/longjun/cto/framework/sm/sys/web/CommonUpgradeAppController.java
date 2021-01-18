package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeAppModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeAppView;
import com.longjun.cto.framework.sm.sys.service.ICommonUpgradeAppService;

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
 * CommonUpgradeApp Controller
 * @author yangxuan
 * @date 2019-04-09 08:42:08
 */
@RequestMapping("/mgn/sys/commonUpgradeApp")
@Controller
public class CommonUpgradeAppController extends StandardBaseController {

	@Autowired
	ICommonUpgradeAppService iCommonUpgradeAppService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeAppListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeAppListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/commonUpgradeApp/commonUpgradeAppListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeAppAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeAppAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/commonUpgradeApp/commonUpgradeAppAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeAppEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeAppEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/commonUpgradeApp/commonUpgradeAppEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeAppShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeAppShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/commonUpgradeApp/commonUpgradeAppShowInit");
		CommonUpgradeAppView ret = this.iCommonUpgradeAppService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonUpgradeAppView>> getByPage(CommonUpgradeAppDto dto){
		PageUtils<CommonUpgradeAppView> ret = this.iCommonUpgradeAppService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonUpgradeAppView> getViewById(long id){
		CommonUpgradeAppView ret = this.iCommonUpgradeAppService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonUpgradeAppModel> findModelById(long id){
		CommonUpgradeAppModel ret = this.iCommonUpgradeAppService.findModelById(id);
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
		Boolean ret = this.iCommonUpgradeAppService.stop(id);
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
		Boolean ret = this.iCommonUpgradeAppService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonUpgradeAppModel model){
		this.iCommonUpgradeAppService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonUpgradeAppModifyDto model){
		this.iCommonUpgradeAppService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id){
		Boolean ret = this.iCommonUpgradeAppService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
