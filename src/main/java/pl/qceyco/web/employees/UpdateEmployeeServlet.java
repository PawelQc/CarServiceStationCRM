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

@WebServlet("/update-employee")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
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
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(Integer.valueOf(id));
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAddress(address);
        employee.setPhoneNumber(phoneNumber);
        employee.setRemarks(remarks);
        employee.setHourlyRate(Double.valueOf(hourlyRate));
        employeeDao.updateEmployee(employee);
        response.sendRedirect("/employees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(Integer.valueOf(id));
        request.setAttribute("employee", employee);
        getServletContext().getRequestDispatcher("/employees/updateEmployee.jsp")
                .forward(request, response);
    }
}
