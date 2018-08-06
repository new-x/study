<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 03.08.2018
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User authorization</title>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color: red">
            <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signin" method="POST">
    <input type="hidden" name="action" value="add">
    Login : <input type="text" name="login"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit" value="Log In">
</form>
</body>
</html>
