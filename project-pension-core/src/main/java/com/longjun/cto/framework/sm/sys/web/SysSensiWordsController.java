package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsView;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsService;

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
 * SysSensiWords Controller
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
@RequestMapping("/mgn/sys/sysSensiWords")
@Controller
public class SysSensiWordsController extends StandardBaseController {

	@Autowired
	ISysSensiWordsService iSysSensiWordsService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWords/sysSensiWordsListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWords/sysSensiWordsAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWords/sysSensiWordsEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/sysSensiWordsShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView sysSensiWordsShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/sysSensiWords/sysSensiWordsShowInit");
		SysSensiWordsView ret = this.iSysSensiWordsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<SysSensiWordsView>> getByPage(SysSensiWordsDto dto){
		PageUtils<SysSensiWordsView> ret = this.iSysSensiWordsService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<SysSensiWordsView> getViewById(long id){
		SysSensiWordsView ret = this.iSysSensiWordsService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<SysSensiWordsModel> findModelById(long id){
		SysSensiWordsModel ret = this.iSysSensiWordsService.findModelById(id);
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
		Boolean ret = this.iSysSensiWordsService.stop(id);
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
		Boolean ret = this.iSysSensiWordsService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(SysSensiWordsModel model){
		this.iSysSensiWordsService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(SysSensiWordsModifyDto model){
		this.iSysSensiWordsService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
