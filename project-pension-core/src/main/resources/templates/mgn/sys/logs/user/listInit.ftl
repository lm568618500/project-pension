<@override name="body">

<fieldset class="layui-elem-field">
    <legend>用户操作日志</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
            <label>用户:</label>
            <div class="layui-input-inline">
                <input type="text" name="c_operaterName" lay-verify="title" autocomplete="off" placeholder="请输入用户" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label>操作内容:</label>
            <div class="layui-input-inline">
                <input type="text" name="c_eventContet" lay-verify="title" autocomplete="off" placeholder="请输入操作内容" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label>事件类型:</label>
            <div class="layui-input-inline">
        	      <select name="c_eventUseId" lay-verify="required">
        	      	<option value="0">全部</option>
        	      	<#list events as items>
        	      		<option value="${items.useId}">${items.beyondModule}</option>
        	      	</#list>
			      </select>
            </div>
        </div>
        <div class="layui-inline">
	      <label class="layui-form-label">开始时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="c_startTime" id="c_startTime"  placeholder="yyyy-MM-dd HH:mm" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label class="layui-form-label">结束时间</label>
	      <div class="layui-input-inline">
	        <input type="text" name="c_endTime" id="c_endTime"  placeholder="yyyy-MM-dd hh:mm" autocomplete="off" class="layui-input">
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
             指派中
  {{#  } else if(d.status === 1){ }}
             处理中
  {{#  } else if(d.status === 2){ }}
             待审核
  {{#  } else if(d.status === 3){ }}
             已完成
  {{#  } else { }}
           其它
  {{#  } }}
</script>

<script>
    layui.use(['layer','form','table','laydate'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                table = layui.table,
                laydate = layui.laydate,
                t;                  //表格数据变量

			//日期
		  laydate.render({
		    elem: '#c_startTime'
		     ,format: 'yyyy-MM-dd HH:mm' //可任意组合
		  });
		  laydate.render({
		    elem: '#c_endTime'
		     ,format: 'yyyy-MM-dd HH:mm' //可任意组合
		  });

		var cols = [
				//{field:'id', title: 'ID'},
                {field:'time', title: '操作时间'},
                {field:'operaterName', title: '用户'},
                {field:'ip', title: 'IP'},
                {field:'moduleName', title: '模块'},
                {field:'eventContet', title: '内容'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/sys/logs/user/getByPage',
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

        //功能按钮
        var active={
            deleteSome : function(){                        //批量删除
                var checkStatus = table.checkStatus('test'),
                     data = checkStatus.data;
                if(data.length > 0){
                    layer.confirm("你确定要删除这些日志么？",{btn:['是的,我确定','我再想想']},
                        function(){
                            var d = [];
                            for(var i=0;i<data.length;i++){
                                d.push(data[i].id);
                            }
                            $.post("${StaticServer}/admin/system/log/delete",{ids:d},function (res) {
                                if(res.success){
                                    layer.msg("删除成功",{time: 1000},function(){
                                        table.reload('test', t);
                                    });
                                }else{
                                    layer.msg(res.message);
                                }
                            });
                        }
                    )
                }else{
                    layer.msg("请选择需要删除的日志",{time:1000});
                }
            },
            
            addTask : function(){
                var addIndex = layer.open({
                    title : "发布任务",
                    type : 2,
                    content : "/cto/project/task/ProjectTask/addProjectTaskInitPage",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回任务中心列表', '.layui-layer-setwin .layui-layer-close', {
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