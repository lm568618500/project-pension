package com.longjun.cto.framework.project.pension.web.finance;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeTwoDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeTwoModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeTwoView;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeOneService;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * NewTypeTwo Controller
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@RequestMapping("/mgn/finance/newTypeTwo")
@Controller
public class NewTypeTwoController extends StandardBaseController {

	@Autowired
	INewTypeTwoService iNewTypeTwoService;
	@Autowired
	INewTypeOneService iNewTypeOneService;
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeTwoListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeTwoListInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeTwo/newTypeTwoListInit");
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
	@RequestMapping(value = "/newTypeTwoAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeTwoAddInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeTwo/newTypeTwoAddInit");
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeTwoEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeTwoEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeTwo/newTypeTwoEditInit");
		NewTypeTwoView ret = this.iNewTypeTwoService.findViewById(id);
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeTwoShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeTwoShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeTwo/newTypeTwoShowInit");
		NewTypeTwoView ret = this.iNewTypeTwoService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<NewTypeTwoView>> getByPage(NewTypeTwoDto dto){
		PageUtils<NewTypeTwoView> ret = this.iNewTypeTwoService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeTwoView> getViewById(Long id){
		NewTypeTwoView ret = this.iNewTypeTwoService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeTwoModel> findModelById(Long id){
		NewTypeTwoModel ret = this.iNewTypeTwoService.findModelById(id);
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
		Boolean ret = this.iNewTypeTwoService.stop(id);
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
		Boolean ret = this.iNewTypeTwoService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(NewTypeTwoModel model){
		this.iNewTypeTwoService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(NewTypeTwoModifyDto model){
		this.iNewTypeTwoService.modify(model);
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
		Boolean ret = this.iNewTypeTwoService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	/**
	 * 通用API接口查询-根据一级分类，查询二级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOneJson" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<NewTypeTwoModel>> getPeriodJson(long id){
		EntityWrapper<NewTypeTwoModel> wrapper=new EntityWrapper<NewTypeTwoModel>();
		wrapper.eq("parent_one_id ", id);
		wrapper.eq("status", 1).eq("is_del",0).orderBy("sort");
		List<NewTypeTwoModel> ret = this.iNewTypeTwoService.selectList(wrapper);
		return ActionResult.ok(ret);
	}
}
