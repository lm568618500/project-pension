<@override name="body">
<div class="layui-layout layui-layout-admin">
 <@extends name="//common/top_menu.ftl"/>
  <div class="layui-side">
    <@extends name="//common/left_menu.ftl"/>
  </div>
  <div class="layui-body">
<style>
    .layui-form{
       margin-top: 4%;
    }
    .layui-form-item{
       margin-left: 15%;
    }
    .layui-form{
       margin-left: 10px;
       width: 80%;
    }
    td {
      text-align:center;
    }
</style>
 <fieldset class="layui-elem-field layui-field-title" style="margin-top:40px;">
     <legend> 通知消息接收设置</legend>
</fieldset>
    <form class="layui-form">
        <input type="hidden" id="id" name="id" value="${userNoticeSetting.id!''}">
        <input type="hidden" id="acceptSms" name="acceptSms" value="${userNoticeSetting.acceptSms!''}">
        <input type="hidden" id="acceptEmail" name="acceptEmail" value="${userNoticeSetting.acceptEmail!''}">
        <input type="hidden" id="sampleSms" name="sampleSms" value="${userNoticeSetting.sampleSms!''}">
        <input type="hidden" id="sampleEmail" name="sampleEmail" value="${userNoticeSetting.sampleEmail!''}">
        <input type="hidden" id="factorySms" name="factorySms" value="${userNoticeSetting.factorySms!''}">
        <input type="hidden" id="factoryEmail" name="factoryEmail" value="${userNoticeSetting.factoryEmail!''}">
        <input type="hidden" id="costSms" name="costSms" value="${userNoticeSetting.costSms!''}">
        <input type="hidden" id="costEmail" name="costEmail" value="${userNoticeSetting.costEmail!''}">
        <div class="layui-form">
		  <table class="layui-table">
		    <colgroup>
		      <col width="150">
		      <col width="220">
		      <col width="220">
		      <col width="220">
		    </colgroup>
		    <thead>
		      <tr>
		        <th style="text-align:center;">序号</th>
		        <th style="text-align:center;">通知类别</th>
		        <th style="text-align:center;">短信</th>
		        <th style="text-align:center;">邮箱</th>
		      </tr> 
		    </thead>
		    <tbody>
		      <tr>
		        <td>1</td>
		        <td>受理通知</td>
		        <td> <input type="checkbox" <#if userNoticeSetting.acceptSms == 0>checked </#if>  lay-skin="switch" lay-filter="switchAcceptSms" title="开关"></td>
		        <td> <input type="checkbox" <#if userNoticeSetting.acceptEmail == 0>checked </#if>  lay-skin="switch" lay-filter="switchAcceptEmail" title="开关"></td>
		      </tr>
		       <tr>
		        <td>2</td>
		        <td>送样通知</td>
		        <td> <input type="checkbox" <#if userNoticeSetting.acceptSms == 0>checked </#if>  lay-skin="switch" lay-filter="switchSampleSms" title="开关"></td>
		        <td> <input type="checkbox" <#if userNoticeSetting.acceptEmail == 0>checked </#if>  lay-skin="switch" lay-filter="switchSampleEmail" title="开关"></td>
		      </tr>
		      <tr>
		        <td>3</td>
		        <td>工厂检查通知</td>
		        <td> <input type="checkbox" <#if userNoticeSetting.factorySms == 0>checked </#if>  lay-skin="switch" lay-filter="switchFactorySms" title="开关"></td>
		        <td> <input type="checkbox" <#if userNoticeSetting.factoryEmail == 0>checked </#if>  lay-skin="switch" lay-filter="switchFactoryEmail" title="开关"></td>
		      </tr>
		      <tr>
		        <td>4</td>
		        <td>费用检查通知</td>
		        <td> <input type="checkbox" <#if userNoticeSetting.costSms == 0>checked </#if> lay-skin="switch" lay-filter="switchCostSms" title="开关"></td>
		        <td> <input type="checkbox" <#if userNoticeSetting.costEmail == 0>checked </#if>  lay-skin="switch" lay-filter="switchCostEmail" title="开关"></td>
		      </tr>
		    </tbody>
		  </table>
		</div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="submit">确定</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'jquery', 'layer'], function () {
        var form = layui.form,
                $ = layui.jquery,
                layer = layui.layer;
                initElement('editUserNoticeSettingInit');
		form.on('switch(switchAcceptSms)', function(data){
		     $("#acceptSms").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchAcceptEmail)', function(data){
		     $("#acceptEmail").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchSampleSms)', function(data){
		     $("#sampleSms").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchSampleEmail)', function(data){
		     $("#sampleEmail").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchFactorySms)', function(data){
		     $("#factorySms").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchFactoryEmail)', function(data){
		     $("#factoryEmail").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchCostSms)', function(data){
		     $("#costSms").val(this.checked ? 0 : 1);
		});
		form.on('switch(switchCostEmail)', function(data){
		     $("#costEmail").val(this.checked ? 0 : 1);
		});
        form.on('submit(submit)', function (data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${serverPath}/user/editUserNoticeSetting", data.field, function (res) {
                layer.close(loadIndex);
                if (res.code == 200) {
                    layer.msg("修改成功");
                } else {
                    layer.msg(res.message);
                }
            });
            return false;
        });
    });
</script>
</@override>
<@extends name="//common/iframe_templates.ftl"/>