package pl.qceyco.web.customers;

import pl.qceyco.dao.CustomerDao;
import pl.qceyco.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getCustomerById(Integer.valueOf(id));
        customerDao.deleteCustomer(customer);
        request.setAttribute("deleteMessage", "Customer with id " + customer.getId() + " is deleted!");
        getServletContext().getRequestDispatcher("/customers")
                .forward(request, response);
    }
}

