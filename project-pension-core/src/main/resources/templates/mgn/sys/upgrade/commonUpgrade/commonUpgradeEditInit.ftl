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
	        <label class="layui-form-label">删除状态</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDel" lay-verify="title" autocomplete="off" placeholder="请输入删除状态" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">操作者ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="adminId" lay-verify="title" autocomplete="off" placeholder="请输入操作者ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">版本名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="version" lay-verify="title" autocomplete="off" placeholder="请输入版本名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">更新提示</label>
	        <div class="layui-input-block">
	        	<input type="text" name="tips" lay-verify="title" autocomplete="off" placeholder="请输入更新提示" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">发布时间-更新时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="pubTime" id="pubTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">平台， 1安卓 2IOS</label>
	        <div class="layui-input-block">
	        	<input type="text" name="platForm" lay-verify="title" autocomplete="off" placeholder="请输入平台， 1安卓 2IOS" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">下载类型， 1、本地 2、第三方</label>
	        <div class="layui-input-block">
	        	<input type="text" name="downType" lay-verify="title" autocomplete="off" placeholder="请输入下载类型， 1、本地 2、第三方" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">文件名</label>
	        <div class="layui-input-block">
	        	<input type="text" name="fileName" lay-verify="title" autocomplete="off" placeholder="请输入文件名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">下载地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="downUrl" lay-verify="title" autocomplete="off" placeholder="请输入下载地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">二维码</label>
	        <div class="layui-input-block">
	        	<input type="text" name="qrCode" lay-verify="title" autocomplete="off" placeholder="请输入二维码" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">1、强制 2、不强制更新</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isNeed" lay-verify="title" autocomplete="off" placeholder="请输入1、强制 2、不强制更新" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否为默认版本</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDefault" lay-verify="title" autocomplete="off" placeholder="请输入是否为默认版本" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">状态</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入状态" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">版本号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="versionNumber" lay-verify="title" autocomplete="off" placeholder="请输入版本号" class="layui-input">
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
	   		 		elem: '#pubTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/upgrade/commonUpgrade/modify",data.field,function(res){
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