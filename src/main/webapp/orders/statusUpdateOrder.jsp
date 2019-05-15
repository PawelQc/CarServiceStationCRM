<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Update status</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Update status of order with id ${order.id} </h2>
        <h4>${notCompleteDataError}</h4>

        <form action="/update-status?orderId=${order.id}" method="post">
            <label>Indicate repair status (previous: ${order.repairStatus.name}): <br>
                <select name="repairStatus">
                    <option value="">Select...</option>
                    <c:forEach items="${statusList}" var="status">
                        <option value="${status.id}">${status.name}</option>
                    </c:forEach>
                </select>
            </label>
            <br><br>
            <input type="submit" value="Update">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
