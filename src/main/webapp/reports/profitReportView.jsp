<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Profit report</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Profit report</h2>
        <h4>Report period: ${startDate} - ${endDate}</h4>
        <h4>${noOrdersError}</h4>
        <table class="table table-hover">
            <tr>
                <th class="active">Income</th>
                <td>${income}</td>
            </tr>
            <tr>
                <th class="active">Labour costs</th>
                <td>${labourCosts}</td>
            </tr>
            <tr>
                <th class="active">Materials costs</th>
                <td>${materialsCost}</td>
            </tr>
            <tr>
                <th class="active">Profit/Loss</th>
                <td>${profit}</td>
            </tr>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>

