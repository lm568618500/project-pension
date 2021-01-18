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
     <legend> 修改绑定手机号</legend>
</fieldset>
 
    <form class="layui-form">
   
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>手机号:</label>
            <div class="layui-input-inline" style="width:400px;">
                <input type="text" name="mobile"
                       lay-verify="required|phone" autocomplete="off" placeholder="请输手机号"
                       class="layui-input" onblur="mobileMouseOut(this)">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>验证码:</label>
            <div class="layui-input-inline" style="width:270px;">
                <input type="text" name="verificationCode"
                       lay-verify="required|number" autocomplete="off" placeholder="请输入验证码"
                       class="layui-input">
            </div>
            <div class="layui-input-inline" style="width:120px;">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="btnSmsCode">获取验证码
                </button>
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
                initElement('editUserMobileInit');
        form.on('submit(submit)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/user/editUserMobile", data.field, function (res) {
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
  function mobileMouseOut(value) {
        var mobile = $("input[name='mobile']").val();

        if(mobile=='' || mobile.length<=0)
        {
            return;
        }

        $.ajax({
            type: "post",
            url: "${serverPath}/web/user/verificationMobile",
            async: false,
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            data: mobile,
            success: function (res) {

                if (res.code != 200) {
                    layer.msg(res.message);

                    $("input[name='mobile']").select();
                }
            }

        });

    }
    $("#btnSmsCode").click(function () {

            var mobile = $("input[name='mobile']").val();
            var data = {
                'type': 'x',
                'mobile': mobile,
                'captchaKey': ''
            };
            if (data.mobile == "" || data.mobile.length <=0) {
                layer.msg("请输入手机号");
            } else {

                $.ajax({
                    type: "post",
                    url: "${serverPath}/web/user/sendVerificationCode",
                    async: false,
                    dataType: 'json',
                    contentType: "application/json;charset=utf-8",
                    data: JSON.stringify(data),
                    success: function (res) {

                        if (res.code == 200) {

                        } else {
                            layer.msg(res.message);
                        }
                    }

                });
                //倒计时
                var o = $("#btnSmsCode");
                time(o);
            }
        });
       
       var wait = 60;

    function time(o) {
        if (wait == 0) {
            o.prop('disabled', false);
            o.removeAttr("disabled");
            o.text("重发验证码");
            wait = 60;
            return;
        } else {
            o.prop("disabled", true);
            o.text(wait + "秒后可重发");
            wait--;

        }
        setTimeout(function () {
                    time(o)
                },
                1000);
    }
       
</script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>