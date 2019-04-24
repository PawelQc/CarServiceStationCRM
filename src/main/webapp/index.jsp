<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<%@ include file="fragments/header.jspf"%>

<h2>List of pending car repair orders</h2>

<h4>${noOrdersError}</h4>
<table border="1">
    <thead>
    <th>Order id</th>
    <th>Customer name</th>
    <th>Start date</th>
    <th>Description</th>
    <th>Final cost (PLN)</th>
    <th>Assigned employee</th>
    <th>Vehicle</th>
    <th>Repair status</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
            <td>${order.actualRepairStartDate}</td>
            <td>${order.problemDescription}</td>
            <td>${order.costFinalToPay}</td>
            <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
            <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
            <td>${order.repairStatus.name}</td>
            <td>
                Details
                <%--<a href="/SolutionUpdate?id=${solution.id}">Edytuj</a>
                <a href="/SolutionDelete?id=${solution.id}">Usuń</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@ include file="fragments/footer.jspf"%>
</body>
</html>
