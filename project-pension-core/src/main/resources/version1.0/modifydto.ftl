package ${codeParentPakage}.${codePakage}.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * ${className}Model
 * @author ${author}
 * @date ${crateDate}
 */
public class ${className}ModifyDto implements Serializable {

	private static final long serialVersionUID = ${serialVersionUID};
	
	<#list cols as field>
	/**
	 * ${field.comment !''}
	 */
	<#if field.javaType == 'java.util.Date'>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	private ${field.javaType} <@linetohump value="${field.columnName}" />;
	</#list>
	
	<#list cols as field>
	public void <@autoset value="${field.columnName}" />(${field.javaType} <@linetohump value="${field.columnName}" />) {
		this.<@linetohump value="${field.columnName}" /> = <@linetohump value="${field.columnName}" />;
	}

	public ${field.javaType} <@autoget value="${field.columnName}" />() {
		return this.<@linetohump value="${field.columnName}" />;
	}
	</#list>
}
