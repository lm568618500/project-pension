package com.longjun.cto.framework.project.pension.web.finance;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeFourModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeThreeModel;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeFourView;
import com.longjun.cto.framework.project.pension.finance.service.INewTypeFourService;
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
 * NewTypeFour Controller
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@RequestMapping("/mgn/finance/newTypeFour")
@Controller
public class NewTypeFourController extends StandardBaseController {

	@Autowired
	INewTypeFourService iNewTypeFourService;
	@Autowired
	INewTypeOneService iNewTypeOneService;

	@Autowired
	INewTypeTwoService iNewTypeTwoService;
	@Autowired
	INewTypeThreeService iNewTypeThreeService;

	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeFourListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeFourListInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeFour/newTypeFourListInit");
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		oneWrapper.orderBy("sort");
		model.addObject("oneList",oneList);
		EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
		twoWrapper.orderBy("sort");
		List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
		model.addObject("twoList",twoList);
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeFourAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeFourAddInit() {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeFour/newTypeFourAddInit");
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
	@RequestMapping(value = "/newTypeFourEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeFourEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeFour/newTypeFourEditInit");
		NewTypeFourView ret = this.iNewTypeFourService.findViewById(id);
		model.addObject("view", ret);
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
		twoWrapper.eq("parent_one_id",ret.getOneParentId()).eq("status",1).eq("is_del",0).orderBy("sort");
		List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
		model.addObject("twoList", twoList);
		EntityWrapper<NewTypeThreeModel> threeWrapper=new EntityWrapper<NewTypeThreeModel>();
		threeWrapper.eq("two_parent_id",ret.getTwoParentId()).eq("status",1).eq("is_del",0).orderBy("sort");;
		List<NewTypeThreeModel> threeList=this.iNewTypeThreeService.selectList(threeWrapper);
		model.addObject("threeList", threeList);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newTypeFourShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newTypeFourShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/newTypeFour/newTypeFourShowInit");
		NewTypeFourView ret = this.iNewTypeFourService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<NewTypeFourView>> getByPage(NewTypeFourDto dto){
		PageUtils<NewTypeFourView> ret = this.iNewTypeFourService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeFourView> getViewById(Long id){
		NewTypeFourView ret = this.iNewTypeFourService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<NewTypeFourModel> findModelById(Long id){
		NewTypeFourModel ret = this.iNewTypeFourService.findModelById(id);
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
		Boolean ret = this.iNewTypeFourService.stop(id);
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
		Boolean ret = this.iNewTypeFourService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(NewTypeFourModel model){
		this.iNewTypeFourService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(NewTypeFourModifyDto model){
		this.iNewTypeFourService.modify(model);
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
		Boolean ret = this.iNewTypeFourService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	/**
	 * 通用API接口查询-根据一级分类，查询二级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getFourJson" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<NewTypeFourModel>> getPeriodJson(long id){
		EntityWrapper<NewTypeFourModel> wrapper=new EntityWrapper<NewTypeFourModel>();
		wrapper.eq("three_parent_id", id);
		wrapper.eq("status", 1).eq("is_del",0).orderBy("sort");;
		List<NewTypeFourModel> ret = this.iNewTypeFourService.selectList(wrapper);
		return ActionResult.ok(ret);
	}
}
