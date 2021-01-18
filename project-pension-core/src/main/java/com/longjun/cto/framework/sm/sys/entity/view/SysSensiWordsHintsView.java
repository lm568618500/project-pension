package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * SysSensiWordsHintsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public class SysSensiWordsHintsView extends BaseView {

	private static final long serialVersionUID = 1554251882258L;
	
	
	
	
	
	/**
	 * 敏感词
	 */
	private String words;
	
	/**
	 * 过滤后字符
	 */
	private String filterStr;
	
	/**
	 * 备注
	 */
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
