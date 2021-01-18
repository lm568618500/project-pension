package com.longjun.cto.framework.sm.sys.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eims.cto.framework.common.conf.SysSetting;

/**
 * 密码加密
 * @author yangxuan
 * @date 2018年11月15日上午11:43:35
 */
public class PasswordEncryKit {
	
	private static Logger log = LoggerFactory.getLogger(PasswordEncryKit.class);
	
	/**
	 * 加密
	 * @param pwd
	 * @return
	 */
	public static String encry(String pwd){
		String sercret = SysSetting.PASSPORT_PASSWORDSERCRET;
		pwd = pwd + sercret;
		log.info("密码摘要前[{}]" , pwd);
		String ret = DigestUtils.md5Hex(pwd + sercret);
		log.info("密码摘要后[{}]" , ret);
		return ret;
	}
	
	

}
