<@extends name="/common/admin/adminAssIgn.ftl"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>忘记密码</title>
    <link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all"/>
</head>
<body>

<style>
    .login-main {
        position: fixed;
        top: 60px;
        right: 0;
        bottom: 0;
        left: 0;
        width: 550px;
        margin: 0 auto;
    }
</style>

<div class="login-main">

    <form class="layui-form">

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>手机号:</label>
            <div class="layui-input-block">
                <input type="text" name="mobile"
                       lay-verify="required|phone" autocomplete="off" placeholder="请输入手机号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>验证码:</label>
            <div class="layui-input-inline">
                <input type="text" name="verificationCode"
                       lay-verify="required|number" autocomplete="off" placeholder="请输入验证码"
                       class="layui-input">
            </div>
            <div class="layui-input-inline">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="btnSmsCode">获取验证码</button>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>新密码:</label>
            <div class="layui-input-block">
                <input type="password" name="password" id="password"
                       lay-verify="required|pass" autocomplete="off" placeholder="请输入密码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>确认密码:</label>
            <div class="layui-input-block">
                <input type="password" name="confirmPassword" id="confirmPassword"
                       lay-verify="required|pass1" autocomplete="off" placeholder="请输入确认密码"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="submit">确认</button>
            </div>
        </div>

    </form>
</div>
<script type="text/javascript" src="${StaticServer}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>

    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate,
                layedit = layui.layedit;


        //自定义验证规则
        form.verify({
            pass: [
                /^[\S]{6,20}$/
                , '密码必须6到20位，且不能出现空格'
            ],
            pass1: function (value) {
                var password = $("input[name='password']").val();

                if (value != password) {
                    return "确认密码和密码不一致";
                }

            }
        });


        $("#btnSmsCode").click(function () {

            var mobile = $("input[name='mobile']").val();

            var data = {
                'type':'m',
                'mobile': mobile,
                'captchaKey': ''
            };
            if (data.mobile == "" || data.mobile.length != 11) {
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


        form.on('submit(submit)', function (data) {

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/web/user/forgetPassword", data.field, function (res) {
                layer.close(loadIndex);
                if (res.code == 200) {
                    location.href = "${serverPath}" + res.result.redirectUrl;
                } else {
                    layer.msg(res.message);
                }
            });
            return false;
        });

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

</body>
</html>