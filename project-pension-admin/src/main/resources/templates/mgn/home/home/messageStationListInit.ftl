<@override name="body">

   <blockquote class="layui-elem-quote layui-field-title">
        <@i18N key='home.message.xxzx' />
   </blockquote>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
</div>
<div id="page"></div>


<script type="text/html" id="operation">

    {{#  if(d.isRead === 1){}}
    <a class="layui-btn layui-btn-xs layui-btn-disabled"><@i18N key='home.message.yd' /></a>
    {{#  } else if(d.isRead === 0){ }}
    <a class="layui-btn layui-btn-xs" lay-event="signRead"><@i18N key='home.message.bjwd' /></a>
    {{#  } else { }}
    {{#  } }}
</script>

<script type="text/html" id="toolbarDemo">

    <a class="layui-btn  layui-btn-sm" id="allSignRead"><@i18N key='home.message.bjqbyd' /></a>

</script>
<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script>
    layui.use(['layer', 'form', 'table'], function () {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                table = layui.table,
                t;                  //表格数据变量

        var cols = [
            {field: '_index', title: '<@i18N key='xh' />', templet: '#zizeng'},
            {field: 'content', title:'<@i18N key='home.message.xxnr' />'},
            {field: 'time', title: '<@i18N key='home.message.time' />'},
            {fixed: 'right', title: '<@i18N key='chaozuo' />', width: 250, align: 'center', toolbar: '#operation'}
        ];

        t = {
            elem: '#test',
            url: '${serverPath}/mgn/home/messageStation/getByPage',
            method: 'post',
            toolbar: '#toolbarDemo', //开启头部工具栏，并为其绑定左侧模板
            defaultToolbar: [],
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                groups: 4, //只显示 1 个连续页码
                first: "<@i18N key='sy' />", //显示首页
                last: "<@i18N key='wy' />", //显示尾页
                limits: [3, 10, 20, 30]
            },
            width: $(parent.window).width() - 223,
            response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            },
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：page
                limitName: 'pageSize' //每页数据量的参数名，默认：limit
            },
            parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.result.total, //解析数据长度
                    "data": res.result.list //解析数据列表
                };
            },
            cols: [cols]
        };
        table.render(t);

        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;

            if (obj.event === 'signRead') {
                $.post("${serverPath}/mgn/home/messageStation/signRead", {"msgId": data.id}, function (res) {
                    if (res.result.ret) {
                        layer.msg( "<@i18N key='czcg' />", {time: 1000}, function () {
                            table.reload('test', t);
                        });
                    } else {
                        layer.msg(res.message);
                    }
                });
            }
        });


        $('#allSignRead').on('click', function () {

            alert("jinlai le ");

            $.post("${serverPath}/mgn/home/messageStation/allSignRead", function (res) {
                if (res.result.ret) {
                    layer.msg( "<@i18N key='czcg' />", {time: 1000}, function () {
                        table.reload('test', t);
                    });
                } else {
                    layer.msg(res.message);
                }
            });


        });

        //搜索
        form.on("submit(searchForm)", function (data) {
            t.where = data.field;
            table.reload('test', t);
            return false;
        });

    });
</script>
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>