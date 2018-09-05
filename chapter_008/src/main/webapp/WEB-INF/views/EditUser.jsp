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
        <%@ include file="/src/getcountry.js" %>
    </script>
</head>
<body>
<c:if test="${sessionScope.user.role.id == 1}">
<div class="container">
    <form action="<%=request.getContextPath()%>/" method="POST" onsubmit="return checkAddUser()">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label><b>New Name</b></label>
            <input type="text" class="form-control" name="name" id="name" value="${user.name}"><br>
        </div>
        <div class="form-group">
            <label><b>New Login</b></label>
            <input type="text" class="form-control" name="login" id="login" value="${user.login}"><br>
        </div>
        <div class="form-group">
            <label><b>New Password</b></label>
            <input type="password" class="form-control" name="password" id="password" value="${user.password}"><br>
        </div>
        <div class="form-group">
            <label><b>New Email</b></label>
            <input type="email" class="form-control" name="email" id="email" value="${user.email}"><br>
        </div>
        <div class="form-group">
            <label for="selectCountry">New Country:</label>
            <select class="form-control" id="selectCountry" name="country" onchange="getCityByCountry()">
            </select>
        </div>
        <div class="form-group">
            <label for="selectCity">New City:</label>
            <select class="form-control" id="selectCity" name="city">

            </select>
        </div>
        <div class="form-group">
            <c:if test="${user.role.id == 1}">
            <label><b>New Role</b></label>
            <select class="form-control" id="sel1" name="roles_id"><br>
                <c:forEach items="${sessionScope.allRoles}" var="role">
                    <option value="${role.id}">${role.name}</option>
                </c:forEach>
                </c:if>
            </select>
        </div>
        <button type="submit" class="btn btn-default">Edit User</button>
    </form>
</div>
</c:if>
</body>
</html>
