<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	            <input type="text" name="id"
	           		value="${view.id !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	 <input type="text" name="time"
	           		value="${(view.time?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	 <input type="text" name="lastupdate"
	           		value="${(view.lastupdate?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">1支付宝 2微信</label>
	        <div class="layui-input-block">
	            <input type="text" name="payTypeRange"
	           		value="${view.payTypeRange !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">10、支付宝App 11、支付宝WAP 12、支付宝PC 20微信App 21微信公众号</label>
	        <div class="layui-input-block">
	            <input type="text" name="payType"
	           		value="${view.payType !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">去支付时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="goPayTime"
	           		value="${(view.goPayTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="payOrderId"
	           		value="${view.payOrderId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchId"
	           		value="${view.mchId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchOrderNo"
	           		value="${view.mchOrderNo !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelId"
	           		value="${view.channelId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付金额,单位分</label>
	        <div class="layui-input-block">
	            <input type="text" name="amount"
	           		value="${view.amount !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">三位货币代码,人民币:cny</label>
	        <div class="layui-input-block">
	            <input type="text" name="currency"
	           		value="${view.currency !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成</label>
	        <div class="layui-input-block">
	            <input type="text" name="status"
	           		value="${view.status !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">客户端IP</label>
	        <div class="layui-input-block">
	            <input type="text" name="clientIp"
	           		value="${view.clientIp !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">设备</label>
	        <div class="layui-input-block">
	            <input type="text" name="device"
	           		value="${view.device !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品标题</label>
	        <div class="layui-input-block">
	            <input type="text" name="subject"
	           		value="${view.subject !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品描述信息</label>
	        <div class="layui-input-block">
	            <input type="text" name="body"
	           		value="${view.body !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">特定渠道发起时额外参数</label>
	        <div class="layui-input-block">
	            <input type="text" name="extra"
	           		value="${view.extra !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道商户ID</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelMchId"
	           		value="${view.channelMchId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelOrderNo"
	           		value="${view.channelOrderNo !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">Api返回结果</label>
	        <div class="layui-input-block">
	            <input type="text" name="apiResp"
	           		value="${view.apiResp !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误码</label>
	        <div class="layui-input-block">
	            <input type="text" name="errCode"
	           		value="${view.errCode !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误描述</label>
	        <div class="layui-input-block">
	            <input type="text" name="errMsg"
	           		value="${view.errMsg !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数1</label>
	        <div class="layui-input-block">
	            <input type="text" name="param1"
	           		value="${view.param1 !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数2</label>
	        <div class="layui-input-block">
	            <input type="text" name="param2"
	           		value="${view.param2 !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知地址</label>
	        <div class="layui-input-block">
	            <input type="text" name="notifyUrl"
	           		value="${view.notifyUrl !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知次数</label>
	        <div class="layui-input-block">
	            <input type="text" name="notifyCount"
	           		value="${view.notifyCount !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后一次通知时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="lastNotifyTime"
	           		value="${(view.lastNotifyTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单失效时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="expireTime"
	           		value="${(view.expireTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单支付成功时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="paySuccTime"
	           		value="${(view.paySuccTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务通知地址</label>
	        <div class="layui-input-block">
	            <input type="text" name="buzNotifyUrl"
	           		value="${view.buzNotifyUrl !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务接口响应</label>
	        <div class="layui-input-block">
	            <input type="text" name="buzNotifyResp"
	           		value="${view.buzNotifyResp !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	            <input type="text" name="isDel"
	           		value="${view.isDel !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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