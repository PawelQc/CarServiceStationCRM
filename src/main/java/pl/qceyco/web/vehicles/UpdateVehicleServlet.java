package pl.qceyco.web.vehicles;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.VehicleDao;
import pl.qceyco.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/update-vehicle")
public class UpdateVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleId = request.getParameter("vehicleId");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String productionYear = request.getParameter("productionYear");
        String registrationNumber = request.getParameter("registrationNumber");
        String nextReviewDate = request.getParameter("nextReviewDate");

        if (StringUtils.isBlank(model) || StringUtils.isBlank(brand) || StringUtils.isBlank(productionYear)
                || StringUtils.isBlank(registrationNumber) || StringUtils.isBlank(nextReviewDate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.getVehicleById(Integer.valueOf(vehicleId));
        vehicle.setModel(model);
        vehicle.setBrand(brand);
        vehicle.setProductionYear(Integer.valueOf(productionYear));
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setNextReviewDate(Date.valueOf(nextReviewDate));
        vehicleDao.updateVehicle(vehicle);
        response.sendRedirect("/vehicles-of-customer?id=" + vehicle.getCustomer().getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleId = request.getParameter("vehicleId");
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.getVehicleById(Integer.valueOf(vehicleId));
        request.setAttribute("vehicle", vehicle);
        getServletContext().getRequestDispatcher("/vehicles/updateVehicle.jsp")
                .forward(request, response);
    }
}
