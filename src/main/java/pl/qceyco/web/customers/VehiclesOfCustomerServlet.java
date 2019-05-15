package pl.qceyco.web.customers;

import pl.qceyco.dao.VehicleDao;
import pl.qceyco.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicles-of-customer")
public class VehiclesOfCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        VehicleDao vehicleDao = new VehicleDao();
        List<Vehicle> vehicles = vehicleDao.getVehiclesByCustomerId(Integer.valueOf(id));
        if (vehicles == null || vehicles.size() == 0) {
            request.setAttribute("noVehiclesError", "This customer has no assigned vehicles!");
        }
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("customerId", id);
        getServletContext().getRequestDispatcher("/customers/vehiclesOfCustomer.jsp")
                .forward(request, response);
    }
}

