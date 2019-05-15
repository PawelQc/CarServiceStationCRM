<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="fragments/head.jspf" %>
    <title>Homepage</title>
</head>
<body>
    <%@ include file="fragments/header.jspf" %>
    <div class="container">
        <h2>List of pending car repair orders</h2>
        <h4>${noOrdersError}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">Assigned employee</th>
            <th class="active">Vehicle</th>
            <th class="active">Customer name</th>
            <th class="active">Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
                    <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
                    <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
                    <td>
                        <a href="/detailed-order?orderId=${order.id}"
                           class="btn btn-info rounded-0 text-light m-1">Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="fragments/footer.jspf" %>
</body>
</html>
