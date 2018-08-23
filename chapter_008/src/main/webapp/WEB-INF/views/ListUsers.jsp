<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 30.07.2018
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Users</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        <%@ include file="/src/style.css" %>
    </style>
    <script type="application/javascript">
        <%@ include file="/src/script.js" %>
    </script>
</head>
<body>
<body>
<div class="container">
    <div class="form-group">
        <c:if test="${error != ''}">
            <p class="text-center"><strong><c:out value="${error}"/></strong></p>
        </c:if>
    </div>
</div>
<div class="container">
    <c:if test="${sessionScope.user.role.id == 1}">
        <div id="left-button">
                <a href="${pageContext.servletContext.contextPath}/add" class="btn btn-primary" role="button">Add User</a>
        </div>
    </c:if>
</div>
<div class="container">
    <div id="right-button">
        <form action="${pageContext.servletContext.contextPath}/" method="POST">
            <input type="hidden" name="action" value="exit"/>
            <button type="submit" class="btn btn-primary">Log Out</button>
        </form>
    </div>
</div>
<div class="container" id="parent-list">
    <table id="list-users" class="table table-hover" style="border: 1px solid black;" cellpadding="1" cellspacing="1"
           border="1">
        <thead>
        <tr>
            <th>Login</th>
            <th>Name</th>
            <th>Email</th>
            <th>City</th>
            <th>Country</th>
            <th>Create Date</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <th><c:out value="${user.login}"></c:out>
                </th>
                <th><c:out value="${user.name}"></c:out>
                </th>
                <th><c:out value="${user.email}"></c:out>
                </th>
                <th><c:out value="${user.city}"></c:out>
                </th>
                <th><c:out value="${user.country}"></c:out></th>
                <th><c:out value="${user.createDate.getTime()}"></c:out>
                </th>
                <th><c:out value="${user.role.name}"></c:out>
                </th>
                <c:if test="${sessionScope.user.role.id == 1 or sessionScope.user.id == user.id}">
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/edit" method="GET">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="btn btn-default">Edit</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${sessionScope.user.role.id == 1}">
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/" method="POST">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="btn btn-default">Delete</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
