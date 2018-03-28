<%--
  Created by IntelliJ IDEA.
  User: ZMJ
  Date: 2018/3/28
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script>
        $(function(){
            $('#dg').datagrid({
                url:'findUser',
                fitColumns:true,
                pagination:true,
                pagePosition:'top',
                pageSize:5,
                pageNumber:1,
                pageList:[10,20,30],
                singleSelect:true,
                columns:[[
                    {field:'id',title:'操作员ID',width:100,align:'center'},
                    {field:'operatorCode',title:'操作人员编码',width:100,align:'center'},
                    {field:'operatorName',title:'操作人员姓名',width:100,align:'center'},
                    {field:'operatorPhone',title:'操作人员手机号码',width:100,align:'center'},
                    {field:'pinyinCode',title:'拼音码',width:100,align:'center'},
                    {field:'userType',title:'用户类型',width:100,align:'center'},
                    {field:'loginNum',title:'登录次数',width:100,align:'center'},
                    {field:'realType',title:'是否激活',width:100,align:'center'}
                ]]
            });

            $("#btnSearch").click(function () {
                var name = $("#searchName").val();
                $.ajax({
                    url: "findUser",
                    type: 'post',
                    data: {'name':name},
                    success: function(data){
                        $('#dg').datagrid('loadData',data);
                    }
                });
            });
        });

        function openAdd(){
            clearFrom();
            $("#password").attr("disabled",false);
            $('#wu-dialog-2').dialog({
                closed: false,
                modal:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function (){
                        var param = {
                            "name":$("#name").val(),
                            "phone":$("#phone").val(),
                            "password":$("#password").val(),
                            "userType":$("#userType").combobox("getValue")
                        };
                        $.ajax({
                            url: "addUser",
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
                url: "getUserInfo",
                type: 'post',
                data: {'id': row.id},
                success: function(data){
                    $("#name").val(data.operatorName);
                    $("#phone").val(data.operatorPhone);
                    $("#password").val(data.operatorPwd);
                    $("#password").attr("disabled",true);
                    $("#userType").combobox("setValue", data.userType);
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
                            "id":row.id,
                            "name":$("#name").val(),
                            "phone":$("#phone").val(),
                            "password":$("#password").val(),
                            "userType":$("#userType").combobox("getValue")
                        };
                        $.ajax({
                            url: "updateUser",
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

        function remove() {
            var row = $('#dg').datagrid('getSelected');
            $.messager.confirm('提示','是否真要删除：'+row.operatorName+'?',function(r){
                if(r){
                    $.ajax({
                        url: "removeUser",
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

        function clearFrom(){
            $("#name").val('');
            $("#phone").val('');
            $("#password").val('');
        }
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-search" style="padding-left: 8px;padding-top: 8px;">
            <label style="font-size:12px">操作员姓名：</label><input class="wu-text" id="searchName" style="width:100px">
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
            <td width="120" align="right">操作人员姓名：</td>
            <td><input id="name" type="text" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="120" align="right">操作人员手机号码：</td>
            <td>
                <input id="phone" type="text" class="wu-text" />
            </td>
        </tr>
        <tr>
            <td width="120" align="right">操作人员操作密码：</td>
            <td><input id="password" type="password" class="wu-text" /></td>
        </tr>
        <tr>
            <td width="120" align="right">用户类型：</td>
            <td>
                <select id="userType" class="easyui-combobox" panelHeight="auto" style="width:180px">
                    <option value='00'>商户</option>
                    <option value='01'>供应商</option>
                </select>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
