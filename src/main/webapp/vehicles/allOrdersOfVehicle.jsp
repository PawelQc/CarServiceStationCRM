<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicle repair history</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Repair history of vehicle with id ${vehicleId}</h2>
<h4>${noOrdersMadeError}</h4>

<table border="1">
    <thead>
    <th>No</th>
    <th>Actual start</th>
    <th>Problem description</th>
    <th>Repair description</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${order.actualRepairStartDate}</td>
            <td>${order.problemDescription}</td>
            <td>${order.repairDescription}</td>
            <td>
                <a href="/detailed-order?orderId=${order.id}">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
