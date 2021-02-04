<@override name="body">

<form class="layui-form" style="width:80%;">
	<input type="hidden" name="id" value="${view.id!}" lay-verify="title" autocomplete="off" placeholder="请输入id" class="layui-input">
	<div class="layui-form-item" >
		<label class="layui-form-label">一级分类</label>
		<div class="layui-input-inline">
			<select name="typeOneId" lay-verify="required" lay-filter="oneSelect">
				<option value="-10001">全部</option>
				<#list oneList as oneList>
					<option <#if oneList.id==view.typeOneId>selected</#if> value="${oneList.id!}">${oneList.name!}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="layui-form-item" >
		<label class="layui-form-label">二级分类</label>
		<div class="layui-input-inline">
			<select name="typeTwoId" id="parentTwoId" lay-filter="twoSelect">
				<option value="-10001">全部</option>
				<#list twoList as twoList>
					<option <#if twoList.id==view.typeTwoId>selected</#if> value="${twoList.id!}">${twoList.name!}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="layui-form-item" >
		<label class="layui-form-label">三级分类</label>
		<div class="layui-input-inline">
			<select name="typeThreeId" id="parentThreeId" lay-filter="threeSelect">
				<option value="-10001">全部</option>
				<#list threeList as threeList>
					<option <#if threeList.id==view.typeThreeId>selected</#if> value="${threeList.id!}">${threeList.name!}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="layui-form-item" >
		<label class="layui-form-label">四级分类</label>
		<div class="layui-input-inline">
			<select name="typeFourId" id="parentFourId" >
				<option value="-10001">全部</option>
				<#list fourList as fourList>
					<option <#if fourList.id==view.typeThreeId>selected</#if> value="${fourList.id!}">${fourList.name!}</option>
				</#list>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻名称</label>
		<div class="layui-input-block">
			<input type="text" name="name" value="${view.name!}" lay-verify="title" autocomplete="off" placeholder="请输入新闻名称" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻名称（英文）</label>
		<div class="layui-input-block">
			<input type="text" name="nameEn" value="${view.nameEn!}" lay-verify="title" autocomplete="off" placeholder="请输入新闻名称（英文）" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻描述</label>
		<div class="layui-input-block">
			<input type="text" name="describes" value="${view.describes!}" lay-verify="title" autocomplete="off" placeholder="请输入新闻描述" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻描述（英文）</label>
		<div class="layui-input-block">
			<input type="text" name="describeEn" value="${view.describeEn!}" lay-verify="title" autocomplete="off" placeholder="请输入新闻描述（英文）" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻内容</label>
		<div class="layui-input-block">
			<input type="hidden" id="conten" name="conten" value="">
			<textarea style="display: none;" id="pact"  name="pact" class="layui-textarea">${view.conten!}</textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新闻内容（英文）</label>
		<div class="layui-input-block">
			<input type="hidden" id="contenEn" name="contenEn" value="">
			<textarea style="display: none;" id="pactEn"  name="pactEn" class="layui-textarea">${view.contenEn!}</textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">视频</label>
		<div class="layui-input-block">
			<button type="button" class="layui-btn" id="test3">上传视频</button>
			<div class="layui-upload-list">
				<video src="${view.video!}" controls="controls" id="video1" width="100px" height="100px"></video>
				<input type="hidden" name="video" id="video" value="${view.video!}">
				<p id="demoText"></p>
			</div>

		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">主图片</label>
		<div class="layui-input-block">
			<button type="button" class="layui-btn" id="test1">上传图片</button>
			<div class="layui-upload-list">
				<img class="layui-upload-img" id="demo1" width="100px" height="100px" src="${view.images!}">
				<input type="hidden" name="images" id="images" value="${view.images!}">
				<p id="demoText"></p>
				建议大小（684*370）
			</div>

		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">图片合集(942*474)</label>
		<div class="layui-input-block">
			<input type="hidden" name="imagesList" id="imagesList">
			<button type="button" class="layui-btn" id="test2">多图片上传</button>
			<blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
				预览图：
				<div class="layui-upload-list" id="demo2"></div>
				<#list img as img>
					<span><img src="${serverPath}/common/image?id=${img}" val="${img}"  width="122px" height="122px" class="layui-upload-img"/><a onclick="delimg(this)">删除</a></span>
				</#list>
			</blockquote>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">排序</label>
		<div class="layui-input-block">
			<input type="text" value="${view.sort!}" name="sort" lay-verify="title" autocomplete="off" placeholder="请输入排序" class="layui-input">
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
    layui.use(['form','jquery','layer','laydate','layedit','upload'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
		   upload = layui.upload,
           laydate = layui.laydate;
           layedit = layui.layedit;
			layedit.set({
				uploadImage: {
					url: '${serverPath}/mgn/sys/uploadLayeditEdit',
					type: 'POST' //默认post
				}
			});
			var layeditindex = layedit.build('pact'); //建立编辑器
			var layeditindexEn = layedit.build('pactEn'); //建立编辑器
	        	laydate.render({
	   		 		elem: '#time',
	   				type: 'datetime'
	 	 		});
	        	laydate.render({
	   		 		elem: '#lastupdate',
	   				type: 'datetime'
	 	 		});
		//普通图片上传
		var uploadInst = upload.render({
			elem: '#test1'
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,done: function(res){

				if(res.code ==200) {
					//上传成功
					$('#demo1').attr('src', res.result.data.src);
					$("#images").val(res.result.data.src)
					return layer.msg('上传成功');
				}
				//如果上传失败
				else{
					return layer.msg('上传失败');
				}
			}
		});
		//多图片上传
		upload.render({
			elem: '#test2'
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,multiple: true
			,bindAction: '#testListAction'
			,choose: function(obj){
				//读取本地文件
				obj.preview(function(index, file, result){
				});
			}
			,done: function(res, index, upload){
				//$("#filesUrl1").val(res.result.attachment);
				if(res.code == 200){ //上传成功
					layer.msg("上传成功");
					$('#demo2').append('<span><img src="'+ res.result.data.src +'" val="'+ res.result.data.id +'"  width="122px" height="122px" class="layui-upload-img"/><a onclick="delimg(this)">删除</a></span>');
					layer.photos({
						photos: '#layer-photos',
						anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
					});

				}
			}
			,error: function(index, upload){
				layer.msg("上传失败");
			}
		});
		//普通图片上传
		var uploadInst = upload.render({
			elem: '#test3'
			,accept: 'video' //视频
			,url: '${serverPath}/mgn/sys/oss/cto/upload'
			,done: function(res){

				if(res.code ==200) {
					//上传成功
					$('#video1').attr('src', res.result.data.src);
					$("#video").val(res.result.data.src)
					return layer.msg('上传成功');
				}
				//如果上传失败
				else{
					return layer.msg('上传失败');
				}
			}
		});
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
			var img="";
			$("#demo2 img").each(function (i,v) {
				if(img==""){
					img=$(v).attr("val");
				}else{
					img=img+","+$(v).attr("val");
				}
			})
			data.field.imagesList = img;
			//富文本框取值需要注意前面需要在方法体内进行赋值
			data.field.conten = layedit.getContent(layeditindex);
			data.field.contenEn = layedit.getContent(layeditindexEn);
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/finance/news/modify",data.field,function(res){
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
		form.on('select(threeSelect)', function(data){
			if(data.value==-10001){
				$("#parentFourId").html("");
				var option1 = $("<option value>").text("请选择全部");
				$("#parentFourId").append(option1);
				form.render('select');
				return false;
			}
			$.ajax({
				type: 'POST',
				url: '${serverPath}/mgn/finance/newTypeFour/getFourJson',
				data: {id:data.value},
				dataType:  'json',
				success: function(data){
					var option1 = $("<option value>").text("请选择全部");
					$("#parentFourId").empty();
					$("#parentFourId").append($("<option value>").text("请选择全部"));
					$.each(data.result, function(key, val) {
						option1 = $("<option>").val(val.id).text(val.name);
						$("#parentFourId").append(option1);
					});
					form.render('select');
				}
			});
		});
	});
	function delimg(img){
		$(img).parent().remove();
	}
</script>

</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>