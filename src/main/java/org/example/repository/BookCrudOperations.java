package org.example.repository;

import org.example.DBConnector.DbConnector;
import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.model.Topic.COMEDY;

public  class BookCrudOperations implements CrudOperations<BookModel> {
    private final Connection connection;

    public BookCrudOperations() {
        this.connection = DbConnector.getConnection();
    }

    private ResultSet statementFinding(String sql) throws SQLException {
        assert this.connection != null;
        PreparedStatement statement = this.connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    @Override
    public List<BookModel> findAll() {
        List<BookModel> books = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (ResultSet resultSet = statementFinding(sql)) {
            while (resultSet.next()) {
                BookModel book = new BookModel();
                book.setId(resultSet.getInt("id"));
                book.setBookId(resultSet.getString("book_id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setTopic(Topic.valueOf(resultSet.getString("topic")));
                book.setPageNumber(resultSet.getInt("page_number"));
                book.setReleaseDate(resultSet.getDate("release_date").toLocalDate());
                book.setAuthorId(resultSet.getInt("author_id"));
                book.setBorrow(resultSet.getBoolean("is_borrow"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    @Override
    public BookModel save(BookModel toSave) {
        String sql = "INSERT INTO book (book_id, book_name, topic, page_number, release_date, author_id, is_borrow) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, toSave.getBookId());
            statement.setString(2, toSave.getBookName());
            statement.setString(3, toSave.getTopic().name().toString());
            statement.setInt(4, toSave.getPageNumber());
            statement.setDate(5, Date.valueOf(toSave.getReleaseDate()));
            statement.setInt(6, toSave.getAuthorId());
            statement.setBoolean(7, toSave.isBorrow());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    toSave.setId(generatedKeys.getInt(1));
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
    public List<BookModel> saveAll(List<BookModel> toSave) {
        List<BookModel> savedBooks = new ArrayList<>();
        String sql = "INSERT INTO book (book_id, book_name, topic, page_number, release_date, author_id, is_borrow) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (BookModel book : toSave) {
                statement.setString(1, book.getBookId());
                statement.setString(2, book.getBookName());
                statement.setString(3, book.getTopic().name());
                statement.setInt(4, book.getPageNumber());
                statement.setDate(5, Date.valueOf(book.getReleaseDate()));
                statement.setInt(6, book.getAuthorId());
                statement.setBoolean(7, book.isBorrow());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        book.setId(generatedKeys.getInt(1));
                        savedBooks.add(book);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedBooks;
    }


    @Override
    public BookModel delete(BookModel toDelete) {
        String sql = "DELETE FROM book WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, toDelete.getId());

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
