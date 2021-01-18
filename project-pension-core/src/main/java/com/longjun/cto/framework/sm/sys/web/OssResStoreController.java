package com.longjun.cto.framework.sm.sys.web;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResStoreDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResStoreModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResSettingModel;
import com.longjun.cto.framework.sm.sys.entity.model.OssResStoreModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSettingView;
import com.longjun.cto.framework.sm.sys.entity.view.OssResStoreView;
import com.longjun.cto.framework.sm.sys.service.IOssResSettingService;
import com.longjun.cto.framework.sm.sys.service.IOssResStoreService;

/**
 * OssResStore Controller
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
@RequestMapping("/mgn/sys/ossResStore")
@Controller
public class OssResStoreController extends StandardBaseController {

	@Autowired
	IOssResStoreService iOssResStoreService;
	
	@Autowired
	IOssResSettingService iOssResSettingService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResStoreListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResStoreListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/ossResStore/ossResStoreListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResStoreAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResStoreAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/ossResStore/ossResStoreAddInit");
		Wrapper<OssResSettingModel> wrapper = new EntityWrapper<OssResSettingModel>();
		wrapper.eq("status", 1);
		wrapper.eq("is_del", 0);
		wrapper.eq("p_id", 0);
		List<OssResSettingModel> settings = this.iOssResSettingService.selectList(wrapper);
		model.addObject("settings", settings);
		return model;
	}
	
	
	/**
	 * 查询ResData数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getResDataBypId" , method = {RequestMethod.POST})
	public ActionResult<List<OssResSettingModel>> getResDataBypId(long pId){
		Wrapper<OssResSettingModel> wrapper = new EntityWrapper<OssResSettingModel>();
		wrapper.eq("status", 1);
		wrapper.eq("is_del", 0);
		wrapper.eq("p_id", pId);
		List<OssResSettingModel> settings = this.iOssResSettingService.selectList(wrapper);
		return ActionResult.ok(settings); 
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResStoreEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResStoreEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/ossResStore/ossResStoreEditInit");
		OssResStoreView ret = this.iOssResStoreService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/ossResStoreShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ossResStoreShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/ossResStore/ossResStoreShowInit");
		OssResStoreView ret = this.iOssResStoreService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<OssResStoreView>> getByPage(OssResStoreDto dto){
		PageUtils<OssResStoreView> ret = this.iOssResStoreService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<OssResStoreView> getViewById(long id){
		OssResStoreView ret = this.iOssResStoreService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<OssResStoreModel> findModelById(long id){
		OssResStoreModel ret = this.iOssResStoreService.findModelById(id);
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
		Boolean ret = this.iOssResStoreService.stop(id);
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
		Boolean ret = this.iOssResStoreService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(OssResStoreModel model){
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		model.setResSuf(FilenameUtils.getExtension(model.getResName()));
		this.iOssResStoreService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(OssResStoreModifyDto model){
		this.iOssResStoreService.modify(model);
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
		Boolean ret = this.iOssResStoreService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
