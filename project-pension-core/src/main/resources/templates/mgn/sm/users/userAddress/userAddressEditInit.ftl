<@override name="body">

<form class="layui-form" style="width:80%;">
    	
    	<input type="hidden" name="id" value="${view.id}" lay-verify="title" autocomplete="off"  class="layui-input">
    	<div class="layui-form-item">
	        <label class="layui-form-label">姓名</label>
	        <div class="layui-input-block" style="width: 250px;">
	        	<input type="text" name="userRealName"  value="${view.userRealName!''}" lay-verify="title" autocomplete="off" placeholder="请输入收货人真实姓名" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">手机号</label>
	        <div class="layui-input-block" style="width: 250px;">
	        	<input type="text" name="userTelephone" value="${view.userTelephone!''}" lay-verify="title" autocomplete="off" placeholder="请输入收货人手机号" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">邮编地址</label>
	        <div class="layui-input-block" style="width: 250px;">
	        	<input type="text" name="zipCode"  value="${view.zipCode!''}"  lay-verify="title" autocomplete="off" placeholder="请输入邮编地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item" style="max-width: 2000px;">
			<label class="layui-form-label required">收货地址</label>
			<div class="layui-inline" style="width: 150px;">
				<select name="s_province" id="s_select-province"
					lay-filter="s_province">
					<option value="-10001">请选择省份</option>
					 <#list provincelist as items>
				    	<#if items.useId == view.provinceId>
				    		<option value="${items.useId}" selected="selected">${items.name}</option>
				    	<#else>
				    		<option value="${items.useId}">${items.name}</option>
				    	</#if>
				    </#list>
				</select>
			</div>
			<div class="layui-inline" style="width: 150px;">
				<select name="s_city" id="s_select-city" lay-filter="s_city">
					<option value="-10001">请选择城市</option>
					<#list citylist as items>
				    	<#if items.useId == view.cityId>
				    		<option value="${items.useId}" selected="selected">${items.name}</option>
				    	<#else>
				    		<option value="${items.useId}">${items.name}</option>
				    	</#if>
				    </#list>
				</select>
			</div>
			<div class="layui-inline" style="width: 150px;">
				<select name="s_area" id="s_select-area" lay-filter="s_area">
					<option value="-10001">请选择县区</option> 
					<#list arealist as items>
				    	<#if items.useId == view.areaId>
				    		<option value="${items.useId}" selected="selected">${items.name}</option>
				    	<#else>
				    		<option value="${items.useId}">${items.name}</option>
				    	</#if>
				    </#list>
				</select>
			</div>
		</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">详细地址</label>
	        <div class="layui-input-block">
	        	<input type="text" name="addressDetail" value="${view.addressDetail!''}" lay-verify="title" autocomplete="off" placeholder="请输入详细地址" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">是否是默</label>
	        <div class="layui-input-block">
	        	<input type="radio" name="isDefault" <#if view.isDefault == 0> checked="checked"  </#if> value="0" lay-filter="category" lay-skin="primary" title="否">
	        	<input type="radio" name="isDefault" <#if view.isDefault == 1> checked="checked"  </#if> value="1"  lay-filter="category"  lay-skin="primary" title="是">
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
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	
        	// 省份下拉选择改变值
        	form.on('select(s_province)', function(data) {
        		loadCityByProvince(data.value,"s_select-province","s_select-city","s_select-area");
        	});

        	// 城市拉选择改变值
        	form.on('select(s_city)', function(data) {
        		loadAreaByCity(data.value,"s_select-city","s_select-area");
        	});

        	// 区县拉选择改变值
        	form.on('select(s_area)', function(data) {
        		$("#s_select-area").val(data.value);
        	}); 	
	        	
		
        	function loadCityByProvince(provinceId,selectProvinceId,selectCityId,selectAreaId) {
        		$("#"+selectProvinceId).val(provinceId);
        		var cityDate =  null;
       		    $.post("${serverPath}/mgn/sys/common/city/getCityByPId",{proviceId:provinceId},function(result){
                      if(result.code == 200){
                    	  cityDate = result.result;
                    	  var nr = '<option value="-10001">请选择城市</option>';
	                  	  $("#"+selectCityId).html(nr);
	
	                  		cityDate.forEach(function(e, i, arr) {
	                  			var tnr = "<option value='" + e.useId + "'>" + e.name + "</option>";
	                  			$("#"+selectCityId).append(tnr);
	                  		});
	
	                  		var nrarea = '<option value="-10001">请选择县区</option>';
	                  		$("#"+selectAreaId).html(nrarea);
	                  		
	                  		form.render();
                      }else{
                          layer.msg(res.message);
                      }
       		 	 }); 
        		
        	}

        	function loadAreaByCity(cityId,selectCityId,selectAreaId) {
        		$("#"+selectCityId).val(cityId);
        		var areaDate =  null;
       		    $.post("${serverPath}/mgn/sys/commonArea/getAreaByCId",{cityId:cityId},function(result){
                      if(result.code == 200){
                    	  areaDate = result.result;
                    	  var nr = '<option value="-10001">请选择县区</option>';
                  		  $("#"+selectAreaId).html(nr);

                  		  areaDate.forEach(function(e, i, arr) {
                  			 var tnr = "<option value='" + e.useId + "'>" + e.name + "</option>";
                  			 $("#"+selectAreaId).append(tnr);
                  		  });
                  		  
                  		form.render();
                      }else{
                          layer.msg(res.message);
                      }
       		 	 }); 
        	}
        	
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            var provinceId = $("#s_select-province").find("option:selected").val();
            var provinceName = $("#s_select-province").find("option:selected").text();
			var cityId = $("#s_select-city").find("option:selected").val();
			var cityName = $("#s_select-city").find("option:selected").text();
			var areaId = $("#s_select-area").find("option:selected").val();
			var areaName = $("#s_select-area").find("option:selected").text();
			data.field.provinceId = provinceId;
			data.field.provinceName = provinceName;
			data.field.cityId = cityId;
			data.field.cityName = cityName;
			data.field.areaId = areaId;
			data.field.areaName = areaName;
            $.post("${serverPath}/mgn/sm/users/userAddress/modify",data.field,function(res){
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