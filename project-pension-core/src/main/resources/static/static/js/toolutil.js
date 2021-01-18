var layer;
layui.use(['layer'], function(){
  layer = layui.layer;
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

/*弹出层*/
/*
	参数解释：
	title	标题
	url		请求的url
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）x7fqx8
*/
function layer_show(title,url,w,h,sooll){
	if (v_isEmpty(title)) {
		title=false;
	}
	if (v_isEmpty(w)) {
		w=($(window).width() - 30);
	}
	if (v_isEmpty(h)) {
		h=($(window).height() - 30);
	}
	if (v_isEmpty(sooll)) {
		sooll = "no";
	}
	layer.open({
		type: 2,
		area: [w+'px', h +'px'],
		fix: false, //不固定
		maxmin: true,
		anim :5,//0-6  -1不要动画效果
		shade:0.4,
		//offset: ['115px', '225px'],
		skin: 'layui-layer-rim', //加上边框
		title: '<span style="font-weight:bold;">'+title+'</span>',
		//btn: ['确定', '关闭'],
		btn: ['确定'],
		content:[urlTool(url),sooll],
		yes: function (index,layero) {
            window["layui-layer-iframe" + index].formSubmit();
        },
       cancel: function(index1, layero){
    	   layer.confirm('您确定要关闭吗？',{icon: 3, title:'提示'},function(index2){
    		   layer.close(index2);
    		   layer.close(index1);
    	   });
    	   return false; 
       },
       success : function(layero, index){
    	   returnPage();
       }
	});
}

function returnPage(){
	 setTimeout(function(){
         layui.layer.tips('点击此处关闭，返回上一级页面！', '.layui-layer-setwin .layui-layer-close', {
             tips: [3, '#3595CC']
         });
     },400);
}
/**
 * 确认详细信息
 */
function confirmDeteil(url,formData,formId){
	var i ;
	var dateArr = formData.field;
	if(v_isEmpty(formData)){//页面多name提交
		dateArr = $("#"+formId).serialize();//数据源
	}
	$.ajax({
		url : urlTool(url),
		type:"post",
		dateType : 'json',
		data : dateArr,//数据源
		beforeSend : function() {
			i = layer.msg("提交中...", {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ; //!图标
		},
		success : function(data) {
			data = typeof data == 'object' ? data : $.parseJSON(data);
			layer.close(i);  
        	if(data.c == 200){
        	    layer_show_icon(data.m,1,3000);//✔图标
            	setTimeout(function(){
            		if( typeof window.parent.queryGrid === 'function' ){//密码修改功能调用
            			window.parent.queryGrid(); //刷新父页面
            			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    	parent.layer.close(index);  // 关闭layer
            		}else{
            			window.location.reload(); //刷新当前页面
            		}
              	}, 600);
        	}else{
        		layer_show_icon(data.m,2,3000);//X图标
        	}
		}
	});
}
/*弹出层*/
/*
	参数解释：
	title	标题
	url		请求的url
*/
function layer_show_no(title,url){
	var w=($(window).width() - 20);
	var	h=($(window).height() - 20);
	var sooll = "yes";
	layer.open({
		type: 2,
		area: [w+'px', h +'px'],
		fix: false, //不固定
		maxmin: true,
		anim :3,//0-6  -1不要动画效果
		shade:0.4,
		skin: 'layui-layer-rim', //加上边框
		title: '<span style="font-weight:bold;">'+title+'</span>',
		content:[urlTool(url),sooll],
	    success : function(layero, index){
	    	returnPage();
	    }
	});
}
/*弹出层*/
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值
	sel_id		选择值id
	sel_name	选择值name
*/
function layer_show_select(title,url,w,h,sel_id,sel_name){
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
		content: [urlTool(url),'no'],
		btn: ['确定', '关闭'],
		yes: function (index) {
            var res = window["layui-layer-iframe" + index].getSelectRowValue();
            if (res != false) {
            	if (!v_isEmpty(sel_id)) {
            		$("#"+sel_id).val(res.SelectId);
            	}
            	if (!v_isEmpty(sel_name)) {
                    $("#"+sel_name).val(res.SelectName);
                    $("#"+sel_name).focus();
            	}
            	selectSuccess(res.SelectId,res.SelectName);
            }
            layer.close(index);
        }
	});
}
/*弹出层*/
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值
	obj		选择值id
*/
function layer_show_selectObj(title,url,w,h,obj){
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
		content: [urlTool(url),'no'],
		btn: ['确定', '关闭'],
		yes: function (index) {
            var res = window["layui-layer-iframe" + index].getSelectRowValue();
            if (res != false) {
            	selectSuccessObj(res.SelectId,res.SelectName,obj);
            }
            layer.close(index);
        }
	});
}


