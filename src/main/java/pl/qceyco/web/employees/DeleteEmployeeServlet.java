package pl.qceyco.web.employees;

import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.getEmployeeById(Integer.valueOf(id));
        employeeDao.deleteEmployee(employee);
        request.setAttribute("deleteMessage", "Employee with id " + employee.getId() + " is deleted!");
        getServletContext().getRequestDispatcher("/employees")
                .forward(request, response);
    }
}

