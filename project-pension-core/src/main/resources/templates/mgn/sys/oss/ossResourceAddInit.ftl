<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">资源名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="resName" lay-verify="title" autocomplete="off" placeholder="请输入资源名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">资源大小</label>
	        <div class="layui-input-block">
	        	<input type="text" name="resSize" lay-verify="title" autocomplete="off" placeholder="请输入资源大小" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">文件后缀</label>
	        <div class="layui-input-block">
	        	<input type="text" name="suffix" lay-verify="title" autocomplete="off" placeholder="请输入文件后缀" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">存储类型(1/本地FASTDFS 2/七牛OSS 3/阿里云OSS)</label>
	        <div class="layui-input-block">
	        	<input type="text" name="ossType" lay-verify="title" autocomplete="off" placeholder="请输入存储类型(1/本地FASTDFS 2/七牛OSS 3/阿里云OSS)" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">文件Hash</label>
	        <div class="layui-input-block">
	        	<input type="text" name="fileHash" lay-verify="title" autocomplete="off" placeholder="请输入文件Hash" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">IP</label>
	        <div class="layui-input-block">
	        	<input type="text" name="ip" lay-verify="title" autocomplete="off" placeholder="请输入IP" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">FASTDFS组</label>
	        <div class="layui-input-block">
	        	<input type="text" name="group" lay-verify="title" autocomplete="off" placeholder="请输入FASTDFS组" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">远程地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="remoteResPath" lay-verify="title" autocomplete="off" placeholder="请输入远程地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">远程全地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="remoteResFullPath" lay-verify="title" autocomplete="off" placeholder="请输入远程全地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="preViewPath" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
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
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/oss/saveModel",data.field,function(res){
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