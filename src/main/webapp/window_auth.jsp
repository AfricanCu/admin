<%--
  Created by IntelliJ IDEA.
  User: ZMJ
  Date: 2018/3/28
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <title>Insert title here</title>
    <script>
        $(function(){
            $('#dg').datagrid({
                url:'findAuth',
                fitColumns:true,
                pagination:true,
                pagePosition:'top',
                pageSize:5,
                pageNumber:1,
                pageList:[10,20,30],
                singleSelect:true,
                columns:[[
                    {field:'id',title:'窗体ID',width:100,align:'center'},
                    {field:'name',title:'窗体名称',width:100,align:'center'},
                    {field:'url',title:'窗体地址',width:100,align:'center'},
                    {field:'authId',title:'权限id',width:100,align:'center'},
                    {field:'authName',title:'权限名称',width:100,align:'center'}
                ]]
            });

            $("#btnSearch").click(function () {
                var name = $("#searchName").val();
                $.ajax({
                    url: "findAuth",
                    type: 'post',
                    data: {'name':name},
                    success: function(data){
                        $('#dg').datagrid('loadData',data);
                    }
                });
            });
        });

        function addWindow(){
            clearFrom();
            $('#wu-dialog-2').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var win = {
                            'name': $("#name").val(),
                            'url': $("#url").val()
                        }
                        $.ajax({
                            url: "addWindow",
                            type: 'post',
                            data: win,
                            success: function(data){
                                if(data == "1"){
                                    $.messager.alert('提示','添加成功');
                                    $('#dg').datagrid('reload');
                                    $('#wu-dialog-2').dialog('close');
                                }
                            }
                        });
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-2').dialog('close');
                    }
                }]
            });
        }

        function editWindow(){
            var row = $('#dg').datagrid('getSelected');
            $.ajax({
                url: "getWindowById",
                type: 'post',
                data: {'id': row.id},
                success: function(data){
                    $("#name").val(data.name);
                    $("#url").val(data.url);
                }
            });
            $('#wu-dialog-2').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var win = {
                            "id": row.id,
                            'name': $("#name").val(),
                            'url': $("#url").val()
                        }
                        $.ajax({
                            url: "updateWindow",
                            type: 'post',
                            data: win,
                            success: function(data){
                                if(data == "1"){
                                    $.messager.alert('提示','修改成功');
                                    $('#dg').datagrid('reload');
                                    $('#wu-dialog-2').dialog('close');
                                }
                            }
                        });
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-2').dialog('close');
                    }
                }]
            });
        }

        function clearFrom(){
            $("#name").val('');
            $("#url").val('');
            $('#windowId').combobox('setValue','');
            $("#authName").val('');
        }

        function addPrivile(){
            $("#windowId").combobox({
                url:'findWindow',
                valueField:'id',
                textField:'name'
            });

            clearFrom();
            $('#wu-dialog-3').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var win = {
                            'windowId': $("#windowId").combobox('getValue'),
                            'authName': $("#authName").val()
                        }
                        $.ajax({
                            url: "addAuth",
                            type: 'post',
                            data: win,
                            success: function(data){
                                if(data == "1"){
                                    $.messager.alert('提示','添加成功');
                                    $('#dg').datagrid('reload');
                                    $('#wu-dialog-3').dialog('close');
                                }
                            }
                        });
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-3').dialog('close');
                    }
                }]
            });
        }

        function editPrivile(){
            var row = $('#dg').datagrid('getSelected');
            $.ajax({
                url: "getAuthById",
                type: 'post',
                data: {'id': row.authId},
                success: function(data){
                    $("#windowId").combobox('setValue',data.windowId);
                    $("#authName").val(data.authName);
                }
            });
            $('#wu-dialog-3').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var win = {
                            "id": row.authId,
                            'windowId': $("#windowId").combobox('getValue'),
                            'authName': $("#authName").val()
                        }
                        $.ajax({
                            url: "updateAuth",
                            type: 'post',
                            data: win,
                            success: function(data){
                                if(data == "1"){
                                    $.messager.alert('提示','修改成功');
                                    $('#dg').datagrid('reload');
                                    $('#wu-dialog-3').dialog('close');
                                }
                            }
                        });
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#wu-dialog-3').dialog('close');
                    }
                }]
            });
        }

        function remove(){
            var row = $('#dg').datagrid('getSelected');
            $.messager.confirm('提示','是否真要删除：'+row.authName+'?',function(r){
                if(r){
                    $.ajax({
                        url: "removeAuth",
                        type: 'post',
                        data: {'id':row.authId},
                        success: function(data){
                            if(data == "1"){
                                $.messager.alert('提示','删除成功');
                                $('#dg').datagrid('reload');
                            }
                        }
                    });
                }
            })
        }
        function removeWindow(){
            var row = $('#dg').datagrid('getSelected');
            $.messager.confirm('提示','是否真要删除：'+row.name+'?',function(r){
                if(r){
                    $.ajax({
                        url: "removeWindow",
                        type: 'post',
                        data: {'id':row.id},
                        success: function(data){
                            if(data == "1"){
                                $.messager.alert('提示','删除成功');
                                $('#dg').datagrid('reload');
                            }
                        }
                    });
                }
            })
        }
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-search" style="padding-left: 8px;padding-top: 8px;">
            <label style="font-size:12px">窗体名称：</label><input class="wu-text" id="searchName" style="width:100px">
            <a href="#" id="btnSearch" class="easyui-linkbutton" iconCls="icon-search">开始检索</a>
        </div>
        <div class="wu-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addWindow()" plain="true">添加窗体</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addPrivile()" plain="true">添加窗体权限</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="editWindow()" plain="true">修改窗体</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="editPrivile()" plain="true">修改窗体权限</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="removeWindow()" plain="true">删除窗体</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除权限</a>
        </div>
    </div>
    <!-- End of toolbar -->
    <table id="dg" class="easyui-datagrid"></table>
</div>

<div id="wu-dialog-2" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
    <table>
        <tr>
            <td align="right">窗体名称：</td>
            <td>
                <input id="name" type="text" class="wu-text" />
            </td>
        </tr>
        <tr>
            <td align="right">窗体地址：</td>
            <td>
                <input id="url" type="text" class="wu-text" />
            </td>
        </tr>
    </table>
</div>
<div id="wu-dialog-3" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
    <table>
        <tr>
            <td align="right">所属窗体：</td>
            <td>
                <select id="windowId" class="easyui-combobox" panelHeight="auto" style="width:180px">

                </select>
            </td>
        </tr>
        <tr>
            <td align="right">权限名称：</td>
            <td>
                <input id="authName" type="text" class="wu-text" />
            </td>
        </tr>
    </table>
</div>
</body>
</html>