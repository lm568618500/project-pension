<@override name="body">

<form class="layui-form" style="width:80%;">
		<div class="layui-form-item" >
			<label class="layui-form-label">一级分类</label>
			<div class="layui-input-inline">
				<select name="oneParentId" lay-verify="required" lay-filter="oneSelect">
					<option value="-10001">全部</option>
					<#list oneList as oneList>
						<option value="${oneList.id!}" <#if oneList.id==view.oneParentId>selected</#if>>${oneList.name!}</option>
					</#list>
				</select>
			</div>
		</div>
		<div class="layui-form-item" >
			<label class="layui-form-label">二级分类</label>
			<div class="layui-input-inline">
				<select name="twoParentId" id="parentTwoId" lay-filter="twoSelect">
					<option value="-10001">全部</option>
					<#list twoList as twoList>
						<option value="${twoList.id!}"  <#if twoList.id==view.twoParentId>selected</#if>>${twoList.name!}</option>
					</#list>
				</select>
			</div>
		</div>
		<div class="layui-form-item" >
			<label class="layui-form-label">三级分类</label>
			<div class="layui-input-inline">
				<select name="threeParentId" id="parentThreeId" >
					<option value="-10001">全部</option>
					<#list threeList as threeList>
						<option value="${threeList.id!}" <#if threeList.id==view.threeParentId>selected</#if>>${threeList.name!}</option>
					</#list>
				</select>
			</div>
		</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">名称</label>
	        <div class="layui-input-block">
	        	<input type="text" name="name" value="${view.name!}" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input">
	        </div>
    	</div>
		<div class="layui-form-item">
			<label class="layui-form-label">名称（英文）</label>
			<div class="layui-input-block">
				<input type="text" name="nameEn" value="${view.nameEn!}" lay-verify="title" autocomplete="off" placeholder="请输入名称（英文）" class="layui-input">
			</div>
		</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">备注</label>
	        <div class="layui-input-block">
	        	<input type="text" name="breaks" value="${view.breaks!}" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label">排序</label>
	        <div class="layui-input-block">
	        	<input type="text" name="sort" value="${view.sort!}" lay-verify="title" autocomplete="off" placeholder="请输入排序" class="layui-input">
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
		
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/finance/newTypeFour/modify",data.field,function(res){
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
		form.on('select(twoSelect)', function(data){
			if(data.value==-10001){
				$("#parentThreeId").html("");
				var option1 = $("<option value>").text("请选择全部");
				$("#parentThreeId").append(option1);
				form.render('select');
				return false;
			}
			$.ajax({
				type: 'POST',
				url: '${serverPath}/mgn/finance/newTypeThree/getThreeJson',
				data: {id:data.value},
				dataType:  'json',
				success: function(data){
					var option1 = $("<option value>").text("请选择全部");
					$("#parentThreeId").empty();
					$("#parentThreeId").append($("<option value>").text("请选择全部"));
					$.each(data.result, function(key, val) {
						option1 = $("<option>").val(val.id).text(val.name);
						$("#parentThreeId").append(option1);
					});
					form.render('select');
				}
			});
		});
		form.on('select(oneSelect)', function(data){
			if(data.value==-10001){
				$("#parentTwoId").html("");
				var option1 = $("<option value>").text("请选择全部");
				$("#parentTwoId").append(option1);
				form.render('select');
				return false;
			}
			$.ajax({
				type: 'POST',
				url: '${serverPath}/mgn/finance/newTypeTwo/getOneJson',
				data: {id:data.value},
				dataType:  'json',
				success: function(data){
					var option1 = $("<option value>").text("请选择全部");
					$("#parentTwoId").empty();
					$("#parentTwoId").append($("<option value>").text("请选择全部"));
					$.each(data.result, function(key, val) {
						option1 = $("<option>").val(val.id).text(val.name);
						$("#parentTwoId").append(option1);
					});
					form.render('select');
				}
			});
		});
    }); 
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>