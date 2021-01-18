<@override name="body">

<form class="layui-form" style="width:80%;">
    	<input type="hidden" name="id" lay-verify="title" autocomplete="off"  class="layui-input">

    	<div class="layui-form-item">
	        <label class="layui-form-label">键</label>
	        <div class="layui-input-block">
	        	<label class="layui-form-label">${view.key!''}</label>
	        	<input type="hidden" name="id"  value="${view.id!}" lay-verify="title" autocomplete="off" placeholder="请输入使用ID" class="layui-input">
	        	<input type="hidden" name="key"  value="${view.key!''}" lay-verify="title" autocomplete="off" placeholder="请输入使用ID" class="layui-input">
	        </div>
    	</div>
    	<#if view.inputType=='TEXT'>
	    	<div class="layui-form-item">
		        <label class="layui-form-label">值</label>
		        <div class="layui-input-block">
		        	<input type="text" name="value" value="${view.value!}" lay-verify="title" autocomplete="off" placeholder="请输入值" class="layui-input">
		        </div>
	    	</div>
	    <#elseif view.inputType=='PASSWORD'>
	    	<div class="layui-form-item">
		        <label class="layui-form-label">值</label>
		        <div class="layui-input-block">
		        	<input type="password" name="value" value="${view.value!}" lay-verify="title" autocomplete="off" placeholder="请输入值" class="layui-input">
		        </div>
	    	</div>
    	<#elseif view.inputType=='IMAGE'>
			<div class="layui-form-item">
				<label class="layui-form-label">文件</label>
				<div class="layui-input-block">
					<input type="hidden" name="value" id="value" value="${view.value!}" lay-verify="title" autocomplete="off" placeholder="请输入值" class="layui-input">
					<img src="${view.value}" id="fileImg"/>
					<button type="button" class="layui-btn" id="logo_upload">上传</button>
				</div>
			</div>
		<#elseif view.inputType=='VIDEO'>
			<div class="layui-form-item">
				<label class="layui-form-label">文件</label>
				<div class="layui-input-block">
					<button type="button" class="layui-btn" id="test3">上传视频</button>
					<div class="layui-upload-list">
						<input type="hidden" name="value" id="value" value="${view.value!}" lay-verify="title" autocomplete="off" placeholder="请输入值" class="layui-input">
						<video src="${view.value!}" controls="controls" id="fileVideo" width="100px" height="100px"></video>
						<p id="demoText"></p>
					</div>

				</div>
			</div>
		<#elseif view.inputType=='RICHEDIT'>
	    	<div class="layui-form-item">
		        <label class="layui-form-label">值</label>
		        <div class="layui-input-block">
		        	<script type="text/plain" id="valueEditor" name="valueEditor">${view.value!}</script>
		        </div>
	    	</div>
	    	<script type="text/javascript">
       			 var valueEditor = UE.getEditor('valueEditor',{initialFrameHeight:300});
			</script>
    	</#if>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['upload','form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
            upload = layui.upload;
           
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
		    elem: '#logo_upload'
		    ,url: '${serverPath}/mgn/sys/oss/cto/upload'
		    ,before: function(obj){
		      obj.preview(function(index, file, result){
		        $('#fileImg').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		    	console.log(res)
		      if(res.code !=200){
		        return layer.msg('上传失败');
		      }
		       $('#value').val(res.result.data.src); //
		       $('#fileImg').attr('src', res.result.data.src); //
		      //上传成功
		    }
		    ,error: function(){
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		  });
		//视频上传
		var uploadInst = upload.render({
			elem: '#test3'
			,accept: 'video' //视频
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,done: function(res){

				if(res.code ==200) {
					//上传成功
					$('#fileVideo').attr('src', res.result.data.src);
					$("#value").val(res.result.data.src)
					return layer.msg('上传成功');
				}
				//如果上传失败
				else{
					return layer.msg('上传失败');
				}
			}
		});
		  
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            <#if view.inputType=='RICHEDIT'>
				data.field.value=valueEditor.getContent();
			</#if>
            $.post("${serverPath}/mgn/sys/common/option/modify",data.field,function(res){
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