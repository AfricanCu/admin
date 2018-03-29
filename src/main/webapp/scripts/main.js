var login = function () {
    var $username = $("#username").val();
    var $password = $("#password").val();
    $.ajax({
        type:"post",
        url:"login",
        data:{'username':$username, 'password':$password},
        success:function (r) {
            if (r){
                $(location).attr('href', 'index.jsp');
            }else{
                $("#error-msg").text("用户名或密码错误");
            }
        }
    })
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

