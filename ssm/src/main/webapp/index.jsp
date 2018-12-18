<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>Hello World!</h2>

<a href="<%=basePath %>goods/list">商品列表</a><br/>
<a href="<%=basePath %>goods/toadd">添加商品</a>
</body>
</html>
