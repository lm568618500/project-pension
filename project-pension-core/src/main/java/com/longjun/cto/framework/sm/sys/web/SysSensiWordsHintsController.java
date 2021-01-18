package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsHintsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsHintsView;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsHintsService;

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
 * SysSensiWordsHints Controller
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
@RequestMapping("/mgn/sys/sysSensiWordsHints")
@Controller
public class SysSensiWordsHintsController extends StandardBaseController {

	@Autowired
	ISysSensiWordsHintsService iSysSensiWordsHintsService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsHintsListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsHintsListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWordsHints/sysSensiWordsHintsListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsHintsAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsHintsAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWordsHints/sysSensiWordsHintsAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsHintsEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsHintsEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWordsHints/sysSensiWordsHintsEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsHintsShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsHintsShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWordsHints/sysSensiWordsHintsShowInit");
		SysSensiWordsHintsView ret = this.iSysSensiWordsHintsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<SysSensiWordsHintsView>> getByPage(SysSensiWordsHintsDto dto){
		PageUtils<SysSensiWordsHintsView> ret = this.iSysSensiWordsHintsService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<SysSensiWordsHintsView> getViewById(long id){
		SysSensiWordsHintsView ret = this.iSysSensiWordsHintsService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<SysSensiWordsHintsModel> findModelById(long id){
		SysSensiWordsHintsModel ret = this.iSysSensiWordsHintsService.findModelById(id);
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
		Boolean ret = this.iSysSensiWordsHintsService.stop(id);
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
		Boolean ret = this.iSysSensiWordsHintsService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(SysSensiWordsHintsModel model){
		this.iSysSensiWordsHintsService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(SysSensiWordsHintsModifyDto model){
		this.iSysSensiWordsHintsService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
