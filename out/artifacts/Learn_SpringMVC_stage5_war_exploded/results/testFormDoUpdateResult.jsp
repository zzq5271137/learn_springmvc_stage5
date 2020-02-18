<%--
  Created by IntelliJ IDEA.
  User: zzq52
  Date: 2020/2/18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SpringMVC自带的form标签</title>
</head>
<body>
<h1>SpringMVC自带的form标签, 结果页</h1>

<h1>执行更新操作后, 将数据展示到页面</h1>
<h1>姓名: ${user.name}</h1>
<h1>年龄: ${user.age}</h1>
<h1>
    性别:
    <c:if test="${user.gender == 0}">
        男
    </c:if>
    <c:if test="${user.gender == 1}">
        女
    </c:if>
</h1>
<h1>
    爱好:<br>
    <c:forEach items="${user.hobby}" var="h">
        ${h}<br>
    </c:forEach>
</h1>
<h1>宠物: ${user.pet}</h1>

</body>
</html>
