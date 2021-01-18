<@extends name="/common/admin/adminAssIgn.ftl"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>世标检测系统</title>
    <link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${PubStaticServer}/web/css/login.css" media="all" />
</head>
<body>
<div class="login">
    <div class="main">
        <img class="header" src="${PubStaticServer}/web/images/LOGO@2x.png" alt="">
        <div class="line1"></div>
        <form class="layui-form" action="${serverPath}/web/user/login" method="post">
            <div class="input_div input_div1">
                <img id="img1" src="${PubStaticServer}/web/images/user.png" alt="">
                <input type="text" name="userName" lay-verify="required"  placeholder="请输入用户名称" onfocus="mouseOver('0')" onblur="mouseOut()">
            </div>
            <div class="input_div input_div2">
                <img id="img2" class="" src="${PubStaticServer}/web/images/password.png" alt="">
                <input type="password" name="password" lay-verify="required" placeholder="请输入登录密码" onfocus="mouseOver('1')"
                       onblur="mouseOut()">
            </div>
            <button type="button" class="layui-btn layui-btn-fluid layui-btn-radius layui-btn-primary" lay-submit=""
                    lay-filter="login">登&nbsp;&nbsp;录
            </button>
        </form>
        <div class="layui-row">
            <div class="layui-col-md4">
                <a href="${StaticServer}/web/user/forgetPasswordInit">忘记密码？</a>
            </div>
            <div class="layui-col-md4">
                <a href="${StaticServer}/web/user/enterpriseRegistrationInit">注册企业用户</a>
            </div>
            <div class="layui-col-md4">
                <a href="${StaticServer}/web/user/personalRegistrationInit">注册个人用户</a>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>深圳世标检测认证股份有限公司 版权所有</p>
        <p>联系电话： 0086-0755-26996143/4/5 0086-075526996192（LINE）</p>
        <p>World Standardization Certification & Testing Group (Shenzhen) Co., LTD</p>
    </div>
</div>
<script type="text/javascript" src="${StaticServer}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form;

        $(document).ready(function () {
            if (window != top) {
                top.location.href = location.href;
            }
        });

        form.on('submit(login)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post(data.form.action, data.field, function (res) {
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

    function mouseOver(id) {
        if (id == '0') {
            document.getElementById('img1').setAttribute("src", "${PubStaticServer}/web/images/user_active.png")
        }
        else {
            document.getElementById('img2').setAttribute("src", "${PubStaticServer}/web/images/password_active.png")
        }
    }

    function mouseOut() {
        document.getElementById('img1').setAttribute("src", "${PubStaticServer}/web/images/user.png")
        // }
        // else{
        document.getElementById('img2').setAttribute("src", "${PubStaticServer}/web/images/password.png")
        // }
    }
</script>
</body>
</html>