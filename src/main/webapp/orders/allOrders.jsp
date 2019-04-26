<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All orders</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>List of all orders</h2>

<a href="/add-order">Add order</a>

<h4>${noOrdersError}</h4> <h4>${deleteMessage}</h4>


<table border="1">
    <thead>
    <th>No</th>
    <th>Acceptance</th>
    <th>Planned start</th>
    <th>Actual start</th>
    <th>Problem description</th>
    <th>Repair description</th>
    <th>Final cost (PLN)</th>
    <th>Used materials (PLN)</th>
    <th>Labour cost (PLN/hour)</th>
    <th>Time(hours)</th>
    <th>Assigned employee</th>
    <th>Vehicle</th>
    <th>Repair status</th>
    <th>Order id</th>
    <th>Customer name</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${order.acceptanceDate}</td>
            <td>${order.plannedRepairStartDate}</td>
            <td>${order.actualRepairStartDate}</td>
            <td>${order.problemDescription}</td>
            <td>${order.repairDescription}</td>
            <td>${order.costFinalToPay}</td>
            <td>${order.costUsedParts}</td>
            <td>${order.costEmployeeHourlyRate}</td>
            <td>${order.repairTimeInHours}</td>
            <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
            <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
            <td>${order.repairStatus.name}</td>
            <td>${order.id}</td>
            <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
            <td>
                <a href="/update-order?orderId=${order.id}">Edit</a>
                <a href="/delete-order?orderId=${order.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
