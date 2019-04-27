package pl.qceyco.web.employees;

import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders-of-employee")
public class OrdersOfEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getActiveOrdersByEmployeeId(Integer.valueOf(id));
        if (orders == null || orders.size() == 0) {
            request.setAttribute("noAssignedOrdersError", "This employee has no active orders");
        }
        request.setAttribute("orders", orders);
        request.setAttribute("employeeId", id);
        getServletContext().getRequestDispatcher("/employees/ordersOfEmployee.jsp")
                .forward(request, response);
    }
}

