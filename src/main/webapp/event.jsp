<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <title>事件</title>
    <script>
        $(function(){
            $("#workflowid").combobox({
                url:'findWorkFlow',
                valueField:'id',
                textField:'workFlowName'
            });

            $("#position").combobox({
                url:'findPosition',
                valueField:'id',
                textField:'positionName'
            });

            $('#dg').datagrid({
                url:'findAllEvent',
                fitColumns:true,
                pagination:true,
                pagePosition:'top',
                pageSize:5,
                pageNumber:1,
                pageList:[10,20,30],
                singleSelect:true,
                columns:[[
                    {field:'id',title:'事件ID',width:100,align:'center'},
                    {field:'workFlowName',title:'所属流程',width:100,align:'center'},
                    {field:'eventName',title:'事件名称',width:100,align:'center'},
                    {field:'parentEventid',title:'上级事件id',width:100,align:'center'},
                    {field:'finishPeriod',title:'预计完成时长',width:100,align:'center'},
                    {field:'eventLevel',title:'重要性等级',width:100,align:'center'},
                    {field:'positionName',title:'岗位',width:100,align:'center'},
                    {field:'sorted',title:'事件次序号',width:100,align:'center'}
                ]]
            });

            $("#btnSearch").click(function () {
                var name = $("#searchName").val();
                $.ajax({
                    url: "findAllEvent",
                    type: 'post',
                    data: {'name':name},
                    success: function(data){
                        $('#dg').datagrid('loadData',data);
                    }
                });
            });
        })

        function openAdd(){
            clearFrom();
            $('#wu-dialog-2').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var param = {
                            "workflowid":$('#workflowid').combobox('getValue'),
                            "name":$("#name").val(),
                            "position":$('#position').combobox('getValue'),
                            "parentid":$("#parentid").val(),
                            "period":$("#period").val(),
                            "eventlevel":$("#eventlevel").val(),
                            "sorted":$("#sorted").val()
                        };
                        $.ajax({
                            url: "addEvent",
                            type: 'post',
                            data: param,
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

        function openEdit(){
            var row = $('#dg').datagrid('getSelected');
            $.ajax({
                url: "getEventById",
                type: 'post',
                data: {'id': row.id},
                success: function(data){
                    $('#workflowid').combobox('setValue', data.workFlowId);
                    $("#name").val(data.eventName);
                    $('#position').combobox('setValue', data.positionId);
                    $("#parentid").val(data.parentEventid);
                    $("#period").val(data.finishPeriod);
                    $("#eventlevel").val(data.eventLevel);
                    $("#sorted").val(data.sorted);
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
                        var param = {
                            "id": row.id,
                            "workflowid":$('#workflowid').combobox('getValue'),
                            "name":$("#name").val(),
                            "position":$('#position').combobox('getValue'),
                            "parentid":$("#parentid").val(),
                            "period":$("#period").val(),
                            "eventlevel":$("#eventlevel").val(),
                            "sorted":$("#sorted").val()
                        };
                        $.ajax({
                            url: "updateEvent",
                            type: 'post',
                            data: param,
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
            $('#workflowid').combobox('setValue','');
            $("#name").val('');
            $('#position').combobox('setValue','');
            $("#parentid").val('');
            $("#period").val('');
            $("#eventlevel").val('');
            $("#sorted").val('');
        }

        function remove() {
            var row = $('#dg').datagrid('getSelected');
            $.messager.confirm('提示','是否真要删除：'+row.eventName+'?',function(r){
                if(r){
                    $.ajax({
                        url: "removeEvent",
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
            <label style="font-size:12px">事件名称：</label><input class="wu-text" id="searchName" style="width:100px">
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
        <tr>
            <td align="right">所属流程：</td>
            <td>
                <select id="workflowid" class="easyui-combobox" panelHeight="auto" style="width:180px">

                </select>
            </td>
        </tr>
        <tr>
            <td width="100" align="right">事件名称：</td>
            <td><input id="name" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="100" align="right">指派岗位：</td>
            <td>
                <select id="position" class="easyui-combobox" panelHeight="auto" style="width:180px">

                </select>
            </td>
        </tr>
        <tr>
            <td width="100" align="right">上级事件id：</td>
            <td><input id="parentid" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="100" align="right">预计完成时长：</td>
            <td><input id="period" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="100" align="right">事件级别：</td>
            <td><input id="eventlevel" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="100" align="right">序列号：</td>
            <td><input id="sorted" type="text" class="wu-text" /></td>
        </tr>
    </table>
</div>
</body>
</html>
