package com.longjun.cto.framework.project.pension.base;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eims.cto.framework.common.base.ret.ActionResult;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSaveView;
import com.longjun.cto.framework.sm.sys.service.OssService;
/**
 * 上传
 * @author Administrator
 *
 */
@RequestMapping("/web/sys")
@Controller
public class UploadController {
	@Autowired
	private OssService ossService;
	@ResponseBody
	@PostMapping("/upload")
	public ActionResult<OssResSaveView> upload(@RequestParam(name = "file") MultipartFile[] file,
			@RequestParam(required = false, defaultValue = "1") int typeOss) throws IOException {
		List<OssResSaveView> ret = this.ossService.save(file);
		return ActionResult.ok(ret.get(0));
	}
}
