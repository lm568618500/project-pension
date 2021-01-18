<@override name="body">

<form class="layui-form" style="width:80%;">
		<input type="hidden" name="id" value="${view.id}" />
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="tempUid"
	           		value="${view.tempName !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">第三方模板</label>
	        <div class="layui-input-block">
	            <input type="text" name="otherTemplateId"
	           		value="${view.otherTemplateId !''}" lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">短信内容</label>
	        <div class="layui-input-block">
	        	<textarea name="smsContent" required lay-verify="required" placeholder="请输入" class="layui-textarea">${view.smsContent !''}</textarea>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">短信开关</label>
	        <div class="layui-input-block">
	        	<input type="checkbox" name="status" lay-skin="switch"  value="1" <#if view.status == 1>checked</#if> lay-text="ON|OFF">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">立刻发送</label>
	        <div class="layui-input-block">
	        	<input type="checkbox" name="immediately" lay-skin="switch"  value="1" <#if view.immediately == 1>checked</#if> lay-text="ON|OFF">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">提示</label>
	        <div class="layui-input-block">
	        	<textarea name="tips" required lay-verify="required" placeholder="请输入" class="layui-textarea">${view.tips !''}</textarea>
	        </div>
    	</div> 
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
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
           
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/message/messageTempSms/modify",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("编辑成功!",{time:1000},function(){
                       //刷新父页面
                       parent.location.reload();
                   });
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
        });
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>