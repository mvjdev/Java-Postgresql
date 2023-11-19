package org.example.repository;

import org.example.model.AuthorModel;
import org.example.DBConnector.DbConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<AuthorModel> {
    private final Connection connection = DbConnector.getConnection();

    @Override
    public AuthorModel save(AuthorModel value) {
        String sql = "INSERT INTO author (author_name, gender_author) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, value.getAuthorName());
            statement.setString(2, String.valueOf(value.getGenderAuthor()));

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating author failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    value.setAuthorId(generatedKeys.getInt(1));
                    return value;
                } else {
                    throw new SQLException("Creating author failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AuthorModel> saveAll(List<AuthorModel> values) {
        List<AuthorModel> authorList = new ArrayList<>();
        for (AuthorModel author : values) {
            AuthorModel saved = save(author);
            if (saved != null) {
                authorList.add(saved);
            }
        }
        return authorList;
    }

    @Override
    public List<AuthorModel> findAll() {
        List<AuthorModel> authors = new ArrayList<>();
        String sql = "SELECT * FROM author";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                AuthorModel author = new AuthorModel();
                author.setAuthorId(result.getInt("author_id"));
                author.setAuthorName(result.getString("author_name"));
                author.setGenderAuthor(result.getString("gender_author").charAt(0));
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public AuthorModel delete(AuthorModel value) {
        String sql = "DELETE FROM author WHERE author_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, value.getAuthorId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 1) {
                return value;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

