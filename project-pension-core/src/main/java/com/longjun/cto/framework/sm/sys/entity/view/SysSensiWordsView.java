package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * SysSensiWordsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public class SysSensiWordsView extends BaseView {

	private static final long serialVersionUID = 1554251881589L;
	
	
	
	
	
	/**
	 * 敏感词
	 */
	private String words;
	
	




	public void setWords(String words) {
		this.words = words;
	}

	public String getWords() {
		return this.words;
	}

}
