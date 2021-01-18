<@override name="body">

<form class="layui-form" style="width:80%;">

	<div class="layui-form-item" >
		<label class="layui-form-label">一级分类</label>
		<div class="layui-input-inline">
			<select name="parentOneId" lay-verify="required">
				<option value>全部</option>
				<#list oneList as oneList>
					<option value="${oneList.id!}">${oneList.name!}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">名称</label>
		<div class="layui-input-block">
			<input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">名称（英文）</label>
		<div class="layui-input-block">
			<input type="text" name="nameEn" lay-verify="title" autocomplete="off" placeholder="请输入名称（英文）" class="layui-input">
		</div>
	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="breaks" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">排序</label>
	        <div class="layui-input-block">
	        	<input type="text" name="sort" lay-verify="title" autocomplete="off" placeholder="请输入排序" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
           
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/finance/newTypeTwo/saveModel",data.field,function(res){
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