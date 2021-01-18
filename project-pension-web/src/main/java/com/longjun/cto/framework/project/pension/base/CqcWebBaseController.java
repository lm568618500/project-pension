package com.longjun.cto.framework.project.pension.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.longjun.cto.framework.project.pension.base.CqcBaseController;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;


/**
 * CQC 客户端基础控制类
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 4:44:00 PM
 */
public class CqcWebBaseController extends CqcBaseController {

	protected  final  static String SESSION_KEY="cqc_user";
	 
	@Autowired
	protected HttpServletRequest request;
	/**
	 * 当前用户
	 * 
	 * @return
	 */
	protected UsersView currentUser() {
		
		UsersView user = (UsersView) this.request.getSession().getAttribute(SESSION_KEY);
		if (user == null) {
			user = new UsersView();
			user.setId(1l);
		}
		return user;
	}
}
