<@extends name="/common/admin/adminAssIgn.ftl"/>
<!DOCTYPE html>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>${GlobalMap['SYS_NAME']}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${PubStaticServer}/static/css/login.css?t=${.now?long}" media="all" />
</head>
<body>
<div id="bg-body"></div>
<div class="login">
    <h1>${GlobalMap['SYS_NAME']}</h1>
    <form class="layui-form" action="${serverPath}/mgn/login" method="post">
        <div class="layui-form-item">
            <input class="layui-input" name="username" value="" placeholder="请输入用户名" lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" value="" placeholder="请输入密码" lay-verify="required" type="password" autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" name="code" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
            <div class="code"><img src="${serverPath}/mgn/genCaptcha" width="116" height="36" id="mycode"></div>
        </div>
        <!--<div class="layui-form-item">
            <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" checked title="记住帐号?">
        </div> -->
        <div class="layui-form-item">
            <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="${PubStaticServer}/static/layui/layui.js"></script>
<script type="text/javascript" src="${PubStaticServer}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${PubStaticServer}/static/js/jquery.bcat.bgswitcher.js"></script>
<script>
    layui.use(['layer', 'form'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form;
        
        $(document).ready(function () {  
            if (window != top) {  
                top.location.href = location.href;  
            }  
        }); 
        
        $(document).ready(function() {
            var srcBgArray = ["${GlobalMap['ADMIN_LOGIN_BANNER1']}",
                "${GlobalMap['ADMIN_LOGIN_BANNER2']}",
                "${GlobalMap['ADMIN_LOGIN_BANNER3']}",
                "${GlobalMap['ADMIN_LOGIN_BANNER4']}"];
            $('#bg-body').bcatBGSwitcher({
                timeout:5000,
                urls: srcBgArray,
                alt: '${GlobalMap['SYS_NAME']}'
            });
        });

        $("#mycode").on('click',function(){
            var t = Math.random();
            $("#mycode")[0].src="${serverPath}/mgn/genCaptcha?t= "+t;
        });

        form.on('submit(login)', function(data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post(data.form.action, data.field, function(res) {
                layer.close(loadIndex);
                if(res.code == 200){
                    location.href="${serverPath}"+res.result.redirectUrl;
                }else{
                    layer.msg(res.message);
                    $("#mycode").click();
                }
            });
            return false;
        });
    });
</script>
</body>
</html>