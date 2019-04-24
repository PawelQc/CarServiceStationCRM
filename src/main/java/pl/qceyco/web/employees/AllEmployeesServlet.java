package pl.qceyco.web.employees;

import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class AllEmployeesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployees();
        if (employees == null) {
            request.setAttribute("noEmployeesError", "There are no emplyees in the database!");
            getServletContext().getRequestDispatcher("/employees/allEmployees.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/employees/allEmployees.jsp")
                .forward(request, response);
    }
}

