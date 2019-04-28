<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>List of employees</h2>

<a href="/add-employee">Add employee</a>

<h4>${noEmployeesError}</h4> <h4>${deleteMessage}</h4>

<table border="1">
    <thead>
    <th>No</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>
                <a href="/detailed-employee?employeeId=${employee.id}">Details</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
