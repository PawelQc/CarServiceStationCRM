<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Customer's vehicles</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>List of vehicles owned by customer of id ${customerId}</h2>
        <a href="/add-vehicle?customerId=${customerId}" class="btn btn-success rounded-0 text-light m-1">Add vehicle</a>
        <h4>${noVehiclesError}</h4> <h4>${deleteMessage}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">Model</th>
            <th class="active">Brand</th>
            <th class="active">Production year</th>
            <th class="active">Registration no</th>
            <th class="active">Review date</th>
            <th class="active">Customer</th>
            <th class="active">Actions</th>
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
                        <a href="/update-vehicle?vehicleId=${vehicle.id}" class="btn btn-warning rounded-0 text-light m-1">Update</a>
                        <a href="/delete-vehicle?vehicleId=${vehicle.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                        <a href="/orders-of-vehicle?vehicleId=${vehicle.id}" class="btn btn-info rounded-0 text-light m-1">Repair
                            history</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
