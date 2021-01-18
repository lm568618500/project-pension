<@override name="body">

<style>
    .layui-form-item {
        margin-left: 10%;
    }

    .layui-form-label {
        width: 150px;
    }

    .layui-input-block {
        margin-left: 180px;
    }
</style>

<form class="layui-form" style="width:80%;">

    <input type="hidden" id="id" name="id" value="${view.id!''}">

    <div class="layui-form-item" style="text-align: center;">
        <input type="hidden" id="photoimg" name="photoimg" value="">
        <div class="layui-upload-list" style="margin:10px auto;">
            <img class="layui-upload-img" style="width: 180px;height: 180px; border-radius:50%;" id="uploadimg"
                 name="uploadimg"  <#if view.photoimg?? &&  view.photoimg != ""> src="${view.photoimg}"
                 <#else>src="${StaticServer}/images/goods_img.png"</#if>>
            <p id="demoText"></p>
        </div>
        <a href="javascript:;" style="font-size:16px;color: #0079FE; " id="test1"><@i18N key='home.personal.ghtx' /></a>
    </div>

    <blockquote class="layui-elem-quote layui-field-title">
        <@i18N key='home.personal.jbzl' />
    </blockquote>

    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color:red;">*</span> <@i18N key='home.personal.name' />:</label>
        <div class="layui-input-block">
            <input type="text" name="realName" value="${view.realName!''}" lay-verify="required" autocomplete="off"
                   placeholder="<@i18N key='qsr' /><@i18N key='home.personal.name' />"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='home.personal.dlzh' />:</label>
        <div class="layui-input-block">
            <input type="text" name="account1" value="${view.account!''}" disabled autocomplete="off"
                   placeholder="<@i18N key='qsr' /><@i18N key='home.personal.dlzh' />"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='home.personal.sslx' />:</label>
        <div class="layui-input-block">
            <input type="text" name="types" value="${types!''}" disabled autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='home.personal.sslx' />"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='home.personal.zyjs' />:</label>
        <div class="layui-input-block">
            <input type="text" name="rolename" value="${rolename!''}" disabled autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='home.personal.zyjs' />"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='home.personal.sjhm' />:</label>
        <div class="layui-input-block">
            <input type="text" name="mobile" value="${view.mobile!''}" lay-verify="required" autocomplete="off"
                   placeholder="<@i18N key='qsr' /><@i18N key='home.personal.sjhm' />"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><@i18N key='home.personal.email' />:</label>
        <div class="layui-input-block">
            <input type="text" name="email" value="${view.email!''}" lay-verify="required" autocomplete="off"
                   placeholder="<@i18N key='qsr' /><@i18N key='home.personal.email' />"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-primary"><@i18N key='reset.button' /></button>
            <button class="layui-btn" lay-submit="" lay-filter="saveModel"><@i18N key='home.personal.tj' /></button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    function quxiao() {
        //刷新父页面
        parent.location.reload();
    }

    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit', 'upload'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate,
                layedit = layui.layedit,
                upload = layui.upload;

//普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '${serverPath}/mgn/sys/upload/'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#uploadimg').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code == 200) {
                    $("#photoimg").val(res.result.attachment);
                } else {
                    layer.msg(res.message);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;"><@i18N key='home.personal.uploaderror' /></span> <a class="layui-btn layui-btn-xs demo-reload"><@i18N key='home.personal.cs' /></a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });


        //表单数据提交
        form.on("submit(saveModel)", function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/home/personalData/saveModel", data.field, function (res) {
                layer.close(loadIndex);
                if (res.result) {
                    parent.layer.msg("<@i18N key='czcg' />!", {time: 1000}, function () {
                        //刷新父页面
                        parent.location.reload();
                    });
                } else {
                    layer.msg(res.message);
                }
            });
            return false;
        });

    });
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>