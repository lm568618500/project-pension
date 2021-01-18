package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * K-v视图
 * @author yangxuan
 * @date 2018年11月10日 上午7:49:40
 */
public class CommonKvView extends BaseView{

	private static final long serialVersionUID = -5405100377878938455L;

	private String k;
	
	private String v;
	
	private String mark;
	
	private int vtype;
	

	public int getVtype() {
		return vtype;
	}

	public void setVtype(int vtype) {
		this.vtype = vtype;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
}
