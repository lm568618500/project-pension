<${at}override name="body">

<form class="layui-form" style="width:80%;">
	<#list cols as field>
    	<div class="layui-form-item">
	        <label class="layui-form-label">${field.comment}</label>
	        <div class="layui-input-block">
	        	<#if field.isDate == 0 >
	            <input type="text" name="<@linetohump value="${field.columnName}" />"
	           		value="${dl}{view.<@linetohump value="${field.columnName}" /> !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        	<#else>
	        	 <input type="text" name="<@linetohump value="${field.columnName}" />"
	           		value="${dl}{(view.<@linetohump value="${field.columnName}" />?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        	</#if>
	        </div>
    	</div>
	</#list>
</form>
<script type="text/javascript" src="${dl}{StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
    }); 
</script>

</${at}override>
<${at}extends name="//common/admin/iframe_templates.ftl"/>