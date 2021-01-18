<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${codeParentPakage}.${codePakage}.mapper.${className}Mapper">

    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
	<#list cols as field>
		t.${field.columnName} as <@linetohump value="${field.columnName}"/><#if field_has_next>, </#if> 
	</#list>
    </sql>
 
	<select id="getByPage" parameterType="${codeParentPakage}.${codePakage}.entity.dto.${className}Dto" 
		resultType="${codeParentPakage}.${codePakage}.entity.view.${className}View">
		SELECT
			<include refid="Base_Column_List" />
		FROM ${tableName} AS t
		WHERE 1 = 1 
		<if test="c_status != -10001">
		 	and t.status = ${jing}{c_status}
		</if>
		<if test="c_startTime != null and c_endTime != null
		 	and c_startTime != '' and c_endTime != '' ">
		 	and t.time <![CDATA[>=]]> ${jing}{c_startTime}  and t.time <![CDATA[<=]]> ${jing}{c_endTime}
		</if>
	</select>
	
	<select id="findViewById" parameterType="java.lang.Object" 
		resultType="${codeParentPakage}.${codePakage}.entity.view.${className}View">
		SELECT
			<include refid="Base_Column_List" />
		FROM ${tableName} AS t
		WHERE 1=1 and t.id = ${jing}{id}
	</select>
	
	<select id="listModelMap" parameterType="java.lang.Object" 
		resultType="${codeParentPakage}.${codePakage}.entity.view.${className}View">
		SELECT
			<include refid="Base_Column_List" />
		FROM ${tableName} AS t
		WHERE 1=1 
		<if test="c_status != null">
		 	and t.status =${jing}{c_status}
		</if>
		<if test="c_limit != null">
		 	limit 0,${jing}{c_limit}
		</if>
	</select>
	
	<select id="countMap" parameterType="java.lang.Object" 
		resultType="java.lang.Integer">
		SELECT
			count(1)
		FROM ${tableName} AS t
		WHERE 1=1 
		<if test="c_status != -10001">
		 	and t.status =${jing}{c_status}
		</if>
	</select>
	
	<update id="del" parameterType="java.lang.Long">
		 update ${tableName} set is_del = 1
		 where id = ${jing}{id}
	</update>
	 
</mapper>