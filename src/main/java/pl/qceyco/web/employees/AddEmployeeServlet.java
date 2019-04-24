package pl.qceyco.web.employees;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String remarks = request.getParameter("remarks");
        String hourlyRate = request.getParameter("hourlyRate");
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(address) ||
                StringUtils.isBlank(phoneNumber) || StringUtils.isBlank(remarks) || StringUtils.isBlank(hourlyRate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        Employee employee = new Employee(firstName, lastName, address, phoneNumber, remarks, Double.valueOf(hourlyRate));
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.createEmployee(employee);
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/employees/addEmployee.jsp")
                .forward(request, response);
    }
}
