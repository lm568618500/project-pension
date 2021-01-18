package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 通用-Kv键值对
 * @author yangxuan
 * @date 2018年11月10日 上午7:46:01
 */
@TableName("t_common_kv")
public class CommonKvModel extends BaseModel<CommonKvModel>{
	
	private static final long serialVersionUID = 7596546906762338682L;

	@TableField("k")
	private String k;
	
	@TableField("v")
	private String v;
	
	@TableField("mark")
	private String mark;
	
	@TableField("vtype")
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
