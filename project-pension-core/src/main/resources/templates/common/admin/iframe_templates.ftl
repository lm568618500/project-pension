 
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
    <link rel="stylesheet" href="${PubStaticServer}/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${PubStaticServer}/static/css/user.css" media="all" />
    <link rel="stylesheet" href="${PubStaticServer}/static/formatJSON/jsonFormater.css" media="all" />
    <script>
    var baseDir = '${PubStaticServer}';
	</script>
	<script type="text/javascript" src="${PubStaticServer}/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/layui/layui.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/js/tools.js"></script>
    <script type="text/javascript" src="${PubStaticServer}/static/js/echarts.min.js"></script>
	<script type="text/javascript" src="${PubStaticServer}/static/formatJSON/jsonFormater.js?v=3.0"></script>
	<script type="text/javascript" charset="utf-8" src="${serverPath}/res/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${serverPath}/res/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="${serverPath}/res/ueditor/lang/zh-cn/zh-cn.js"></script>
    <style>
        #Canvas {
            margin-top: 13px;
            padding: 20px 20px;
        }
        div.Canvas {
            font-size: 13px;
            background-color: #ECECEC;
            color: #000000;
            border: solid 1px #CECECE;
        }
        
        .layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
        @media(max-width:1240px){
            .layui-form-item .layui-inline{ width:100%; float:none; }
        }
        .layui-form-item .role-box {
            position: relative;
        }
        .layui-form-item .role-box .jq-role-inline {
            height: 100%;
            overflow: auto;
        }

    </style>
</head>
<body class="childrenBody">
	<@block name="body" >Body Content</@block>
</body>
</html>