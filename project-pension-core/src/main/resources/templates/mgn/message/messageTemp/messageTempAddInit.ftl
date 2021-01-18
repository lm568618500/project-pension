<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">状态1开启2停用</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入状态1开启2停用" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="tempName" lay-verify="title" autocomplete="off" placeholder="请输入模板名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板使用ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="tempUid" lay-verify="title" autocomplete="off" placeholder="请输入模板使用ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板类型</label>
	        <div class="layui-input-block">
	        	<input type="text" name="tempType" lay-verify="title" autocomplete="off" placeholder="请输入模板类型" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mark" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
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
            $.post("${serverPath}/mgn/message/messageTemp/saveModel",data.field,function(res){
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