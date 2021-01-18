package com.longjun.cto.framework.sm.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonKvDto;
import com.longjun.cto.framework.sm.sys.entity.view.CommonKvView;
import com.longjun.cto.framework.sm.sys.service.ICommonKvService;

@RequestMapping("/mgn/sys/common/kv")
@Controller
public class CommonKvController extends SmBaseController{
	
	@Autowired
	ICommonKvService iCommonKvService;
	
	@GetMapping("/listInit")
	public ModelAndView listInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/kv/listInit");
    	return model;
	}
	
    /**
     * 查询
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getByPage"  , method = {RequestMethod.GET , RequestMethod.POST})
    public ActionResult<PageUtils<CommonKvView>> getByPage(CommonKvDto dto)  {
    	PageUtils<CommonKvView> ret = this.iCommonKvService.getByPage(dto);
    	return ActionResult.ok(ret);
    }

}
