package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysSensiWordsHintsModel
 * @author yangxuan
 * @date 2019-04-03 08:37:59
 */
@TableName("t_sys_sensi_words_hints")
public class SysSensiWordsHintsModel extends BaseModel<SysSensiWordsHintsModel> {

	private static final long serialVersionUID = 1554251888022L;
	
	
	
	
	
	/**
	 * 敏感词
	 */
	@TableField("words")
	private String words;
	
	/**
	 * 过滤后字符
	 */
	@TableField("filter_str")
	private String filterStr;
	
	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;
	
	




	public void setWords(String words) {
		this.words = words;
	}

	public String getWords() {
		return this.words;
	}

	public void setFilterStr(String filterStr) {
		this.filterStr = filterStr;
	}

	public String getFilterStr() {
		return this.filterStr;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

}
