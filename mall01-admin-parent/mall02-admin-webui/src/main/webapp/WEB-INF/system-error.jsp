<%--
  Created by IntelliJ IDEA.
  User: mzx
  Date: 2021/9/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="jquery/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function (){
                // 相当于浏览器的后退按钮
                window.history.back();
            });
        });
    </script>
    <style>

    </style>
    <title>system-error</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">拼客-购物平台后台管理系统</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <h2 class="form-signin-heading" style="text-align:center">
        <i class="glyphicon glyphicon-log-in"></i> 系统消息
    </h2>
    <h3 style="text-align:center">${requestScope.exception.message}</h3>
    <button style="width: 150px;margin: 50px auto 0 auto;" type="submit" class="btn btn-lg btn-success btn-block">返回上一步</button>
</div>

</body>
</html>