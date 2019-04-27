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
    <thead>
    <th>First name</th>
    <th>Last name</th>
    <th>Address</th>
    <th>Phone number</th>
    <th>Remarks</th>
    <th>Hourly rate (PLN)</th>
    <th>Actions</th>
    </thead>
    <tbody>
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.address}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.remarks}</td>
            <td>${employee.hourlyRate}</td>
            <td>
                <a href="/update-employee?id=${employee.id}">Edit</a>
                <a href="/delete-employee?id=${employee.id}">Delete</a>
                <a href="/orders-of-employee?id=${employee.id}">Show orders</a>
            </td>
        </tr>

    </tbody>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
