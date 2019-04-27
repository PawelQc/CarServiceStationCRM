<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report form</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Report form - please specify report period</h2>

<h4>${notCompleteDataError}</h4>

<form action="/profit-report" method="post">
    <label>
        Indicate start date: <input type="date" name="startDate">
    </label> <br>
    <label>
        Indicate end date: <input type="date" name="endDate">
    </label>
    <br><br>
    <input type="submit" value="Generate">
</form>


<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
