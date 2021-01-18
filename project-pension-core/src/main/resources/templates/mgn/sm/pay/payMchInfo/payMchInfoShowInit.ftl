<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户状态</label>
	        <div class="layui-input-block">
	        	<select name="status" disabled lay-filter="aihao">
			        <option value="1" <#if view.status == 1>selected</#if> >使用</option>
			        <option value="0">禁用</option>
			      </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchId"
	           		value="${view.mchId !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchName"
	           		value="${view.mchName !''}" disabled lay-verify="title" autocomplete="off"   class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">请求私钥</label>
	        <div class="layui-input-block">
	        	<textarea class="layui-textarea" name="reqKey">${view.reqKey !''}</textarea>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">响应私钥</label>
	        <div class="layui-input-block">
	        	<textarea class="layui-textarea" name="resKey">${view.resKey !''}</textarea>
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