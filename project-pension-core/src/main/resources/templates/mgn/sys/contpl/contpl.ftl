<@override name="body">

<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"><span style="color:red">*</span><@i18N key='sys.contpl.HeTongMingCheng' /></label>
	        <div class="layui-input-block">
	        	<input type="text" name="CONTPL_NAME" lay-verify="required" value='${contplData["CONTPL_NAME"].v!}' autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='sys.contpl.HeTongMingCheng' />" class="layui-input">
	        </div>
    	</div>
    	
    	<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red;">*</span><@i18N key='sys.contpl.HeTongShuiYin' />：</label>
		    <div class="layui-input-item">
		        <div style="float: left;margin-right: 10px">
					<img id="LAY_upload" width="120px" height="120px" src="${contplData["CONTPL_PIC"].v!}">
				</div>
				<div style="float: left;line-height: 120px;">
				   	<input type="hidden" id="CONTPL_PIC" name="CONTPL_PIC"  value='${contplData["CONTPL_PIC"].v!}'  autocomplete="off"  class="layui-input">
					<button type="button" class="layui-btn" id="upload"><i class="layui-icon"></i><@i18N key='sys.contpl.ShangChuanShuiYin' /></button>
				</div>
		    </div>
		</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"><@i18N key='sys.contpl.NeiRongMuBan' /></label>
	        <div class="layui-input-block">
                 <textarea style="display: none;" id="CONTPL_CONTENT" name="CONTPL_CONTENT" class="layui-textarea">${contplData["CONTPL_CONTENT"].v!}</textarea>
            </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="modify"><@i18N key='bianji' /></button>
        </div>
    </div>
</form>
<script>
    layui.use(['form','jquery','layer','layedit','upload'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer,
           upload = layui.upload,
           layedit = layui.layedit;
           var layeditindex = layedit.build('CONTPL_CONTENT'); //建立编辑器
         //指定允许上传的文件类型
		  upload.render({
		    elem: '#upload'
		    ,url: '${serverPath}/mgn/sys/upload/'
		    ,done: function(res){
		      if(res.code == 200){
                   layer.msg("<@i18N key='ShangChuanChengGong' />!",{time:200},function(){
                       $("#LAY_upload").attr('src',res.result.attachment);
                       $("#CONTPL_PIC").val(res.result.attachment);
                   });
               }else{
                   layer.msg(res.message);
               }
		    }
		  });
		//表单数据提交
        form.on("submit(modify)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //富文本框取值需要注意前面需要在方法体内进行赋值
            data.field.CONTPL_CONTENT = layedit.getContent(layeditindex);
            $.post("${serverPath}/mgn/sys/editConTpl",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   layer.msg("<@i18N key='czcg' />!",{time:1000},function(){
                       //刷新父页面
                      location.reload();
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