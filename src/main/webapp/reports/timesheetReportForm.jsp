<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Report form</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Report form - please specify report period</h2>
        <h4>${notCompleteDataError}</h4>

        <form action="/timesheet-report" method="post">
            <label>
                Indicate start date: <input type="date" name="startDate">
            </label> <br>
            <label>
                Indicate end date: <input type="date" name="endDate">
            </label>
            <br><br>
            <input type="submit" value="Generate">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
