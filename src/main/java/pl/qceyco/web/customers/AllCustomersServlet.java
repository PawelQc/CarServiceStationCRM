package pl.qceyco.web.customers;

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
import java.util.List;

@WebServlet("/customers")
public class AllCustomersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAllCustomers();
        if (customers == null) {
            request.setAttribute("noCustomersError", "There are no customers in the database!");
            getServletContext().getRequestDispatcher("/customers/allCustomers.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/customers/allCustomers.jsp")
                .forward(request, response);
    }
}
