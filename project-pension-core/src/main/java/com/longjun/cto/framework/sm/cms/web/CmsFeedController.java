package com.longjun.cto.framework.sm.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedAckView;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedView;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedAckService;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedService;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.web.SmBaseController;

/**
 * CmsFeed Controller
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@RequestMapping("/mgn/sm/cms/cmsFeed")
@Controller
public class CmsFeedController extends SmBaseController {

	@Autowired
	ICmsFeedService iCmsFeedService;

	@Autowired
	ICmsFeedAckService iCmsFeedAckService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsFeedListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsFeed/cmsFeedListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsFeedAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsFeed/cmsFeedAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsFeedEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsFeed/cmsFeedEditInit");
		CmsFeedView ret = this.iCmsFeedService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsFeedShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsFeedShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsFeed/cmsFeedShowInit");
		CmsFeedView ret = this.iCmsFeedService.findViewById(id);
		model.addObject("view", ret);
		CmsFeedAckView cmsFeedAckView = this.iCmsFeedAckService.findByFeedNo(ret.getFeedNo());
		model.addObject("cmsFeedAckView", cmsFeedAckView);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<CmsFeedView>> getByPage(CmsFeedDto dto) {
		PageUtils<CmsFeedView> ret = this.iCmsFeedService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<CmsFeedView> getViewById(Long id) {
		CmsFeedView ret = this.iCmsFeedService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<CmsFeedModel> findModelById(Long id) {
		CmsFeedModel ret = this.iCmsFeedService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ApiResult stop(Long id) {
		Boolean ret = this.iCmsFeedService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ApiResult start(Long id) {
		Boolean ret = this.iCmsFeedService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ApiResult saveModel(CmsFeedModel model) {
		this.iCmsFeedService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ApiResult modify(CmsFeedModifyDto model) {
		AdminView adminView = currentAdmin();
		model.setAdminId(adminView.getId());
		this.iCmsFeedService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public ApiResult del(Long id) {
		Boolean ret = this.iCmsFeedService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

}
