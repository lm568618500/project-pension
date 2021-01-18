package com.longjun.cto.framework.project.pension.web.finance;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewsDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewsModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.*;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewsView;
import com.longjun.cto.framework.project.pension.finance.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * News Controller
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@RequestMapping("/mgn/finance/news")
@Controller
public class NewsController extends StandardBaseController {

	@Autowired
	INewsService iNewsService;
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
	@RequestMapping(value = "/newsListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newsListInit() {
		ModelAndView model = getModelAndView("/mgn/finance/news/newsListInit");
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
	@RequestMapping(value = "/newsAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newsAddInit() {
		ModelAndView model = getModelAndView("/mgn/finance/news/newsAddInit");
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
	@RequestMapping(value = "/newsEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newsEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/news/newsEditInit");
		NewsView ret = this.iNewsService.findViewById(id);
		model.addObject("view", ret);
		EntityWrapper<NewTypeOneModel> oneWrapper=new EntityWrapper<NewTypeOneModel>();
		oneWrapper.orderBy("sort");
		List<NewTypeOneModel> oneList=this.iNewTypeOneService.selectList(oneWrapper);
		model.addObject("oneList",oneList);
		EntityWrapper<NewTypeTwoModel> twoWrapper=new EntityWrapper<NewTypeTwoModel>();
		twoWrapper.eq("parent_one_id",ret.getTypeOneId()).eq("status",1).eq("is_del",0).orderBy("sort");
		List<NewTypeTwoModel> twoList=this.iNewTypeTwoService.selectList(twoWrapper);
		model.addObject("twoList", twoList);
		EntityWrapper<NewTypeThreeModel> threeWrapper=new EntityWrapper<NewTypeThreeModel>();
		threeWrapper.eq("two_parent_id",ret.getTypeTwoId()).eq("status",1).eq("is_del",0).orderBy("sort");
		List<NewTypeThreeModel> threeList=this.iNewTypeThreeService.selectList(threeWrapper);
		model.addObject("threeList", threeList);
		EntityWrapper<NewTypeFourModel> fourWrapper=new EntityWrapper<NewTypeFourModel>();
		fourWrapper.eq("three_parent_id",ret.getTypeThreeId()).eq("status",1).eq("is_del",0).orderBy("sort");
		List<NewTypeFourModel> FourList=this.iNewTypeFourService.selectList(fourWrapper);
		model.addObject("fourList", FourList);
		List<String> img=new ArrayList<String>();
		if(!ret.getImagesList().isEmpty()){
			String[] imgs=ret.getImagesList().split(",");
			for (int i = 0; i < imgs.length; i++) {
				if(StringUtils.isNoneBlank(imgs[i])){
					img.add(imgs[i]);
				}
			}
		}
		model.addObject("img", img);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/newsShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView newsShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/finance/news/newsShowInit");
		NewsView ret = this.iNewsService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<NewsView>> getByPage(NewsDto dto){
		PageUtils<NewsView> ret = this.iNewsService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<NewsView> getViewById(Long id){
		NewsView ret = this.iNewsService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<NewsModel> findModelById(Long id){
		NewsModel ret = this.iNewsService.findModelById(id);
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
		Boolean ret = this.iNewsService.stop(id);
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
		Boolean ret = this.iNewsService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(NewsModel model){
		this.iNewsService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(NewsModifyDto model){
		this.iNewsService.modify(model);
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
		Boolean ret = this.iNewsService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
