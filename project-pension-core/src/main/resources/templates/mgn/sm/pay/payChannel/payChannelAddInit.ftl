<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付渠道</label>
	        <div class="layui-input-block" >
	        	<select name="channelId"  lay-filter="channelIdSelect">
			        <option value="">请选择</option>
			        <#list channels as items>
			        	<option value="${items.id}">${items.channelName}</option>
			        </#list>
			      </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">支付名称</label>
	        <div class="layui-input-block">
	        	<select id="channelItemsId" name="channelItemsId" lay-filter="channelItemsId">
			    </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">商户名称</label>
	        <div class="layui-input-block">
	        	<select name="mchId"  lay-filter="channelIdSelect">
			        <#list mchInfos as items>
			        	<option value="${items.mchId}">${items.mchName}</option>
			        </#list>
			      </select>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">接口配置</label>
	        <div class="layui-input-block">
	        	<textarea placeholder="请输入接口配置" name="param"  class="layui-textarea" name="desc"></textarea>
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<textarea placeholder="请输入备注" name="remark"  class="layui-textarea" ></textarea>
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
		
        form.on('select(channelIdSelect)', function(data){
		  		$.ajax({
		                type: 'POST',
		                url: '${serverPath}/mgn/pay/payChannelItemDict/listByChannelId',
		                data: {channelId:data.value},
		                dataType:  'json',
		                success: function(data){
		                $("#channelItemsId").html("");
		                  $.each(data.result.rets, function(key, val) {
		                var option1 = $("<option>").val(val.id).text(val.channelItemsName);
		                            $("#channelItemsId").append(option1);
		                            form.render('select');
		                        }); 
		              	$("#channelItemsId").get(0).selectedIndex=0;
		                }
		        }); 
		});
		
		
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sm/pay/payChannel/saveModel",data.field,function(res){
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