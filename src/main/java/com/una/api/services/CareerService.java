package com.una.api.services;

import com.una.api.models.Career;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CareerService extends Service implements IService<Career> {

    @Override
    public List<Career> getAll() {
        connect();

        List<Career> collection = new ArrayList<>();
        Career career;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from carrera");
            while(rs.next()) {
                career = build(rs);
                collection.add(career);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Career get(int id) {
        connect();

        Career career = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from carrera where idcarrera = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                career = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return career;
    }

    @Override
    public void post(Career obj) {

    }

    @Override
    public void put(Career obj) {
    }

    private Career build(ResultSet rs) throws SQLException {
        return new Career(
                rs.getInt("idcarrera"),
                rs.getString("nombre"),
                rs.getString("titulo"));
    }
}
