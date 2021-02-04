package com.longjun.cto.framework.project.pension.base;

import com.eims.cto.framework.common.base.ret.ActionResult;
import com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import com.longjun.cto.framework.sm.cms.service.IImageService;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSaveView;
import com.longjun.cto.framework.sm.sys.service.OssService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 上传
 * @author Administrator
 *
 */
@RequestMapping("/mgn/sys")
@Controller
public class UploadController {
	@Autowired
	private OssService ossService;
	@Autowired
	IImageService imageService;
	@ResponseBody
	@PostMapping("/upload")
	public ActionResult<OssResSaveView> upload(@RequestParam(name = "file") MultipartFile[] file,
			@RequestParam(required = false, defaultValue = "1") int typeOss) throws IOException {
		List<OssResSaveView> ret = this.ossService.save(file);
		return ActionResult.ok(ret.get(0));
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
	@PostMapping("/uploadLayeditEdit")
	public Map<String, Object> uploadLayeditEdit(@RequestParam(name = "file") MultipartFile file,
											 @RequestParam(required = false, defaultValue = "1") int typeOss) throws IOException {
		ImageModel rets = this.imageService.save(file);
		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put("code", "0");
		datas.put("msg", "上传成功");
		Map<String, String> data = new HashMap<String, String>();
		data.put("src", rets.getUrl());
		data.put("title", "");
		datas.put("data", data);


		return datas;
	}
	@RequestMapping(value = "/download")
	@ResponseBody
	public void downloadImg(HttpServletResponse response,HttpServletRequest request,String path) {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			if (StringUtils.isNotEmpty(path)) {
				response.setContentType("application/force-download");
				response.setCharacterEncoding("utf-8");
				String fileName = path.substring(path.lastIndexOf("/")+1, path.length());
				if (request.getHeader("user-agent").contains("Firefox")){// 判断是否为火狐
					fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
				} else{
					fileName = URLEncoder.encode(fileName, "utf-8");
				}
				response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				// 图片下载
				URL url = new URL(path);
				URLConnection conn = url.openConnection();
				outputStream = response.getOutputStream();
				inputStream = conn.getInputStream();
				IOUtils.copy(inputStream, outputStream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
		}
	}
	
}
