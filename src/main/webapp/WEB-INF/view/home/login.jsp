<%--
  Created by IntelliJ IDEA.
  User: namng
  Date: 5/8/2023
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<c:if test="${param.get('error')!=null}">
    <p style="color: red;">Login Failed</p>
</c:if>
<c:if test="${param.get('logout')!=null}">
    <p style="color: green;">Logout Successfully</p>
</c:if>
<form action="" method="post">
    <div>
        <label>Username:</label>
        <input type="text" name="username" value="${user.username}">
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password" value="${user.password}">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>
