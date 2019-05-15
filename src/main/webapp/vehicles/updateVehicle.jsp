<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Update vehicle</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Update vehicle form </h2>
        <h4>${notCompleteDataError}</h4>

        <form action="/update-vehicle?vehicleId=${vehicle.id}" method="post">
            <label>
                Indicate model: <input type="text" name="model" placeholder="model" value="${vehicle.model}">
            </label> <br>
            <label>
                Indicate brand: <input type="text" name="brand" placeholder="brand" value="${vehicle.brand}">
            </label> <br>
            <label>
                Indicate production year (YYYY): <input type="number" name="productionYear" placeholder="production year"
                                                        value="${vehicle.productionYear}">
            </label> <br>
            <label>
                Indicate registration number: <input type="text" name="registrationNumber" placeholder="registration number"
                                                     value="${vehicle.registrationNumber}">
            </label> <br>
            <label>
                Indicate next review date: <input type="date" name="nextReviewDate" placeholder="nextReviewDate"
                                                  value="${vehicle.nextReviewDate}">
            </label> <br><br>
            <input type="submit" value="Update">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
