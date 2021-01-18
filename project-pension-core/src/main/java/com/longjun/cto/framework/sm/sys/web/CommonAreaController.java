package com.longjun.cto.framework.sm.sys.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonAreaView;
import com.longjun.cto.framework.sm.sys.service.ICommonAreaService;

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
 * CommonArea Controller
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@RequestMapping("/mgn/sys/commonArea")
@Controller
public class CommonAreaController extends StandardBaseController {

	@Autowired
	ICommonAreaService iCommonAreaService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonAreaListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonAreaListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/area/commonAreaListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonAreaAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonAreaAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/area/commonAreaAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonAreaEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonAreaEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/area/commonAreaEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/commonAreaShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView commonAreaShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/area/commonAreaShowInit");
		CommonAreaView ret = this.iCommonAreaService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<CommonAreaView>> getByPage(CommonAreaDto dto){
		PageUtils<CommonAreaView> ret = this.iCommonAreaService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<CommonAreaView> getViewById(long id){
		CommonAreaView ret = this.iCommonAreaService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<CommonAreaModel> findModelById(long id){
		CommonAreaModel ret = this.iCommonAreaService.findModelById(id);
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
		Boolean ret = this.iCommonAreaService.stop(id);
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
		Boolean ret = this.iCommonAreaService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(CommonAreaModel model){
		this.iCommonAreaService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(CommonAreaModifyDto model){
		this.iCommonAreaService.modify(model);
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
		Boolean ret = this.iCommonAreaService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 通用API接口查询-根据省Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAreaByCId" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<List<Map<String,Object>>> getAreaByCId(String cityId){
		List<Map<String,Object>> ret = this.iCommonAreaService.getAreaByCId(cityId);
		return ActionResult.ok(ret); 
	}
	
}
