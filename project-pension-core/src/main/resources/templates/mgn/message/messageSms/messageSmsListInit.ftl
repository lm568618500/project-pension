<@override name="body">

<fieldset class="layui-elem-field">
    <legend>短信发送记录</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
        	<!--请在对应DTO 添加c_字段 过滤。-->
            <label></label>
            <div class="layui-input-inline">
                <input type="text" name="c_mobile"  autocomplete="off" placeholder="请输入手机号码" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
            	<select name="c_tempUid"  >
			        <option value="">模板</option>
			        <#list tempSms as items>
			        	<option value="${items.tempUid!''}">${items.tempName!''}</option>
			        </#list>
			      </select>
            </div>
        </div>
        
        <div class="layui-inline">
	      <label></label>
	      <div class="layui-input-inline">
	        <input type="text" name="c_startTime" id="c_startTime"  placeholder="开始时间" autocomplete="off" class="layui-input">
	      </div>
	    </div>
	    <div class="layui-inline">
	      <label></label>
	      <div class="layui-input-inline">
	        <input type="text" name="c_endTime" id="c_endTime"  placeholder="结束时间" autocomplete="off" class="layui-input">
	      </div>
	    </div>
        
         <div class="layui-inline" style="margin-left: 15px">
            <label></label>
            <div class="layui-input-inline">
        	      <select name="c_status" lay-verify="required">
			        <option value="-10001">状态</option>
			        <option value="0">停止</option>
			        <option value="1">开启</option>
			      </select>
            </div>
        </div>
        
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        <!--
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal"   data-type="addInit">新增</a>
        </div> -->
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
		<span class="layui-badge layui-bg-red">发送中</span>
	{{#  } else if(d.status === 1){ }}
		<span class="layui-badge layui-bg-blue">已发送</span>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">其它</span>
	{{#  } }}
</script>

<script type="text/html" id="operation">
	<!--<a class="layui-btn layui-btn-xs" lay-event="showInfo">查看</a>-->
	<!--<a class="layui-btn layui-btn-xs" lay-event="editInit">编辑</a>-->
	<!--<a class="layui-btn layui-btn-xs" id="infoShow" lay-event="showParams">参数显示</a>-->
	{{#  if(d.status === 1){ }}
		<!--<a class="layui-btn layui-btn-xs" lay-event="stop">禁用</a>-->
	{{#  } else if(d.status === 0){ }}
		<!--<a class="layui-btn layui-btn-xs" lay-event="start">开启</a>-->
	{{#  } else { }}
		<!--<span class="layui-badge layui-bg-gray">未知操作</span>-->
	{{#  } }}
	
	{{#  if(d.isDel === 0){ }}
		<!--<a class="layui-btn layui-btn-xs" lay-event="del">删除</a>-->
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
		    ,type: 'datetime'
		  });
		  laydate.render({
		    elem: '#c_endTime'
		    ,type: 'datetime'
		  });              //表格数据变量

		var cols = [
					//{field:'id', title: ''},
					//{field:'time', title: '数据插入时间'},
					//{field:'lastupdate', title: '最后修改时间'},
					{field:'mobile', title: '手机号码'},
					//{field:'tempId', title: '模板ID'},
					{field:'content', title: '内容'},
					//{field:'tempContent', title: '模板内容'},
					{field:'tempParamsBind', title: '参数'},
					{field:'sendTime', title: '发送时间'},
					//{field:'mechId', title: '商户ID'},
					//{field:'settingId', title: '设置'},
					//{field:'status', title: '状态'},
					//{field:'createTime', title: '创建时间戳'},
					//{field:'isDel', title: '-1 删除 0 正常'},
					{field:'status', title: '状态',templet: '#statusTpl'}//,
					//{fixed : 'right',title : '操作',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/message/messageSms/getByPage',
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
                        $.post("${serverPath}/mgn/message/messageSms/start",{"id":data.id},function (res){
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
                        $.post("${serverPath}/mgn/message/messageSms/stop",{"id":data.id},function (res){
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
	                    content : "${serverPath}/mgn/message/messageSms/messageSmsShowInit?id=" + data.id,
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
                        $.post("${serverPath}/mgn/message/messageSms/del",{"id":data.id},function (res){
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
                    title : "发布任务",
                    type : 2,
                    content : "${serverPath}/mgn/message/messageSms/messageSmsEditInit",
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
                    title : "发布任务",
                    type : 2,
                    content : "${serverPath}/mgn/message/messageSms/messageSmsAddInit",
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