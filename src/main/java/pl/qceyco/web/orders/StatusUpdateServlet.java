package pl.qceyco.web.orders;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.dao.OrderDao;
import pl.qceyco.dao.StatusDao;
import pl.qceyco.dao.VehicleDao;
import pl.qceyco.model.Employee;
import pl.qceyco.model.Order;
import pl.qceyco.model.Status;
import pl.qceyco.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/update-status")
public class StatusUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String repairStatusId = request.getParameter("repairStatus");
        if (StringUtils.isBlank(repairStatusId)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        order.setRepairStatusById(Integer.valueOf(repairStatusId));
        orderDao.updateOrder(order);
        response.sendRedirect("/orders");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatusDao statusDao = new StatusDao();
        List<Status> statusList = statusDao.getAllStatus();
        request.setAttribute("statusList", statusList);

        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        request.setAttribute("order", order);

        getServletContext().getRequestDispatcher("/orders/statusUpdateOrder.jsp")
                .forward(request, response);
    }
}
