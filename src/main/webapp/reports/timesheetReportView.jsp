<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Timesheet report</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Timesheet report</h2>
        <h4>Report period: ${startDate} - ${endDate}</h4>
        <h4>${noOrdersError}</h4>

        <table class="table table-hover">
            <thead>
            <th class="active">Employee</th>
            <th class="active">Amount of hours</th>
            </thead>
            <tbody>
            <c:forEach items="${timesheet}" var="data">
                <tr>
                    <td>${data.key.firstName} ${data.key.lastName}</td>
                    <td>${data.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
