<@override name="body">
<form class="layui-form" style="width:80%;">
    	<div class="layui-form-item">
	        <label class="layui-form-label"><span style="color:red">*</span><@i18N key='sys.settingLab.ShiYanShiMingCheng' /></label>
	        <div class="layui-input-block">
	        	<input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='sys.settingLab.ShiYanShiMingCheng' />" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"><span style="color:red">*</span><@i18N key='sys.settingLab.JianChaFanWei' /></label>
	        <div class="layui-input-block">
	        	<input type="text" name="scope" lay-verify="required" autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='sys.settingLab.JianChaFanWei' />" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"><span style="color:red">*</span><@i18N key='sys.settingLab.XiangXiDiZhi' /></label>
	        <div class="layui-input-block">
	        	<input type="text" name="address" lay-verify="required" autocomplete="off" placeholder="<@i18N key='qsr' /><@i18N key='sys.settingLab.XiangXiDiZhi' />" class="layui-input">
	        </div>
    	</div>
    	<div class="layui-form-item">
		    <label class="layui-form-label"><span style="color:red">*</span><@i18N key='status' /></label>
		    <div class="layui-input-block">
		      <input type="radio" name="status" value="1" title="<@i18N key='admin.kq' />" checked="">
		      <input type="radio" name="status" value="0" title="<@i18N key='evaluation.ty' />">
		    </div>
	    </div>
		<div class="layui-form-item">
			<label class="layui-form-label"><span style="color: red">*</span><@i18N key='sys.settingLab.ZhuYaoLianXiRen' /></label>
			<div class="layui-input-block" id="contactText">
                <button type="button" class="layui-btn layui-btn-normal" id="select-icon1"><@i18N key='xz' /></button>
                <input type="hidden"  id="contact"  name="contact">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label"><span style="color: red">*</span><@i18N key='sys.settingLab.QiTaLianXiRen' /></label>
			<div class="layui-input-block" id="otherContactText" >
                <button type="button" class="layui-btn layui-btn-normal" id="select-icon2"><@i18N key='xz' /></button>
                <input type="hidden"   id="otherContact" name="otherContact">
			</div>
		</div>
    	<div class="layui-form-item">
	        <label class="layui-form-label"><@i18N key='bz' /></label>
	        <div class="layui-input-block">
                 <textarea placeholder="<@i18N key='qsr' /><@i18N key='bz' />" name="mark" class="layui-textarea"></textarea>
            </div>
    	</div>
		<div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="saveModel"><@i18N key='logo.bc' /></button>
            <button type="reset" class="layui-btn layui-btn-primary"><@i18N key='logo.cz' /></button>
        </div>
    </div>
</form>
<script>
    layui.use(['form','jquery','layer','laydate','layedit'],function(){
       var form = layui.form,
           $    = layui.jquery,
           layer = layui.layer;
		   $('#select-icon1').on('click',function(){
				layer_show_select("<@i18N key='xz' /><@i18N key='sys.settingLab.ZhuYaoLianXiRen' />","/mgn/sys/admin/adminSingle","","","contact","contact",1);
		   });
		   $('#select-icon2').on('click',function(){
				layer_show_select("<@i18N key='xz' /><@i18N key='sys.settingLab.QiTaLianXiRen' />","/mgn/sys/admin/adminMultiple","","","otherContact","otherContact",2);
		   });
		//表单数据提交
        form.on("submit(saveModel)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            var contact = data.field.contact;
            if(contact == ""){
               layer.close(loadIndex);
               layer.msg("<@i18N key='qxz' /><@i18N key='sys.settingLab.ZhuYaoLianXiRen' />");
               return false;
            }
            var otherContactIds = $("input[name=otherContactId]").map(function(){return this.value;}).get().join(",");
            if(otherContactIds.length == 0){
               layer.close(loadIndex);
               layer.msg("<@i18N key='qxz' /><@i18N key='sys.settingLab.QiTaLianXiRen' />");
               return false;
            }
            data.field.otherContact = otherContactIds;
            //富文本框取值需要注意前面需要在方法体内进行赋值
            //data.field.taskDesc = layedit.getContent(taskDescIndex);
            $.post("${serverPath}/mgn/sys/settinglab/saveModel",data.field,function(res){
               layer.close(loadIndex);
               if(res.result){
                   parent.layer.msg("<@i18N key='czcg' />!",{time:1000},function(){
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
/**
** 是否为空
**/
function v_isEmpty(str){
	var isN;
	if (str == "" || str == null){
        isN = true;
    } else {
        isN = false;
    }
	return isN;
}
function layer_show_select(title,url,w,h,sel_id,sel_name,type){
	if (v_isEmpty(title)) {
		title=false;
	}
	if (v_isEmpty(w)) {
		w=($(window).width() - 30);
	}
	if (v_isEmpty(h)) {
		h=($(window).height() - 30);
	}
	layer.open({
		type: 2,
		area: [w+'px', h +'px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		anim :3,//0-6  -1不要动画效果
		title: '<span style="font-weight:bold;">'+title+'</span>',
		closeBtn: 0, //不显示关闭按钮
		skin: 'layui-layer-rim', //加上边框
		content: [url,'no'],
		btn: ['<@i18N key='queding'/>', '<@i18N key='guanbi'/>'],
		yes: function (index) {
            var res = window["layui-layer-iframe" + index].getSelectRowValue();
            if (res != false) {
               if(type == 1){//单选
                   if (!v_isEmpty(sel_id)) {
        		        $("#"+sel_id).val(res.SelectId);
	               }
	               if (!v_isEmpty(sel_name)) {
	                    $("#contactButton").remove();
	                    $("#"+sel_name+"Text").prepend("<button id=\"contactButton\" type=\"button\" class=\"layui-btn layui-btn-primary layui-btn-sm\">"+res.SelectName+"</button>");
	               }
               }else {//多选
                   selectSuccess(res.SelectId,res.SelectName,sel_name);
               }
            }
            layer.close(index);
        }
	});
}
function selectSuccess(ids,names,selName){
   var otherContactIds = $("input[name=otherContactId]").map(function(){return this.value;}).get();
   for(var i in ids){
      if($.inArray(ids[i]+"",otherContactIds) == -1){//去重复
         $("#"+selName+"Text").prepend("<button type=\"button\" onclick=\"delHtml(this)\"class=\"layui-btn layui-btn-primary layui-btn-sm\">"+names[i]+"<i class=\"layui-icon\"></i><input type=\"hidden\"   id=\"otherContactId\" name=\"otherContactId\" value=\""+ids[i]+"\"></button>");
      }
   }
}
function delHtml(obj){
  var index = layer.confirm('<@i18N key='evaluation.nqdyscm'/>？',{icon: 3, title:'<@i18N key='TiShi'/>'},function(index){
      $(obj).remove();
      layer.close(index);
  });
}
</script>
</@override>
<@extends name="//common/admin/iframe_templates.ftl"/>