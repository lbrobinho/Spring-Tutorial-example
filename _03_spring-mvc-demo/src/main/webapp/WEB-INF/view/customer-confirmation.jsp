<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 8/14/18
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Confirmation Form</title>
</head>
<body>
    The Customer name is confirmed ${customer.firstName} ${customer.lastName}

    <br><br>

    Free passes: ${customer.freePasses}

    <br><br>

    Postal Code: ${customer.postalCode}

    <br><br>

    Course Code: ${customer.courseCode}
</body>
</html>
