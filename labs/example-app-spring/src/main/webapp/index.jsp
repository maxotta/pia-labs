<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:if test="${not empty requestScope.err}">
    <p>
        Error: ${requestScope.err}
    </p>
</c:if>

<h1>Normal login</h1>
<form action="/login" method="post">
    <label for="username">Login:&nbsp;</label>
    <input type="text" id="username" name="username">
    <label for="pwd">Password:&nbsp;</label>
    <input type="password" id="pwd" name="password">
    <input type="submit" value="Login">
</form>

<h1>Spring login</h1>
<form action="/spring/login" method="post">
    <label for="username">Login:&nbsp;</label>
    <input type="text" id="username" name="username">
    <label for="pwd">Password:&nbsp;</label>
    <input type="password" id="pwd" name="password">
    <input type="submit" value="Login">
</form>

<p>
    <a href="/register">Register</a>
</p>

<p>
    <a href="/spring/register">Spring Register</a>
</p>

</body>
</html>
