<@override name="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>问题反馈</legend>
</fieldset>


<div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col>
      <col>
      <col>
      <col>
    </colgroup>
    <tbody>
      <tr>
        <td>联系人</td>
        <td>${view.linkName!''}</td>
        <td>反馈时间</td>
        <td>${view.time?string('yyyy.MM.dd HH:mm:ss')}</td>
      </tr>
      <tr>
        <td>联系方式</td>
        <td>${view.links!''}</td>
        <td>反馈标题</td>
        <td>${view.feedTitle!''}</td>
      </tr>
      <tr>
        <td>反馈内容</td>
        <td colspan=3>${view.feedContent!''}</td>
      </tr>
    </tbody>
  </table>
</div>


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>处理方式</legend>
</fieldset>
<form class="layui-form" style="width:80%;">
		<input type="hidden" name="id" value="${view.id!''}" lay-verify="required" autocomplete="off" class="layui-input">
		<input type="hidden" name="feedNo" value="${view.feedNo!''}" lay-verify="required" autocomplete="off"   class="layui-input">
    	<div class="layui-form-item">
	        <label class="layui-form-label">处理备注</label>
	        <div class="layui-input-block">
	        	<textarea name="feedAck" placeholder="请输入内容" lay-verify="required" class="layui-textarea"></textarea>
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">提交</button>
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
            $.post("${serverPath}/mgn/sm/cms//cmsFeed/modify",data.field,function(res){
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