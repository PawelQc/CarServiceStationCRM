<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers search</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>List of found customers</h2>

<h4>${noCustomersError}</h4> <h4>${deleteMessage}</h4>
<table border="1">
    <thead>
    <th>No</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Birthday</th>
    <th>Actions</th>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.birthDate}</td>
            <td>
                <a href="/update-customer?id=${customer.id}">Edit</a>
                <a href="/delete-customer?id=${customer.id}">Delete</a>
                <a href="/orders-of-customer?id=${customer.id}">Show orders</a>
                <a href="/vehicles-of-customer?id=${customer.id}">Show vehicles</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
