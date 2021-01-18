<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	            <input type="text" name="id"
	           		value="${view.id !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">添加时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="time"
	           		value="${(view.time?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">更新时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="lastupdate"
	           		value="${(view.lastupdate?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">状态</label>
	        <div class="layui-input-block">
	            <input type="text" name="status"
	           		value="${view.status !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否删除 0正常 -1删除</label>
	        <div class="layui-input-block">
	            <input type="text" name="isDel"
	           		value="${view.isDel !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">类型名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="typeName"
	           		value="${view.typeName !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否推荐首页</label>
	        <div class="layui-input-block">
	            <input type="text" name="isRecommond"
	           		value="${view.isRecommond !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">父类ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="parentId"
	           		value="${view.parentId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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