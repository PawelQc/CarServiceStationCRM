<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Timesheet report</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Timesheet report</h2>
<h3>Report period: ${startDate} - ${endDate}</h3>


<h4>${noEmplyeesError}</h4>

<table border="1">
    <thead>
    <th>Employee</th>
    <th>Amount of hours</th>
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

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
