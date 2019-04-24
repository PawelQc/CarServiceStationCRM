package pl.qceyco.dao;

import pl.qceyco.model.Order;
import pl.qceyco.model.Vehicle;
import pl.qceyco.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private static final String CREATE_VEHICLE_QUERY = "INSERT INTO vehicles(model, brand, production_year, registration_number, next_review_date, customer_id) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE_VEHICLE_QUERY = "UPDATE vehicles SET model=?, brand=?, production_year=?, registration_number=?, next_review_date=?, customer_id=? WHERE id = ?;";
    private static final String DELETE_VEHICLE_QUERY = "DELETE FROM vehicles WHERE id = ?;";
    private static final String GET_ALL_VEHICLES_QUERY = "SELECT * FROM vehicles;";
    private static final String GET_VEHICLE_BY_ID_QUERY = "SELECT * FROM vehicles WHERE id = ?;";
    private static final String GET_VEHICLES_BY_CUSTOMER_ID_QUERY = "SELECT * FROM vehicles WHERE customer_id = ?;";

    public Vehicle createVehicle(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_VEHICLE_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getRegistrationNumber());
            statement.setDate(5, vehicle.getNextReviewDate());
            statement.setInt(6, vehicle.getCustomer().getId());
            int result = statement.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    vehicle.setId(generatedKeys.getInt(1));
                    return vehicle;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVehicle(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_VEHICLE_QUERY)) {
            statement.setInt(7, vehicle.getId());
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getProductionYear());
            statement.setString(4, vehicle.getRegistrationNumber());
            statement.setDate(5, vehicle.getNextReviewDate());
            statement.setInt(6, vehicle.getCustomer().getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(Vehicle vehicle) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLE_QUERY)) {
            statement.setInt(1, vehicle.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vehicle getVehicleById(int vehicleId) {
        Vehicle vehicle = new Vehicle();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_VEHICLE_BY_ID_QUERY)) {
            statement.setInt(1, vehicleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    vehicle.setId(resultSet.getInt("id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setProductionYear(resultSet.getInt("production_year"));
                    vehicle.setRegistrationNumber(resultSet.getString("registration_number"));
                    vehicle.setNextReviewDate(resultSet.getDate("next_review_date"));
                    vehicle.setCustomerById(resultSet.getInt("customer_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_VEHICLES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setProductionYear(resultSet.getInt("production_year"));
                vehicle.setRegistrationNumber(resultSet.getString("registration_number"));
                vehicle.setNextReviewDate(resultSet.getDate("next_review_date"));
                vehicle.setCustomerById(resultSet.getInt("customer_id"));
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByCustomerId(int customerId) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_VEHICLES_BY_CUSTOMER_ID_QUERY)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(resultSet.getInt("id"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setBrand(resultSet.getString("brand"));
                    vehicle.setProductionYear(resultSet.getInt("production_year"));
                    vehicle.setRegistrationNumber(resultSet.getString("registration_number"));
                    vehicle.setNextReviewDate(resultSet.getDate("next_review_date"));
                    vehicle.setCustomerById(resultSet.getInt("customer_id"));
                    vehicleList.add(vehicle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicleList;
    }



}
