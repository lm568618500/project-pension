package ${codeParentPakage}.${codePakage}.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
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
import ${codeParentPakage}.${codePakage}.entity.model.${className}Model;
import ${codeParentPakage}.${codePakage}.entity.view.${className}View;
import ${codeParentPakage}.${codePakage}.entity.dto.${className}Dto;
import ${codeParentPakage}.${codePakage}.entity.dto.${className}ModifyDto;
import ${codeParentPakage}.${codePakage}.service.I${className}Service;
import java.lang.Long;

/**
 * ${className} Controller
 * @author ${author}
 * @date ${crateDate}
 */
@RequestMapping("${ftlPath}/${className?uncap_first}")
@Controller
public class ${className}Controller extends StandardBaseController {

	@Autowired
	I${className}Service i${className}Service;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/${className?uncap_first}ListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ${className?uncap_first}ListInit() {
		ModelAndView model = getModelAndView("${ftlPath}/${className?uncap_first}/${className?uncap_first}ListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/${className?uncap_first}AddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ${className?uncap_first}AddInit() {
		ModelAndView model = getModelAndView("${ftlPath}/${className?uncap_first}/${className?uncap_first}AddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/${className?uncap_first}EditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ${className?uncap_first}EditInit(Long id) {
		ModelAndView model = getModelAndView("${ftlPath}/${className?uncap_first}/${className?uncap_first}EditInit");
		${className}View ret = this.i${className}Service.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/${className?uncap_first}ShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView ${className?uncap_first}ShowInit(Long id) {
		ModelAndView model = getModelAndView("${ftlPath}/${className?uncap_first}/${className?uncap_first}ShowInit");
		${className}View ret = this.i${className}Service.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<${className}View>> getByPage(${className}Dto dto){
		PageUtils<${className}View> ret = this.i${className}Service.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<${className}View> getViewById(Long id){
		${className}View ret = this.i${className}Service.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<${className}Model> findModelById(Long id){
		${className}Model ret = this.i${className}Service.findModelById(id);
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
		Boolean ret = this.i${className}Service.stop(id);
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
		Boolean ret = this.i${className}Service.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(${className}Model model){
		this.i${className}Service.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(${className}ModifyDto model){
		this.i${className}Service.modify(model);
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
		Boolean ret = this.i${className}Service.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
