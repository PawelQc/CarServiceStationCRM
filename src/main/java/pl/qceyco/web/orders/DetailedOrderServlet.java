package pl.qceyco.web.orders;

import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailed-order")
public class DetailedOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        OrderDao orderDao = new OrderDao();
        Order order = orderDao.getOrderById(Integer.valueOf(orderId));
        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/orders/detailedOrder.jsp")
                .forward(request, response);
    }
}
