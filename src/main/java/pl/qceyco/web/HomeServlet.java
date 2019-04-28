package pl.qceyco.web;

import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getAllActiveOrders();
        if (orders == null || orders.size() == 0) {
            request.setAttribute("noOrdersError", "There are no pending orders with 'in repair' status!");
            getServletContext().getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
