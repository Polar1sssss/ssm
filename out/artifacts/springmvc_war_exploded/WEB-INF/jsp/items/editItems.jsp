<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hujtb
  Date: 2018/9/17
  Time: 12:47
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

    <title>商品修改页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
    <!--action：表单提交到的页面-->
    <!--enctype="multipart/form-data"设置这个属性会导致提交时无法绑定参数-->
    <form id="itemForm" action="${pageContext.request.contextPath}/items/editItemsSubmit.action" method="post">
        <input type="hidden" name="id" value="${itemsCustom.id}"/>
        修改商品信息
        <table width="100%" border="1px">
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="name" value="${itemsCustom.name}" /></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="price" value="${itemsCustom.price}" /></td>
            </tr>
            <tr>
                <td>商品生产日期</td>
                <td><input type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}"
                pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>" /></td>
            </tr>
            <%--<tr>
                <td>商品图片</td>
                <td>
                    <c:if test="${itemsCustom.pic != null}">
                        <img src="/pic/${itemsCustom.pic} " width="100" height="100" />
                        </br>
                    </c:if>
                    <input type="file" name="pictureFile" />
                </td>
            </tr>--%>
            <tr>
                <td>商品简介</td>
                <td>
                    <textarea rows="3" cols="30" name="detail">
                        ${itemsCustom.detail}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
