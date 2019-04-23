package pl.qceyco.dao;

import pl.qceyco.model.Customer;
import pl.qceyco.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private static final String CREATE_CUSTOMER_QUERY = "INSERT INTO customers(first_name, last_name, birth_date) VALUES (?,?,?);";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customers SET first_name=?, last_name=?, birth_date=? WHERE id = ?;";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customers WHERE id = ?;";
    private static final String GET_ALL_CUSTOMERS_QUERY = "SELECT * FROM customers;";
    private static final String GET_CUSTOMER_BY_ID_QUERY = "SELECT * FROM customers WHERE id = ?;";


    public Customer createCustomer(Customer customer) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_CUSTOMER_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setDate(3, customer.getBirthDate());
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    customer.setId(generatedKeys.getInt(1));
                    return customer;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_QUERY)) {
            statement.setInt(4, customer.getId());
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setDate(3, customer.getBirthDate());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Customer customer) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_QUERY)) {
            statement.setInt(1, customer.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int customerId) {
        Customer customer = new Customer();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_BY_ID_QUERY)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("first_name"));
                    customer.setLastName(resultSet.getString("last_name"));
                    customer.setBirthDate(resultSet.getDate("birth_date"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_CUSTOMERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setBirthDate(resultSet.getDate("birth_date"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}



