package pl.qceyco.web.customers;

import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders-of-customer")
public class OrdersOfCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getOrdersByCustomerId(Integer.valueOf(id));
        if (orders == null || orders.size() == 0) {
            request.setAttribute("noOrdersMadeError", "This customer has made no orders!");
        }
        request.setAttribute("orders", orders);
        request.setAttribute("customerId", id);
        getServletContext().getRequestDispatcher("/customers/ordersOfCustomer.jsp")
                .forward(request, response);
    }
}

