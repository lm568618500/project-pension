<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品订单ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="goodsorderid" lay-verify="title" autocomplete="off" placeholder="请输入商品订单ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="goodsid" lay-verify="title" autocomplete="off" placeholder="请输入商品ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商品名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="goodsname" lay-verify="title" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">金额,单位分</label>
	        <div class="layui-input-block">
	        	<input type="text" name="amount" lay-verify="title" autocomplete="off" placeholder="请输入金额,单位分" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">用户ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="userid" lay-verify="title" autocomplete="off" placeholder="请输入用户ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">订单状态,订单生成(0),支付成功(1),处理完成(2),处理失败(-1)</label>
	        <div class="layui-input-block">
	        	<input type="text" name="status" lay-verify="title" autocomplete="off" placeholder="请输入订单状态,订单生成(0),支付成功(1),处理完成(2),处理失败(-1)" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付订单号</label>
	        <div class="layui-input-block">
	        	<input type="text" name="payorderid" lay-verify="title" autocomplete="off" placeholder="请输入支付订单号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">渠道ID</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channelid" lay-verify="title" autocomplete="off" placeholder="请输入渠道ID" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付渠道用户ID(微信openID或支付宝账号等第三方支付账号)</label>
	        <div class="layui-input-block">
	        	<input type="text" name="channeluserid" lay-verify="title" autocomplete="off" placeholder="请输入支付渠道用户ID(微信openID或支付宝账号等第三方支付账号)" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">创建时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="createtime" id="createtime" autocomplete="off" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">更新时间</label>
	        <div class="layui-input-block">
	        	<input type="text" name="updatetime" id="updatetime" autocomplete="off" class="layui-input">
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
	   		 		elem: '#createtime',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#updatetime',
	   				type: 'datetime'
	 	 		});
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/pay/payGoodsOrder/modify",data.field,function(res){
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