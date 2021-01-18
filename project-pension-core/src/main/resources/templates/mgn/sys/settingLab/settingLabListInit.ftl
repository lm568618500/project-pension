<@override name="body">
<fieldset class="layui-elem-field">
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
            <label><@i18N key='sys.settingLab.ShiYanShiMingCheng' />:</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="name" autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='sys.settingLab.ShiYanShiMingCheng' />" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm"><@i18N key='seacher.button' /></a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary"><@i18N key='reset.button' /></button>
        </div>
        
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal"   data-type="addInit"><@i18N key='add' /></a>
        </div>
    </form>
    </div>
</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
</div>
<div id="page"></div>
<div id='jsonContainer' class="Canvas" style="display: none"></div>

<script type="text/html" id="statusTpl">
	{{#  if(d.status === 0){ }}
		<span class="layui-badge layui-bg-red"><@i18N key='evaluation.ty' /></span>
	{{#  } else if(d.status === 1){ }}
		<span class="layui-badge layui-bg-blue"><@i18N key='evaluation.kq' /></span>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">其它</span>
	{{#  } }}
</script>

<script type="text/html" id="operation">
	<a class="layui-btn layui-btn-xs" lay-event="editInit"><@i18N key='bianji' /></a>
</script>

<script>
    layui.use(['layer','form','table'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                table = layui.table,
                t;                  //表格数据变量

		var cols = [
					{field:'name', title: '<@i18N key='sys.settingLab.ShiYanShiMingCheng' />'},
					{field:'adminName', title: '<@i18N key='sys.settingLab.TianJiaRen' />'},
					{field:'time', title: '<@i18N key='sys.settingLab.TianJiaShiJian' />'},
					{field:'status', title: '<@i18N key='status' />',templet: '#statusTpl'},
					{fixed : 'right',title : '<@i18N key='chaozuo' />',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/sys/settinglab/getByPage',
            method:'post',
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                groups: 4, //只显示 1 个连续页码
                first: "首页", //显示首页
                last: "尾页", //显示尾页
                limits:[3,10, 20, 30]
            },
            width: $(parent.window).width()-223,
            response: {
      			statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
   			 },
   			 request: {
		      pageName: 'pageNum', //页码的参数名称，默认：page
		      limitName: 'pageSize' //每页数据量的参数名，默认：limit
		    },
		    parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
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
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === "editInit"){
                var addIndex = layer.open({
                    title : "<@i18N key='evaluation.bjsj'/>",
                    type : 2,
                    content : "${serverPath}/mgn/sys/settinglab/settingLabEditInit?id=" + data.id,
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('<@i18N key='evaluation.djccfhlb'/>', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(addIndex);
                });
                layer.full(addIndex);
            }
        });
        

        //功能按钮
        var active={
            addInit : function(){
                var addIndex = layer.open({
                    title : "<@i18N key='zengjia'/>",
                    type : 2,
                    content : "${serverPath}/mgn/sys/settinglab/settingLabAddInit",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('<@i18N key='evaluation.djccfhlb'/>', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(addIndex);
                });
                layer.full(addIndex);
            }
        };

        $('.layui-inline .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //搜索
        form.on("submit(searchForm)",function(data){
            t.where = data.field;
            table.reload('test', t);
            return false;
        });

    });
</script>
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>