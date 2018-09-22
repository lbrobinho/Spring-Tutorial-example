<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 9/20/18
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3>Spring Rest Demo</h3>

<hr>

<a href="${pageContext.request.contextPath}/test/hello">Hello</a>

<br><br>

<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
</body>
</html>
