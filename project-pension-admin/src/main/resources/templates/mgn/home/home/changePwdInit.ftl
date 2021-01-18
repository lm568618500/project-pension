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

    <blockquote class="layui-elem-quote layui-field-title">
        <@i18N key='home.changpwd.xgmm' />
    </blockquote>

<form class="layui-form" style="width:80%;">

    <div class="layui-form-item">
        <label class="layui-form-label"><@i18N key='home.changpwd.ysmm' /></label>
        <div class="layui-input-block">
            <input type="password" name="oldPassword" id="oldPassword" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><@i18N key='home.changpwd.xmm' /></label>
        <div class="layui-input-block">
            <input type="password" name="newPassword" id="newPassword" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label"><@i18N key='home.changpwd.qrmm' /></label>
        <div class="layui-input-block">
            <input type="password" name="reNewPassword" id="reNewPassword" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify"><@i18N key='home.changpwd.bc' /></button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate;
        layedit = layui.layedit;

        //表单数据提交
        form.on("submit(modify)", function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/admin/modifyPassword", data.field, function (res) {
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