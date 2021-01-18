<@override name="body">

<form class="layui-form" style="width:80%;">
		<input type="hidden" value="${view.id}" name="id" lay-verify="title" autocomplete="off"  class="layui-input">
    	<div class="layui-form-item">
	        <label class="layui-form-label">文章类型</label>
	        <div class="layui-input-block">
	        	<select name="typeId">
			        <#list types as item>
			        	<option value="${item.id}" <#if item.id == view.typeId>selected </#if> >${item.typeName}</option>
			        </#list>
			      </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">新闻标题</label>
	        <div class="layui-input-block">
	        	<input type="text" name="title" value="${view.title!''}" lay-verify="required" autocomplete="off" placeholder="请输入新闻标题" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">简介</label>
	        <div class="layui-input-block">
	        	<input type="text" name="remark" value="${view.remark!''}" lay-verify="required" autocomplete="off" placeholder="请输入简介" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">新闻内容</label>
	        <div class="layui-input-block">
	        	<script type="text/plain" id="valueEditor" name="contents">${view.contents!''}</script>
	        </div>
	        <script type="text/javascript">
       			 var valueEditor = UE.getEditor('valueEditor',{initialFrameHeight:300});
			</script>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">SEO标题</label>
	        <div class="layui-input-block">
	        	<input type="text" name="seoTitle" value="${view.seoTitle!''}" lay-verify="required" autocomplete="off" placeholder="请输入SEO标题" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">SEO关键词</label>
	        <div class="layui-input-block">
	        	<input type="text" name="seoKeywords" value="${view.seoKeywords!''}"  lay-verify="required" autocomplete="off" placeholder="请输入SEO关键词" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">SEO描述</label>
	        <div class="layui-input-block">
	        	<input type="text" name="seoDescription"  value="${view.seoDescription!''}"  lay-verify="required" autocomplete="off" placeholder="请输入SEO描述" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">浏览量</label>
	        <div class="layui-input-block">
	        	<input type="text" name="viewcount"  value="${view.viewcount!''}"  lay-verify="number" autocomplete="off" placeholder="请输入浏览量" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">来源</label>
	        <div class="layui-input-block">
	        	<input type="text" name="source" value="${view.source!''}" lay-verify="required"   autocomplete="off" placeholder="请输入来源" class="layui-input">
	        </div>
    	</div>
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">缩略图</label>
	        <div class="layui-input-block">
	        	<img src="${view.thumbimg!''}" id="fileImg"/>
	        	<input type="hidden" value="${view.thumbimg!''}" name="thumbimg"  id="thumbimg" lay-verify="required" autocomplete="off"  class="layui-input">
	        	<button type="button" class="layui-btn" id="logo_upload">上传</button>
	        </div>
    	</div>
    	
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">置顶</label>
	        <div class="layui-input-block">
	        	<input type="checkbox" <#if view.isTop==1>checked </#if>    value="1" name="isTop" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
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
	        	laydate.render({
	   		 		elem: '#toptime',
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
		       $('#thumbimg').val(res.data.src); //图片链接（base64）
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
        	var viewcount = data.field.viewcount;
        	if(viewcount < 0){
        		layer.msg("浏览量不能小于0");
        		return false;
        	}
        	
        	var thumbimg = data.field.thumbimg;
        	if(thumbimg == ''){
        		layer.msg("请上传缩略图");
        		return false;
        	}
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/cms/cmsContent/modify",data.field,function(res){
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