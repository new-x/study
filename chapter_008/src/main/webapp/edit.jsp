<%@ page import="ru.job4j.servlets.data.User" %>
<%@ page import="ru.job4j.servlets.logic.ValidateService" %><%--
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
<%User user = null;%>
<%if (request.getParameter("id") != null) {%>
<%user = ValidateService.getInstance().getUser(Integer.parseInt(request.getParameter("id")));%>
<%}%>
<form action="<%=request.getContextPath()%>/users?action=update&id=<%=user.getId()%>" method="POST">
    New Name : <input type="text" name="name" value="<%=user.getName()%>"/><br>
    New Login : <input type="text" name="login" value="<%=user.getLogin()%>"/><br>
    New Email : <input type="text" name="email" value="<%=user.getEmail()%>"/><br>
    <input type="submit" value="Edit User"/>
</form>
</body>
</html>
