<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: veveri
  Date: 13.10.15
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>
    <h1>Disastrous JPA Example</h1>

    <table>
    <jstl:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.cinfo.id}</td>
            <td>${user.cinfo.title}</td>
        </tr>
    </jstl:forEach>
</table>
</body>
</html>
