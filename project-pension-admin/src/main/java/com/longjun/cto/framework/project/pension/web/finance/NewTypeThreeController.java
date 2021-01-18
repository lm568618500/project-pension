package com.longjun.cto.framework.project.pension.web.finance;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeThreeDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeThreeModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeThreeModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeThreeView;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeOneService;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeThreeService;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * NewTypeThree Controller
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@RequestMapping("/mgn/finance/newTypeThree")
@Controller
public class NewTypeThreeController extends StandardBaseController {

	@Autowired
	INewTypeThreeService iNewTypeThreeService;

	@Autowired
	INewTypeOneService iNewTypeOneService;

	@Autowired
	INewTypeTwoService iNewTypeTwoService;

	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeThreeListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeThreeListInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeThree/newTypeThreeListInit");
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
	@RequestMapping(value = "/newTypeThreeAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeThreeAddInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeThree/newTypeThreeAddInit");
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
	@RequestMapping(value = "/newTypeThreeEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeThreeEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeThree/newTypeThreeEditInit");
		NewTypeThreeView ret = this.iNewTypeThreeService.findViewById(id);
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		model.addObject("view", ret);
		EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
		twoWrapper.eq("parent_one_id",ret.getOneParentId()).eq("status",1).eq("is_del",0).orderBy("sort");;
		List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
		model.addObject("twoList", twoList);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeThreeShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeThreeShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeThree/newTypeThreeShowInit");
		NewTypeThreeView ret = this.iNewTypeThreeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<NewTypeThreeView>> getByPage(NewTypeThreeDto dto){
		PageUtils<NewTypeThreeView> ret = this.iNewTypeThreeService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeThreeView> getViewById(Long id){
		NewTypeThreeView ret = this.iNewTypeThreeService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeThreeModel> findModelById(Long id){
		NewTypeThreeModel ret = this.iNewTypeThreeService.findModelById(id);
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
		Boolean ret = this.iNewTypeThreeService.stop(id);
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
		Boolean ret = this.iNewTypeThreeService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(NewTypeThreeModel model){
		this.iNewTypeThreeService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(NewTypeThreeModifyDto model){
		this.iNewTypeThreeService.modify(model);
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
		Boolean ret = this.iNewTypeThreeService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	/**
	 * 通用API接口查询-根据一级分类，查询二级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getThreeJson" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<NewTypeThreeModel>> getThreeJson(long id){
		EntityWrapper<NewTypeThreeModel> wrapper=new EntityWrapper<NewTypeThreeModel>();
		wrapper.eq("two_parent_id", id);
		wrapper.eq("status", 1).eq("is_del",0).orderBy("sort");
		List<NewTypeThreeModel> ret = this.iNewTypeThreeService.selectList(wrapper);
		return ActionResult.ok(ret);
	}
}
