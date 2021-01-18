<#assign StaticServer="http://res.test1.shovesoft.com">
<#assign PubStaticServer="http://res.test1.shovesoft.com">
<html>
<head>
	<meta charset="utf-8">
	<title>支付测试DEMO</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="${PubStaticServer}/favicon.ico">
	<link rel="stylesheet" href="${PubStaticServer}/plugins/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${PubStaticServer}/css/index.css" media="all" />
	<script type="text/javascript" src="${PubStaticServer}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/qrcode/qrcode.js"></script>
	
	<style>
		.layui-form-label {
		    float: left;
		    display: block;
		    padding: 9px 15px;
		    width: 100px;
		    font-weight: 400;
		    line-height: 20px;
		    text-align: right;
		}
		
		.layui-input, .layui-textarea {
		    display: block;
		    width: 80%;
		    padding-left: 10px;
		}
	</style>
</head>
<body class="main_body" style="height: 100%">

	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>创建支付订单</legend>
</fieldset>


	 <form class="layui-form" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">商户订单号</label>
    <div class="layui-input-block">
      <input type="text" name="mchOrderNo" value="${mchOrderNo}" required  lay-verify="required" placeholder="请输入商户订单号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">金额（分）</label>
    <div class="layui-input-block">
      <input type="text" name="amount" required  value="${amount}" lay-verify="required" placeholder="请输入amount" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户端IP</label>
    <div class="layui-input-block">
      <input type="text" name="clientId" required  value="${clientId}" lay-verify="required" placeholder="请输入客户端调用IP" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">subject</label>
    <div class="layui-input-block">
      <input type="text" name="subject" required  value="${subject}" lay-verify="required" placeholder="请输入subject" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">body</label>
    <div class="layui-input-block">
      <input type="text" name="body" required  value="${body}" lay-verify="required" placeholder="请输入body" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">扩展参数-1</label>
    <div class="layui-input-block">
      <textarea name="param1" placeholder="请输入内容" class="layui-textarea">${param1}</textarea>
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">扩展参数-2</label>
    <div class="layui-input-block">
      <textarea name="param2" placeholder="请输入内容" class="layui-textarea">${param2}</textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">业务异步地址</label>
    <div class="layui-input-block">
      <input type="text" name="buzNotifyUrl" required  lay-verify="required" value="${buzNotifyUrl}" placeholder="请输入业务异步通知地址" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">业务同步地址</label>
    <div class="layui-input-block">
      <input type="text" name="buzCallbackUrl" required  lay-verify="required" value="${buzCallbackUrl}" placeholder="请输入业务同步通知地址" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">创建订单</button>
    </div>
  </div>
</form>




<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>去支付</legend>
</fieldset>

 <form class="layui-form" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">支付订单号</label>
    <div class="layui-input-block">
      <input type="text" id="payOrderId" name="payOrderId"   required  lay-verify="required" placeholder="请输入商户订单号" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="goPay">支付宝PC支付</button>
      <button class="layui-btn" lay-submit lay-filter="goWcahtScanPay">微信-扫码支付</button>
    </div>
  </div>
  
  
    <label class="layui-form-label">微信支付二维码</label>
    <div class="layui-input-block" id="wxScanImg">
    </div>
  </div>
</form>

 
<script>


layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate;
           layedit = layui.layedit;
           
           
	function payStateQuery(){ 
		var payOrderId = $("#payOrderId").val();
		$.post("/open/sm/pay/payStateQuery",{"payOrderId":payOrderId},function(res){
               if(res.code == 200){
               		//支付成功
               		if(res.result.state == 1){
               			layer.msg("订单:" + payOrderId + "支付成功!");
               		}
               }else{
                   layer.msg(res.message);
               }
            });
	} 

	function payStateQueryInterval(){
		window.setInterval(payStateQuery, 2000); 
	}
	           
  
  //监听提交
  form.on('submit(formDemo)', function(data){
  	$.post("/open/sm/pay/submitOrderCreateTest",data.field,function(res){
               if(res.code == 200){
               		layer.msg(res.result.payOrderId);
               		$("#payOrderId").val(res.result.payOrderId);
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
  });
  //监听提交
  form.on('submit(goPay)', function(data){
  	$.post("/open/sm/pay/aliPcPayTest",data.field,function(res){
               if(res.code == 200){
               		layer.msg(res.result.payUrl);
               		window.open(res.result.payUrl);  
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
  });
  
  form.on('submit(goWcahtScanPay)', function(data){
  			$.post("/open/sm/pay/wechatScanPayTest",data.field,function(res){
               if(res.code == 200){
               		new QRCode(document.getElementById("wxScanImg"), res.result.qrcode);
               		payStateQueryInterval();   
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
  });
});
</script>
</body>
</html>