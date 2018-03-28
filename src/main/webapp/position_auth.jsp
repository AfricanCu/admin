<%--
  Created by IntelliJ IDEA.
  User: ZMJ
  Date: 2018/3/28
  Time: 17:39
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
    <title>岗位权限设置</title>
    <script>
        $(function() {
            $('#position_type').combobox({
                onChange : function(n, o) {
                    var position_type = $("#position_type").val();
                    $.ajax({
                        url: "position_auth/findPositions",
                        type: 'post',
                        data: {'position_type':position_type},
                        success: function(positions){
                            $("#position").combobox({
                                data: positions,
                                textField: "positionName",
                                valueField: "id"
                            });
                        }
                    });
                }
            });

            var currentData = [];
            //加载窗体树
            $("#window_auth_tree").tree({
                url: 'position_auth/findWindowAuth',
                checkbox: true,
                loadFilter: function(data){
                    currentData = data;
                    return data;
                }
            });

            /**新增权限**/
            $('#btn_ok').bind('click', function() {
                var data = $('#window_auth_tree').tree('getChecked');
                var positionId = $('#position').combobox('getValue');
                var list = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i].children === undefined) {
                        list.push({
                            id: data[i].id,
                            text: data[i].text
                        });
                    }
                }
                $.ajax({
                    url: "position_auth/insertPositionAuth",
                    type: 'post',
                    data: {'data': JSON.stringify(list), 'positionId':positionId},
                    success: function(r){
                        if(r){
                            $.messager.alert('警告','新增成功');
                        }else{
                            $.messager.alert('警告','请选择岗位');
                        }
                    }
                });
            });

            /**修改权限**/
            $('#btn_cancel').bind('click', function () {
                var data = $('#window_auth_tree').tree('getChecked');
                var positionId = $('#position').combobox('getValue');
                var list = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i].children === undefined) {
                        list.push({
                            id: data[i].id,
                            text: data[i].text
                        });
                    }
                }
                $.ajax({
                    url: "position_auth/updatePositionAuth",
                    type: 'post',
                    data: {'data': JSON.stringify(list), 'positionId':positionId},
                    success: function(r){
                        if(r){
                            $.messager.alert('警告','修改成功');
                        }else{
                            $.messager.alert('警告','请选择岗位');
                        }
                    }
                });
            });

        });



    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div id="wu-toolbar-2">
        <div class="wu-toolbar-search" style="padding-left: 8px; padding-top: 8px; margin-bottom:10px">
            <label style="font-size: 12px">岗位归属：</label>
            <select class="easyui-combobox" panelHeight="auto" id="position_type" style="width: 100px">
                <option value="">所有</option>
                <option value="01">商户</option>
                <option value="02">供应商</option>
            </select>
            <label style="font-size: 12px">岗位：</label>
            <select class="easyui-combobox" panelHeight="auto" id="position" style="width: 100px"></select>
        </div>
        <div class="easyui-panel" title="窗体权限列表" style="width:450px;height:450px;padding:10px;margin-bottom:10px">
            <ul id="window_auth_tree"></ul>
        </div>
        <div style="padding-left:300px">
            <a id="btn_cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">修改</a>
            <a id="btn_ok" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">新增</a>
        </div>
    </div>
</div>
</body>
</html>
