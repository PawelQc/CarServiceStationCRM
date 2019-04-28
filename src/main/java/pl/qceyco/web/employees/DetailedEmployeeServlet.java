package pl.qceyco.web.employees;

import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Employee;
import pl.qceyco.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailed-employee")
public class DetailedEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeId = request.getParameter("employeeId");
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(Integer.valueOf(employeeId));
        request.setAttribute("employee", employee);
        getServletContext().getRequestDispatcher("/employees/detailedEmployee.jsp")
                .forward(request, response);
    }
}
