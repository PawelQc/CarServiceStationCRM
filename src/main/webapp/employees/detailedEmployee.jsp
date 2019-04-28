<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Employee of id ${employee.id}</h2>

<table border="1">
    <tr>
        <th>First name</th>
        <td>${employee.firstName}</td>
    </tr>
    <tr>
        <th>Last name</th>
        <td>${employee.lastName}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${employee.address}</td>
    </tr>
    <tr>
        <th>Phone number</th>
        <td>${employee.phoneNumber}</td>
    </tr>
    <tr>
        <th>Remarks</th>
        <td>${employee.remarks}</td>
    </tr>
    <tr>
        <th>Hourly rate (PLN)</th>
        <td>${employee.hourlyRate}</td>
    </tr>
    <tr>
        <th>Actions</th>
        <td>
            <a href="/update-employee?id=${employee.id}">Edit</a>
            <a href="/delete-employee?id=${employee.id}">Delete</a>
            <a href="/orders-of-employee?id=${employee.id}">Show orders</a>
        </td>
    </tr>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
