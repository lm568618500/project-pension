<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">主键id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入主键id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">注册时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">头像</label>
	        <div class="layui-input-block">
	        	<input type="text" name="photo" lay-verify="title" autocomplete="off" placeholder="请输入头像" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">用户名</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userName" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">真实姓名</label>
	        <div class="layui-input-block">
	        	<input type="text" name="realName" lay-verify="title" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">手机号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mobile" lay-verify="title" autocomplete="off" placeholder="请输入手机号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">密码</label>
	        <div class="layui-input-block">
	        	<input type="text" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">身份类型</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userType" lay-verify="title" autocomplete="off" placeholder="请输入身份类型" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">会员状态 0 未认证 1已认证 </label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入会员状态 0 未认证 1已认证 " class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">1在线0离线</label>
	        <div class="layui-input-block">
	        	<input type="text" name="online" lay-verify="title" autocomplete="off" placeholder="请输入1在线0离线" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="remark" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否删除（1是，0否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDel" lay-verify="title" autocomplete="off" placeholder="请输入是否删除（1是，0否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后一次修改时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否黑名单（1是0否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isBlack" lay-verify="title" autocomplete="off" placeholder="请输入是否黑名单（1是0否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否锁定（1是0否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isLock" lay-verify="title" autocomplete="off" placeholder="请输入是否锁定（1是0否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">登录错误次数</label>
	        <div class="layui-input-block">
	        	<input type="text" name="loginErrorCount" lay-verify="title" autocomplete="off" placeholder="请输入登录错误次数" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">账号被锁定的开始时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lockTime" id="lockTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
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
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lockTime',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/users/user/modify",data.field,function(res){
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