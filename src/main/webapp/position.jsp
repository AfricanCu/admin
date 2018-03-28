<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>岗位设置</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url: 'findPositions',
                fitColumns: true,
                pagination: true,
                pagePosition: 'top',
                pageSize: 5,
                pageNumber: 1,
                pageList: [10, 20, 30],
                singleSelect: true,
                columns: [[{
                    field: 'type',
                    title: '类别',
                    width: 100,
                    align: 'center'
                }, {
                    field: 'id',
                    title: '岗位ID',
                    width: 100,
                    align: 'center'
                }, {
                    field: 'positionName',
                    title: '岗位名称',
                    width: 100,
                    align: 'center'
                }, {
                    field: 'positionCode',
                    title: '岗位编码',
                    width: 100,
                    align: 'center'
                }, {
                    field: 'positionType',
                    title: '岗位类别(普通:00, 负责人:01)',
                    width: 100,
                    align: 'center'
                },]]
            });
            $("#btnSearch").click(function () {
                var name = $("#name").val();
                var type = $("#type").val();
                $.ajax({
                    url: "findPositions",
                    type: 'post',
                    data: {
                        'name': name,
                        'type': type
                    },
                    success: function (data) {
                        $('#dg').datagrid('loadData', data);
                    }
                });
            });
        });

        /**添加功能**/
        function openAdd() {
            $("#typeRow").show();
            $('#wu-dialog-2').dialog({
                closed: false,
                modal: true,
                title: "添加岗位",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        var position_type = $("#add_type").val();
                        var position_code = $("#add_code").val();
                        var position_name = $("#add_name").val();
                        var position_level = $("#position_level").val();
                        $.ajax({
                            url: "addPosition",
                            type: 'post',
                            data: {
                                'position_type': position_type,
                                'position_code': position_code,
                                'position_name': position_name,
                                'position_level': position_level
                            },
                            success: function (data) {
                                if (data == "1") {
                                    $.messager.alert('提示', '添加成功');
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

        /**删除功能**/
        function remove() {
            var row = $('#dg').datagrid('getSelected');
            $.messager.confirm('提示', '真的删除？  ' + row.positionName,
                function (r) {
                    if (r) {
                        $.ajax({
                            url: "deletePosition",
                            type: 'post',
                            data: {
                                'type': row.type,
                                'id': row.id
                            },
                            success: function (data) {
                                if (data == "1") {
                                    $.messager.alert('提示', '删除成功');
                                    $('#dg').datagrid('reload');
                                }
                            }
                        });
                    }
                })
        }

        /**修改功能**/
        function openEdit() {
            var row = $('#dg').datagrid('getSelected');
            if (row != null) {
                $("#add_code").val(row.positionCode);
                $("#add_name").val(row.positionName);
                $("#position_level").val(row.positionType);
                $("#typeRow").hide();
                $('#wu-dialog-2').dialog({
                    closed: false,
                    modal: true,
                    title: "修改",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function () {
                            var code = $("#add_code").val();
                            var name = $("#add_name").val();
                            var level = $("#position_level").val();
                            $.ajax({
                                url: "editPosition",
                                type: 'post',
                                data: {
                                    'type': row.type,
                                    'id': row.id,
                                    'name': name,
                                    'code': code,
                                    'level': level
                                },
                                success: function (data) {
                                    if (data == "1") {
                                        $.messager.alert('提示', '修改成功');
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
        }
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-search"
             style="padding-left: 8px; padding-top: 8px;">
            <label style="font-size: 12px">岗位名称：</label><input class="wu-text"
                                                               id="name" style="width: 100px"> <label
                style="font-size: 12px">岗位类型：</label> <select
                class="easyui-combobox" panelHeight="auto" id="type"
                style="width: 100px">
            <option value="">所有</option>
            <option value="01">商户</option>
            <option value="02">供应商</option>
        </select> <a href="#" id="btnSearch" class="easyui-linkbutton"
                     iconCls="icon-search">开始检索</a>
        </div>
        <div class="wu-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add"
               onclick="openAdd()" plain="true">添加</a> <a href="#"
                                                          class="easyui-linkbutton" iconCls="icon-edit"
                                                          onclick="openEdit()"
                                                          plain="true">修改</a> <a href="#" class="easyui-linkbutton"
                                                                                 iconCls="icon-remove"
                                                                                 onclick="remove()" plain="true">删除</a>
        </div>
    </div>
    <!-- End of toolbar -->
    <table id="dg" class="easyui-datagrid"></table>
</div>

<div id="wu-dialog-2" class="easyui-dialog"
     data-options="closed:true,iconCls:'icon-save'"
     style="width: 400px; padding: 10px;">
    <table>
        <tr id="typeRow">
            <td align="right">岗位类型：</td>
            <td><select id="add_type" class="easyui-combobox"
                        panelHeight="auto" style="width: 100px">
                <option value="1">商户</option>
                <option value="2">供应商</option>
            </select></td>
        </tr>
        <tr>
            <td width="60" align="right">岗位编码：</td>
            <td><input id="add_code" type="text" class="wu-text"/></td>
        </tr>
        <tr>
            <td width="60" align="right">岗位名称：</td>
            <td><input id="add_name" type="text" class="wu-text"/></td>
        </tr>
        <tr>
            <td align="right">岗位级别：</td>
            <td><select id="position_level" class="easyui-combobox"
                        panelHeight="auto" style="width: 100px">
                <option value="00">普通</option>
                <option value="01">负责人</option>
            </select></td>
        </tr>
    </table>
</div>
</body>
</html>
