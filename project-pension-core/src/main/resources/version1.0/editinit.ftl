<${at}override name="body">

<form class="layui-form" style="width:80%;">
	<#list cols as field>
    	<div class="layui-form-item">
	        <label class="layui-form-label">${field.comment}</label>
	        <div class="layui-input-block">
	        	<#if field.isDate == 0 >
	        	<input type="text" name="<@linetohump value="${field.columnName}" />" lay-verify="title" autocomplete="off" placeholder="请输入${field.comment}" class="layui-input">
	        	<#else>
	        	<input type="text" name="<@linetohump value="${field.columnName}" />" id="<@linetohump value="${field.columnName}" />" autocomplete="off" class="layui-input">
	        	</#if>
	        </div>
    	</div>
	</#list>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${dl}{StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
           
        <#list cols as field>
	        	<#if field.isDate == 0 >
	        	<#else>
	        	laydate.render({
	   		 		elem: '#<@linetohump value="${field.columnName}" />',
	   				type: 'datetime'
	 	 		});
	        	</#if>
		</#list>
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${dl}{serverPath}${ftlPath}/${className?uncap_first}/modify",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("编辑成功!",{time:1000},function(){
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

</${at}override>
<${at}extends name="//common/admin/iframe_templates.ftl"/>