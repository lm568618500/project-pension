<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="time" id="time" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastupdate" id="lastupdate" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">1支付宝 2微信</label>
	        <div class="layui-input-block">
	        	<input type="text" name="payTypeRange" lay-verify="title" autocomplete="off" placeholder="请输入1支付宝 2微信" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">10、支付宝App 11、支付宝WAP 12、支付宝PC 20微信App 21微信公众号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="payType" lay-verify="title" autocomplete="off" placeholder="请输入10、支付宝App 11、支付宝WAP 12、支付宝PC 20微信App 21微信公众号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">去支付时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="goPayTime" id="goPayTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付订单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="payOrderId" lay-verify="title" autocomplete="off" placeholder="请输入支付订单号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mchId" lay-verify="title" autocomplete="off" placeholder="请输入商户ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户订单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mchOrderNo" lay-verify="title" autocomplete="off" placeholder="请输入商户订单号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelId" lay-verify="title" autocomplete="off" placeholder="请输入渠道ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付金额,单位分</label>
	        <div class="layui-input-block">
	        	<input type="text" name="amount" lay-verify="title" autocomplete="off" placeholder="请输入支付金额,单位分" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">三位货币代码,人民币:cny</label>
	        <div class="layui-input-block">
	        	<input type="text" name="currency" lay-verify="title" autocomplete="off" placeholder="请输入三位货币代码,人民币:cny" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">客户端IP</label>
	        <div class="layui-input-block">
	        	<input type="text" name="clientIp" lay-verify="title" autocomplete="off" placeholder="请输入客户端IP" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">设备</label>
	        <div class="layui-input-block">
	        	<input type="text" name="device" lay-verify="title" autocomplete="off" placeholder="请输入设备" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品标题</label>
	        <div class="layui-input-block">
	        	<input type="text" name="subject" lay-verify="title" autocomplete="off" placeholder="请输入商品标题" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品描述信息</label>
	        <div class="layui-input-block">
	        	<input type="text" name="body" lay-verify="title" autocomplete="off" placeholder="请输入商品描述信息" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">特定渠道发起时额外参数</label>
	        <div class="layui-input-block">
	        	<input type="text" name="extra" lay-verify="title" autocomplete="off" placeholder="请输入特定渠道发起时额外参数" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道商户ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelMchId" lay-verify="title" autocomplete="off" placeholder="请输入渠道商户ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道订单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelOrderNo" lay-verify="title" autocomplete="off" placeholder="请输入渠道订单号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">Api返回结果</label>
	        <div class="layui-input-block">
	        	<input type="text" name="apiResp" lay-verify="title" autocomplete="off" placeholder="请输入Api返回结果" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误码</label>
	        <div class="layui-input-block">
	        	<input type="text" name="errCode" lay-verify="title" autocomplete="off" placeholder="请输入渠道支付错误码" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道支付错误描述</label>
	        <div class="layui-input-block">
	        	<input type="text" name="errMsg" lay-verify="title" autocomplete="off" placeholder="请输入渠道支付错误描述" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数1</label>
	        <div class="layui-input-block">
	        	<input type="text" name="param1" lay-verify="title" autocomplete="off" placeholder="请输入扩展参数1" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">扩展参数2</label>
	        <div class="layui-input-block">
	        	<input type="text" name="param2" lay-verify="title" autocomplete="off" placeholder="请输入扩展参数2" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="notifyUrl" lay-verify="title" autocomplete="off" placeholder="请输入通知地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知次数</label>
	        <div class="layui-input-block">
	        	<input type="text" name="notifyCount" lay-verify="title" autocomplete="off" placeholder="请输入通知次数" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">最后一次通知时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="lastNotifyTime" id="lastNotifyTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单失效时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="expireTime" id="expireTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单支付成功时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="paySuccTime" id="paySuccTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务通知地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="buzNotifyUrl" lay-verify="title" autocomplete="off" placeholder="请输入业务通知地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">业务接口响应</label>
	        <div class="layui-input-block">
	        	<input type="text" name="buzNotifyResp" lay-verify="title" autocomplete="off" placeholder="请输入业务接口响应" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="isDel" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
           
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#goPayTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastNotifyTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#expireTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#paySuccTime',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/pay/payOrder/modify",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("编辑成功!",{time:1000},function(){
                       //刷新父页面
                       parent.location.reload();
                   });
               }else{
                   layer.msg(res.message);
               }
            });
            return false;
        });
		
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>