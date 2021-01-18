package com.longjun.cto.framework.sm.sys.web;

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
import com.longjun.cto.framework.sm.sys.annotation.Log;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonOptionDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonOptionModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;

/**
 * 通用OPTION 控制类
 * 
 * @author yangxuan
 * @date Jun 6, 2019 - 2:13:23 PM
 */
@RequestMapping("/mgn/sys/common/option")
@Controller
public class CommonOptionController extends StandardBaseController {

	@Autowired
	private ICommonOptionService iCommonOptionService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commonOptionListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView commonProvinceListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/common/option/commonOptionListInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commonoptionEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView commonoptionEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sys/common/option/commonoptionEditInit");
		CommonOptionModel ret = this.iCommonOptionService.selectById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<CommonOptionView>> getByPage(CommonOptionDto dto) {
		PageUtils<CommonOptionView> ret = this.iCommonOptionService.getByPage(dto);
		return ActionResult.ok(ret);
	}
	
	/**
	 * 修改
	 * @param id
	 * @param key
	 * @param value
	 * @return
	 */
	@Log(eventUseId = 2002000L)
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST, RequestMethod.GET })
	public ApiResult modify(Long id ,String key , String value) {
		this.iCommonOptionService.updateModelByKeyVal(key, value);
		return ApiResult.instance().ok("ret" , true); 
	}

}
