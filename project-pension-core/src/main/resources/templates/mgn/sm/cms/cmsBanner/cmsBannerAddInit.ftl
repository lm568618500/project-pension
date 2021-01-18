<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">t_cms_banner_location id</label>
	        <div class="layui-input-block">
	        	<input type="text" name="locationId" lay-verify="title" autocomplete="off" placeholder="请输入t_cms_banner_location id" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">说明</label>
	        <div class="layui-input-block">
	        	<input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入说明" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">跳转地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="urls" lay-verify="title" autocomplete="off" placeholder="请输入跳转地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">banner图</label>
	        <div class="layui-input-block">
	        	<input type="text" name="images" lay-verify="title" autocomplete="off" placeholder="请输入banner图" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">排序</label>
	        <div class="layui-input-block">
	        	<input type="text" name="bSort" lay-verify="title" autocomplete="off" placeholder="请输入排序" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否外链（1，是，2，否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="iswai" lay-verify="title" autocomplete="off" placeholder="请输入是否外链（1，是，2，否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">操作用户</label>
	        <div class="layui-input-block">
	        	<input type="text" name="adminid" lay-verify="title" autocomplete="off" placeholder="请输入操作用户" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">创建时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">修改时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否启用（1是 0否）</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入是否启用（1是 0否）" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否删除(0否，-1是)</label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDel" lay-verify="title" autocomplete="off" placeholder="请输入是否删除(0否，-1是)" class="layui-input">
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
            $.post("${serverPath}/mgn/sm/cms/cmsBanner/saveModel",data.field,function(res){
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