package com.longjun.cto.framework.sm.sys.web;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.service.IAdminService;

/**
 * Service module基础控制类
 * @author yangxuan
 * @date 2019年3月25日 下午8:02:29
 */
public class SmBaseController extends StandardBaseController{
	
	@Autowired
	IAdminService iAdminService;
	
	/**
	 * 当前管理员
	 * @return
	 */
	protected AdminView currentAdmin(){
		Subject subject = SecurityUtils.getSubject();
		if(subject == null) {
			return null;
		}
		AdminView admin = (AdminView) SecurityUtils.getSubject().getPrincipal();
//		String sesinId = webKit.getRequest().getSession().getId();
//		return iAdminService.getById(1L);
		return admin;
	}
	  /**
	   * 响应二进制流图片，并设置contentType
	   *
	   * @param response
	   * @param is
	   * @param contentType
	   */
	  protected void renderImage(HttpServletResponse response, InputStream is, String contentType) {
	    try {
	      response.setContentType(contentType);
	      OutputStream os = response.getOutputStream();
	      IOUtils.copy(is, os);
	    } catch (Exception e) {
	     	return;
	    }
	  }
}
