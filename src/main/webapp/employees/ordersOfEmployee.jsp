<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Assigned Orders</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>List of orders assigned to employee of id ${employeeId}</h2>
        <h4>${noAssignedOrdersError}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">Actual start</th>
            <th class="active">Repair description</th>
            <th class="active">Final cost (PLN)</th>
            <th class="active">Customer</th>
            <th class="active">Vehicle</th>
            <th class="active">Repair status</th>
            <th class="active">Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${order.actualRepairStartDate}</td>
                    <td>${order.repairDescription}</td>
                    <td>${order.costFinalToPay}</td>
                    <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
                    <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
                    <td>${order.repairStatus.name}</td>
                    <td>
                        <a href="/detailed-order?orderId=${order.id}"
                           class="btn btn-info rounded-0 text-light m-1">Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
