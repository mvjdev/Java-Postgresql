package org.example.repository;

import org.example.DBConnector.DbConnector;
import org.example.model.AuthorModel;
import org.example.model.SubscriberModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<SubscriberModel> {
    private final Connection connection;

    public SubscriberCrudOperations() {
        this.connection = DbConnector.getConnection();
    }

    private ResultSet statementFinding(String sql) throws SQLException {
        assert this.connection != null;
        PreparedStatement statement = this.connection.prepareStatement(sql);
        return statement.executeQuery();
    }
    @Override
    public List<SubscriberModel> findAll() {
        List<SubscriberModel> subscribers = new ArrayList<>();
        String sql = "SELECT * FROM subscriber";

        try {
            ResultSet resultSet = statementFinding(sql);
            while (resultSet.next()) {
                SubscriberModel subscriber = new SubscriberModel();
                subscriber.setSubscriberId(resultSet.getInt("subscriber_id"));
                subscriber.setSubscriberName(resultSet.getString("subscriber_name"));
                subscriber.setSubscriberReference(resultSet.getString("subscriber_reference"));
                subscriber.setBorrow(resultSet.getBoolean("borrow"));
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public SubscriberModel save(SubscriberModel toSave) {
        String sql = "INSERT INTO subscriber (subscriber_name, subscriber_reference, borrow) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, toSave.getSubscriberName());
            statement.setString(2, toSave.getSubscriberReference());
            statement.setBoolean(3, toSave.isBorrow());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setSubscriberId(generatedKeys.getInt(1));
                    return toSave;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AuthorModel save(AuthorModel toSave) {
        return null;
    }

    @Override
    public List<SubscriberModel> saveAll(List<SubscriberModel> toSave) {
        List<SubscriberModel> savedSubscribers = new ArrayList<>();
        String sql = "INSERT INTO subscriber (subscriber_name, subscriber_reference, borrow) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (SubscriberModel subscriber : toSave) {
                statement.setString(1, subscriber.getSubscriberName());
                statement.setString(2, subscriber.getSubscriberReference());
                statement.setBoolean(3, subscriber.isBorrow());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        subscriber.setSubscriberId(generatedKeys.getInt(1));
                        savedSubscribers.add(subscriber);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedSubscribers;
    }

    @Override
    public SubscriberModel delete(SubscriberModel toDelete) {
        String sql = "DELETE FROM subscriber WHERE subscriber_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, toDelete.getSubscriberId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return toDelete;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}