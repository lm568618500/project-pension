<@override name="body">

<form class="layui-form" style="width:80%;">
		<input type="hidden" name="id" value="${view.id}" />
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户名称</label>
	        <div class="layui-input-block">
	        	<select name="mechId" disabled lay-filter="mechId">
	        		<#list mechs as items>
	        			<option value="${items.id}" <#if view.mechId == items.id>selected</#if> >${items.mechName}</option>
	        		</#list>
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">网关名称</label>
	        <div class="layui-input-block">
	        	<select name="gatwayId" disabled lay-filter="gatwayId">
	        	<#list gayways as items>
	        			<option value="${items.id}" <#if view.gatwayId == items.id>selected</#if>  >${items.gatwayName}</option>
        		</#list>
        		</select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">配置信息</label>
	        <div class="layui-input-block">
	        	<textarea placeholder="请输入内容" class="layui-textarea" name="profile">${view.profile !''}</textarea>
	        </div>
    	</div>
    	
    	<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
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
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/message/messageSetting/modify",data.field,function(res){
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

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>