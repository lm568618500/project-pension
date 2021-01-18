package com.longjun.cto.framework.sm.cms.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

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
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerLocationDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerLocationModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerLocationModel;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerLocationView;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerView;
import com.longjun.cto.framework.sm.cms.service.ICmsBannerLocationService;
import com.longjun.cto.framework.sm.cms.service.ICmsBannerService;
import com.longjun.cto.framework.sm.sys.annotation.Log;

import cn.hutool.core.convert.Convert;

/**
 * CmsBannerLocation Controller
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
@RequestMapping("/mgn/sm/cms/cmsBannerLocation")
@Controller
public class CmsBannerLocationController extends StandardBaseController {

	@Autowired
	private ICmsBannerLocationService iCmsBannerLocationService;

	@Autowired
	private ICmsBannerService iCmsBannerService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerLocationListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsBannerLocationListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBannerLocation/cmsBannerLocationListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerLocationAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsBannerLocationAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBannerLocation/cmsBannerLocationAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerLocationEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsBannerLocationEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBannerLocation/cmsBannerLocationEditInit");
		CmsBannerLocationView ret = this.iCmsBannerLocationService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cmsBannerLocationShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cmsBannerLocationShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBannerLocation/cmsBannerLocationShowInit");
		CmsBannerLocationView ret = this.iCmsBannerLocationService.findViewById(id);
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
	public ActionResult<PageUtils<CmsBannerLocationView>> getByPage(CmsBannerLocationDto dto) {
		PageUtils<CmsBannerLocationView> ret = this.iCmsBannerLocationService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<CmsBannerLocationView> getViewById(Long id) {
		CmsBannerLocationView ret = this.iCmsBannerLocationService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<CmsBannerLocationModel> findModelById(Long id) {
		CmsBannerLocationModel ret = this.iCmsBannerLocationService.findModelById(id);
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
		Boolean ret = this.iCmsBannerLocationService.stop(id);
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
		Boolean ret = this.iCmsBannerLocationService.start(id);
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
	public ApiResult saveModel(CmsBannerLocationModel model) {
		this.iCmsBannerLocationService.saveModel(model);
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
	public ApiResult modify(CmsBannerLocationModifyDto model) {
		this.iCmsBannerLocationService.modify(model);
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
		Boolean ret = this.iCmsBannerLocationService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 管理banner
	 * 
	 * @param locationId
	 * @return
	 */
	@GetMapping("/managerBanner")
	public ModelAndView managerBanner(Long locationId) {
		ModelAndView model = getModelAndView("/mgn/sm/cms/cmsBannerLocation/managerBanner");
		List<CmsBannerView> banners = this.iCmsBannerService.listByLocation(locationId);
		model.addObject("banners", banners);
		CmsBannerLocationView ret = this.iCmsBannerLocationService.findViewById(locationId);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 管理banner
	 * 
	 * @param locationId
	 * @return
	 */
	@Log(eventUseId = 1000000L, contet = "编辑横幅")
	@ResponseBody
	@PostMapping("/saveBanners")
	public ApiResult saveBanners(HttpServletRequest request) {
		Long locationId = Convert.toLong(request.getParameter("id"), -1L);
		Map<String, String[]> params = request.getParameterMap();
		Map<Long, String> bannerCondition = new HashMap<Long, String>();
		for (Entry<String, String[]> entry : params.entrySet()) {
//			log.info(entry.getKey() + " | " + entry.getValue()[0]);
			if (entry.getKey().startsWith("images_")) {
				// 前台页面参数需要按照要求传递
				bannerCondition.put(Convert.toLong(entry.getKey().split("_")[1], -1L), entry.getValue()[0]);
			}
		}
		for (Entry<Long, String> entry : bannerCondition.entrySet()) {
			CmsBannerModel cmsBannerModel = this.iCmsBannerService.selectById(entry.getKey());
			cmsBannerModel.setLastupdate(new Date());
			cmsBannerModel.setImages(entry.getValue());
			cmsBannerModel.setUrls(request.getParameter("urls_" + entry.getKey()));
			this.iCmsBannerService.updateById(cmsBannerModel);
		}
		return ApiResult.instance().ok("ret", true);
	}
}
