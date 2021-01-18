package com.longjun.cto.framework.project.pension.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.longjun.cto.framework.project.pension.base.CqcBaseController;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;

/**
 * CQC 管理端基础控制类
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 4:44:00 PM
 */
public class CqcAdminBaseController extends CqcBaseController {

	/**
	 * 当前管理员
	 * 
	 * @return
	 */
	protected AdminView currentAdmin() {
		Subject subject = SecurityUtils.getSubject();
		if (subject == null) {
			return null;
		}
		AdminView admin = (AdminView) SecurityUtils.getSubject().getPrincipal();
		return admin;
	}

}
