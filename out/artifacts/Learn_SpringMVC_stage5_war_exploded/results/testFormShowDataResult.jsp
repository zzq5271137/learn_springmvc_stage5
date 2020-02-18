<%--
  Created by IntelliJ IDEA.
  User: zzq52
  Date: 2020/2/18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>

<html>
<head>
    <title>SpringMVC自带的form标签</title>
</head>
<body>
<h1>SpringMVC自带的form标签, 结果页</h1>

<h1>查出数据, 使用SpringMVC的form标签展示数据, 供用户修改</h1>

<%-- modelAttribute: 从控制器方法里传过来的参数的key值 --%>
<fm:form modelAttribute="user" action="${pageContext.request.contextPath}/doUpdate">
<%-- 如果想要不写modelAttribute="user", 需要在控制器方法内传参的时候传key为command --%>
<%-- <fm:form action="${pageContext.request.contextPath}/doUpdate"> --%>
    姓名: <fm:input path="name"/><fm:errors path="name" cssStyle="color: red"/> <br>
    年龄: <fm:input path="age"/><fm:errors path="age" cssStyle="color: red"/> <br>
    性别:
    <fm:radiobutton path="gender" value="0" label="男"/>
    <fm:radiobutton path="gender" value="1" label="女"/>
    <br>
    <%-- path: 已选择的, items: 所有的 --%>
    爱好: <fm:checkboxes path="hobby" items="${allHobbies}"/><br>
    宠物: <fm:select path="pet.petId" items="${allPets}" itemValue="petId" itemLabel="petName"/><br>
    <%-- form表单里没写action, 是默认提交到原来的路径的 --%>
    <input type="submit" value="提交修改">
</fm:form>

</body>
</html>
