package pl.qceyco.web.customers;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.CustomerDao;
import pl.qceyco.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/update-customer")
public class UpdateCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(birthDate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(Integer.valueOf(id));
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBirthDate(Date.valueOf(birthDate));
        customerDao.updateCustomer(customer);
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(Integer.valueOf(id));
        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/customers/updateCustomer.jsp")
                .forward(request, response);
    }
}
