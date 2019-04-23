package pl.qceyco.dao;

import pl.qceyco.model.Employee;
import pl.qceyco.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employees(first_name, last_name, address, phone_number, remarks, hourly_rate) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employees SET first_name=?, last_name=?, address=?, phone_number=?, remarks=?, hourly_rate=? WHERE id = ?;";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employees WHERE id = ?;";
    private static final String GET_ALL_EMPLOYEES_QUERY = "SELECT * FROM employees;";
    private static final String GET_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employees WHERE id = ?;";

    public Employee createEmployee(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getRemarks());
            statement.setDouble(6, employee.getHourlyRate());
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    employee.setId(generatedKeys.getInt(1));
                    return employee;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_QUERY)) {
            statement.setInt(7, employee.getId());
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getRemarks());
            statement.setDouble(6, employee.getHourlyRate());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_QUERY)) {
            statement.setInt(1, employee.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeById(int employeeId) {
        Employee employee = new Employee();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_BY_ID_QUERY)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setAddress(resultSet.getString("address"));
                    employee.setPhoneNumber(resultSet.getString("phone_number"));
                    employee.setRemarks(resultSet.getString("remarks"));
                    employee.setHourlyRate(resultSet.getDouble("hourly_rate"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_EMPLOYEES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setRemarks(resultSet.getString("remarks"));
                employee.setHourlyRate(resultSet.getDouble("hourly_rate"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


}

