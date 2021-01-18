<@override name="body">

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>用户收货地址信息</legend>
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
        <td>姓名</td>
        <td>${view.userRealName!''}</td>
        <td>注册时间</td>
        <td>${view.time?string('yyyy.MM.dd HH:mm:ss')}</td>
      </tr>
      <tr>
        <td>手机号</td>
        <td>${view.userTelephone!''}</td>
        <td>邮编地址</td>
        <td>${view.zipCode!''}</td>
      </tr>
      <tr>
        <td>省份</td>
        <td>${view.provinceName!''}</td>
        <td>城市</td>
        <td>${view.cityName!''}</td>
      </tr>
      <tr>
        <td>区域</td>
        <td>${view.areaName!''}</td>
        <td>详细地址</td>
        <td>${view.addressDetail!''}</td>
      </tr>
      <tr>
        <td>是否默认</td>
        <td><#if view.isDefault==1>是<#elseif view.isDefault==2>否</#if></td>
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