<@override name="body">


<form class="layui-form" style="width:80%;">
    	<input type="hidden" name="tempId" lay-verify="title" autocomplete="off" placeholder="请输入模板ID" class="layui-input">
    	<div class="layui-form-item">
	        <label class="layui-form-label">发送人</label>
	        <div class="layui-input-block">
	        	<input type="text" name="creator" value="系统消息" lay-verify="required" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">标题</label>
	        <div class="layui-input-block">
	        	<input type="text" name="title"  lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">内容</label>
	        <div class="layui-input-block">
	       	 <textarea name="content" placeholder="请输入内容" lay-verify="required" class="layui-textarea"></textarea>
	        </div>
    	</div>
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">用户编号</label>
	        <div class="layui-input-block">
	        	<textarea name="userNos" placeholder="请输入收件人,多人采用换行,比如 
用户编号1 
用户编号2" class="layui-textarea"></textarea>
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
	        	laydate.render({
	   		 		elem: '#sendTime',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/message/messageStation/saveModel",data.field,function(res){
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