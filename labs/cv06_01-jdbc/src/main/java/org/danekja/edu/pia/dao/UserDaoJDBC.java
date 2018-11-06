package org.danekja.edu.pia.dao;

import org.danekja.edu.pia.domain.User;

import java.sql.*;

public class UserDaoJDBC implements UserDao {

    private static final String SQL_INSERT = "INSERT INTO danekja_user (username, password) VALUES (?, ?)";
    public static final String SQL_FIND_BY_USERNAME = "SELECT * FROM danekja_user WHERE username = ?";

    private String jdbcUrl;
    private String jdbcUser;
    private String jdbcPassword;

    public UserDaoJDBC(String jdbcUrl, String user, String password) {
        this.jdbcUrl = jdbcUrl;
        this.jdbcUser = user;
        this.jdbcPassword = password;
    }

    @Override
    public User save(User value) {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             PreparedStatement pstm = conn.prepareStatement(SQL_INSERT)){

            pstm.setString(1, value.getUsername());
            pstm.setString(2, value.getPassword());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return value;
    }

    @Override
    public User findOne(Long id) {
        throw new UnsupportedOperationException("Database schema does not support this operation!");
    }

    @Override
    public void remove(User toRemove) {
        throw new UnsupportedOperationException("We do not need to implement this method in this lab!");
    }

    @Override
    public User findByUsername(String username) {
        User user = null;

        try {
            //TODO implement this
            user = mapResult(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User mapResult(ResultSet resultSet) throws SQLException {
        if(resultSet == null) {
            return null;
        }

        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new User(username, password);
    }


}
