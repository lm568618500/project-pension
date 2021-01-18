package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreRecordDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreRecordModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreRecordModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreRecordView;
import com.longjun.cto.framework.sm.users.service.IUserScoreRecordService;

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
 * UserScoreRecord Controller
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
@RequestMapping("/mgn/sm/users/userScoreRecord")
@Controller
public class UserScoreRecordController extends StandardBaseController {

	@Autowired
	IUserScoreRecordService iUserScoreRecordService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreRecordListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreRecordListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreRecord/userScoreRecordListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreRecordAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreRecordAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreRecord/userScoreRecordAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreRecordEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreRecordEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreRecord/userScoreRecordEditInit");
		UserScoreRecordView ret = this.iUserScoreRecordService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreRecordShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreRecordShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreRecord/userScoreRecordShowInit");
		UserScoreRecordView ret = this.iUserScoreRecordService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserScoreRecordView>> getByPage(UserScoreRecordDto dto){
		PageUtils<UserScoreRecordView> ret = this.iUserScoreRecordService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserScoreRecordView> getViewById(Long id){
		UserScoreRecordView ret = this.iUserScoreRecordService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserScoreRecordModel> findModelById(Long id){
		UserScoreRecordModel ret = this.iUserScoreRecordService.findModelById(id);
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
		Boolean ret = this.iUserScoreRecordService.stop(id);
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
		Boolean ret = this.iUserScoreRecordService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserScoreRecordModel model){
		this.iUserScoreRecordService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UserScoreRecordModifyDto model){
		this.iUserScoreRecordService.modify(model);
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
		Boolean ret = this.iUserScoreRecordService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
