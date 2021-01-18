package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminTokenView;
import com.longjun.cto.framework.sm.sys.service.IAdminTokenService;

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
 * AdminToken Coontroller
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:03
 */
@RequestMapping("/mgn/sm/sys/adminToken/adminToken")
@Controller
public class AdminTokenController extends StandardBaseController {

	@Autowired
	IAdminTokenService iAdminTokenService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/adminTokenListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView adminTokenListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/sys/adminToken/adminToken/adminTokenListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/adminTokenAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView adminTokenAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/sys/adminToken/adminToken/adminTokenAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/adminTokenEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView adminTokenEditInit() {
		ModelAndView model = getModelAndView("/mgn/sm/sys/adminToken/adminToken/adminTokenEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/adminTokenShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView adminTokenShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sm/sys/adminToken/adminToken/adminTokenShowInit");
		AdminTokenView ret = this.iAdminTokenService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<AdminTokenView>> getByPage(AdminTokenDto dto){
		PageUtils<AdminTokenView> ret = this.iAdminTokenService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<AdminTokenView> getViewById(long id){
		AdminTokenView ret = this.iAdminTokenService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<AdminTokenModel> findModelById(long id){
		AdminTokenModel ret = this.iAdminTokenService.findModelById(id);
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
		Boolean ret = this.iAdminTokenService.stop(id);
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
		Boolean ret = this.iAdminTokenService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(AdminTokenModel model){
		this.iAdminTokenService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(AdminTokenModifyDto model){
		this.iAdminTokenService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
}
