<@override name="body">


<form class="layui-form" style="width:100%;">


    <blockquote class="layui-elem-quote layui-field-title">
        待处理事务
    </blockquote>

    <blockquote class="layui-elem-quote layui-field-title">
        数据汇总
    </blockquote>

    <blockquote class="layui-elem-quote layui-field-title">
        认证总览
    </blockquote>

    <blockquote class="layui-elem-quote layui-field-title">
        证书总览
    </blockquote>

</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>

    layui.use(['form', 'jquery', 'layer', 'laydate', 'layedit', 'upload'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer,
                laydate = layui.laydate,
                layedit = layui.layedit,
                upload = layui.upload;



    });
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>