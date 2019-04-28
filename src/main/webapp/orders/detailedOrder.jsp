<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detailed order</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Order of id ${order.id}</h2>

<table border="1">
    <tr>
        <th>Order id</th>
        <td>${order.id}</td>
    </tr>
    <tr>
        <th>Acceptance</th>
        <td>${order.acceptanceDate}</td>
    </tr>
    <tr>
        <th>Planned start</th>
        <td>${order.plannedRepairStartDate}</td>
    </tr>
    <tr>
        <th>Actual start</th>
        <td>${order.actualRepairStartDate}</td>
    </tr>
    <tr>
        <th>Problem description</th>
        <td>${order.problemDescription}</td>
    </tr>
    <tr>
        <th>Repair description</th>
        <td>${order.repairDescription}</td>
    </tr>
    <tr>
        <th>Final cost (PLN)</th>
        <td>${order.costFinalToPay}</td>
    </tr>
    <tr>
        <th>Used materials (PLN)</th>
        <td>${order.costUsedParts}</td>
    </tr>
    <tr>
        <th>Labour cost (PLN/hour)</th>
        <td>${order.costEmployeeHourlyRate}</td>
    </tr>
    <tr>
        <th>Time (hours)</th>
        <td>${order.repairTimeInHours}</td>
    </tr>
    <tr>
        <th>Assigned employee</th>
        <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
    </tr>
    <tr>
        <th>Vehicle</th>
        <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
    </tr>
    <tr>
        <th>Repair status</th>
        <td>${order.repairStatus.name}</td>
    </tr>
    <tr>
        <th>Customer</th>
        <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
    </tr>
    <tr>
        <th>Actions</th>
        <td>
            <a href="/update-order?orderId=${order.id}">Edit</a>
            <a href="/delete-order?orderId=${order.id}">Delete</a>
            <a href="/update-status?orderId=${order.id}">Change status</a>
        </td>
    </tr>
</table>


<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
