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
	        <label class="layui-form-label">数据插入时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="time"
	           		value="${(view.time?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后修改时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="lastupdate"
	           		value="${(view.lastupdate?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">手机号码</label>
	        <div class="layui-input-block">
	            <input type="text" name="mobile"
	           		value="${view.mobile !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="tempId"
	           		value="${view.tempId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">内容</label>
	        <div class="layui-input-block">
	            <input type="text" name="content"
	           		value="${view.content !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板内容</label>
	        <div class="layui-input-block">
	            <input type="text" name="tempContent"
	           		value="${view.tempContent !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板參數绑定</label>
	        <div class="layui-input-block">
	            <input type="text" name="tempParamsBind"
	           		value="${view.tempParamsBind !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">发送时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="sendTime"
	           		value="${(view.sendTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="mechId"
	           		value="${view.mechId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">设置</label>
	        <div class="layui-input-block">
	            <input type="text" name="settingId"
	           		value="${view.settingId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">创建时间戳</label>
	        <div class="layui-input-block">
	            <input type="text" name="createTime"
	           		value="${view.createTime !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">-1 删除 0 正常</label>
	        <div class="layui-input-block">
	            <input type="text" name="isDel"
	           		value="${view.isDel !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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