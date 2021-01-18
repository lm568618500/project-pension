package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysSensiWordsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
@TableName("t_sys_sensi_words")
public class SysSensiWordsModel extends BaseModel<SysSensiWordsModel> {

	private static final long serialVersionUID = 1554251890185L;
	
	
	
	
	
	/**
	 * 敏感词
	 */
	@TableField("words")
	private String words;
	
	




	public void setWords(String words) {
		this.words = words;
	}

	public String getWords() {
		return this.words;
	}

}
