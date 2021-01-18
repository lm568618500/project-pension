<@override name="body">

<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
	        <label class="layui-form-label">App</label>
	        <div class="layui-input-block">
	        	<select name="appId" lay-filter="categoryId">
        		<#list apps as items>
        			<option value="${items.appId}">${items.appName}</option>
        		</#list>
		    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">版本名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="version" lay-verify="title" autocomplete="off" placeholder="请输入版本名称" class="layui-input">
	        </div>
    	</div>
    	
	  	<div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">更新提示</label>
		    <div class="layui-input-block">
		      <textarea placeholder="请输入更新提示" name="tips"  class="layui-textarea"></textarea>
		    </div>
		  </div>
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">强制更新</label>
	        <div class="layui-input-block">
	        	<select name="isNeed" lay-filter="aihao">
			        <option value="0">否</option>
			        <option value="1">是</option>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">默认版本</label>
	        <div class="layui-input-block">
	        	<select name="isDefault" lay-filter="aihao">
			        <option value="0">否</option>
			        <option value="1">是</option>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">第三方地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="downUrl" lay-verify="title" autocomplete="off" placeholder="请输入第三方下载地址,系统优先使用第三方地址" class="layui-input"> 
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">版本号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="versionNumber"   autocomplete="off" placeholder="请输入版本号" lay-verify="number"  class="layui-input">
	        </div>
    	</div>
    	
    	
    	<div class="layui-form-item">
	        <label class="layui-form-label">文件</label>
	        <div class="layui-input-block">
	       		<div class="layui-upload-drag" id="fileElem">
				  <i class="layui-icon"></i>
				  <p>点击上传，或将文件拖拽到此处</p>
				</div>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">下载地址</label>
	        <div class="layui-input-block">
	        	<input type="text" id="localUrl" name="localUrl" lay-verify="title" autocomplete="off" placeholder="" class="layui-input"> 
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
	   		 		elem: '#pubTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		
		
			//拖拽上传
		  upload.render({
		    elem: '#fileElem'
		    ,url: '/mgn/sys/oss/cto/upload'
		    ,done: function(res){
		      console.log(res)
		      $("#localUrl").val(res.data.src);
		    }
		  });
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/upgrade/commonUpgrade/saveModel",data.field,function(res){
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