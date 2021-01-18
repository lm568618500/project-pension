<@override name="body">

          
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>用户基本信息</legend>
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
        <td>用户头像</td>
        <td colspan=3><img lay-src="${view.photo!''}"></td>
      </tr>
      <tr>
        <td>用户名</td>
        <td>${view.userName!''}</td>
        <td>注册时间</td>
        <td>${view.time?string('yyyy.MM.dd HH:mm:ss')}</td>
      </tr>
      <tr>
        <td>姓名</td>
        <td>${view.realName!''}</td>
        <td>手机号</td>
        <td>${view.mobile!''}</td>
      </tr>
      <tr>
        <td>邮箱</td>
        <td>${view.email!''}</td>
        <td>性别</td>
        <td><#if view.sex==1>男<#elseif view.sex==2>女</#if></td>
      </tr>
      <tr>
        <td>省份</td>
        <td>${view.pName!''}</td>
        <td>城市</td>
        <td>${view.cName!''}</td>
      </tr>
      <tr>
        <td>区域</td>
        <td>${view.aName!''}</td>
        <td>职业</td>
        <td>${view.jobName!''}</td>
      </tr>
      <tr>
        <td>个性签名</td>
        <td colspan=3>${view.signature!''}</td>
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