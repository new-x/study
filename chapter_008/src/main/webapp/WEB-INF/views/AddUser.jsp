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
<c:if test="${sessionScope.user.role.id == 1}">
    <div class="container">
        <form action="${pageContext.servletContext.contextPath}/" method="POST" onsubmit="return checkAddUser()">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label><b>Name</b></label>
                <input type="text" class="form-control" placeholder="Enter user Name" name="name" id="name"><br>
            </div>
            <div class="form-group">
                <label><b>Login</b></label>
                <input type="text" class="form-control" placeholder="Enter user Login" name="login" id="login"><br>
            </div>
            <div class="form-group">
                <label><b>City</b></label>
                <input type="text" class="form-control" placeholder="Enter user City" name="city" id="city"><br>
            </div>
            <div class="form-group">
                <label><b>Country</b></label>
                <input type="text" class="form-control" placeholder="Enter user Country" name="country" id="country"><br>
            </div>
            <div class="form-group">
                <label><b>Password</b></label>
                <input type="password" class="form-control" placeholder="Enter user Password" name="password" id="password"><br>
            </div>
            <div class="form-group">
                <label><b>Email</b></label>
                <input type="email" class="form-control" placeholder="Enter user Email" name="email" id="email"><br>
            </div>
            <button type="submit" class="btn btn-default">Create User</button>
        </form>
    </div>
</c:if>
</body>
</html>
