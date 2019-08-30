<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Add customer</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>
<div class="container">
    <h2>Add customer form </h2>
    <h4>${notCompleteDataError}</h4>
    <form action="/add-customer" method="post">
        <div class="form-group">
            <label for="firstNameId">First name:</label>
                <input type="text" name="firstName" placeholder="first name" class="form-control" id="firstNameId">
        </div>
        <div class="form-group">
            <label for="lastNameId">First name:</label>
                <input type="text" name="lastName" placeholder="last name" class="form-control" id="lastNameId">
        </div>
        <div class="form-group">
            <label for="birthDateId">First name:</label>
               <input type="date" name="birthDate" placeholder="birth date" class="form-control" id="birthDateId">
            </label> <br><br>
        </div>
        <input type="submit" value="Create">
    </form>
</div>
<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
