<@override name="body">

 

<form class="layui-form" style="width:80%;">
	<div class="layui-form-item">
	        <label class="layui-form-label">模板名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="tempUid"
	           		value="${view.tempName !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮件内容</label>
	        <div class="layui-input-block">
	        	<textarea name="emailContent" required lay-verify="required" placeholder="请输入" class="layui-textarea">${view.emailContent !''}</textarea>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮件开关</label>
	        <div class="layui-input-block">
	        	<input type="checkbox" name="status" lay-skin="switch" lay-text="开|关" disabled <#if view.status == 1>checked</#if>  >
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">立刻发送</label>
	        <div class="layui-input-block">
        		<input type="checkbox" name="immediately" lay-skin="switch" lay-text="是|否" disabled <#if view.emailimmediately == 1>checked</#if>  >
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">提示</label>
	        <div class="layui-input-block">
	        	<textarea name="tips" required lay-verify="required" placeholder="请输入" class="layui-textarea">${view.tips !''}</textarea>
	        </div>
    	</div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>