package com.una.api.services;

import com.una.api.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService extends Service implements IService<User> {

    @Override
    public List<User> getAll() {
        connect();

        List<User> collection = new ArrayList<>();
        User user;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            while(rs.next()) {
                user = build(rs);
                collection.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public User get(int id) {
        connect();

        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from usuarios where idusuarios = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                user = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return user;
    }
    
    private User build(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("idusuarios"),
                rs.getInt("tipo"));
    }
}