function urlTool(url){
	if (url.indexOf("_=") != -1) {
	     url = url.replace(/_=\d+/, "_=" + new Date().getTime());
	}else {
		if (url.indexOf("?") != -1) {
            url = url + "&_=" + new Date().getTime();
        } else {
            url = url + "?_=" + new Date().getTime();
        }    
	}
	return url;
}
//选择成功
function selectSuccess(ids,names){
	
}
//选择成功
function selectSuccessObj(ids,names,obj){
	
}
/*弹出层*/
/*
	参数解释：
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
function layer_show_icon(msg,icon,time){
	layer.msg(msg,{
		icon:icon,
		anim :3,//0-6  -1不要动画效果
		time: time,
		offset: '12px',
		closeBtn: 1
	});
}
/*关闭弹出框口*/
function layer_close(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
/**
 * 删除
 * @param url
 */
function del(id,url) {
	layer.confirm("确认要删除吗？",{icon: 3, title:'提示'},function(index){
		var i ;
		$.ajax({
			url : urlTool(url),
			type:"post",
			dateType : 'json',
			data :{
				'selectedId' : id
			},
			beforeSend : function() {
				i = layer.msg("正在删除...", {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000}) ; //!图标
			},
			success : function(data) {
				data = typeof data == 'object' ? data : $.parseJSON(data);
				layer.close(i);  
	        	if(data.c == 200){
	        	    layer_show_icon(data.m,1,3000);//✔图标
	            	setTimeout(function(){
	            		queryGrid(); //刷新父页面
	              	}, 400);
	        	}else{
	        		layer_show_icon(data.m,2,3000);//X图标
	        	}
			}
		});
	});
}
/**
 * 格式化日期
 */
function dateFormat(value){
	if(v_isEmpty(value)){
		return "";
	}
	var unixTimestamp = new Date(value);  
    return unixTimestamp.toLocaleString();
}
   

//表单序列化
function serializeObject(form){
  var o={};
  $.each(form.serializeArray(),function(index){
            if(o[this['name'] ]){
                 o[this['name'] ] = o[this['name'] ] + "," + this['value'];
             }else{
                o[this['name'] ]=this['value'];
             }
      })
    return o;
}

/**
 * 只能输入整数
 */
function keyNumber(obj){
	obj.value=obj.value.replace(/[^\d]/g,'');
}
/**
 * 浮点数的小数位
 */
function keyFloat(input, n) {
    input.value = input.value.replace(/[^0-9\.]/ig, '');
    var dotIdx = input.value.indexOf('.'), dotLeft, dotRight;
    if (dotIdx >= 0) {
        dotLeft = input.value.substring(0, dotIdx);
        dotRight = input.value.substring(dotIdx + 1);
        if (dotRight.length > n) {
            dotRight = dotRight.substring(0, n);
        }
        input.value = dotLeft + '.' + dotRight;
    }
}

/**
 * 设置未来(全局)的AJAX请求默认选项
 * 主要设置了AJAX请求遇到Session过期的情况
 */
$.ajaxSetup({
    type: 'POST',
    beforeSend: function(xhr) {
    	//可以设置自定义标头 
    	xhr.setRequestHeader('Test', 'msf');
    },
    complete: function(xhr,status) {
        var sessionStatus = xhr.getResponseHeader('sessionstatus');
        if(sessionStatus == 'timeout') {
        	layer_show_icon("连接超时，请从新登录！",5,3000);//X图标
        	setTimeout(function(){
        		if(window.parent.length>0) 
            		top.location.href='/login';
            	else 
            		window.location='/login';
          	}, 800);
        }
    }
});
function logout(){
    layer.confirm('您确定要退出吗？',{icon: 3, title:'提示'},function(index){
     	    layer.close(index);
           location.href = "/enterprise/user/logout";
	 });
 }
