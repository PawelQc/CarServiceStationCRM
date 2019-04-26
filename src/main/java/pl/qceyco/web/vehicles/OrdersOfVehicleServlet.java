package pl.qceyco.web.vehicles;

import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders-of-vehicle")
public class OrdersOfVehicleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleId = request.getParameter("vehicleId");
        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.getOrdersByVehicleId(Integer.valueOf(vehicleId));
        if (orders == null || orders.size() == 0) {
            request.setAttribute("noOrdersMadeError", "This vehicle has no repair history!");
        }
        request.setAttribute("orders", orders);
        request.setAttribute("vehicleId", vehicleId);
        getServletContext().getRequestDispatcher("/vehicles/ordersOfVehicle.jsp")
                .forward(request, response);
    }
}

