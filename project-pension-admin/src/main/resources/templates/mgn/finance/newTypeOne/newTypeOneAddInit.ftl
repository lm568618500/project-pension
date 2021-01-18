<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称（英文）</label>
			<div class="layui-input-block">
				<input type="text" name="nameEn" lay-verify="title" autocomplete="off" placeholder="请输入名称（英文）" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片</label>
			<div class="layui-input-block">
				<button type="button" class="layui-btn" id="test1">上传图片</button>
				<div class="layui-upload-list">
					<img class="layui-upload-img" id="demo1" width="100px" height="100px">
					<input type="hidden" name="image" id="image">
					<p id="demoText"></p>
					建议大小（580*210）
				</div>

			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">banner图片</label>
			<div class="layui-input-block">
				<button type="button" class="layui-btn" id="test2">上传图片</button>
				<div class="layui-upload-list">
					<img class="layui-upload-img" id="demo2" width="100px" height="100px">
					<input type="hidden" name="imageBanner" id="imageBanner">
					<p id="demoText"></p>
					建议大小（580*210）
				</div>

			</div>
		</div>

	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="breaks" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">排序</label>
	        <div class="layui-input-block">
	        	<input type="text" name="sort" lay-verify="title" autocomplete="off" placeholder="请输入排序" class="layui-input">
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
    layui.use(['form','jquery','layer','laydate','layedit','upload'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
		   upload = layui.upload,
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

		//普通图片上传
		var uploadInst = upload.render({
			elem: '#test1'
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,done: function(res){

				if(res.code ==200) {
					//上传成功
					$('#demo1').attr('src', res.result.data.src);
					$("#image").val(res.result.data.src)
					return layer.msg('上传成功');
				}
				//如果上传失败
				else{
					return layer.msg('上传失败');
				}
			}
		});
		//普通图片上传
		var uploadInst = upload.render({
			elem: '#test2'
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,done: function(res){

				if(res.code ==200) {
					//上传成功
					$('#demo2').attr('src', res.result.data.src);
					$("#imageBanner").val(res.result.data.src)
					return layer.msg('上传成功');
				}
				//如果上传失败
				else{
					return layer.msg('上传失败');
				}
			}
		});
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/finance/newTypeOne/saveModel",data.field,function(res){
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