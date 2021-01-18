<@override name="body">

<fieldset class="layui-elem-field">
    <legend>用户反馈</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
        	<!--请在对应DTO 添加c_字段 过滤。-->
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_links" lay-verify="title" autocomplete="off" placeholder="请输入联系方式" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_linkName" lay-verify="title" autocomplete="off" placeholder="请输入联系人" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
        	     <input type="text" name="c_startTime" 
        	     id="c_startTime"  placeholder="开始时间" 
        	     autocomplete="off" class="layui-input">
            </div>
        </div>
        
         <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
        	     <input type="text" name="c_endTime" id="c_endTime"  placeholder="结束时间" autocomplete="off" class="layui-input">
            </div>
        </div>
        
         <div class="layui-inline" style="margin-left: 15px">
            <label>状态:</label>
            <div class="layui-input-inline">
        	      <select name="c_status" lay-verify="required">
			        <option value="-10001">全部</option>
			        <option value="0">待处理</option>
			        <option value="1">已处理</option>
			      </select>
            </div>
        </div>
        
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
		<span class="layui-badge layui-bg-red">待反馈</span>
	{{#  } else if(d.status === 1){ }}
		<span class="layui-badge layui-bg-blue">已反馈</span>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">其它</span>
	{{#  } }}
</script>

<script type="text/html" id="operation">
	{{#  if(d.status === 1){ }}
		<a class="layui-btn layui-btn-xs" lay-event="showInit">查看反馈</a>
	{{#  } else if(d.status === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="editInit">处理反馈</a>
	{{#  } else { }}
	{{#  } }}
	
	{{#  if(d.isDel === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
	{{#  } }}
</script>

<script>
    layui.use(['layer','form','table', 'laydate'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                laydate = layui.laydate,
                table = layui.table,
                t;                  //表格数据变量

		laydate.render({
			    elem: '#c_startTime'
			  });
		  laydate.render({
		    elem: '#c_endTime'
		  });

		var cols = [
					//{field:'id', title: ''},
					{field:'time', title: '反馈时间'},
					//{field:'lastupdate', title: ''},
					//{field:'status', title: ''},
					//{field:'isDel', title: ''},
					{field:'links', title: '联系方式'},
					//{field:'linkType', title: '联系类型：1 手机号 2邮箱'},
					//{field:'userId', title: '用户ID'},
					{field:'linkName', title: '联系人'},
					//{field:'feedContent', title: '反馈内容'},
					{field:'feedTitle', title: '反馈标题'},
					//{field:'feedType', title: '反馈分类。后续扩展。'},
					{field:'feedNo', title: '反馈编号'},
					{field:'status', title: '状态',templet: '#statusTpl'},
					{fixed : 'right',title : '操作',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/sm/cms//cmsFeed/getByPage',
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
           if (obj.event === 'del') {
				layer.confirm("你确定要删除么？",{btn:['是的,我确定','我再想想']},
                    function(){
                        $.post("${serverPath}/mgn/sm/cms//cmsFeed/del",{"id":data.id},function (res){
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
            
            if(obj.event === "editInit"){
                var addIndex = layer.open({
                    title : "编辑数据",
                    type : 2,
                    content : "${serverPath}/mgn/sm/cms//cmsFeed/cmsFeedEditInit?id=" + data.id,
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
            if(obj.event === "showInit"){
                var addIndex = layer.open({
                    title : "查看数据",
                    type : 2,
                    content : "${serverPath}/mgn/sm/cms//cmsFeed/cmsFeedShowInit?id=" + data.id,
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
                    content : "${serverPath}/mgn/sm/cms//cmsFeed/cmsFeedAddInit",
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

    });
</script>
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>