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
        <td>账号</td>
        <td>${cmsFeedAckView.adminAccount!''}</td>
        <td>处理员</td>
        <td>${cmsFeedAckView.adminRealName!''}</td>
      </tr>
       <tr>
        <td>手机号</td>
        <td>${cmsFeedAckView.adminMobile!''}</td>
        <td>处理时间</td>
        <td>${cmsFeedAckView.time?string('yyyy.MM.dd HH:mm:ss')}</td>
      </tr>
      <tr>
        <td colspan=1>反馈信息</td>
        <td colspan=3>${cmsFeedAckView.ackContent!''}</td>
      </tr>
    </tbody>
  </table>
</div>


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
		
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>