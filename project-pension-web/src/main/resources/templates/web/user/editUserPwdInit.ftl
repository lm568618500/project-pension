<@override name="body">
<div class="layui-layout layui-layout-admin">
 <@extends name="//common/top_menu.ftl"/>
  <div class="layui-side">
    <@extends name="//common/left_menu.ftl"/>
  </div>
  <div class="layui-body">
<style>
    .layui-form{
       margin-top: 4%;
    }
    .layui-form-item{
       margin-left: 7%;
    }
    .layui-form-label {
      width: 220px;
    }
   .layui-input-block {
      margin-left: 280px;
   }
</style>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top:40px;">
     <legend> 修改密码</legend>
</fieldset>
 
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;"></span>用户名:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="text" name="loginName" value="${loginName!''}" disabled lay-verify="required" autocomplete="off" placeholder="请输手机号" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>原始密码:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="password" name="oldPwd"  lay-verify="required" autocomplete="off"  class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>新密码:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="password" name="pwd"   lay-verify="required|pwd" autocomplete="off"  class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>确认密码:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="password" name="confirmPwd"   lay-verify="required|confirmPwd" autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="submit">确定</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'jquery', 'layer'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer;
                initElement('editUserPwdInit');
        //自定义验证规则
        form.verify({
            pwd: [
                /^[\S]{6,20}$/
                , '密码必须6到20位，且不能出现空格'
            ],
            confirmPwd: function (value) {
                var password = $("input[name='pwd']").val();
                if (value != password) {
                    return "确认密码和新密码不一致";
                }
            }
        });
        form.on('submit(submit)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/user/editUserPwd", data.field, function (res) {
                layer.close(loadIndex);
                if (res.code == 200) {
                    layer.msg("修改成功");
                } else {
                    layer.msg(res.message);
                }
            });
            return false;
        });
    });
</script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>