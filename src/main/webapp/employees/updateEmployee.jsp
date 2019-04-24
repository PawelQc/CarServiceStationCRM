<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Update employee form </h2>
<h4>${notCompleteDataError}</h4>
<form action="/update-employee?id=${employee.id}" method="post">
    <label>
        Indicate first name: <input type="text" name="firstName" placeholder="first name" value="${employee.firstName}">
    </label> <br>
    <label>
        Indicate last name: <input type="text" name="lastName" placeholder="last name" value="${employee.lastName}">
    </label> <br>
    <label>
        Indicate address: <input type="text" name="address" placeholder="address" value="${employee.address}">
    </label> <br>
    <label>
        Indicate phone number: <input type="text" name="phoneNumber" placeholder="phone number" value="${employee.phoneNumber}">
    </label> <br>
    <label>
        Additional remarks: <input type="text" name="remarks" placeholder="remarks" value="${employee.remarks}">
    </label> <br>
    <label>
        Pay per hour (PLN): <input type="number" name="hourlyRate" placeholder="Pay per hour" value="${employee.hourlyRate}" min="1" step="1">
    </label> <br> <br>
    <input type="submit" value="Update">
</form>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
