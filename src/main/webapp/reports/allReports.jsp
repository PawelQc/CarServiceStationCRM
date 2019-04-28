<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>All reports</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container" style="width: 30%">
        <h2 style="text-align: center; margin-bottom: 10%">Choose your report</h2>
        <div>
            <a href="/timesheet-report" class="btn btn-lg btn-primary rounded-0 text-light m-1" style="float: left">Generate timesheet
                report</a>
        </div>
        <div>
            <a href="/profit-report" class="btn btn-lg btn-success rounded-0 text-light m-1" style="float: right">Generate profit report</a>
        </div>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
