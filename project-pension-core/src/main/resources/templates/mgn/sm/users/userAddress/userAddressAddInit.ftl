<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">登录用户id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userId" lay-verify="title" autocomplete="off" placeholder="请输入登录用户id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">收货人真实姓名</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userRealName" lay-verify="title" autocomplete="off" placeholder="请输入收货人真实姓名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">收货人手机号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userTelephone" lay-verify="title" autocomplete="off" placeholder="请输入收货人手机号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮编地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="zipCode" lay-verify="title" autocomplete="off" placeholder="请输入邮编地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">省id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="provinceId" lay-verify="title" autocomplete="off" placeholder="请输入省id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">省名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="provinceName" lay-verify="title" autocomplete="off" placeholder="请输入省名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">市id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="cityId" lay-verify="title" autocomplete="off" placeholder="请输入市id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">市名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="cityName" lay-verify="title" autocomplete="off" placeholder="请输入市名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">区id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="areaId" lay-verify="title" autocomplete="off" placeholder="请输入区id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">区名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="areaName" lay-verify="title" autocomplete="off" placeholder="请输入区名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">详细地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="addressDetail" lay-verify="title" autocomplete="off" placeholder="请输入详细地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否是默认收货地址 默认收货地址只能有一个 0不是 1表示是</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDefault" lay-verify="title" autocomplete="off" placeholder="请输入是否是默认收货地址 默认收货地址只能有一个 0不是 1表示是" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否删除（1是，0否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDel" lay-verify="title" autocomplete="off" placeholder="请输入是否删除（1是，0否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后一次修改的时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">状态</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入状态" class="layui-input">
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
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
           
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
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
            $.post("${serverPath}/mgn/sm/users/userAddress/saveModel",data.field,function(res){
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