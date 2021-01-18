package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserLevelDictModel;
import com.longjun.cto.framework.sm.users.entity.view.UserLevelDictView;
import com.longjun.cto.framework.sm.users.service.IUserLevelDictService;

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

import java.lang.Long;

/**
 * UserLevelDict Controller
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
@RequestMapping("/mgn/sm/users/userLevelDict")
@Controller
public class UserLevelDictController extends StandardBaseController {

	@Autowired
	IUserLevelDictService iUserLevelDictService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userLevelDictListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userLevelDictListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userLevelDict/userLevelDictListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userLevelDictAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userLevelDictAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userLevelDict/userLevelDictAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userLevelDictEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userLevelDictEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userLevelDict/userLevelDictEditInit");
		UserLevelDictView ret = this.iUserLevelDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userLevelDictShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userLevelDictShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userLevelDict/userLevelDictShowInit");
		UserLevelDictView ret = this.iUserLevelDictService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserLevelDictView>> getByPage(UserLevelDictDto dto){
		PageUtils<UserLevelDictView> ret = this.iUserLevelDictService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserLevelDictView> getViewById(Long id){
		UserLevelDictView ret = this.iUserLevelDictService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserLevelDictModel> findModelById(Long id){
		UserLevelDictModel ret = this.iUserLevelDictService.findModelById(id);
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
		Boolean ret = this.iUserLevelDictService.stop(id);
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
		Boolean ret = this.iUserLevelDictService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserLevelDictModel model){
		this.iUserLevelDictService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UserLevelDictModifyDto model){
		this.iUserLevelDictService.modify(model);
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
		Boolean ret = this.iUserLevelDictService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
