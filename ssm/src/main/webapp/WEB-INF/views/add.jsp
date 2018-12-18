<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>商品添加</title>
</head>
<body>
<a href="<%=basePath %>goods/list">《商品列表</a>
<h1>商品
    <c:if test="${goods.id==null}">
        添加
    </c:if>
    <c:if test="${goods.id!=null}">
        修改 ID：${goods.id}
    </c:if>
</h1>
<form action="<%=basePath %>goods/edit" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>商品名称</td>
            <td>
                <c:if test="${goods.id!=null}">
                    <input type="hidden" name="id" id="id" value="${goods.id}"/>
                </c:if>
                <input id="name" name="name" type="text" value="${goods.name}"/>
            </td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input id="price" name="price" type="text" value="${goods.price}"></td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td><input name="picture" type="file" /></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
