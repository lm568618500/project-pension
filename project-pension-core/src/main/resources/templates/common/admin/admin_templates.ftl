<@extends name="/common/admin/adminAssIgn.ftl"/>
<html>
<head>
	<meta charset="utf-8">
	<title>${GlobalMap['SYS_NAME']}</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="${PubStaticServer}/favicon.ico">
	<link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${PubStaticServer}/static/css/index.css" media="all" />
</head>
<body class="main_body" style="height: 100%">
	<div class="layui-layout layui-layout-admin">
		<!-- 顶部 -->
		<div class="layui-header header">
			<div class="layui-main mag0">
				<a href="javascript:;" class="logo">${GlobalMap['SYS_NAME']}</a>
				<!-- 显示/隐藏菜单 -->
				<a href="javascript:;" class="seraph hideMenu icon-caidan"></a>
				<ul class="layui-nav topLevelMenus" pc>
				 <#list topMenus as menu>
				     <#if menu_index == 0>
				 		<li class="layui-nav-item layui-this" data-menuId="${menu.id!''}">
				 		   <a href="javascript:;"><i class="layui-icon" data-icon="${menu.icon!''}" >${menu.icon!''}</i><cite>${menu.name!''}</cite></a>
					    </li>
                     <#else>
				 		<li class="layui-nav-item" data-menuId="${menu.id!''}">
				 		   <a href="javascript:;"><i class="layui-icon" data-icon="${menu.icon!''}" >${menu.icon!''}</i><cite>${menu.name!''}</cite></a>
					    </li>
                     </#if>
				  </#list>
				  
				</ul>
			    <!-- 顶部右侧菜单 -->
			    <ul class="layui-nav top_menu">
					<!--<li class="layui-nav-item lockcms" pc>
						<a href="javascript:;"><i class="seraph icon-lock"></i><cite>锁屏</cite></a>
					</li>-->
					<li class="layui-nav-item" id="userInfo">
						<a href="javascript:;"><img src="${admin.photoimg!''}" class="layui-nav-img userAvatar" width="35" height="35"><cite class="adminName" >${admin.realName !''}</cite></a>
						<dl class="layui-nav-child">
							<!-- <dd><a href="javascript:;" data-url="page/user/userInfo.html"><i class="seraph icon-ziliao" data-icon="icon-ziliao"></i><cite>个人资料</cite></a></dd> -->
							<dd><a href="javascript:;" class="modify-pawssword" ><i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a></dd>
							<!--<dd pc><a href="javascript:;"  class="changeSkin"><i class="layui-icon">&#xe61b;</i><cite>更换皮肤</cite></a></dd>-->
							<dd><a  class="signOut"><i class="seraph icon-tuichu"></i><cite>退出</cite></a></dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<!-- 左侧导航 -->
		<div class="layui-side layui-bg-black">
			<div class="navBar layui-side-scroll" id="navBar">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this">
						<a href="javascript:;" data-url=""><i class="layui-icon" data-icon=""></i><cite>后台首页</cite></a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 右侧内容 -->
		<div class="layui-body layui-form">
			<div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
				<ul class="layui-tab-title top_tab" id="top_tabs">
					<li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>
				</ul>
				<ul class="layui-nav closeBox">
				  <li class="layui-nav-item">
				    <a href="javascript:;"><i class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
				    <dl class="layui-nav-child">
					  <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
				      <dd><a href="javascript:;" class="closePageOther"><i class="seraph icon-prohibit"></i> 关闭其他</a></dd>
				      <dd><a href="javascript:;" class="closePageAll"><i class="seraph icon-guanbi"></i> 关闭全部</a></dd>
				    </dl>
				  </li>
				</ul>
				<div class="layui-tab-content clildFrame">
					<div class="layui-tab-item layui-show">
						<iframe src="${serverPath}/mgn/tongji/index"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部 -->
		<div class="layui-footer footer">
			<p><span>${GlobalMap['ADMIN_FOOTER']}</span></p>
		</div>
	</div>

	<!-- 移动导航 -->
	<div class="site-tree-mobile"><i class="layui-icon">&#xe602;</i></div>
	<div class="site-mobile-shade"></div>
    <!-- main -->
    <script type="text/javascript" src="${PubStaticServer}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/js/index.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/js/cache.js"></script>
    <script type="text/javascript" src="${PubStaticServer}/static/js/echarts.min.js"></script>
	<script type="text/javascript" >
	  $('.modify-pawssword').on('click',function(){
     	layer.open({
 			type: 2,
 			area: ['600px', '500px'],
 			fix: false, //不固定
 			maxmin: true,
 			anim :3,//0-6  -1不要动画效果
 			shade:0.4,
 			skin: 'layui-layer-rim', //加上边框
 			title: '<span style="font-weight:bold;">修改密码</span>',
 			content:["/mgn/sys/admin/adminChangePwdInit","yes"],
 	        cancel: function(index1, layero){
 	    	   layer.confirm('您确定要关闭吗？',{icon: 3, title:'提示'},function(index2){
 	    		   layer.close(index2);
 	    		   layer.close(index1);
 	    	   });
 	    	   return false; 
 	      }
 		});
 	  });
	</script>
</body>
</html>