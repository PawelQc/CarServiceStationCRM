package pl.qceyco.web.reports;

import org.apache.commons.lang3.StringUtils;
import pl.qceyco.dao.EmployeeDao;
import pl.qceyco.dao.OrderDao;
import pl.qceyco.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/profit-report")
public class ProfitReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
            request.setAttribute("notCompleteDataError", "Please fill in the form completely!");
            doGet(request, response);
            return;
        }
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.getAllEmployees();
        if (employees == null || employees.size() == 0) {
            request.setAttribute("noEmplyeesError", "There are no employees in the database! Cannot generate report!");
            getServletContext().getRequestDispatcher("/reports/profitReportView.jsp")
                    .forward(request, response);
            return;
        }
        OrderDao orderDao = new OrderDao();
        Double income = orderDao.getIncomeForSpecificPeriod(Date.valueOf(startDate),Date.valueOf(endDate));
        Double materialsCost = orderDao.getMaterialsCostForSpecificPeriod(Date.valueOf(startDate),Date.valueOf(endDate));
        double labourCosts = 0;
        for (Employee employee : employees) {
            Double hours = orderDao.getNumberOfHoursByEmployeeId(employee.getId(), Date.valueOf(startDate), Date.valueOf(endDate));
            Double hourlyRate = employee.getHourlyRate();
            labourCosts += hours * hourlyRate;
        }
        double profit = income - (materialsCost + labourCosts);

        request.setAttribute("profit", profit);
        request.setAttribute("labourCosts", labourCosts);
        request.setAttribute("income", income);
        request.setAttribute("materialsCost", materialsCost);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        getServletContext().getRequestDispatcher("/reports/profitReportView.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reports/profitReportForm.jsp")
                .forward(request, response);
    }
}
