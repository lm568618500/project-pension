package com.longjun.cto.framework.sm.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.dto.LogUserDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogUserView;
import com.longjun.cto.framework.sm.sys.service.ILogEventService;
import com.longjun.cto.framework.sm.sys.service.ILogUserService;

/**
 * 日志-用户控制类
 * @author yangxuan
 * @date 2018年11月8日 下午7:13:37
 */
@RequestMapping("/mgn/sys/logs/user")
@Controller
public class LogUserController extends StandardBaseController{
	
	@Autowired
	ILogUserService iLogUserService;
	
	@Autowired
	ILogEventService iLogEventService;
	
	/**
	 * 列表初始化页面
	 * @return
	 */
	@RequestMapping(value = "/listInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView listInit() {
		ModelAndView model = getModelAndView("/mgn/sys/logs/user/listInit");
		List<LogEventModel> events = this.iLogEventService.listModelByEtype(2);
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
	public ActionResult<PageUtils<LogUserView>> getByPage(LogUserDto dto){
		PageUtils<LogUserView> ret = this.iLogUserService.getByPage(dto);
		return ActionResult.ok(ret);
	}

}
