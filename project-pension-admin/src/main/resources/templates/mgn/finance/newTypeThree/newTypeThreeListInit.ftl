<@override name="body">

<fieldset class="layui-elem-field">
    <legend>三级分类</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
            <label>一级分类:</label>
            <div class="layui-input-inline">
                <select name="c_parent_one_id" lay-verify="required" lay-filter="oneSelect">
                    <option value="-10001">全部</option>
                    <#list oneList as oneList>
                        <option value="${oneList.id!}">${oneList.name!}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="layui-inline" style="margin-left: 15px">
            <label>二级分类:</label>
            <div class="layui-input-inline">
                <select name="c_parent_two_id" id="c_parent_two_id" lay-filter="twoSelect">
                    <option value="-10001">全部</option>

                </select>
            </div>
        </div>
        <div class="layui-inline" style="margin-left: 15px">
            <label>三级分类:</label>
            <div class="layui-input-inline">
                <select name="c_parent_three_id" id="c_parent_three_id">
                    <option value="-10001">全部</option>

                </select>
            </div>
        </div>
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal"   data-type="addInit">新增</a>
        </div>
    </form>
    </div>
</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
</div>
<div id="page"></div>
<div id='jsonContainer' class="Canvas" style="display: none"></div>
<script type="text/html" id="zizeng">
    {{d.LAY_TABLE_INDEX+1}}
</script>
<script type="text/html" id="statusTpl">
	{{#  if(d.status === 0){ }}
		<span class="layui-badge layui-bg-red">停用</span>
	{{#  } else if(d.status === 1){ }}
		<span class="layui-badge layui-bg-blue">开启</span>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">其它</span>
	{{#  } }}
</script>

<script type="text/html" id="operation">
	<a class="layui-btn layui-btn-xs" lay-event="editInit">编辑</a>
	{{#  if(d.status === 1){ }}
		<a class="layui-btn layui-btn-xs" lay-event="stop">禁用</a>
	{{#  } else if(d.status === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="start">开启</a>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">未知操作</span>
	{{#  } }}
	
	{{#  if(d.isDel === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
	{{#  } }}
</script>

<script>
    layui.use(['layer','form','table'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                table = layui.table,
                t;                  //表格数据变量

		var cols = [
                    {field : '_index',title : '序号',templet:'#zizeng'},
					{field:'parentOneName', title: '一级分类'},
					{field:'parentTwoName', title: '二级分类'},
					{field:'name', title: '三级分类'},
                    {field:'nameEn', title: '三级分类英文'},
					{field:'time', title: '时间'},
					{field:'lastupdate', title: '更新时间'},
					{field:'sort', title: '排序'},
					{fixed : 'right',title : '操作',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/finance/newTypeThree/getByPage',
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
            
            if (obj.event === 'start') {
				layer.confirm("你确定要开启么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/finance/newTypeThree/start",{"id":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("操作成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} else if (obj.event === 'stop') {
				layer.confirm("你确定要关闭么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/finance/newTypeThree/stop",{"id":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("操作成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} else if (obj.event === 'showInfo') {
				console.log(obj);
					var addIndex = layer.open({
	                    title : "基础信息",
	                    type : 2,
	                    content : "${serverPath}/mgn/finance/newTypeThree/newTypeThreeShowInit?id=" + data.id,
	                    success : function(layero, addIndex){
	                        setTimeout(function(){
	                            layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
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
			} else if (obj.event === 'del') {
				layer.confirm("你确定要删除么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/finance/newTypeThree/del",{"id":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("操作成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} 
            
            if(obj.event === "showParams"){
                var jsonStr = JSON.stringify(data);       //转为JSON字符串
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: '516px',
                    shadeClose: true,
                    content: jsonStr
                });
            }
            if(obj.event === "editInit"){
                var addIndex = layer.open({
                    title : "编辑数据",
                    type : 2,
                    content : "${serverPath}/mgn/finance/newTypeThree/newTypeThreeEditInit?id=" + data.id,
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
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
                    title : "新增数据",
                    type : 2,
                    content : "${serverPath}/mgn/finance/newTypeThree/newTypeThreeAddInit",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
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
        form.on('select(oneSelect)', function(data){
            if(data.value==-10001){
                $("#c_parent_two_id").html("");
                var option1 = $("<option value='-10001'>").text("请选择全部");
                $("#c_parent_two_id").append(option1);
                form.render('select');
                return false;
            }
            $.ajax({
                type: 'POST',
                url: '${serverPath}/mgn/finance/newTypeTwo/getOneJson',
                data: {id:data.value},
                dataType:  'json',
                success: function(data){
                    var option1 = $("<option value='-10001'>").text("请选择全部");
                    $("#c_parent_two_id").empty();
                    $("#c_parent_two_id").append($("<option value='-10001'>").text("请选择全部"));
                    $.each(data.result, function(key, val) {
                        option1 = $("<option>").val(val.id).text(val.name);
                        $("#c_parent_two_id").append(option1);
                    });
                    form.render('select');
                }
            });
        });
        form.on('select(twoSelect)', function(data){
            if(data.value==-10001){
                $("#c_parent_three_id").html("");
                var option1 = $("<option value='-10001'>").text("请选择全部");
                $("#c_parent_three_id").append(option1);
                form.render('select');
                return false;
            }
            $.ajax({
                type: 'POST',
                url: '${serverPath}/mgn/finance/newTypeThree/getThreeJson',
                data: {id:data.value},
                dataType:  'json',
                success: function(data){
                    var option1 = $("<option value='-10001'>").text("请选择全部");
                    $("#c_parent_three_id").empty();
                    $("#c_parent_three_id").append($("<option value='-10001'>").text("请选择全部"));
                    $.each(data.result, function(key, val) {
                        option1 = $("<option>").val(val.id).text(val.name);
                        $("#c_parent_three_id").append(option1);
                    });
                    form.render('select');
                }
            });
        });
    });
</script>
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>