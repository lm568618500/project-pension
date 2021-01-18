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
          <span class="layui-badge layui-bg-red">锁定</span>
  {{#  } else if(d.status === 1){ }}
           <span class="layui-badge layui-bg-blue"> 正常</span>
  {{#  } else { }}
           <span class="layui-badge layui-bg-red">其它</span>
  {{#  } }}
</script>

<script>
    var table;
    layui.use(['layer','form','table'], function() {
        table = layui.table;
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                t;//表格数据变量
		var cols = [
		        {type:'radio'},
                {field:'account', title: '用户名'},
                {field:'realName', title: '姓名'},
                {field:'email', title: '邮箱'},
                {field:'mobile', title: '手机号'},
                {field:'roleName', title: '角色'},
                {field:'status', title: '状态',templet: '#statusTpl'}
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
        //搜索
        form.on("submit(searchForm)",function(data){
            t.where = data.field;
            table.reload('test', t);
            return false;
        });
        
    });
    function getSelectRowValue(){
		var ids = [];
		var names = [];
		var checkStatus = table.checkStatus('test')
	      ,rows = checkStatus.data;
		for(var i=0; i<rows.length; i++){
			ids.push(rows[i].id);
			names.push(rows[i].realName);
		}
	    if(rows){
	    	var returnJson = { 
	    		"SelectId": ids,  
	            "SelectName": names 
	        } 
	    }else{
	    	var returnJson = { 
	    		"SelectId": "",  
	            "SelectName": "" 
		    } 
	    }
        return returnJson;  
	}
</script>
</@override>

<@extends name="//common/admin/iframe_templates.ftl"/>