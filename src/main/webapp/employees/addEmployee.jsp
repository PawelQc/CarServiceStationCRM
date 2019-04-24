<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add employee</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Add employee form </h2>
<h4>${notCompleteDataError}</h4>
<form action="/add-employee" method="post">
    <label>
        Indicate first name: <input type="text" name="firstName" placeholder="first name">
    </label> <br>
    <label>
        Indicate last name: <input type="text" name="lastName" placeholder="last name">
    </label> <br>
    <label>
        Indicate address: <input type="text" name="address" placeholder="address">
    </label> <br>
    <label>
        Indicate phone number: <input type="text" name="phoneNumber" placeholder="phone number">
    </label> <br>
    <label>
        Additional remarks: <input type="text" name="remarks" placeholder="remarks">
    </label> <br>
    <label>
        Pay per hour (PLN): <input type="number" name="hourlyRate" placeholder="Pay per hour" min="1" step="1">
    </label> <br> <br>
    <input type="submit" value="Create">
</form>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
