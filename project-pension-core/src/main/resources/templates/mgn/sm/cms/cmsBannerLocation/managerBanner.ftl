<@override name="body">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>Banner管理</legend>
</fieldset>




<form class="layui-form" style="width:80%;">
    	<input type="hidden" name="id" value="${view.id}" lay-verify="title" autocomplete="off"   class="layui-input">
    	

<div class="layui-form">
 
    <#list banners as items>
     <table class="layui-table">
    <colgroup>
      <col width="150">
      <col>
    </colgroup>
    <tbody>
    	 <tr>
        <td>图片</td>
        <td>
        <div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<img src="${items.images!''}" id="fileImg${items_index}"/>
	        	<input type="hidden" name="images_${items.id}" value="${items.images!''}" id="images_${items.id}" lay-verify="title" autocomplete="off"  class="layui-input">
	        	<button type="button" class="layui-btn" id="logo_upload${items_index}">上传</button>
	        </div>
    	</div>
        	
        </td>
        </tr>
         <tr>
        <td>跳转地址</td>
        <td>
        	<input type="text" name="urls_${items.id}" value="${items.urls!''}" lay-verify="require" autocomplete="off" placeholder="请输入跳转地址" class="layui-input">
        </td>
    </tr>
    
    </tbody>
  </table>
  </br>
    	</#list>
    
     
        
      
</div>    	
    	
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
	 	 		
	 	 <#list banners as items>
    		var uploadInst${items_index} = upload.render({
		    elem: '#logo_upload${items_index}'
		    ,url: '${serverPath}/mgn/sys/oss/cto/upload'
		    ,before: function(obj){
		      obj.preview(function(index, file, result){
		        $('#fileImg${items_index}').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(res){
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		       $('#images_${items.id}').val(res.data.src); //图片链接（base64）
		       $('#fileImg${items_index}').attr('src', res.data.src); //图片链接（base64）
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
		
    	</#list>
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/cms/cmsBannerLocation/saveBanners",data.field,function(res){
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