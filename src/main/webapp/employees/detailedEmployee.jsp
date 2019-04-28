<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Employees</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Employee of id ${employee.id}</h2>
        <table class="table table-hover">
            <tr>
                <th class="active">First name</th>
                <td>${employee.firstName}</td>
            </tr>
            <tr>
                <th class="active">Last name</th>
                <td>${employee.lastName}</td>
            </tr>
            <tr>
                <th class="active">Address</th>
                <td>${employee.address}</td>
            </tr>
            <tr>
                <th class="active">Phone number</th>
                <td>${employee.phoneNumber}</td>
            </tr>
            <tr>
                <th class="active">Remarks</th>
                <td>${employee.remarks}</td>
            </tr>
            <tr>
                <th class="active">Hourly rate (PLN)</th>
                <td>${employee.hourlyRate}</td>
            </tr>
            <tr>
                <th class="active">Actions</th>
                <td>
                    <a href="/update-employee?id=${employee.id}" class="btn btn-warning rounded-0 text-light m-1">Update</a>
                    <a href="/delete-employee?id=${employee.id}" class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                    <a href="/orders-of-employee?id=${employee.id}" class="btn btn-info rounded-0 text-light m-1">Show orders</a>
                </td>
            </tr>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
