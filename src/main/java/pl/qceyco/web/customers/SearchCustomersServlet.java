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
import java.util.List;

@WebServlet("/search-customers")
public class SearchCustomersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.searchForCustomerByLastName(lastName);
        if (StringUtils.isBlank(lastName) || customers == null || customers.size() == 0) {
            request.setAttribute("noCustomersError", "There are no such customers in the database!");
            getServletContext().getRequestDispatcher("/customers/searchCustomers.jsp")
                    .forward(request, response);
            return;
        }
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/customers/searchCustomers.jsp")
                .forward(request, response);
    }
}
