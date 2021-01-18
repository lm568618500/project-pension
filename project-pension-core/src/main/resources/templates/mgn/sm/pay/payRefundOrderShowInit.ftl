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
	        <label class="layui-form-label">退款订单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="refundOrderId"
	           		value="${view.refundOrderId !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">渠道支付单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelPayOrderNo"
	           		value="${view.channelPayOrderNo !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">商户退款单号</label>
	        <div class="layui-input-block">
	            <input type="text" name="mchRefundNo"
	           		value="${view.mchRefundNo !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	            <input type="text" name="payAmount"
	           		value="${view.payAmount !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">退款金额,单位分</label>
	        <div class="layui-input-block">
	            <input type="text" name="refundAmount"
	           		value="${view.refundAmount !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成</label>
	        <div class="layui-input-block">
	            <input type="text" name="status"
	           		value="${view.status !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败</label>
	        <div class="layui-input-block">
	            <input type="text" name="result"
	           		value="${view.result !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	            <input type="text" name="remarkInfo"
	           		value="${view.remarkInfo !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道用户标识,如微信openId,支付宝账号</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelUser"
	           		value="${view.channelUser !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">用户姓名</label>
	        <div class="layui-input-block">
	            <input type="text" name="userName"
	           		value="${view.userName !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">渠道错误码</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelErrCode"
	           		value="${view.channelErrCode !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道错误描述</label>
	        <div class="layui-input-block">
	            <input type="text" name="channelErrMsg"
	           		value="${view.channelErrMsg !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">通知地址</label>
	        <div class="layui-input-block">
	            <input type="text" name="notifyUrl"
	           		value="${view.notifyUrl !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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
	        <label class="layui-form-label">订单失效时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="expireTime"
	           		value="${(view.expireTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单退款成功时间</label>
	        <div class="layui-input-block">
	        	 <input type="text" name="refundSuccTime"
	           		value="${(view.refundSuccTime?string('yyyy.MM.dd HH:mm:ss')) !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	            <input type="text" name="buzNotify"
	           		value="${view.buzNotify !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	            <input type="text" name="buzResp"
	           		value="${view.buzResp !''}" disabled lay-verify="title" autocomplete="off" placeholder="请输入标签名称" class="layui-input">
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