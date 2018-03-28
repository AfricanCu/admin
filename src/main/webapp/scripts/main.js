var login = function () {
    $(location).attr('href', 'index.jsp');
}
var addPanel = function (title) {
    var t = title.split("|");
    var bol = $('#tt').tabs('exists', t[0]);
    if(bol){
        $('#tt').tabs('select', t[0]);
    }else{
        $('#tt').tabs('add', {
            title: t[0],
            content: '<iframe scrolling="no" frameborder="0"  src="'+t[1]+'" style="width:100%;height:100%;"></iframe>',
            closable: true
        });
    }
}

