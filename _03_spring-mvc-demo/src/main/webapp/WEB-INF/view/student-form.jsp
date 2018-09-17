<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 9/12/18
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        FirstName: <form:input path="firstName" />

        <br><br>

        LastName(*): <form:input path="lastName" />

        <br><br>

        <form:select path="country">
            <form:options items="${theCountryOptions}" />

        </form:select>

        <br><br>
        Favorite language:

        Java<form:radiobutton path="favoriteLanguage" value="Java" />
        PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
        Python<form:radiobutton path="favoriteLanguage" value="Python" />
        C<form:radiobutton path="favoriteLanguage" value="C" />

        <br><br>
        Operating Systems:

        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
        Windows <form:checkbox path="operatingSystems" value="Windows"/>


        <br><br>



        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
