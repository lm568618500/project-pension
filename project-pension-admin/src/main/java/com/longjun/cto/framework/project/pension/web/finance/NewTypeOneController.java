package com.longjun.cto.framework.project.pension.web.finance;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeOneDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeOneModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeOneView;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * NewTypeOne Controller
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@RequestMapping("/mgn/finance/newTypeOne")
@Controller
public class NewTypeOneController extends StandardBaseController {

	@Autowired
	INewTypeOneService iNewTypeOneService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeOneListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeOneListInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeOne/newTypeOneListInit");
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeOneAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeOneAddInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeOne/newTypeOneAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeOneEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeOneEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeOne/newTypeOneEditInit");
		NewTypeOneView ret = this.iNewTypeOneService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeOneShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeOneShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeOne/newTypeOneShowInit");
		NewTypeOneView ret = this.iNewTypeOneService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<NewTypeOneView>> getByPage(NewTypeOneDto dto){
		PageUtils<NewTypeOneView> ret = this.iNewTypeOneService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeOneView> getViewById(Long id){
		NewTypeOneView ret = this.iNewTypeOneService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeOneModel> findModelById(Long id){
		NewTypeOneModel ret = this.iNewTypeOneService.findModelById(id);
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
		Boolean ret = this.iNewTypeOneService.stop(id);
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
		Boolean ret = this.iNewTypeOneService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(NewTypeOneModel model){
		this.iNewTypeOneService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(NewTypeOneModifyDto model){
		this.iNewTypeOneService.modify(model);
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
		Boolean ret = this.iNewTypeOneService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
