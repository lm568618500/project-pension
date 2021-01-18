<@override name="body">

<fieldset class="layui-elem-field">
    <legend>管理员列表</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_account" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_realName" lay-verify="title" autocomplete="off" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_email" lay-verify="title" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_mobile" lay-verify="title" autocomplete="off" placeholder="请输入手机号" class="layui-input">
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

<script type="text/html" id="operation">
	<a  class="layui-btn layui-btn-xs" lay-event="modify">修改</a>
	{{#  if(d.status === 0){ }}
		<a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="unlock">解锁</a>
	{{#  } }}
	{{#  if(d.status === 1){ }}
		<a class="layui-btn  layui-btn-normal layui-btn-xs" lay-event="lock">锁定</a>
	{{#  } }}
		<a  class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="statusTpl">
 {{#  if(d.status === 0){ }}
          <span class="layui-badge layui-bg-red">锁定</span>
  {{#  } else if(d.status === 1){ }}
           <span class="layui-badge layui-bg-blue"> 正常</span>
  {{#  } else { }}
           <span class="layui-badge layui-bg-red">其它</span>
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
				//{field:'id', title: 'ID'},
                {field:'account', title: '用户名'},
                {field:'realName', title: '姓名'},
                {field:'email', title: '邮箱'},
                {field:'mobile', title: '手机号'},
                {field:'roleName', title: '角色'},
                {field:'time', title: '添加时间'},
                {field:'lastLoginTime', title: '最后登录时间'},
                {field:'roleName', title: '角色'},
                {field:'status', title: '状态',templet: '#statusTpl'},
                {fixed : 'right',title : '操作',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/sys/admin/getByPage',
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
            
            if (obj.event === 'unlock') {
				layer.confirm("你确定要解锁管理员"+data.realName+"么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/sys/admin/unlock",{"adminId":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("解锁成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} else if (obj.event === 'lock') {
				layer.confirm("你确定要锁定管理员"+data.realName+"么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/sys/admin/lock",{"adminId":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("锁定成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} else if (obj.event === 'del') {
				layer.confirm("你确定要删除管理员"+data.realName+"么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/sys/admin/del",{"adminId":data.id},function (res){
                           if(res.result.ret){
                               layer.msg("删除成功",{time: 1000},function(){
                                   table.reload('test', t);
                               });
                           }else{
                               layer.msg(res.message);
                           }
                        });
                    }
                )
			} 
			else if (obj.event === 'modify') {
				console.log(obj);
					var addIndex = layer.open({
	                    title : "编辑管理员",
	                    type : 2,
	                    content : "${serverPath}/mgn/sys/admin/editAdminInitPage?id="+obj.data.id,
	                    success : function(layero, addIndex){
	                        setTimeout(function(){
	                            layer.tips('点击此处返回管理员列表', '.layui-layer-setwin .layui-layer-close', {
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
            
            if(obj.event === "showParams"){
                $("#jsonContainer").empty();
                var options = {dom : document.getElementById('jsonContainer')};
                window.jf = new JsonFormatter(options);
                jf.doFormat(data.params);
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: '516px',
                    shadeClose: true,
                    content: $('#jsonContainer')
                });
            }
            if(obj.event === "showResponse"){
                $("#jsonContainer").empty();
                var options = {dom : document.getElementById('jsonContainer')};
                window.jf = new JsonFormatter(options);
                jf.doFormat(data.response);
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: '516px',
                    shadeClose: true,
                    content: $('#jsonContainer')
                });
            }
        });

        //功能按钮
        var active={
            addInit : function(){
                var addIndex = layer.open({
                    title : "添加管理员",
                    type : 2,
                    content : "${serverPath}/mgn/sys/admin/addAdminInitPage",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回管理员列表', '.layui-layer-setwin .layui-layer-close', {
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