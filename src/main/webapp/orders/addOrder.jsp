<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Add order</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Add order form </h2>
        <h4>${notCompleteDataError}</h4>
        <form action="/add-order" method="post">
            <label>
                Indicate acceptance date: <input type="date" name="acceptanceDate">
            </label> <br>
            <label>
                Indicate planned repair start date: <input type="date" name="plannedRepairStartDate">
            </label> <br>
            <label>
                Indicate actual repair start date: <input type="date" name="actualRepairStartDate">
            </label> <br>
            <label>Indicate assigned employee:
                <select name="assignedEmployeeId">
                    <option value="">Select...</option>
                    <c:forEach items="${employeeList}" var="employee">
                        <option value="${employee.id}">${employee.firstName} ${employee.lastName} </option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Indicate problem description: <input type="text" name="problemDescription"
                                                     placeholder="problem description">
            </label> <br>
            <label>
                Indicate repair description: <input type="text" name="repairDescription" placeholder="repair description">
            </label> <br>
            <label>Indicate repair status:
                <select name="repairStatus">
                    <option value="">Select...</option>
                    <c:forEach items="${statusList}" var="status">
                        <option value="${status.id}">${status.name}</option>
                    </c:forEach>
                </select>
            </label><br>
            <label>Indicate repaired vehicle:
                <select name="repairedVehicleId">
                    <option value="">Select...</option>
                    <c:forEach items="${vehicleList}" var="vehicle">
                        <option value="${vehicle.id}">${vehicle.model} ${vehicle.brand} reg.
                            no: ${vehicle.registrationNumber} </option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Indicate final cost (PLN): <input type="number" name="costFinalToPay" placeholder="final cost" min="0"
                                                  step="0.01">
            </label> <br>
            <label>
                Indicate materials cost (PLN): <input type="number" name="costUsedParts" placeholder="material cost" min="0"
                                                      step="0.01">
            </label> <br>
            <label>
                Indicate repair time (hours): <input type="number" name="repairTimeInHours" placeholder="repair time"
                                                     min="0"
                                                     step="0.1">
            </label>
            <br><br>
            <input type="submit" value="Create">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
