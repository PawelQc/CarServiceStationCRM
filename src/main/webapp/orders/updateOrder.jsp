<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/fragments/head.jspf" %>
    <title>Update order</title>
</head>
<body>
    <%@ include file="../fragments/header.jspf" %>
    <div class="container">
        <h2>Update order form </h2>
        <h4>${notCompleteDataError}</h4>
        <form action="/update-order?orderId=${order.id}" method="post">
            <label>
                Indicate acceptance date: <input type="date" name="acceptanceDate" value="${order.acceptanceDate}">
            </label> <br>
            <label>
                Indicate planned repair start date: <input type="date" name="plannedRepairStartDate"
                                                           value="${order.plannedRepairStartDate}">
            </label> <br>
            <label>
                Indicate actual repair start date: <input type="date" name="actualRepairStartDate"
                                                          value="${order.actualRepairStartDate}">
            </label> <br>
            <label>Indicate assigned employee (previous: ${order.assignedEmployee.lastName}):
                <select name="assignedEmployeeId">
                    <option value="">Select...</option>
                    <c:forEach items="${employeeList}" var="employee">
                        <option value="${employee.id}">${employee.firstName} ${employee.lastName} </option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                Indicate problem description: <input type="text" name="problemDescription" placeholder="problem description"
                                                     value="${order.problemDescription}">
            </label> <br>
            <label>
                Indicate repair description: <input type="text" name="repairDescription" placeholder="repair description"
                                                    value="${order.repairDescription}">
            </label> <br>
            <label>Indicate repaired vehicle (previous: ${order.repairedVehicle.registrationNumber}):
                <select name="repairedVehicleId">
                    <option value="">Select...</option>
                    <c:forEach items="${vehicleList}" var="vehicle">
                        <option value="${vehicle.id}">${vehicle.model} ${vehicle.brand} reg.
                            no: ${vehicle.registrationNumber} </option>
                    </c:forEach>
                </select>
            </label> <br>
            <label>
                Indicate final cost (PLN): <input type="number" name="costFinalToPay" placeholder="final cost" min="0"
                                                  step="0.01" value="${order.costFinalToPay}">
            </label> <br>
            <label>
                Indicate materials cost (PLN): <input type="number" name="costUsedParts" placeholder="material cost" min="0"
                                                      step="0.01" value="${order.costUsedParts}">
            </label> <br>
            <label>
                Indicate repair time (hours): <input type="number" name="repairTimeInHours" placeholder="repair time"
                                                     min="0"
                                                     step="0.1" value="${order.repairTimeInHours}">
            </label>
            <br><br>
            <input type="submit" value="Update">
        </form>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
