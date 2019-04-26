package pl.qceyco.web.orders;

import pl.qceyco.dao.CustomerDao;
import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Customer;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-order")
public class DeleteOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        orderDao.deleteOrder(order);
        request.setAttribute("deleteMessage", "Order with id " + order.getId() + " is deleted!");
        getServletContext().getRequestDispatcher("/orders")
                .forward(request, response);
    }
}

