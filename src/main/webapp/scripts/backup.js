$(function() {
    $('#dg').datagrid({
        url:'findAllWorkFlow',
        fitColumns:true,
        pagination:true,
        pagePosition:'top',
        pageSize:5,
        pageNumber:1,
        pageList:[10,20,30],
        singleSelect:true,
        columns:[[
            {field:'id',title:'流程ID',width:100,align:'center'},
            {field:'systemType',title:'系统类型',width:100,align:'center'},
            {field:'workFlowName',title:'流程名称',width:100,align:'center'},
            {field:'workFlowLevel',title:'重要性等级',width:100,align:'center'},
            {field:'sorted',title:'流程次序号',width:100,align:'center'}
        ]]
    });

    $("#btnSearch").click(function () {
        var name = $("#name").val();
        var type = $("#type").val();
        $.ajax({
            url: "findAllWorkFlow",
            type: 'post',
            data: {'name':name, 'type':type},
            success: function(data){
                $('#dg').datagrid('loadData',data);
            }
        });
    });
});

function openAdd(){
    $("#typeRow").show();
    $('#wu-dialog-2').dialog({
        closed: false,
        modal:true,
        title: "添加信息",
        buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: function (){
                var type = $("#add_type").val();
                var name = $("#add_name").val();
                var level = $("#add_level").val();
                var sort = $("#add_sort").val();
                $.ajax({
                    url: "addWorkFlow",
                    type: 'post',
                    data: {'type':type, 'name':name, 'level':level, 'sort':sort},
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

function remove() {
    var row = $('#dg').datagrid('getSelected');
    $.messager.confirm('提示','是否真要删除：'+row.workFlowName+'?',function(r){
        if(r){
            $.ajax({
                url: "removeWorkFlow",
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

function openEdit(){
    var row = $('#dg').datagrid('getSelected');
    if(row != null){
        $("#add_name").val(row.workFlowName);
        $("#add_level").val(row.workFlowLevel);
        $("#add_sort").val(row.sorted);
        $("#typeRow").hide();
        $('#wu-dialog-2').dialog({
            closed: false,
            modal:true,
            title: "修改",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: function (){
                    var name = $("#add_name").val();
                    var level = $("#add_level").val();
                    var sort = $("#add_sort").val();
                    $.ajax({
                        url: "editWorkFlow",
                        type: 'post',
                        data: {'id':row.id, 'name':name, 'level':level, 'sort':sort},
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
}