<@override name="body">



<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>站点信发送信息</legend>
</fieldset>


<div class="layui-form">
  <table class="layui-table">
    <colgroup>
      <col width="150">
      <col width="600">
    </colgroup>
    <tbody>
    	<tr >
       		<td>添加时间</td>
        	<td>${view.time?string('yyyy-MM-dd HH:mm:ss')}</td>
        </tr>
        <tr >
       		<td>发送状态</td>
        	<td><#if view.status==-1>发送失败 <#elseif view.status==0>发送中 <#elseif view.status==1>发送成功</#if></td>
        </tr>
        <tr >
       		<td>发送时间</td>
        	<td><#if view.status==1>${view.sendTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
        </tr>
    	<tr >
       		<td>发送人</td>
        	<td>${view.creator!''}</td>
        </tr>
    	<tr >
       		<td>用户编号</td>
        	<td>${view.userNo!''}</td>
        </tr>
    	<tr >
       		<td>用户账号</td>
        	<td>${view.userName!''}</td>
        </tr>
    	<tr >
       		<td>用户手机号</td>
        	<td>${view.userMobile!''}</td>
        </tr>
    	<tr >
       		<td>用户姓名</td>
        	<td>${view.userRealName!''}</td>
        </tr>
        <tr >
       		<td>标题</td>
        	<td>${view.title!''}</td>
        </tr>
        <tr >
       		<td>内容</td>
       		<td ><textarea placeholder="请输入内容" class="layui-textarea">${view.content!''}</textarea></td>
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
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>