package pl.qceyco.dao;

import pl.qceyco.model.Status;
import pl.qceyco.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    private static final String GET_ALL_STATUS_QUERY = "SELECT * FROM status;";
    private static final String GET_STATUS_BY_ID_QUERY = "SELECT * FROM status WHERE id=?;";

    public List<Status> getAllStatus() {
        List<Status> statusList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_STATUS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setName(resultSet.getString("name"));
                status.setStatusOrder(resultSet.getInt("status_order"));
                statusList.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusList;
    }

    public Status getStatusById(int statusId) {
        Status status = new Status();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_STATUS_BY_ID_QUERY)) {
            statement.setInt(1, statusId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    status.setId(resultSet.getInt("id"));
                    status.setName(resultSet.getString("name"));
                    status.setStatusOrder(resultSet.getInt("status_order"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}

