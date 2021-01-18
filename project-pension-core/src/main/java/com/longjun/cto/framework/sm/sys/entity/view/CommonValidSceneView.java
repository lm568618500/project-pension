package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 通用-校验场景(短信、邮件等)视图
 * @author yangxuan
 * @date 2018年11月13日 下午6:15:46
 */
public class CommonValidSceneView extends BaseView{
	
	private static final long serialVersionUID = -2088260708551446979L;

	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 场景名称
	 */
	private String scenceName;
	
	/**
	 * 子场景
	 */
	private String itemSence;
	
	/**
	 * 描述
	 */
	private String mark;
	
	/**
	 * 分钟频率限制
	 */
	private long minutesRateNum;
	
	/**
	 * 小时频率限制
	 */
	private long hourRateNum;
	
	/**
	 * 天频率限制
	 */
	private long dayRateNum;
	
	/**
	 * 周频率限制
	 */
	private long weekRateNum;
	
	/**
	 * 月频率限制
	 */
	private long monthRateNum;
	
	/**
	 * 年频率限制
	 */
	private long yearRateNum;

	public long getUseId() {
		return useId;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public String getScenceName() {
		return scenceName;
	}

	public void setScenceName(String scenceName) {
		this.scenceName = scenceName;
	}

	public String getItemSence() {
		return itemSence;
	}

	public void setItemSence(String itemSence) {
		this.itemSence = itemSence;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getMinutesRateNum() {
		return minutesRateNum;
	}

	public void setMinutesRateNum(long minutesRateNum) {
		this.minutesRateNum = minutesRateNum;
	}

	public long getHourRateNum() {
		return hourRateNum;
	}

	public void setHourRateNum(long hourRateNum) {
		this.hourRateNum = hourRateNum;
	}

	public long getDayRateNum() {
		return dayRateNum;
	}

	public void setDayRateNum(long dayRateNum) {
		this.dayRateNum = dayRateNum;
	}

	public long getWeekRateNum() {
		return weekRateNum;
	}

	public void setWeekRateNum(long weekRateNum) {
		this.weekRateNum = weekRateNum;
	}

	public long getMonthRateNum() {
		return monthRateNum;
	}

	public void setMonthRateNum(long monthRateNum) {
		this.monthRateNum = monthRateNum;
	}

	public long getYearRateNum() {
		return yearRateNum;
	}

	public void setYearRateNum(long yearRateNum) {
		this.yearRateNum = yearRateNum;
	}
	

}
