package com.longjun.cto.framework.sm.sys.web;

import java.util.List;

import org.mapstruct.BeforeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.LogAdminDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogAdminView;
import com.longjun.cto.framework.sm.sys.service.ILogAdminService;
import com.longjun.cto.framework.sm.sys.service.ILogEventService;

/**
 * 日志-管理员控制类
 * @author yangxuan
 * @date 2018年11月8日 下午7:13:37
 */
@RequestMapping("/mgn/sys/logs/admin")
@Controller
public class LogAdminController extends StandardBaseController{
	
	
	@Autowired
	ILogAdminService iLogAdminService;
	
	@Autowired
	ILogEventService iLogEventService;
	
	/**
	 * 列表初始化页面
	 * @return
	 */
	@RequestMapping(value = "/listInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView listInit() {
		ModelAndView model = getModelAndView("/mgn/sys/logs/admin/listInit");
		List<LogEventModel> events = this.iLogEventService.listModelByEtype(1);
		model.addObject("events", events);
    	return model;
	}
	
	/**
	 * 分页查看
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.GET , RequestMethod.POST}) 
	public ActionResult<PageUtils<LogAdminView>> getByPage(LogAdminDto dto){
		PageUtils<LogAdminView> ret = this.iLogAdminService.getByPage(dto);
		return ActionResult.ok(ret);
	}
	
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.GET , RequestMethod.POST}) 
	public ApiResult del(long id){
		boolean ret =this.iLogAdminService.deleteById(id);
		return ApiResult.instance().ok("ret" , ret);
	}

}
