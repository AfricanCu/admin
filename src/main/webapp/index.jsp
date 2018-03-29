<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="scripts/main.js"></script>
</head>
<body class="easyui-layout" id="layout">
<div data-options="region:'north',title:'North Title',noheader:true,collapsible:false" style="height: 60px">

</div>
<div data-options="region:'south',title:'Copyright © 2018 Fungo.com Inc. All Rights Reserved. 范格科技 版权所有',collapsible:false"></div>
<div data-options="region:'west',title:'菜单导航',split:true,iconCls:'icon-nav'" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">
        <div title="基础设置" data-options="iconCls:'icon-setting',selected:true" style="overflow:auto;padding-right: 6px; padding-left: 6px">
            <ul id="base-setting">
                <li id="workflow_id" onclick="addPanel('流程设置|workflow.jsp')">流程设置</li>
                <li id="event_id" onclick="addPanel('事件设置|event.jsp')">事件设置</li>
                <li id="position_id" onclick="addPanel('岗位设置|position.jsp')">岗位设置</li>
                <li id="operator_id" onclick="addPanel('操作员设置|operator.jsp')">操作员设置</li>
                <li id="position_auth_id" onclick="addPanel('岗位权限设置|position_auth.jsp')">岗位权限设置</li>
                <li id="window_auth_id" onclick="addPanel('窗体权限设置|window_auth.jsp')">窗体权限设置</li>
            </ul>
        </div>
        <div title="Title2">
            content2
        </div>
        <div title="Title3">
            content3
        </div>
    </div>
</div>
<div data-options="region:'center',noheader:true" style="background:#eee;">
    <div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
        <div title="欢迎页" style="padding:20px;display:none;">

        </div>
    </div>
</div>
</body>
</html>
