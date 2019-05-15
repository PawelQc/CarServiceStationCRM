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
            <label>
                Indicate first name: <input type="text" name="firstName" placeholder="first name">
            </label> <br>
            <label>
                Indicate last name: <input type="text" name="lastName" placeholder="last name">
            </label> <br>
            <label>
                Indicate birth date: <input type="date" name="birthDate" placeholder="birth date">
            </label> <br><br>
            <input type="submit" value="Create">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
