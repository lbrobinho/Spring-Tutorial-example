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

    <security:authorize access="hasRole('MANAGER')">
    <%--Add a link to point to /leaders ... this is for the managers--%>

    <P>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps)
    </P>

    </security:authorize>

    <hr>

    <security:authorize access="hasRole('ADMIN')">

    <%--Add a link to point to /systems... this is for the admin--%>

    <P>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (Only for Admin peeps)
    </P>

    </security:authorize>

    <hr>

    <%-- Add a log out button--%>
    <form:form action="${pageContext.request.contextPath}/logout"
                method="POST">

        <input type="submit" value="Logout" />
    </form:form>

</body>
</html>
