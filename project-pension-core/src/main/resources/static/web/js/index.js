//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});

/**
 * 初始化选中菜单
 */
function initElement(id){ 
     $("#"+id).addClass("layui-this");
     var li =  $('#'+id).parents('li');
     li.addClass("layui-nav-itemed");
}