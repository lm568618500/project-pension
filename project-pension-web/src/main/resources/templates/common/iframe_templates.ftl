 
 <@extends name="/common/admin/adminAssIgn.ftl"/>
 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <title>${GlobalMap['SYS_NAME']}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">	
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${PubStaticServer}/favicon.ico">


    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/base.css">
    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/animate.css">
    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/page.css">
    <link rel="stylesheet" type="text/css" href="${PubStaticServer}/static/jw/css/media.css">
    <script>
    var baseDir = '${PubStaticServer}';
	</script>
    <script type="text/javascript" src="${PubStaticServer}/static/jw/js/jquery-3.4.1.min.js"></script>

	
</head>
<body class="childrenBody">
	<@block name="body" >Body Content</@block>
</body>
</html>