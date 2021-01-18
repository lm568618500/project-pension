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
	        <label class="layui-form-label">退款订单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="refundOrderId" lay-verify="title" autocomplete="off" placeholder="请输入退款订单号" class="layui-input">
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
	        <label class="layui-form-label">商户退款单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="mchRefundNo" lay-verify="title" autocomplete="off" placeholder="请输入商户退款单号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付金额,单位分</label>
	        <div class="layui-input-block">
	        	<input type="text" name="payAmount" lay-verify="title" autocomplete="off" placeholder="请输入支付金额,单位分" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">退款金额,单位分</label>
	        <div class="layui-input-block">
	        	<input type="text" name="refundAmount" lay-verify="title" autocomplete="off" placeholder="请输入退款金额,单位分" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">三位货币代码,人民币:cny</label>
	        <div class="layui-input-block">
	        	<input type="text" name="currency" lay-verify="title" autocomplete="off" placeholder="请输入三位货币代码,人民币:cny" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败</label>
	        <div class="layui-input-block">
	        	<input type="text" name="result" lay-verify="title" autocomplete="off" placeholder="请输入退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败" class="layui-input">
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
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="remarkInfo" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道用户标识,如微信openId,支付宝账号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelUser" lay-verify="title" autocomplete="off" placeholder="请输入渠道用户标识,如微信openId,支付宝账号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">用户姓名</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userName" lay-verify="title" autocomplete="off" placeholder="请输入用户姓名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付方式ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelItemsId" lay-verify="title" autocomplete="off" placeholder="请输入支付方式ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelId" lay-verify="title" autocomplete="off" placeholder="请输入渠道ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道错误码</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelErrCode" lay-verify="title" autocomplete="off" placeholder="请输入渠道错误码" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道错误描述</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelErrMsg" lay-verify="title" autocomplete="off" placeholder="请输入渠道错误描述" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">特定渠道发起时额外参数</label>
	        <div class="layui-input-block">
	        	<input type="text" name="extra" lay-verify="title" autocomplete="off" placeholder="请输入特定渠道发起时额外参数" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">通知地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="notifyUrl" lay-verify="title" autocomplete="off" placeholder="请输入通知地址" class="layui-input">
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
	        <label class="layui-form-label">订单失效时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="expireTime" id="expireTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单退款成功时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="refundSuccTime" id="refundSuccTime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="buzNotify" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"></label>
	        <div class="layui-input-block">
	        	<input type="text" name="buzResp" lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
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
            <button class="layui-btn" lay-submit="" lay-filter="saveModel">保存</button>
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
	   		 		elem: '#expireTime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#refundSuccTime',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/pay/payRefundOrder/saveModel",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("保存成功!",{time:1000},function(){
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