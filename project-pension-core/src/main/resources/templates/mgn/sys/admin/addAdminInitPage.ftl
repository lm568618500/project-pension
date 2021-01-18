<@override name="body">

<form class="layui-form" style="width:80%;">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="account" lay-verify="title" autocomplete="off" placeholder="请输入账号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="realName" lay-verify="title" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input type="password" name="rePassword" lay-verify="title" autocomplete="off" placeholder="请再次输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" lay-verify="title" autocomplete="off" placeholder="请输入 邮箱" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="mobile" lay-verify="title" autocomplete="off" placeholder="请输入手机号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
        	<#list roles as items>
	      		<input  type='checkbox' value='${items.id}' name="roleIds" lay-skin='primary' title='${items.rolename}'>
    	  	</#list>
    	  	<input  type='hidden'  name="roleId" id="roleId">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block" >
	      <textarea placeholder="请输入内容" name="remarks" id="remarks" class="layui-textarea"></textarea>
	    </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addTask">保存<button>
        </div>
    </div>
</form>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
	 	//表单数据提交
        form.on("submit(addTask)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            
            if(data.field.account == null || data.field.account == '' ){
        		layer.msg("请输入账号")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	if(data.field.realName == null || data.field.realName == '' ){
        		layer.msg("请输入姓名")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	if(data.field.password == null || data.field.password == '' ){
        		layer.msg("请输入密码")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	if(data.field.rePassword == null || data.field.rePassword == '' ){
        		layer.msg("请输入确认密码")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	if(data.field.password != data.field.rePassword ){
        		layer.msg("两次输入密码不一致")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	if(data.field.email == null || data.field.email == '' ){
        		layer.msg("请输入邮箱")
        		layer.close(loadIndex);
        		return false;
        	}
        	
        	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
		    if(!re.test(data.field.email)){
		        layer.msg("邮箱格式不正确")
        		layer.close(loadIndex);
        		return false;
		    }
            
            if(data.field.mobile == null || data.field.mobile == '' ){
        		layer.msg("请输入手机号码")
        		layer.close(loadIndex);
        		return false;
        	}
        	
			 var reg2 = /^1[3|4|5|6|7|8|9][0-9]{9}$/
			 if(!reg2.test(data.field.mobile)){
				layer.msg("手机号码格式不正确")
        		layer.close(loadIndex);
        		return false;
			 }
			 
        	var str="";
            $("input[name='roleIds']:checked").each(function (index, item) {
		        if (str=="") {
		            str = $(this).val();
		        } else {
		            str =str+","+ $(this).val() ;
		        }  
		    });
		    console.log(str)
		    data.field.roleId=str;
			if(data.field.roleId == null || data.field.roleId == "" ){
        		layer.msg("请选择角色")
        		layer.close(loadIndex);
        		return false;
        	}
            $.post("${serverPath}/mgn/sys/admin/addAdminAction",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("添加成功!",{time:1000},function(){
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