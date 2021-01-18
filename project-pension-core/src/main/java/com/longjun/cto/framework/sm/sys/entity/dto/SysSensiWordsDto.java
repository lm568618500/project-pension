package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * SysSensiWordsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public class SysSensiWordsDto extends BaseDTO {

	private static final long serialVersionUID = 1554251884538L;
	
	/**
	 * 敏感词
	 */
	private String c_words;

	public String getC_words() {
		return c_words;
	}

	public void setC_words(String c_words) {
		this.c_words = c_words;
	}
	
}
