<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All reports</title>
</head>
<body>
<%@ include file="../fragments/header.jspf" %>

<h2>Choose your report</h2>

<a href="/timesheet-report">Generate timesheet report</a> <br>
<a href="/profit-report">Generate profit report</a>


<%@ include file="../fragments/footer.jspf" %>
</body>
</html>
