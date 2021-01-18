<@override name="body">

<fieldset class="layui-elem-field">
    <legend>LISTINIT</legend>
    <div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-inline" style="margin-left: 15px">
        	<!--请在对应DTO 添加c_字段 过滤。-->
            <label>查询条件1:</label>
            <div class="layui-input-inline">
                <input type="text" name="c_xxx" lay-verify="title" autocomplete="off" placeholder="请输入查询条件1" class="layui-input">
            </div>
        </div>
        
        <div class="layui-inline" style="margin-left: 15px">
            <label>查询条件2:</label>
            <div class="layui-input-inline">
                <input type="text" name="c_xxx2" lay-verify="title" autocomplete="off" placeholder="请输入查询条件2" class="layui-input">
            </div>
        </div>
        
         <div class="layui-inline" style="margin-left: 15px">
            <label>状态:</label>
            <div class="layui-input-inline">
        	      <select name="c_status" lay-verify="required">
			        <option value="-10001">全部</option>
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
	<a class="layui-btn layui-btn-xs" lay-event="showInfo">查看</a>
	<a class="layui-btn layui-btn-xs" lay-event="editInit">编辑</a>
	<a class="layui-btn layui-btn-xs" id="infoShow" lay-event="showParams">参数显示</a>
	{{#  if(d.status === 1){ }}
		<a class="layui-btn layui-btn-xs" lay-event="stop">禁用</a>
	{{#  } else if(d.status === 0){ }}
		<a class="layui-btn layui-btn-xs" lay-event="start">开启</a>
	{{#  } else { }}
		<span class="layui-badge layui-bg-gray">未知操作</span>
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
					{field:'id', title: ''},
					{field:'time', title: ''},
					{field:'lastupdate', title: ''},
					{field:'refundOrderId', title: '退款订单号'},
					{field:'payOrderId', title: '支付订单号'},
					{field:'channelPayOrderNo', title: '渠道支付单号'},
					{field:'mchId', title: '商户ID'},
					{field:'mchRefundNo', title: '商户退款单号'},
					{field:'channelId', title: '渠道ID'},
					{field:'payAmount', title: '支付金额,单位分'},
					{field:'refundAmount', title: '退款金额,单位分'},
					{field:'currency', title: '三位货币代码,人民币:cny'},
					{field:'status', title: '退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成'},
					{field:'result', title: '退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败'},
					{field:'clientIp', title: '客户端IP'},
					{field:'device', title: '设备'},
					{field:'remarkInfo', title: '备注'},
					{field:'channelUser', title: '渠道用户标识,如微信openId,支付宝账号'},
					{field:'userName', title: '用户姓名'},
					{field:'channelMchId', title: '渠道商户ID'},
					{field:'channelOrderNo', title: '渠道订单号'},
					{field:'channelErrCode', title: '渠道错误码'},
					{field:'channelErrMsg', title: '渠道错误描述'},
					{field:'extra', title: '特定渠道发起时额外参数'},
					{field:'notifyUrl', title: '通知地址'},
					{field:'param1', title: '扩展参数1'},
					{field:'param2', title: '扩展参数2'},
					{field:'expireTime', title: '订单失效时间'},
					{field:'refundSuccTime', title: '订单退款成功时间'},
					{field:'buzNotify', title: ''},
					{field:'buzResp', title: ''},
					{field:'isDel', title: ''},
					{field:'status', title: '状态',templet: '#statusTpl'},
					{fixed : 'right',title : '操作',	width : 250,align : 'center',toolbar : '#operation'}
            ];

        t = {
            elem: '#test',
            url:'${serverPath}/mgn/sm/pay/payRefundOrder/getByPage',
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
                        $.post("${serverPath}/mgn/sm/pay/payRefundOrder/start",{"id":data.id},function (res){
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
                        $.post("${serverPath}/mgn/sm/pay/payRefundOrder/stop",{"id":data.id},function (res){
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
	                    content : "${serverPath}/mgn/sm/pay/payRefundOrder/payRefundOrderShowInit?id=" + data.id,
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
                    content : "${serverPath}/mgn/sm/pay/payRefundOrder/payRefundOrderEditInit",
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
                    content : "${serverPath}/mgn/sm/pay/payRefundOrder/payRefundOrderAddInit",
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