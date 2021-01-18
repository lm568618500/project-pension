<@override name="body">

<style>
.layui-form-label {
    float: left;
    display: block;
    padding: 9px 15px;
    width: 120px;
    font-weight: 400;
    line-height: 20px;
    text-align: right;
}

.layui-input, .layui-textarea {
    display: block;
    width: 90%;
    padding-left: 10px;
}
</style>

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">创建时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="time"
	           		value="${(view.time?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">去支付时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="goPayTime"
	           		value="${(view.goPayTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off"   class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="payOrderId"
	           		value="${view.payOrderId !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchOrderNo"
	           		value="${view.mchOrderNo !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付金额(分)</label>
	        <div class="layui-input-block">
	            <input type="text" name="amount"
	           		value="${view.amount !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">币种</label>
	        <div class="layui-input-block">
	            <input type="text" name="currency"
	           		value="${view.currency !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单状态</label>
	        <div class="layui-input-block">
	            <input type="text" name="status"
	           		value="<#if view.status==0>订单生成<#elseif view.status==1>支付中<#elseif view.status==2>支付成功<#elseif view.status==2>业务处理完成</#if>" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品标题</label>
	        <div class="layui-input-block">
	            <input type="text" name="subject"
	           		value="${view.subject !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品描述</label>
	        <div class="layui-input-block">
	            <input type="text" name="body"
	           		value="${view.body !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">Api结果</label>
	        <div class="layui-input-block">
	            <input type="text" name="apiResp"
	           		value="${view.apiResp !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误码</label>
	        <div class="layui-input-block">
	            <input type="text" name="errCode"
	           		value="${view.errCode !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误描述</label>
	        <div class="layui-input-block">
	            <input type="text" name="errMsg"
	           		value="${view.errMsg !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数1</label>
	        <div class="layui-input-block">
	            <input type="text" name="param1"
	           		value="${view.param1 !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数2</label>
	        <div class="layui-input-block">
	            <input type="text" name="param2"
	           		value="${view.param2 !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知地址</label>
	        <div class="layui-input-block">
	            <input type="text" name="notifyUrl"
	           		value="${view.notifyUrl !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知次数</label>
	        <div class="layui-input-block">
	            <input type="text" name="notifyCount"
	           		value="${view.notifyCount !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后一次通知时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="lastNotifyTime"
	           		value="${(view.lastNotifyTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付成功时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="paySuccTime"
	           		value="${(view.paySuccTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务通知地址</label>
	        <div class="layui-input-block">
	            <input type="text" name="buzNotifyUrl"
	           		value="${view.buzNotifyUrl !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务接口响应</label>
	        <div class="layui-input-block">
	            <input type="text" name="buzNotifyResp"
	           		value="${view.buzNotifyResp !''}" disabled lay-verify="title" autocomplete="off"  class="layui-input">
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
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>