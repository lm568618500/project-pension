<@override name="body">

<form class="layui-form" style="width:80%;">
       <div class="layui-form-item">
	        <label class="layui-form-label">一级目录</label>
	        <div class="layui-input-block">
	        	<select name="pId" lay-verify="required" lay-filter="pId">
	        	    <option value="">选择一级目录</option>
			        <#list settings as items>
			        	<option value="${items.id}">${items.setName}</option>
			        </#list>
			      </select>
	        </div>
    	</div>
		<div class="layui-form-item">
	        <label class="layui-form-label">二级目录</label>
	        <div class="layui-input-block">
	        	<select name="setId" id="setId" lay-verify="required">
	        	    <option value="">选择二级目录</option>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">文件</label>
	        <div class="layui-input-block">
	        	<img src="" id="fileImg"/>
	        	<button type="button" class="layui-btn" id="logo_upload">上传</button>
	        </div>
		</div>
		
    	<div class="layui-form-item">
	        <label class="layui-form-label">资源链接</label>
	        <div class="layui-input-block">
	        	<input type="text" name="resHref"  id="resHref" lay-verify="title" autocomplete="off" placeholder="请输入资源链接" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">资源名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="resName" id="resName" lay-verify="title" autocomplete="off" placeholder="请输入资源名称" class="layui-input">
	        </div>
    	</div>
    	
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
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
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		       $('#resHref').val(res.data.src); //图片链接（base64）
		       $('#resName').val(res.data.up_fileName); //图片链接（base64）
		       $('#fileImg').attr('src', res.data.src); //图片链接（base64）
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
		//监听指定开关
		form.on('select(pId)', function(data){
		    $.post("${serverPath}/mgn/sys/ossResStore/getResDataBypId",{pId:data.value},function(res){
               if(res.code == 200){
                   var result = res.result;
                   var html = "<option value=\"\">选择二级目录</option>";
                   for(var i=0;i<result.length;i++){
                      html += "<option value=\""+result[i].id+"\">"+result[i].setName+"</option>";
                   }
                   $("#setId").html(html);
                   form.render('select');
               }else{
                   layer.msg(res.message);
               }
            });
		});
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/ossResStore/saveModel",data.field,function(res){
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