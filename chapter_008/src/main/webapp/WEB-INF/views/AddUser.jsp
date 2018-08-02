<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 31.07.2018
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/" method="POST">
    <input type="hidden" name="action" value="add">
    Name : <input type="text" name="name"><br>
    Login : <input type="text" name="login"><br>
    Email : <input type="text" name="email"><br>
    <input type="submit" value="Create User">
</form>
</body>
</html>
