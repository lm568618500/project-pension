package com.longjun.cto.framework.project.pension.web.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.project.pension.base.CqcAdminBaseController;
import com.longjun.cto.framework.sm.sys.entity.model.CommonKvModel;
import com.longjun.cto.framework.sm.sys.service.ICommonKvService;
/**
 * 参数设置
 * @author Administrator
 *
 */
@RequestMapping("/mgn/sys")
@Controller
public class ConTplController extends CqcAdminBaseController{
	
	@Autowired
	private ICommonKvService  iCommonKvService;
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/contpl" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView settingDetail() {
		ModelAndView model = getModelAndView("/mgn/sys/contpl/contpl");
		Wrapper<CommonKvModel> wrapper = new EntityWrapper<CommonKvModel>();
		String k[] = {"CONTPL_NAME","CONTPL_PIC","CONTPL_CONTENT"}; 
		wrapper.in("k", k);
		List<CommonKvModel> commonKvs =  this.iCommonKvService.selectList(wrapper);
		Map<String, CommonKvModel> settingData = new HashMap<String, CommonKvModel>();
		for (CommonKvModel commonKvModel : commonKvs) {
			settingData.put(commonKvModel.getK(), commonKvModel);
		}
		model.addObject("contplData", settingData);
		return model;
	}
	
	/**
	 *编辑参数 
	 * @return
	 */
	@RequestMapping(value = "/editConTpl", method = RequestMethod.POST)
	@ResponseBody
	public ApiResult editSetting(ServletRequest request) {
		String contplName = request.getParameter("CONTPL_NAME");
		String contplPic = request.getParameter("CONTPL_PIC");
		String contplContent = request.getParameter("CONTPL_CONTENT");
		Wrapper<CommonKvModel> wrapper = new EntityWrapper<CommonKvModel>();
		String k[] = {"CONTPL_NAME","CONTPL_PIC","CONTPL_CONTENT"}; 
		wrapper.in("k", k);
		List<CommonKvModel> commonKvs =  this.iCommonKvService.selectList(wrapper);
		commonKvs.get(0).setV(contplName);
		commonKvs.get(1).setV(contplPic);
		commonKvs.get(2).setV(contplContent);
		this.iCommonKvService.updateBatchById(commonKvs);
		return ApiResult.instance().ok("ret" , true); 
	}
}