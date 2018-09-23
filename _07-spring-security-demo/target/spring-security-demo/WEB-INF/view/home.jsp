<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 9/20/18
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Home Page</h2>

<hr>
    <p>Welcome to home page</p>

    <p>
        User: <security:authentication property="principal.username" />

        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>

    <hr>

    <%-- Add a log out button--%>
    <form:form action="${pageContext.request.contextPath}/logout"
                method="POST">

        <input type="submit" value="Logout" />
    </form:form>

</body>
</html>
