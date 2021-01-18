package ${codeParentPakage}.${codePakage}.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ${className}Model
 * @author ${author}
 * @date ${crateDate}
 */
@TableName("${tableName}")
public class ${className}Model extends BaseModel<${className}Model> {

	private static final long serialVersionUID = ${serialVersionUID};
	
	<#list cols as field>
	<#if field.columnName != 'id' && field.columnName != 'lastupdate' && field.columnName != 'status' && field.columnName != 'time'>
	/**
	 * ${field.comment !''}
	 */
	@TableField("${field.columnName !''}")
	<#if field.javaType == 'java.util.Date'>
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	</#if>
	private ${field.javaType} <@linetohump value="${field.columnName}" />;
	</#if>
	
	</#list>
	
	<#list cols as field>
	<#if field.columnName != 'id' && field.columnName != 'lastupdate' && field.columnName != 'status' && field.columnName != 'time'>
	public void <@autoset value="${field.columnName}" />(${field.javaType} <@linetohump value="${field.columnName}" />) {
		this.<@linetohump value="${field.columnName}" /> = <@linetohump value="${field.columnName}" />;
	}

	public ${field.javaType} <@autoget value="${field.columnName}" />() {
		return this.<@linetohump value="${field.columnName}" />;
	}
	</#if>

	</#list>
}