<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>商品列表</title>
</head>
<script>
    function searchgoods() {
        var sname = document.getElementById("sname").value;
        if(sname==null||sname==""){
            alert("请输入查询条件！");
        }else {
            location.href= "<%=basePath %>goods/searchgoodslist?sname="+sname;
        }
    }
</script>
<body>
<a href="<%=basePath %>">《返回首页</a> <a href="<%=basePath %>goods/toadd">添加</a>  <a href="<%=basePath %>goods/list">查所有</a>
<h1>商品列表</h1><br/>
总共${count}条数据,每页显示${size}条
<input id="sname" name="sname" type="text" value="${sname}"/><button onclick="searchgoods()">查询</button>
<table border="1">
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>图片</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach var="g" items="${goods}">
       <tr>
           <td>${g.id}</td>
           <td>${g.name}</td>
           <td><img src="/images/${g.picture}" height="40px"></td>
           <td>${g.price}</td>
           <td>
               <a href="<%=basePath %>goods/toedit/${g.id}">编辑</a>
               <a href="<%=basePath %>goods/delete/${g.id}/${pageno}">删除</a>
           </td>
       </tr>
    </c:forEach>
</table>
第${pageno}页
<c:if test="${pageno!=1}">
    <a href="<%=basePath %>goods/list?pageno=${pageno-1}">上一页</a>
</c:if>


<c:if test="${pageno<pagecount}">
    <a href="<%=basePath %>goods/list?pageno=${pageno+1}">下一页</a>
</c:if>

   总共${pagecount}页
</body>
</html>
