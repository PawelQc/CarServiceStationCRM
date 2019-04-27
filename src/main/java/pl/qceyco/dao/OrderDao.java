package pl.qceyco.dao;

import pl.qceyco.model.Order;
import pl.qceyco.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String CREATE_ORDER_QUERY = "INSERT INTO orders(acceptance_date, planned_repair_start_date, actual_repair_start_date, problem_description, repair_description, cost_final_to_pay, cost_used_parts, cost_employee_hourly_rate, repair_time_in_hours, employee_id, vehicle_id, status_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_ORDER_QUERY = "UPDATE orders SET acceptance_date=?, planned_repair_start_date=?, actual_repair_start_date=?, problem_description=?, repair_description=?, cost_final_to_pay=?, cost_used_parts=?, cost_employee_hourly_rate=?, repair_time_in_hours=?, employee_id=?, vehicle_id=?, status_id=? WHERE id = ?;";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?;";
    private static final String GET_ALL_ORDERS_QUERY = "SELECT * FROM orders ORDER BY id DESC;";
    private static final String GET_ALL_ACTIVE_ORDERS_QUERY = "SELECT * FROM orders WHERE status_id=3 ORDER BY employee_id ASC;";
    private static final String GET_ORDER_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?;";
    private static final String GET_ACTIVE_ORDERS_BY_EMPLOYEE_ID = "SELECT * FROM orders WHERE employee_id = ? AND status_id=3;";
    private static final String GET_ORDERS_BY_CUSTOMER_ID = "SELECT * FROM orders JOIN vehicles ON orders.vehicle_id = vehicles.id WHERE vehicles.customer_id = ?;";
    private static final String GET_ORDERS_BY_VEHICLE_ID = "SELECT * FROM orders WHERE vehicle_id = ?;";
    private static final String GET_NUMBER_OF_HOURS_BY_EMPLOYEE_ID = "SELECT SUM(repair_time_in_hours) AS hours FROM orders WHERE actual_repair_start_date BETWEEN ? AND ? AND employee_id = ?;";
    private static final String GET_INCOME_IN_SPECIFIC_PERIOD = "SELECT SUM(cost_final_to_pay) AS income FROM orders WHERE actual_repair_start_date BETWEEN ? AND ?;";
    private static final String GET_MATERIALS_COST_IN_SPECIFIC_PERIOD = "SELECT SUM(cost_used_parts) AS cost_materials FROM orders WHERE actual_repair_start_date BETWEEN ? AND ?;";


    public Order createOrder(Order order) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ORDER_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            getOrderValues(order, statement);
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    order.setId(generatedKeys.getInt(1));
                    return order;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateOrder(Order order) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_QUERY)) {
            statement.setInt(13, order.getId());
            getOrderValues(order, statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_QUERY)) {
            statement.setInt(1, order.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order getOrderById(int orderId) {
        Order order = new Order();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ORDER_BY_ID_QUERY)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    setOrderValues(resultSet, order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ORDERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                setOrderValues(resultSet, order);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getAllActiveOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_ACTIVE_ORDERS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                setOrderValues(resultSet, order);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getActiveOrdersByEmployeeId(int employeeId) {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ACTIVE_ORDERS_BY_EMPLOYEE_ID)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    setOrderValues(resultSet, order);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ORDERS_BY_CUSTOMER_ID)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    setOrderValues(resultSet, order);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getOrdersByVehicleId(int vehicleId) {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ORDERS_BY_VEHICLE_ID)) {
            statement.setInt(1, vehicleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    setOrderValues(resultSet, order);
                    orderList.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    private void getOrderValues(Order order, PreparedStatement statement) throws SQLException {
        statement.setDate(1, order.getAcceptanceDate());
        statement.setDate(2, order.getPlannedRepairStartDate());
        statement.setDate(3, order.getActualRepairStartDate());
        statement.setString(4, order.getProblemDescription());
        statement.setString(5, order.getRepairDescription());
        statement.setDouble(6, order.getCostFinalToPay());
        statement.setDouble(7, order.getCostUsedParts());
        statement.setDouble(8, order.getCostEmployeeHourlyRate());
        statement.setDouble(9, order.getRepairTimeInHours());
        statement.setInt(10, order.getAssignedEmployee().getId());
        statement.setInt(11, order.getRepairedVehicle().getId());
        statement.setInt(12, order.getRepairStatus().getId());
    }

    private void setOrderValues(ResultSet resultSet, Order order) throws SQLException {
        order.setId(resultSet.getInt("id"));
        order.setAcceptanceDate(resultSet.getDate("acceptance_date"));
        order.setPlannedRepairStartDate(resultSet.getDate("planned_repair_start_date"));
        order.setActualRepairStartDate(resultSet.getDate("actual_repair_start_date"));
        order.setProblemDescription(resultSet.getString("problem_description"));
        order.setRepairDescription(resultSet.getString("repair_description"));
        order.setCostFinalToPay(resultSet.getDouble("cost_final_to_pay"));
        order.setCostUsedParts(resultSet.getDouble("cost_used_parts"));
        order.setCostEmployeeHourlyRate(resultSet.getDouble("cost_employee_hourly_rate"));
        order.setRepairTimeInHours(resultSet.getDouble("repair_time_in_hours"));
        order.setAssignedEmployeeById(resultSet.getInt("employee_id"));
        order.setRepairedVehicleById(resultSet.getInt("vehicle_id"));
        order.setRepairStatusById(resultSet.getInt("status_id"));
    }

    public Double getNumberOfHoursByEmployeeId(int employeeId, Date start, Date end) {
        Double numberOfHours = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_NUMBER_OF_HOURS_BY_EMPLOYEE_ID)) {
            statement.setDate(1, start);
            statement.setDate(2, end);
            statement.setInt(3, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfHours = resultSet.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfHours;
    }

    public Double getIncomeForSpecificPeriod(Date start, Date end) {
        Double income = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_INCOME_IN_SPECIFIC_PERIOD)) {
            statement.setDate(1, start);
            statement.setDate(2, end);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    income = resultSet.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return income;
    }

    public Double getMaterialsCostForSpecificPeriod(Date start, Date end) {
        Double cost = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_MATERIALS_COST_IN_SPECIFIC_PERIOD)) {
            statement.setDate(1, start);
            statement.setDate(2, end);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cost = resultSet.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }

}