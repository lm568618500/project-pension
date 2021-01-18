<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">数据插入时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后修改时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">收件人邮箱</label>
	        <div class="layui-input-block">
	        	<input type="text" name="email" lay-verify="title" autocomplete="off" placeholder="请输入收件人邮箱" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">抄送</label>
	        <div class="layui-input-block">
	        	<input type="text" name="cc" lay-verify="title" autocomplete="off" placeholder="请输入抄送" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">附件</label>
	        <div class="layui-input-block">
	        	<input type="text" name="attaments" lay-verify="title" autocomplete="off" placeholder="请输入附件" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">模板ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="tempId" lay-verify="title" autocomplete="off" placeholder="请输入模板ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮件标题</label>
	        <div class="layui-input-block">
	        	<input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入邮件标题" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮件内容</label>
	        <div class="layui-input-block">
	        	<input type="text" name="content" lay-verify="title" autocomplete="off" placeholder="请输入邮件内容" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">发送者邮箱</label>
	        <div class="layui-input-block">
	        	<input type="text" name="sender" lay-verify="title" autocomplete="off" placeholder="请输入发送者邮箱" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">发送者名字</label>
	        <div class="layui-input-block">
	        	<input type="text" name="senderName" lay-verify="title" autocomplete="off" placeholder="请输入发送者名字" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">发送时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="sendTime" id="sendTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务状态</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入业务状态" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mechId" lay-verify="title" autocomplete="off" placeholder="请输入商户ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">设置ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="settingId" lay-verify="title" autocomplete="off" placeholder="请输入设置ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">创建时间戳</label>
	        <div class="layui-input-block">
	        	<input type="text" name="createTime" lay-verify="title" autocomplete="off" placeholder="请输入创建时间戳" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
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
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/message/messageEmail/modify",data.field,function(res){
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