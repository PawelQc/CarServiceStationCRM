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
        <h2>List of employees</h2>
        <a href="/add-employee" class="btn btn-success rounded-0 text-light m-1">Add employee</a>
        <h4>${noEmployeesError}</h4> <h4>${deleteMessage}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">First name</th>
            <th class="active">Last name</th>
            <th class="active">Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="employee" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>
                        <a href="/detailed-employee?employeeId=${employee.id}"
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
