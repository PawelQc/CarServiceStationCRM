<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Customers search</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>List of found customers</h2>
        <h4>${noCustomersError}</h4> <h4>${deleteMessage}</h4>
        <table class="table table-hover">
            <thead>
            <th class="active">No</th>
            <th class="active">First name</th>
            <th class="active">Last name</th>
            <th class="active">Birthday</th>
            <th class="active">Actions</th>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="customer" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.birthDate}</td>
                    <td>
                        <a href="/update-customer?id=${customer.id}"
                           class="btn btn-warning rounded-0 text-light m-1">Update</a>
                        <a href="/delete-customer?id=${customer.id}"
                           class="btn btn-danger rounded-0 text-light m-1">Delete</a>
                        <a href="/orders-of-customer?id=${customer.id}" class="btn btn-info rounded-0 text-light m-1">Show
                            orders</a>
                        <a href="/vehicles-of-customer?id=${customer.id}" class="btn btn-info rounded-0 text-light m-1">Show
                            vehicles</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
