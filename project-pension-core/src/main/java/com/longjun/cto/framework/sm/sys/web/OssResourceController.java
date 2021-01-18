package com.longjun.cto.framework.sm.sys.web;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import com.longjun.cto.framework.sm.cms.service.IImageService;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResourceDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResourceModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResourceModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSaveView;
import com.longjun.cto.framework.sm.sys.entity.view.OssResourceView;
import com.longjun.cto.framework.sm.sys.es.OssTypeEnums;
import com.longjun.cto.framework.sm.sys.service.IOssResourceService;
import com.longjun.cto.framework.sm.sys.service.OssService;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OssResource Coontroller
 * 
 * @author yangxuan
 * @date 2019-04-01 07:19:42
 */
@RequestMapping("/mgn/sys/oss")
@Controller
public class OssResourceController extends StandardBaseController {

	@Autowired
	IOssResourceService iOssResourceService;

	@Autowired
	OssService ossService;
	@Autowired
	IImageService imageService;
	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:oss:ossResourceListInit")
	@RequestMapping(value = "/ossResourceListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView ossResourceListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/oss/ossResourceListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:oss:ossResourceAddInit")
	@RequestMapping(value = "/ossResourceAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView ossResourceAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/oss/ossResourceAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:oss:ossResourceEditInit")
	@RequestMapping(value = "/ossResourceEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView ossResourceEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/oss/ossResourceEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:oss:ossResourceShowInit")
	@RequestMapping(value = "/ossResourceShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView ossResourceShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/oss/ossResourceShowInit");
		OssResourceView ret = this.iOssResourceService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	//@RequiresPermissions("sys:oss:getByPage")
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<OssResourceView>> getByPage(OssResourceDto dto) {
		PageUtils<OssResourceView> ret = this.iOssResourceService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:getViewById")
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<OssResourceView> getViewById(long id) {
		OssResourceView ret = this.iOssResourceService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:getModelById")
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<OssResourceModel> findModelById(long id) {
		OssResourceModel ret = this.iOssResourceService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:stop")
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ApiResult stop(long id) {
		Boolean ret = this.iOssResourceService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:start")
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ApiResult start(long id) {
		Boolean ret = this.iOssResourceService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:saveModel")
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ApiResult saveModel(OssResourceModel model) {
		this.iOssResourceService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:oss:modify")
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ApiResult modify(OssResourceModifyDto model) {
		this.iOssResourceService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	@ResponseBody
	@PostMapping("/upload")
	public ActionResult<List<OssResSaveView>> upload(@RequestParam(name = "file") MultipartFile[] file,
			@RequestParam(required = false, defaultValue = "1") int typeOss) throws IOException {
		OssTypeEnums e = OssTypeEnums.matchEnums(typeOss);
		List<OssResSaveView> ret = this.ossService.save( file);
		return ActionResult.ok(ret);
	}
	@ResponseBody
	@PostMapping("/uploadLayedit")
	public Map<String, Object> uploadLayedit(@RequestParam(name = "file") MultipartFile[] file,
											 @RequestParam(required = false, defaultValue = "1") int typeOss) throws IOException {
		List<OssResSaveView> ret = this.ossService.save(file);
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("code", "0");
		datas.put("msg", "上传成功");
		Map<String, String> data = new HashMap<String, String>();
		data.put("src", ret.get(0).getAttachment());
		data.put("title", "");
		datas.put("data", data);
		return datas;
	}
	@ResponseBody
	@PostMapping("/cto/upload")
	public ActionResult upload(@RequestParam(name = "file") MultipartFile file) throws IOException {
		
		ImageModel rets = this.imageService.save(file);
		JSONObject ret = new JSONObject();
		ret.put("code", 0);
		ret.put("msg", "文件上传成功");
		JSONObject dataJson = new JSONObject();
		dataJson.put("src", rets.getUrl());
		dataJson.put("up_fileName", file.getOriginalFilename());
		dataJson.put("filesize", rets.getSize());
		dataJson.put("id", rets.getId());
		dataJson.put("fileSuffix", FilenameUtils.getExtension(file.getOriginalFilename()));
		dataJson.put("up_fileName", file.getOriginalFilename());
		ret.put("data", dataJson);
		return ActionResult.ok(ret);
	}

}
