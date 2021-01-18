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
     <legend> 修改邮箱</legend>
</fieldset>
 
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;"></span>用户名:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="text" name="loginName" value="${loginName!''}" disabled lay-verify="required" autocomplete="off" placeholder="请输手机号" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>新邮箱地址:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="text" name="email"  lay-verify="required|email" autocomplete="off"  class="layui-input" >
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
                initElement('editUserEmailInit');
        form.on('submit(submit)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/user/editUserEmail", data.field, function (res) {
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