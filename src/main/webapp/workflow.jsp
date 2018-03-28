<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>流程设置</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/locale/easyui-lang-zh_CN.js">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="scripts/main.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true" style="padding-left: 6px">
    <div class="common">
        <label style="font-size:12px">流程分类：</label>
        <select class="easyui-combobox" panelHeight="auto" id="type" style="width:100px">
            <option value="">所有</option>
            <option value="01">商户流程</option>
            <option value="02">供应商流程</option>
        </select>
        &nbsp;&nbsp;
        <label style="font-size:12px">流程名称：</label><input class="wu-text" id="name" style="width:100px">
        &nbsp;&nbsp;
        <a href="#" id="btnSearch" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>
    </div>
    <div class="easyui-panel" title="流程列表" style="width: 1000px;">
        <table id="dg"></table>
    </div>
    <div style="text-align: right; width: 1000px; margin-top: 10px;">
        <a href="#" id="btn_remove" class="easyui-linkbutton" iconCls="icon-remove">删除</a> &nbsp;&nbsp;
        <a href="#" id="btn_edit" class="easyui-linkbutton" iconCls="icon-edit">修改</a> &nbsp;&nbsp;
        <a href="#" id="btn_add" class="easyui-linkbutton" iconCls="icon-add">新增</a>
    </div>

</div>
<script type="text/javascript">
    $(function () {
        $('#dg').datagrid({
            url:'findAllWorkFlow',
            fitColumns:true,
            pagination:true,
            pageSize:5,
            pageNumber:1,
            pageList:[10,20,30],
            singleSelect:true,
            columns:[[
                {field:'id',title:'流程ID',width:200,align:'center'},
                {field:'systemType',title:'系统类型',width:200,align:'center'},
                {field:'workFlowName',title:'流程名称',width:200,align:'center'},
                {field:'workFlowLevel',title:'重要性等级',width:200,align:'center'},
                {field:'sorted',title:'流程次序号',width:200,align:'center'}
            ]]
        });
    })
</script>
</body>
</html>