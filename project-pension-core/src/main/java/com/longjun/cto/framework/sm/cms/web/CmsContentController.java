package com.longjun.cto.framework.sm.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentTypeView;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentView;
import com.longjun.cto.framework.sm.cms.service.ICmsContentService;
import com.longjun.cto.framework.sm.cms.service.ICmsContentTypeService;
import com.longjun.cto.framework.sm.sys.annotation.Log;

/**
 * CmsContent Controller
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@RequestMapping("/mgn/sm/cms/cmsContent")
@Controller
public class CmsContentController extends StandardBaseController {

	@Autowired
	ICmsContentService iCmsContentService;

	@Autowired
	ICmsContentTypeService iCmsContentTypeService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsContentListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsContentListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/cmsContentListInit");
		List<CmsContentTypeView> types = this.iCmsContentTypeService.listByClassId(1L);
		model.addObject("types", types);
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsContentAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsContentAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/cmsContentAddInit");
		List<CmsContentTypeView> types = this.iCmsContentTypeService.listByClassId(1L);
		model.addObject("types", types);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsContentEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsContentEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/cmsContentEditInit");
		List<CmsContentTypeView> types = this.iCmsContentTypeService.listByClassId(1L);
		model.addObject("types", types);
		CmsContentView ret = this.iCmsContentService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsContentShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsContentShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/cmsContentShowInit");
		CmsContentView ret = this.iCmsContentService.findViewById(id);
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
	public ActionResult<PageUtils<CmsContentView>> getByPage(CmsContentDto dto) {
		PageUtils<CmsContentView> ret = this.iCmsContentService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<CmsContentView> getViewById(Long id) {
		CmsContentView ret = this.iCmsContentService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<CmsContentModel> findModelById(Long id) {
		CmsContentModel ret = this.iCmsContentService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001002L)
	@ResponseBody
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ApiResult stop(Long id) {
		Boolean ret = this.iCmsContentService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001001L)
	@ResponseBody
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ApiResult start(Long id) {
		Boolean ret = this.iCmsContentService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001000L)
	@ResponseBody
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ApiResult saveModel(CmsContentModel model) {
		this.iCmsContentService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001003L)
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ApiResult modify(CmsContentModifyDto model) {
		this.iCmsContentService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001004L)
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public ApiResult del(Long id) {
		Boolean ret = this.iCmsContentService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 协议管理
	 * 
	 * @return
	 */
	@GetMapping("/pactPage")
	public ModelAndView pactPage() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/pactPage");
		return model;
	}

	/**
	 * 编辑协议内容
	 * 
	 * @return
	 */
	@GetMapping("/editPactPage")
	public ModelAndView editPactPage(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/editPactPage");
		CmsContentView view = this.iCmsContentService.findViewById(id);
		model.addObject("view", view);
		return model;
	}

	/**
	 * 保存协议
	 * 
	 * @return
	 */
	@Log(eventUseId = 1001005L)
	@ResponseBody
	@PostMapping("/modifyPact")
	public ApiResult modifyPact(CmsContentModifyDto model) {
		boolean ret = this.iCmsContentService.modifyPact(model);
		return ApiResult.instance().ok("ret", "操作成功");
	}

	/**
	 * 单片文章管理
	 * 
	 * @return
	 */
	@GetMapping("/singlePage")
	public ModelAndView singlePage() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/singlePage");
		return model;
	}

	/**
	 * 编辑单片文章内容
	 * 
	 * @return
	 */
	@GetMapping("/editSinglePage")
	public ModelAndView editSinglePage(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/editSinglePage");
		CmsContentView view = this.iCmsContentService.findViewById(id);
		model.addObject("view", view);
		return model;
	}

	/**
	 * 保存单篇文章
	 * 
	 * @return
	 */
	@Log(eventUseId = 1001006L)
	@ResponseBody
	@PostMapping("/modifySingle")
	public ApiResult modifySingle(CmsContentModifyDto model) {
		boolean ret = this.iCmsContentService.modifySingle(model);
		return ApiResult.instance().ok("ret", "操作成功");
	}

	/**
	 * 帮助中心
	 * 
	 * @return
	 */
	@GetMapping("/helperPage")
	public ModelAndView helperPage() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/helperPage");
		return model;
	}

	/**
	 * 编辑帮助中心文章内容
	 * 
	 * @return
	 */
	@GetMapping("/editHelperPage")
	public ModelAndView editHelperPage(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsContent/editHelperPage");
		CmsContentView view = this.iCmsContentService.findViewById(id);
		model.addObject("view", view);
		return model;
	}

	/**
	 * 保存协议
	 * 
	 * @return
	 */
	@Log(eventUseId = 1001007L)
	@ResponseBody
	@PostMapping("/modifyHelper")
	public ApiResult modifyHelper(CmsContentModifyDto model) {
		boolean ret = this.iCmsContentService.modifyHelper(model);
		return ApiResult.instance().ok("ret", "操作成功");
	}
	
	/**
	 * 首页推荐
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001008L)
	@ResponseBody
	@RequestMapping(value = "/toIndex", method = { RequestMethod.POST })
	public ApiResult toIndex(Long id) {
		Boolean ret = this.iCmsContentService.toIndex(id);
		return ApiResult.instance().ok("ret", ret);
	}
	
	/**
	 * 取消首页推荐
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 1001009L)
	@ResponseBody
	@RequestMapping(value = "/toUnIndex", method = { RequestMethod.POST })
	public ApiResult toUnIndex(Long id) {
		Boolean ret = this.iCmsContentService.toUnIndex(id);
		return ApiResult.instance().ok("ret", ret);
	}

}
