<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">名称</label>
	        <div class="layui-input-block">
	        	<input type="hidden" name="id" value="${view.id!''}" lay-verify="title" autocomplete="off" placeholder="请输入合伙伙伴名称" class="layui-input">
	        	<input type="text" name="linkName" value="${view.linkName!''}" lay-verify="title" autocomplete="off" placeholder="请输入合伙伙伴名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">图片地址</label>
	        <div class="layui-input-block">
	        	<img src="${view.linkImg!''}" id="fileImg"/>
	        	<input type="hidden" name="linkImg"  id="linkImg" lay-verify="title" autocomplete="off"  class="layui-input">
	        	<button type="button" class="layui-btn" id="logo_upload">上传</button>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">超链接</label>
	        <div class="layui-input-block">
	        	<input type="text" name="linkHref" value="${view.linkHref!''}"  lay-verify="title" autocomplete="off" placeholder="请输入超链接" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">类型</label>
	        <div class="layui-input-block">
	        	<select name="linkType" >
			        <option value="1" <#if view.linkType == 1>selected</#if>  >友情连接</option>
			        <option value="2" <#if view.linkType == 2>selected</#if>  >合作伙伴</option>
			      </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">推荐首页</label>
	        <div class="layui-input-block">
	        	<input type="checkbox" name="isRecommend" value="1" <#if view.isRecommend == 1>checked</#if> lay-skin="switch" lay-text="ON|OFF">
	        </div>
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
		       $('#linkImg').val(res.data.src); //图片链接（base64）
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
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/cms/cmsLinks/modify",data.field,function(res){
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