<%--
  Created by IntelliJ IDEA.
  User: zzq52
  Date: 2020/2/18
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mvc:view-controller配置请求跳转和mvc-annotation-driven的作用</title>
</head>
<body>
<h1>mvc:view-controller配置请求跳转和mvc-annotation-driven的作用</h1>

<h1>mvc:view-controller配置请求跳转</h1>
<a href="${pageContext.request.contextPath}/testView">
    url: /testView
</a>

<hr>

<h1>mvc-annotation-driven的作用</h1>
<a href="${pageContext.request.contextPath}/testDriven">
    url: /testDriven
</a>

</body>
</html>
