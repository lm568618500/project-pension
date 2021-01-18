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
     <legend> 修改个人信息</legend>
</fieldset>
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="loginName" value="${usersView.loginName!''}"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入用户名"
                       class="layui-input" readOnly >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>手机号:</label>
            <div class="layui-input-block">
                <input type="text" name="mobile" value="${usersView.mobile!''}"
                       lay-verify="required|phone" autocomplete="off" placeholder="请输手机号"
                       class="layui-input"  readOnly>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>国家或地区:</label>
            <div class="layui-input-block">
                <select name="country" lay-verify="required" lay-filter="country" lay-search="">
                    <option value="">请选择国家或地区</option>
			        <#list world as world>
			        	<option value="${world.code}" <#if world.code==usersView.country> selected</#if>> ${world.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>区域:</label>
            <div class="layui-input-block" id="divDistrict">
                <div class="layui-input-inline" style="width: 120px">
                    <select name="province" lay-filter="province" lay-search="" ${disabled!''}>
                        <option value="-1">请选择省</option>
                        <#list commonProvinces as item>
			        	   <option value="${item.useId}" <#if item.useId+""==usersView.province> selected</#if>> ${item.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 120px">
                    <select name="city" lay-filter="city" lay-search="" ${disabled!''}>
                        <option value="-1">请选择市</option>
                        <#list commonCitys as item>
			        	   <option value="${item.useId}" <#if item.useId+""==usersView.city> selected</#if>> ${item.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 120px">
                    <select name="district" lay-verify="district" lay-filter="district" lay-search="" ${disabled!''}>
                        <option value="-1">请选择区/县</option>
                        <#list commonAreas as item>
			        	   <option value="${item.useId}" <#if item.useId+""==usersView.district> selected</#if>> ${item.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">QQ:</label>
            <div class="layui-input-block">
                <input type="text" name="qq" value="${usersView.qq!''}"
                       lay-verify="title" autocomplete="off" placeholder="请输QQ号"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>邮箱:</label>
            <div class="layui-input-block">
                <input type="text" name="userEmail" value="${usersView.userEmail!''}"
                       lay-verify="required|email" autocomplete="off"
                       placeholder="请输入邮箱"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>企业名称（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="name" value="${usersView.name!''}"
                       lay-verify="required" autocomplete="off" placeholder="请输入企业名称"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司名称（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="companyEnName" value="${usersView.companyEnName!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入公司名称（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>公司地址（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="address" value="${usersView.address!''}"
                       lay-verify="required" autocomplete="off" placeholder="请输入公司地址"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司地址（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="companyEnAddress" value="${usersView.companyEnAddress!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入公司地址（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>统一社会信用代码/组织机构代码:</label>
            <div class="layui-input-block">
                <input type="required" name="userCardId" value="${usersView.userCardId!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入统一社会信用代码/组织机构代码"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">法人代表:</label>
            <div class="layui-input-block">
                <input type="text" name="legalRepresentative" value="${usersView.legalRepresentative!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入法人代表" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>企业联系人（中文）:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseCnContact"  value="${usersView.enterpriseCnContact!''}"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入企业联系人（中文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">企业联系人（英文）:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseEnContact" value="${usersView.enterpriseEnContact!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入企业联系人（英文）" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>联系人座机:</label>
            <div class="layui-input-block">
                <input type="text" name="contactLine" value="${usersView.contactLine!''}"
                       lay-verify="required" autocomplete="off"
                       placeholder="请输入联系人座机"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">企业传真:</label>
            <div class="layui-input-block">
                <input type="text" name="enterpriseFax" value="${usersView.enterpriseFax!''}"
                       lay-verify="title" autocomplete="off"
                       placeholder="请输入企业传真" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color:red;">*</span>邮政编码:</label>
            <div class="layui-input-block">
                <input type="text" name="postCode" value="${usersView.postCode!''}"
                       lay-verify="required" autocomplete="off" placeholder="请输入邮政编码"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
            <textarea name="remarks" lay-verify="title" autocomplete="off"
                      placeholder="请输入备注" class="layui-textarea"> ${usersView.remarks!''} </textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <input type="hidden" id="businessLicense" name="businessLicense" value="${usersView.businessLicense!''}">
            <label class="layui-form-label"><span style="color:red;">*</span>营业执照:</label>
            <div class="layui-input-block">

                <img src="${usersView.businessLicense!''}" lay-verify="imgVerify" class="layui-layer-imgtit"
                     style="width: 150px;height: 150px"
                     name="businessLicenseImg" id="businessLicenseImg"/>
                <p id="demoText"></p>
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
    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit', 'upload'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate,
                layedit = layui.layedit,
                upload = layui.upload;
                initElement('editUserinfoInit');
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
                var area = $("select[name='district']").val();
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
        //国家
        form.on('select(country)', function (data) {
            var country = $("select[name='country']").val();
            //中国
            if (country == 'CHN') {
                $('select[name=province]').attr("disabled",false);
                $('select[name=city]').attr("disabled",false);
                $('select[name=district]').attr("disabled",false);
                
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
                $("select[name=province]").html('<option value="-1">请选择省份</option>');
                $('select[name=province]').attr("disabled","disabled");
                $("select[name=city]").empty();
                $("select[name=city]").html('<option value="-1">请选择城市</option>');
                $('select[name=city]').attr("disabled","disabled");
                $("select[name=district]").empty();
                $("select[name=district]").html('<option value="-1">请选择区/县</option>');
                $('select[name=district]').attr("disabled","disabled");
            }

            form.render();
        });


        //省份
        form.on('select(province)', function (data) {
            $("select[name=city]").empty();

            $("select[name=city]").html('<option value="-1">请选择城市</option>');

            $("select[name=district]").empty();

            $("select[name=district]").html('<option value="-1">请选择区/县</option>');

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

            $("select[name=district]").empty();

            $("select[name=district]").html('<option value="-1">请选择区/县</option>');

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

                        $("select[name='district']").append(html);
                    } else {
                        layer.msg(res.message);
                    }
                }

            });
            form.render();

        });

        //注册
        form.on('submit(submit)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/user/editUserinfo", data.field, function (res) {
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