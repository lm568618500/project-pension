<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">敏感词</label>
	        <div class="layui-input-block">
      			<textarea placeholder="请输入敏感词,多次采用,分隔" name="words" class="layui-textarea"></textarea>
    		</div>
    	</div>
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">敏感词</label>
	        <div class="layui-input-block">
	        	<div class="rich-wrap">
		        <!-- 富文本容器 -->
		        <script type="text/plain" id="myEditor" name="myEditor">
		            <p></p>
		        </script>
		      </div>
    		</div>
    	</div>
    	
    	
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
        </div>
    </div>
</form>

<script type="text/javascript">
        var editor = UE.getEditor('myEditor',{initialFrameHeight:300});
        var step = editor.getContent(); //获取内容
</script>

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
            $.post("${serverPath}/mgn/sys//sysSensiWords/saveModel",data.field,function(res){
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