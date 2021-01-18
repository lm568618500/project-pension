<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户</label>
	        <div class="layui-input-block">
	        	<select name="mechId" lay-filter="gatwayId">
	        		<#list mechs as items>
	        			<option value="${items.id}">${items.mechName}</option>
	        		</#list>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">消息网关</label>
	        <div class="layui-input-block">
	        	<select name="gatwayId" lay-filter="gatwayId">
	        		<#list gayways as items>
	        			<option value="${items.id}">${items.gatwayName}</option>
	        		</#list>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">配置</label>
	        <div class="layui-input-block">
	        	<textarea placeholder="请输入内容" class="layui-textarea" name="profile"></textarea>
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/message/messageSetting/saveModel",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("保存成功!",{time:1000},function(){
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