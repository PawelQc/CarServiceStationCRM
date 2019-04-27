<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All orders</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>History of all orders</h2>

<a href="/add-order">Add order</a>

<h4>${noOrdersError}</h4> <h4>${deleteMessage}</h4> <h4>${updateMessage}</h4>


<table border="1">
    <thead>
    <th>No</th>
    <th>Assigned employee</th>
    <th>Vehicle</th>
    <th>Customer name</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${order.assignedEmployee.firstName} ${order.assignedEmployee.lastName}</td>
            <td>${order.repairedVehicle.model} ${order.repairedVehicle.brand}</td>
            <td>${order.repairedVehicle.customer.firstName} ${order.repairedVehicle.customer.lastName}</td>
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
