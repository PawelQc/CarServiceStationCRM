package pl.qceyco.web.vehicles;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.CustomerDao;
import pl.qceyco.dao.VehicleDao;
import pl.qceyco.model.Customer;
import pl.qceyco.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add-vehicle")
public class AddVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String productionYear = request.getParameter("productionYear");
        String registrationNumber = request.getParameter("registrationNumber");
        String nextReviewDate = request.getParameter("nextReviewDate");

        if (StringUtils.isBlank(model) || StringUtils.isBlank(brand) || StringUtils.isBlank(productionYear) ||
                StringUtils.isBlank(registrationNumber) || StringUtils.isBlank(nextReviewDate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(Integer.valueOf(customerId));
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = new Vehicle(model, brand, Integer.valueOf(productionYear), registrationNumber, Date.valueOf(nextReviewDate), customer);
        vehicleDao.createVehicle(vehicle);
        response.sendRedirect("/vehicles-of-customer?id=" + customerId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        request.setAttribute("customerId", customerId);
        getServletContext().getRequestDispatcher("/vehicles/addVehicle.jsp")
                .forward(request, response);
    }
}
