<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 31.07.2018
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/" method="POST">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${user.id}"/>
    New Name : <input type="text" name="name" value="${user.name}"/><br>
    New Login : <input type="text" name="login" value="${user.login}"/><br>
    New Password : <input type="password" name="password" value="${user.password}"/><br>
    New Email : <input type="text" name="email" value="${user.email}"/><br>
    <c:if test="${user.role.id == 1}">
    New Role: <select name="roles_id"><br>
    <c:forEach items="${sessionScope.allRoles}" var="role">
        <option value="${role.id}">${role.name}</option>
    </c:forEach>
    </c:if>
</select>
    <input type="submit" value="Edit User"/>
</form>
</body>
</html>
