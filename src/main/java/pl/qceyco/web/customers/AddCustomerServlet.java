package pl.qceyco.web.customers;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.CustomerDao;
import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.model.Customer;
import pl.qceyco.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add-customer")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(birthDate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        Customer customer = new Customer(firstName, lastName, Date.valueOf(birthDate));
        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(customer);
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/customers/addCustomer.jsp")
                .forward(request, response);
    }
}
