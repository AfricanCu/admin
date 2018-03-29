<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="scripts/main.js" type="text/javascript"></script>
</head>
<body id="login-body">
<div class="container">
    <div class="row">
        <div id="login-logo" class="col-md-4 col-md-offset-4">范格后台管理系统</div>
        <div id="login-box" class="col-md-4 col-md-offset-4" style="text-align: center">
            <p class="login-box-msg">管理员登录</p>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="username" placeholder="账号">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <hr/>
            <button type="button" class="btn btn-primary btn-block" style="margin-bottom: 10px" onclick="login()">登录</button>
            <span id="error-msg" style="color: red"></span>
        </div>
    </div>
</div>
</body>
</html>
