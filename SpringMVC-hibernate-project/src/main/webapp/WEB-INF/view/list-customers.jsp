<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 9/4/18
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <%--put new button: Add Customer--%>

            <input type="button" value="Add Customer"
                    onclick="window.location.href='showFormForAdd'; return false;"
                    class="add-button"/>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print our customers -->
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <tr>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <!-- display the update link -->
                            <a href="${updateLink}">Update</a>

                            <!-- display the delete link -->
                            <a href="${deleteLink}"
                               onclick="return confirm('Are you sure you want to delete ${student.firstName}');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
