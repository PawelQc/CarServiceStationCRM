package pl.qceyco.web.orders;

import pl.qceyco.dao.*;
import pl.qceyco.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class AllOrdersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getAllOrders();
        if (orders == null || orders.size() == 0) {
            request.setAttribute("noOrdersError", "There are no orders in the database!");
            getServletContext().getRequestDispatcher("/orders/allOrders.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/orders/allOrders.jsp")
                .forward(request, response);
    }
}
