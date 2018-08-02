<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 30.07.2018
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Users</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/add" method="GET">
    <input type="submit" value="Add user">
</form>
<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <td>Login</td>
        <td>Name</td>
        <td>Email</td>
        <td>Create Date</td>
    </tr>
    <c:forEach items="${users}" var = "user">
    <tr>
        <td><c:out value="${user.login}"></c:out>
        </td>
        <td><c:out value="${user.name}"></c:out>
        </td>
        <td><c:out value="${user.email}"></c:out>
        </td>
        <td><c:out value="${user.createDate.getTime()}"></c:out>
        </td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/edit" method="GET">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="Edit">
            </form>

        </td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/" method="POST">
                <input type="hidden" name="action" value="delete"/>
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
