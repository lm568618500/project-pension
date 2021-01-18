<@extends name="/common/admin/adminAssIgn.ftl"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>企业注册</title>
    <link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all"/>
</head>
<body>

<style>
    .login-main {
        position: absolute;
        top: 60px;
        right: 0;
        bottom: 0;
        left: 0;
        width: 600px;
        margin: 0 auto;
    }
</style>
<div class="login-main">

    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="loginName"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入用户名"
                       class="layui-input" onblur="mouseOut(this)">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>密码:</label>
            <div class="layui-input-block">
                <input type="password" name="password"
                       lay-verify="required|pass" autocomplete="off" placeholder="请输入密码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>确认密码:</label>
            <div class="layui-input-block">
                <input type="password" name="confirmPassword"
                       lay-verify="required|pass1" autocomplete="off" placeholder="请输入确认密码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>国家或地区:</label>
            <div class="layui-input-block">
                <select name="country" lay-verify="required" lay-filter="country" lay-search="">
                    <option value="">请选择国家或地区</option>
			        <#list world as world>
			        	<option value="${world.code}"> ${world.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>区域:</label>
            <div class="layui-input-block" id="divDistrict">
                <div class="layui-input-inline" style="width: 120px">
                    <select name="province" lay-filter="province" lay-search="">
                        <option value="">请选择省</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 120px">
                    <select name="city" lay-filter="city" lay-search="">
                        <option value="">请选择市</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 120px">
                    <select name="area" lay-verify="area" lay-filter="area" lay-search="">
                        <option value="">请选择区/县</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>手机号:</label>
            <div class="layui-input-block">
                <input type="text" name="mobile"
                       lay-verify="required|phone" autocomplete="off" placeholder="请输手机号"
                       class="layui-input" onblur="mobileMouseOut(this)">
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
                <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="btnSmsCode">获取验证码
                </button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">QQ:</label>
            <div class="layui-input-block">
                <input type="text" name="qq"
                       lay-verify="title" autocomplete="off" placeholder="请输QQ号"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>邮箱:</label>
            <div class="layui-input-block">
                <input type="text" name="userEmail"
                       lay-verify="required|email" autocomplete="off"
                       placeholder="请输入邮箱"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>企业名称（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="name"
                       lay-verify="required" autocomplete="off" placeholder="请输入企业名称"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司名称（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="companyEnName"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入公司名称（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>公司地址（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="address"
                       lay-verify="required" autocomplete="off" placeholder="请输入公司地址"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司地址（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="companyEnAddress"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入公司地址（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>统一社会信用代码/组织机构代码:</label>
            <div class="layui-input-block">
                <input type="required" name="userCardId"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入统一社会信用代码/组织机构代码"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">法人代表:</label>
            <div class="layui-input-block">
                <input type="text" name="legalRepresentative"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入法人代表" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>企业联系人（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseCnContact"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入企业联系人（中文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">企业联系人（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseEnContact"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入企业联系人（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>联系人座机:</label>
            <div class="layui-input-block">
                <input type="text" name="contactLine"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入联系人座机"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">企业传真:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseFax"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入企业传真" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>邮政编码:</label>
            <div class="layui-input-block">
                <input type="text" name="postCode"
                       lay-verify="required" autocomplete="off" placeholder="请输入标签名称"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
            <textarea name="remarks" lay-verify="title" autocomplete="off"
                      placeholder="请输入备注" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <input type="hidden" id="businessLicense" name="businessLicense" value="">
            <label class="layui-form-label"><span style="color:red;">*</span>营业执照:</label>
            <div class="layui-input-block">

                <img src="${StaticServer}/images/goods_img.png" lay-verify="imgVerify" class="layui-layer-imgtit"
                     style="width: 150px;height: 150px"
                     name="businessLicenseImg" id="businessLicenseImg"/>
                <p id="demoText"></p>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="register">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${StaticServer}/static/js/jquery.min.js"></script>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>


    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit', 'upload'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate,
                layedit = layui.layedit,
                upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#businessLicenseImg'
            , url: '${serverPath}/web/sys/upload'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#businessLicenseImg').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code == 200) {
                    $("#businessLicense").val(res.result.attachment);
                } else {
                    layer.msg(res.message);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });


        //自定义验证规则
        form.verify({
            area: function (value) {

                var country = $("select[name='country']").val();

                var area = $("select[name='area']").val();

                //中国
                if (country == 'CHN') {

                    if (area == '' || area.length <= 0) {
                        return "请选择区域/县";
                    }

                }

            },
            imgVerify: function (value) {

                var businessLicense = $("input[name='businessLicense']").val();

                if (businessLicense == '' || businessLicense.length <= 0) {
                    return "请上传营业执照";
                }
            },
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
                'type': 'e',
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


        //国家
        form.on('select(country)', function (data) {

            var country = $("select[name='country']").val();

            //中国
            if (country == 'CHN') {

                $.ajax({
                    type: "post",
                    url: "${serverPath}/web/user/getProvince",
                    async: false,
                    dataType: 'json',
                    contentType: "application/json;charset=utf-8",
                    data: "",
                    success: function (res) {

                        if (res.code == 200) {

                            var html = '';
                            $.each(res.result.province, function (index, item) {

                                html += '<option value="' + index + '">' + item + '</option>';
                            });

                            $("select[name='province']").append(html);

                        } else {
                            layer.msg(res.message);
                        }
                    }

                });


            } else {

                $("select[name=province]").empty();

                $("select[name=province]").html('<option value="">请选择省份</option>');

                $("select[name=city]").empty();

                $("select[name=city]").html('<option value="">请选择城市</option>');

                $("select[name=area]").empty();

                $("select[name=area]").html('<option value="">请选择区/县</option>');

            }

            form.render();
        });


        //省份
        form.on('select(province)', function (data) {


            $("select[name=city]").empty();

            $("select[name=city]").html('<option value="">请选择城市</option>');

            $("select[name=area]").empty();

            $("select[name=area]").html('<option value="">请选择区/县</option>');

            $.ajax({
                type: "post",
                url: "${serverPath}/web/user/getCity",
                async: false,
                dataType: 'json',
                contentType: "application/json;charset=utf-8",
                data: data.value,
                success: function (res) {

                    if (res.code == 200) {

                        var html = '';
                        $.each(res.result.city, function (index, item) {

                            html += '<option value="' + index + '">' + item + '</option>';
                        });

                        $("select[name='city']").append(html);
                    } else {
                        layer.msg(res.message);
                    }
                }

            });
            form.render();

        });

        //区域
        form.on('select(city)', function (data) {

            $("select[name=area]").empty();

            $("select[name=area]").html('<option value="">请选择区/县</option>');

            $.ajax({
                type: "post",
                url: "${serverPath}/web/user/getArea",
                async: false,
                dataType: 'json',
                contentType: "application/json;charset=utf-8",
                data: data.value,
                success: function (res) {

                    if (res.code == 200) {

                        var html;

                        $.each(res.result.area, function (index, item) {
                            console.log(index);
                            console.log(item);
                            html += '<option value="' + index + '">' + item + '</option>';
                        });

                        $("select[name='area']").append(html);
                    } else {
                        layer.msg(res.message);
                    }
                }

            });
            form.render();

        });

        //注册
        form.on('submit(register)', function (data) {

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/web/user/enterpriseRegistration", data.field, function (res) {
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


    function mouseOut(value) {
        var loginName = $("input[name='loginName']").val();

        $.ajax({
            type: "post",
            url: "${serverPath}/web/user/verificationAccount",
            async: false,
            dataType: 'json',
            contentType: "application/json;charset=utf-8",
            data: loginName,
            success: function (res) {
                if (res.code != 200) {
                    layer.msg(res.message);

                    $("input[name='loginName']").select();
                }
            }

        });

    }

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
</script>

</body>
</html>