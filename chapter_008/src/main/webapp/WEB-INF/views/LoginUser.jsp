<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 03.08.2018
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>User authorization</title>
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
<div class="container">
    <div class="form-group">
        <c:if test="${error != ''}">
            <p class="text-center"><strong><c:out value="${error}"/></strong></p>
        </c:if>
    </div>
</div>
<div class="container" id="parent">
        <form class="form-vertical" name="login-form" id="form_login" action="${pageContext.servletContext.contextPath}/signin"
              method="POST" onsubmit="return checkLogin()">
            <div class="form-group">
                <label class="sr-only"><b>Login</b></label>
                <input type="text" class="form-control" placeholder="Enter you login" name="login" id="login"><br>
            </div>
            <div class="form-group">
                <label class="sr-only"><b>Password</b></label>
                <input type="password" class="form-control" placeholder="Enter you password" name="password"
                       id="password"><br>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default">Log In</button>
            </div>
        </form>
</div>

</body>
</html>
