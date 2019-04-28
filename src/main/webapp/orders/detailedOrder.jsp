<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Detailed order</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Order of id ${order.id}</h2>

        <table class="table table-hover">
            <tr>
                <th class="active">Order id</th>
                <td>${order.id}</td>
            </tr>
            <tr>
                <th class="active">Acceptance</th>
                <td>${order.acceptanceDate}</td>
            </tr>
            <tr>
                <th class="active">Planned start</th>
                <td>${order.plannedRepairStartDate}</td>
            </tr>
            <tr>
                <th class="active">Actual start</th>
                <td>${order.actualRepairStartDate}</td>
            </tr>
            <tr>
                <th class="active">Problem description</th>
                <td>${order.problemDescription}</td>
            </tr>
            <tr>
                <th class="active">Repair description</th>
                <td>${order.repairDescription}</td>
            </tr>
            <tr>
                <th class="active">Final cost (PLN)</th>
                <td>${order.costFinalToPay}</td>
            </tr>
            <tr>
                <th class="active">Used materials (PLN)</th>
                <td>${order.costUsedParts}</td>
            </tr>
            <tr>
                <th class="active">Labour cost (PLN/hour)</th>
                <td>${order.costEmployeeHourlyRate}</td>
            </tr>
            <tr>
                <th class="active">Time (hours)</th>
                <td>${order.repairTimeInHours}</td>
            </tr>
            <tr>
                <th class="active">Assigned employee</th>
                <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
            </tr>
            <tr>
                <th class="active">Vehicle</th>
                <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
            </tr>
            <tr>
                <th class="active">Repair status</th>
                <td>${order.repairStatus.name}</td>
            </tr>
            <tr>
                <th class="active">Customer</th>
                <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
            </tr>
            <tr>
                <th class="active">Actions</th>
                <td>
                    <a href="/update-order?orderId=${order.id}" class="btn btn-warning rounded-0 text-light m-1">Update</a>
                    <a href="/delete-order?orderId=${order.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                    <a href="/update-status?orderId=${order.id}" class="btn btn-primary rounded-0 text-light m-1">Change
                        status</a>
                </td>
            </tr>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
