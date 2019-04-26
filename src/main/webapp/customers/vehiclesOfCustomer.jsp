<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer's vehicles</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>List of vehicles owned by customer of id ${customerId}</h2>

<a href="/add-vehicle?customerId=${customerId}">Add vehicle</a>

<h4>${noVehiclesError}</h4> <h4>${deleteMessage}</h4>

<table border="1">
    <thead>
    <th>No</th>
    <th>Model</th>
    <th>Brand</th>
    <th>Production year</th>
    <th>Registration no</th>
    <th>Review date</th>
    <th>Customer</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${vehicles}" var="vehicle" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${vehicle.model}</td>
            <td>${vehicle.brand}</td>
            <td>${vehicle.productionYear}</td>
            <td>${vehicle.registrationNumber}</td>
            <td>${vehicle.nextReviewDate}</td>
            <td>${vehicle.customer.firstName} ${vehicle.customer.lastName}</td>
            <td>
                <a href="/update-vehicle?vehicleId=${vehicle.id}">Edit</a>
                <a href="/delete-vehicle?vehicleId=${vehicle.id}">Delete</a>
                <a href="/orders-of-vehicle?vehicleId=${vehicle.id}">Repair history</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
