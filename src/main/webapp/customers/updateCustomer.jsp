<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Update customer form </h2>
<h4>${notCompleteDataError}</h4>
<form action="/update-customer?id=${customer.id}" method="post">
    <label>
        Indicate first name: <input type="text" name="firstName" placeholder="first name" value="${customer.firstName}">
    </label> <br>
    <label>
        Indicate last name: <input type="text" name="lastName" placeholder="last name" value="${customer.lastName}">
    </label> <br>
    <label>
        Indicate birth date: <input type="date" name="birthDate" placeholder="birth date" value="${customer.birthDate}">
    </label> <br><br>
    <input type="submit" value="Update">
</form>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
