package com.longjun.cto.framework.sm.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeSaveDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeAppView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeView;
import com.longjun.cto.framework.sm.sys.service.ICommonUpgradeAppService;
import com.longjun.cto.framework.sm.sys.service.ICommonUpgradeService;

/**
 * CommonUpgrade Controller
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
@RequestMapping("/mgn/sys/upgrade/commonUpgrade")
@Controller
public class CommonUpgradeController extends StandardBaseController {

	@Autowired
	ICommonUpgradeService iCommonUpgradeService;
	
	@Autowired
	ICommonUpgradeAppService iCommonUpgradeAppService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/upgrade/commonUpgrade/commonUpgradeListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/upgrade/commonUpgrade/commonUpgradeAddInit");
		List<CommonUpgradeAppView> apps = this.iCommonUpgradeAppService.listAll();
		model.addObject("apps", apps);
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/upgrade/commonUpgrade/commonUpgradeEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonUpgradeShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonUpgradeShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/upgrade/commonUpgrade/commonUpgradeShowInit");
		CommonUpgradeView ret = this.iCommonUpgradeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonUpgradeView>> getByPage(CommonUpgradeDto dto){
		PageUtils<CommonUpgradeView> ret = this.iCommonUpgradeService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonUpgradeView> getViewById(long id){
		CommonUpgradeView ret = this.iCommonUpgradeService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonUpgradeModel> findModelById(long id){
		CommonUpgradeModel ret = this.iCommonUpgradeService.findModelById(id);
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
		Boolean ret = this.iCommonUpgradeService.stop(id);
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
		Boolean ret = this.iCommonUpgradeService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonUpgradeSaveDto dto){
		this.iCommonUpgradeService.saveModel(dto);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonUpgradeModifyDto model){
		this.iCommonUpgradeService.modify(model);
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
		Boolean ret = this.iCommonUpgradeService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
