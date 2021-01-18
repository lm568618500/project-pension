<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">角色名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="rolename" lay-verify="title" autocomplete="off" placeholder="请输入角色名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">描述</label>
	        <div class="layui-input-block">
	        	<input type="text" name="roleDesc" lay-verify="title" autocomplete="off" placeholder="请输入描述" class="layui-input">
	        </div>
    	</div>
    	
    	<div class="layui-form-item">
	      <label class="layui-form-label">选择权限</label>
	      <div class="layui-input-block">
	        <div id="LAY-auth-tree-index"></div>
	      </div>
	    </div>
    	
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
	layui.config({
	base: '${PubStaticServer}/static/js/',
	}).extend({
		authtree: 'authtree',
	});
	
    layui.use(['form','jquery','layer','laydate','layedit','authtree'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate,
           authtree = layui.authtree,
           layedit = layui.layedit;
	 	 		
	 	 		
	 	var menusSelected; 		
	 	 // 初始化
		$.ajax({
			url: '${serverPath}/mgn/sys/authResources/getAllMenus',
			dataType: 'json',
			success: function(data){
			// 渲染时传入渲染目标ID，树形结构数据（具体结构看样例，checked表示默认选中），以及input表单的名字
			authtree.render('#LAY-auth-tree-index', data.data.trees, {
				inputname: 'authids[]'
				,layfilter: 'lay-check-auth'
				// ,autoclose: false
				// ,autochecked: false
				// ,openchecked: true
				// ,openall: true
				,autowidth: true
		});

		// PS:使用 form.on() 会引起了事件冒泡延迟的BUG，需要 setTimeout()，并且无法监听全选/全不选
		// PS:如果开启双击展开配置，form.on()会记录两次点击事件，authtree.on()不会
		form.on('checkbox(lay-check-auth)', function(data){
			// 注意这里：需要等待事件冒泡完成，不然获取叶子节点不准确。
			setTimeout(function(){
				console.log('监听 form 触发事件数据', data);
				// 获取选中的叶子节点
				var leaf = authtree.getLeaf('#LAY-auth-tree-index');
				console.log('leaf', leaf);
				// 获取最新选中
				var lastChecked = authtree.getLastChecked('#LAY-auth-tree-index');
				console.log('lastChecked', lastChecked);
				// 获取最新取消
				var lastNotChecked = authtree.getLastNotChecked('#LAY-auth-tree-index');
				console.log('lastNotChecked', lastNotChecked);
			}, 100);
		});
		
			// 使用 authtree.on() 不会有冒泡延迟
		authtree.on('change(lay-check-auth)', function(data) {
				//console.log('监听 authtree 触发事件数据', data);
				// 获取所有节点
				var all = authtree.getAll('#LAY-auth-tree-index');
				//console.log('all', all);
				// 获取所有已选中节点
				var checked = authtree.getChecked('#LAY-auth-tree-index');
				//console.log('checked', checked);
				menusSelected = checked;
				// 获取所有未选中节点
				var notchecked = authtree.getNotChecked('#LAY-auth-tree-index');
				//console.log('notchecked', notchecked);
				// 获取选中的叶子节点
				var leaf = authtree.getLeaf('#LAY-auth-tree-index');
				//console.log('leaf', leaf);
				// 获取最新选中
				var lastChecked = authtree.getLastChecked('#LAY-auth-tree-index');
				//console.log('lastChecked', lastChecked);
				// 获取最新取消
				var lastNotChecked = authtree.getLastNotChecked('#LAY-auth-tree-index');
				//console.log('lastNotChecked', lastNotChecked);
			});
		authtree.on('deptChange(lay-check-auth)', function(data) {
				console.log('监听到显示层数改变',data);
				});
			},
			error: function(xml, errstr, err) {
				layer.alert(errstr+'，获取样例数据失败，请检查是否部署在本地服务器中！');
			}
		});
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            
            $.post("${serverPath}/mgn/sys/authRole/saveModel",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("保存成功!",{time:1000},function(){
                       //刷新父页面
                       parent.location.reload();
                   });
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
        });
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>