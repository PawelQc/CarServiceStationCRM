package pl.qceyco.web.orders;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.*;
import pl.qceyco.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/update-order")
public class UpdateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceptanceDate = request.getParameter("acceptanceDate");
        String plannedRepairStartDate = request.getParameter("plannedRepairStartDate");
        String actualRepairStartDate = request.getParameter("actualRepairStartDate");
        String assignedEmployeeId = request.getParameter("assignedEmployeeId");
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        String repairedVehicleId = request.getParameter("repairedVehicleId");
        String costFinalToPay = request.getParameter("costFinalToPay");
        String costUsedParts = request.getParameter("costUsedParts");
        String repairTimeInHours = request.getParameter("repairTimeInHours");

        if (StringUtils.isBlank(acceptanceDate) || StringUtils.isBlank(plannedRepairStartDate) ||
                StringUtils.isBlank(actualRepairStartDate) || StringUtils.isBlank(assignedEmployeeId) ||
                StringUtils.isBlank(problemDescription) || StringUtils.isBlank(repairDescription) ||
                StringUtils.isBlank(repairedVehicleId) || StringUtils.isBlank(costFinalToPay) ||
                StringUtils.isBlank(costUsedParts) || StringUtils.isBlank(repairTimeInHours)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }

        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        order.setAcceptanceDate(Date.valueOf(acceptanceDate));
        order.setPlannedRepairStartDate(Date.valueOf(plannedRepairStartDate));
        order.setActualRepairStartDate(Date.valueOf(actualRepairStartDate));
        order.setRepairDescription(repairDescription);
        order.setProblemDescription(problemDescription);
        order.setRepairedVehicleById(Integer.valueOf(repairedVehicleId));
        order.setAssignedEmployeeById(Integer.valueOf(assignedEmployeeId));
        order.setCostFinalToPay(Double.valueOf(costFinalToPay));
        order.setCostUsedParts(Double.valueOf(costUsedParts));
        order.setRepairTimeInHours(Double.valueOf(repairTimeInHours));
        orderDao.updateOrder(order);
        response.sendRedirect("/orders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatusDao statusDao = new StatusDao();
        List<Status> statusList = statusDao.getAllStatus();
        request.setAttribute("statusList", statusList);

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.getAllEmployees();
        request.setAttribute("employeeList", employeeList);

        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicleList = vehicleDao.getAllVehicles();
        request.setAttribute("vehicleList", vehicleList);

        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        request.setAttribute("order", order);

        getServletContext().getRequestDispatcher("/orders/updateOrder.jsp")
                .forward(request, response);
    }
}
