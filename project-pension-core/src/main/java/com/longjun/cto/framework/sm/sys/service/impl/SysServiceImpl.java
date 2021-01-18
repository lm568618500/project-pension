package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.module.base.service.MircoBaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;
import com.longjun.cto.framework.sm.sys.service.ISysService;

import cn.hutool.core.convert.Convert;

/**
 * 系统业务接口实现
 * 
 * @author yangxuan
 * @date Jul 6, 2019 - 3:10:43 PM
 */
@Service
public class SysServiceImpl extends MircoBaseServiceImpl implements ISysService {

	@Autowired
	private ICommonOptionService iCommonOptionService;

	@Override
	public boolean isDev() throws BusinessException {
		CommonOptionView ret = this.iCommonOptionService.findByKey("SYS_DEV");
		if(ret == null) {
			return true;
		}
		boolean dev = Convert.toBool(ret.getValue(), true);
		if (dev) {
			log.info("#####当前环境为测试环境");
		}
		return dev;
	}

	@Override
	public Date serverTime() throws BusinessException {
		Date date = new Date();
		return date;
	}

	@Override
	public String serverUrl() throws BusinessException {
		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_SERVER_URL"),
				SysSetting.STANDARD_SERVERURL);
		return ret;
	}

	@Override
	public String publicStaticUrlSupervisor() throws BusinessException {
		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_PUBLIC_STATIC_URL"),
				SysSetting.STANDARD_PUBSTATICSERVER);
		return ret;
	}

	@Override
	public String staticUrlSupervisor() throws BusinessException {
		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_STATIC_URL"),
				SysSetting.STANDARD_STATICSERVER);
		return ret;
	}

	@Override
	public String frontStaticUrlSupervisor() throws BusinessException {
//		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_SERVER_URL"), SysSetting.STANDARD_SERVERURL);
//		return ret;
		return null;
	}

	@Override
	public String publicStaticUrlFront() throws BusinessException {
		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_FRONT_PUBLIC_STATIC_URL"),
				SysSetting.STANDARD_PUBSTATICSERVER);
		return ret;
	}

	@Override
	public String staticUrlFront() throws BusinessException {
		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_FRONT_STATIC_URL"),
				SysSetting.STANDARD_STATICSERVER);
		return ret;
	}

	@Override
	public String frontStaticUrlFront() throws BusinessException {
//		String ret = Convert.toStr(this.iCommonOptionService.findByKey("SYS_FRONT_WEB_STATIC_URL"), SysSetting.STANDARD_STATICSERVER);
//		return ret;
		return null;
	}

}
