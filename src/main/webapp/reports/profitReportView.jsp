<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profit report</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Profit report</h2>
<h3>Report period: ${startDate} - ${endDate}</h3>

<h4>${noOrdersError}</h4>


<table border="1">
    <tr>
        <th>Income</th>
        <td>${income}</td>
    </tr>
    <tr>
        <th>Labour costs</th>
        <td>${labourCosts}</td>
    </tr>
    <tr>
        <th>Materials costs</th>
        <td>${materialsCost}</td>
    </tr>
    <tr>
        <th>Profit/Loss</th>
        <td>${profit}</td>
    </tr>
</table>


<%@ include file="../fragments/footer.jspf" %>
</body>
</html>

