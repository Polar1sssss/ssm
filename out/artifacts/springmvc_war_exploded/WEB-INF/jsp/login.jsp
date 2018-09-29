<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/9/25
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">

    <title>系统登录</title>

</head>

<body>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名：<input type="text" name="username" /></br>
        密码：<input type="password" name="password" /></br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
