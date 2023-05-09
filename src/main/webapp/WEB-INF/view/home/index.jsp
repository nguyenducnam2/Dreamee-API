<%--
  Created by IntelliJ IDEA.
  User: namng
  Date: 5/10/2023
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${mess !=null}">
    <p style="color: green">${mess}</p>
</c:if>
<c:if test="${error !=null}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="sendMail" method="post">
    <div>
        <label>Email:</label>
        <input type="email" name="email">
    </div>
    <div>
        <label>Subject:</label>
        <input type="text" name="subject">
    </div>
    <div>
        <label>Content:</label>
        <textarea name="text" id="" cols="30" rows="10"></textarea>
    </div>
    <div>
        <label>Send:</label>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
