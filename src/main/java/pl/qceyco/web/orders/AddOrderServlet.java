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

@WebServlet("/add-order")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String acceptanceDate = request.getParameter("acceptanceDate");
        String plannedRepairStartDate = request.getParameter("plannedRepairStartDate");
        String actualRepairStartDate = request.getParameter("actualRepairStartDate");
        String assignedEmployeeId = request.getParameter("assignedEmployeeId");
        String problemDescription = request.getParameter("problemDescription");
        String repairDescription = request.getParameter("repairDescription");
        String repairStatusId = request.getParameter("repairStatus");
        String repairedVehicleId = request.getParameter("repairedVehicleId");
        String costFinalToPay = request.getParameter("costFinalToPay");
        String costUsedParts = request.getParameter("costUsedParts");
        String repairTimeInHours = request.getParameter("repairTimeInHours");

        if (StringUtils.isBlank(acceptanceDate) || StringUtils.isBlank(plannedRepairStartDate) ||
                StringUtils.isBlank(actualRepairStartDate) || StringUtils.isBlank(assignedEmployeeId) ||
                StringUtils.isBlank(problemDescription) || StringUtils.isBlank(repairDescription) ||
                StringUtils.isBlank(repairStatusId) || StringUtils.isBlank(repairedVehicleId) ||
                StringUtils.isBlank(costFinalToPay) || StringUtils.isBlank(costUsedParts) ||
                StringUtils.isBlank(repairTimeInHours)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }

        StatusDao statusDao = new StatusDao();
        Status status = statusDao.getStatusById(Integer.valueOf(repairStatusId));
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.getVehicleById(Integer.valueOf(repairedVehicleId));
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(Integer.valueOf(assignedEmployeeId));
        OrderDao orderDao = new OrderDao();
        Order order = new Order(Date.valueOf(acceptanceDate), Date.valueOf(plannedRepairStartDate),
                Date.valueOf(actualRepairStartDate), employee, problemDescription, repairDescription, status, vehicle,
                Double.valueOf(costFinalToPay), Double.valueOf(costUsedParts), Double.valueOf(repairTimeInHours));
        orderDao.createOrder(order);
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

        getServletContext().getRequestDispatcher("/orders/addOrder.jsp")
                .forward(request, response);
    }
}
