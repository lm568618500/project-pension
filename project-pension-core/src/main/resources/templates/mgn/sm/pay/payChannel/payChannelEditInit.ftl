<@override name="body">

<form class="layui-form" style="width:80%;">
    	<input type="hidden" value="${view.id}" name="id" lay-verify="title" autocomplete="off" placeholder="请输入渠道主键ID" class="layui-input">
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付渠道</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelName" disabled value="${view.channelName}" lay-verify="title" autocomplete="off" placeholder="请输入渠道ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelItemsName" disabled value="${view.channelItemsName}" lay-verify="title" autocomplete="off" placeholder="请输入渠道名称,如:alipay,wechat" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mchName" disabled  value="${view.mchName}" lay-verify="title" autocomplete="off" placeholder="请输入渠道商户ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">接口配置</label>
	        <div class="layui-input-block">
	        	<textarea placeholder="请输入接口配置" name="param"  class="layui-textarea" >${view.param}</textarea>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	      		<textarea placeholder="请输入备注" name="remark"  class="layui-textarea" >${view.remark}</textarea>
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
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/pay/payChannel/modify",data.field,function(res){
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