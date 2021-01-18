package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * SysSensiWordsHintsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public class SysSensiWordsHintsModifyDto implements Serializable {

	private static final long serialVersionUID = 1554251888665L;
	
	/**
	 * ID
	 */
	private long id;
	/**
	 * 数据插入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态
	 */
	private int status;
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
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
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
