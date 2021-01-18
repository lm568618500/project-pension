<@override name="body">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>${view.title!''}</legend>
</fieldset>

</br>


<form class="layui-form" style="width:80%;">
	        	<input type="hidden" value="${view.id}" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        	<input type="hidden" value="${view.title}" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    	
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">内容</label>
	        <div class="layui-input-block">
	        	<script type="text/plain" id="valueEditor" name="valueEditor">${view.contents}</script>
	        </div>
	        <script type="text/javascript">
       			 var valueEditor = UE.getEditor('valueEditor',{initialFrameHeight:300});
			</script>
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
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            data.field.contents=valueEditor.getContent();
            //富文本框取值需要注意前面需要在方法体内进行赋值
            $.post("${serverPath}/mgn/sm/cms/cmsContent/modifyPact",data.field,function(res){
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