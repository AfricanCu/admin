<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>流程设置</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="scripts/main.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-search" style="padding-left: 8px;padding-top: 8px;">
            <label style="font-size:12px">流程名称：</label><input class="wu-text" id="name" style="width:100px">
            <label style="font-size:12px">系统类型：</label>
            <select class="easyui-combobox" panelHeight="auto" id="type" style="width:100px">
                <option value="">所有</option>
                <option value="01">商户流程</option>
                <option value="02">供应商流程</option>
            </select>
            <a href="#" id="btnSearch" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>
        </div>
        <div class="wu-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
        </div>
    </div>
    <!-- End of toolbar -->
    <table id="dg" class="easyui-datagrid"></table>
</div>

<div id="wu-dialog-2" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
    <table>
        <tr id="typeRow">
            <td align="right">流程类别：</td>
            <td>
                <select id="add_type" class="easyui-combobox" panelHeight="auto" style="width:100px">
                    <option value="1">商户流程</option>
                    <option value="2">供应商流程</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="60" align="right">流程名称：</td>
            <td><input id="add_name" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td align="right">重要级别：</td>
            <td><input id="add_level" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td align="right">流程序号：</td>
            <td><input id="add_sort" type="text" class="wu-text" /></td>
        </tr>
    </table>
</div>
</body>
</html>