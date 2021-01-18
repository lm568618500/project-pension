<@override name="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>商户信息</legend>
</fieldset>


<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mechName" value="${ret.mechName!''}" lay-verify="title" disabled autocomplete="off" placeholder="请输入商户名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">短信支持</label>
	        <div class="layui-input-block">
	        	<input type="text" name="supportSms" <#if ret.supportSms == 1> value="支持"</#if>  value="不支持"  disabled lay-verify="title" autocomplete="off" placeholder="请输入短信支持1支持 0不支持" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮件支持</label>
	        <div class="layui-input-block">
	        	<input type="text" name="supportEmail" <#if ret.supportEmail == 1> value="支持"</#if>  value="不支持" disabled lay-verify="title" autocomplete="off" placeholder="请输入邮件支持1支持 0不支持" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">推送支持</label>
	        <div class="layui-input-block">
	        	<input type="text" name="supportPush" <#if ret.supportPush == 1> value="支持"</#if>  value="不支持" disabled lay-verify="title" autocomplete="off" placeholder="请输入推送支持1支持 0不支持" class="layui-input">
	        </div>
    	</div>
    	<!--<div class="layui-form-item">
	        <label class="layui-form-label">余额 分 。暂不使用。后续支持</label>
	        <div class="layui-input-block">
	        	<input type="text" name="amount" lay-verify="title" autocomplete="off" placeholder="请输入余额 分 。暂不使用。后续支持" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">锁定状态 1锁定 0正常</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lockStatus" lay-verify="title" autocomplete="off" placeholder="请输入锁定状态 1锁定 0正常" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">锁定开始时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lockStart" id="lockStart" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">锁定结束时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lockEnd" id="lockEnd" autocomplete="off" class="layui-input">
	        </div>
    	</div> -->
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
	   		 		elem: '#lockStart',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lockEnd',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/message/messageMech/saveModel",data.field,function(res){
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