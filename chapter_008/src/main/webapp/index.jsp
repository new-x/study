<%@ page import="ru.job4j.servlets.data.User" %>
<%@ page import="ru.job4j.servlets.logic.ValidateService" %>
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
<form action="<%=request.getContextPath()%>/add.jsp" method="GET">
    <input type="submit" value="Add user">
</form>
<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <td>Login</td>
        <td>Name</td>
        <td>Email</td>
        <td>Create Date</td>
    </tr>
    <% for (User user : ValidateService.getInstance().findAll()) { %>
    <tr>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getCreateDate().getTime()%>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/edit.jsp?id=<%=user.getId()%>" method="POST">
                <input type="submit" value="Edit">
            </form>

        </td>
        <td>
            <form action="<%=request.getContextPath()%>/users?action=delete&id=<%=user.getId()%>" method="POST">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%};%>
</table>

</body>
</html>
