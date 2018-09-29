<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/9/11
  Time: 16:43
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

    <title>查询商品列表</title>
    <script>
        function selectItems(){
            document.getElementById("itemsForm").action = "${pageContext.request.contextPath}/items/queryItems.action";
            document.getElementById("itemsForm").submit();
        }
        function deleteItems(){
            document.getElementById("itemsForm").action = "${pageContext.request.contextPath}/items/deleteItems.action";
            document.getElementById("itemsForm").submit();
        }
    </script>
</head>

<body>
    <form id="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
        查询条件：
        <table width="100%" border="1">
            <tr>
                <td>商品名称：<input name="itemsCustom.name"/></td>
                <td><input type="button" value="查询" onclick="selectItems()"/>
                <input type="button" value="批量删除" onclick="deleteItems()"/></td>
            </tr>
        </table>
        商品列表：
        <table width="100%" border="1">
            <tr>
                <td>选择</td>
                <td>商品名称</td>
                <td>商品价格</td>
                <td>生产日期</td>
                <td>商品描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${item.detail}</td>
                    <td><a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">update</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
