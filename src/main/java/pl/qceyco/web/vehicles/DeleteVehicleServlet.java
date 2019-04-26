package pl.qceyco.web.vehicles;

import pl.qceyco.dao.VehicleDao;
import pl.qceyco.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-vehicle")
public class DeleteVehicleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehicleId = request.getParameter("vehicleId");
        VehicleDao vehicleDao = new VehicleDao();
        Vehicle vehicle = vehicleDao.getVehicleById(Integer.valueOf(vehicleId));
        vehicleDao.deleteVehicle(vehicle);
        request.setAttribute("deleteMessage", "Vehicle with id " + vehicle.getId() + " is deleted!");
        getServletContext().getRequestDispatcher("/vehicles-of-customer?id=" + vehicle.getCustomer().getId())
                .forward(request, response);
    }
}

