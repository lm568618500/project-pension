<@override name="body">

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
    width: 95%;
    padding-left: 10px;
}
</style>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>支付帮助中心</legend>
</fieldset>

<div class="layui-tab" lay-filter="test">
  <ul class="layui-tab-title">
    <li class="layui-this" lay-id="11">微信支付-订单查询</li>
    <li lay-id="22">微信支付-退款查询</li>
    <li lay-id="33">阿里支付-订单查询</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
  	    <form class="layui-form" style="width:80%;">
		    	<div class="layui-form-item">
			        <label class="layui-form-label">微信订单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="transactionId" id="transactionId" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	<div class="layui-form-item">
			        <label class="layui-form-label">支付订单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="outTradeNo" id="outTradeNo" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	
		    	<div class="layui-form-item">
			        <label class="layui-form-label">查询结果</label>
			        <div class="layui-input-block">
			        	<textarea   name="param"  class="layui-textarea" style="height:350px;" id="wechatQueryDiv" name="wechatQueryDiv" ></textarea>
			        </div>
		    	</div>
		    	
				<div class="layui-form-item">
		        <div class="layui-input-block">
		            <button class="layui-btn" lay-submit="" lay-filter="wechatOrderQuery">查询</button>
		            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		        </div>
		    </div>
		</form>
    </div>
    
    <div class="layui-tab-item">
    	<form class="layui-form" style="width:80%;">
		    	<div class="layui-form-item">
			        <label class="layui-form-label">微信订单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="transactionId" id="transactionId" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	<div class="layui-form-item">
			        <label class="layui-form-label">支付订单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="outTradeNo" outTradeNo="time" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	<div class="layui-form-item">
			        <label class="layui-form-label">商户退款单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="outRefundNo" id="outTradeNo" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	<div class="layui-form-item">
			        <label class="layui-form-label">微信退款单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="refundId" id="refundId" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	
		    	<div class="layui-form-item">
			        <label class="layui-form-label">查询结果</label>
			        <div class="layui-input-block">
			        	<textarea     class="layui-textarea" style="height:350px;" id="wechatRefundQueryDiv" name="wechatRefundQueryDiv" ></textarea>
			        </div>
		    	</div>
		    	
				<div class="layui-form-item">
		        <div class="layui-input-block">
		            <button class="layui-btn" lay-submit="" lay-filter="wechatRefundQuery">查询</button>
		            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		        </div>
		    </div>
		</form>
    </div>
    
    <div class="layui-tab-item">
    	<form class="layui-form" style="width:80%;">
		    	<div class="layui-form-item">
			        <label class="layui-form-label">商户订单号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="outTradeNo" id="outTradeNo" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	<div class="layui-form-item">
			        <label class="layui-form-label">支付宝交易号</label>
			        <div class="layui-input-block">
			        	<input type="text" name="tradeNo" id="tradeNo" autocomplete="off" class="layui-input">
			        </div>
		    	</div>
		    	
		    	<div class="layui-form-item">
			        <label class="layui-form-label">查询结果</label>
			        <div class="layui-input-block">
			        	<textarea     class="layui-textarea" style="height:350px;" id="aliPayQueryOrderDiv" name="aliPayQueryOrderDiv" ></textarea>
			        </div>
		    	</div>
		    	
				<div class="layui-form-item">
		        <div class="layui-input-block">
		            <button class="layui-btn" lay-submit="" lay-filter="aliPayQueryOrder">查询</button>
		            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		        </div>
		    </div>
		</form>
    
    </div>
    
    
  </div>
</div>



<script type="text/javascript" src="${StaticServer}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate','layedit','element','code'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           laydate = layui.laydate,
           layedit = layui.layedit,
           element = layui.element; 
           
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		
		//Hash地址的定位
		  var layid = location.hash.replace(/^#test=/, '');
		  element.tabChange('test', layid);
		  
		  element.on('tab(test)', function(elem){
		    location.hash = 'test='+ $(this).attr('lay-id');
		  });
		  
		  //表单数据提交
        form.on("submit(wechatOrderQuery)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            $.post("${serverPath}/mgn/sm/pay/payHelper/wechatOrderQuery",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){	
               	   var result = JSON.stringify(res);
                   $("#wechatQueryDiv").text(result);
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
        });
		  //表单数据提交
        form.on("submit(wechatRefundQuery)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            $.post("${serverPath}/mgn/sm/pay/payHelper/wechatRefundQuery",data.field,function(res){
               layer.close(loadIndex);
           	   var result = JSON.stringify(res);
               $("#wechatRefundQueryDiv").text(result);
            });
            return false;
        });
        
        
        
        
		  //表单数据提交
        form.on("submit(aliPayQueryOrder)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            $.post("${serverPath}/mgn/sm/pay/payHelper/aliPayQueryOrder",data.field,function(res){
               layer.close(loadIndex);
           	   var result = JSON.stringify(res);
               $("#aliPayQueryOrderDiv").text(result);
            });
            return false;
        });
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>