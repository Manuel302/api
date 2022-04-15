package com.una.api.services;

import com.una.api.models.Cycle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CycleService extends Service implements IService<Cycle> {

    @Override
    public List<Cycle> getAll() {
        connect();

        List<Cycle> collection = new ArrayList<>();
        Cycle cycle;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ciclo");
            while(rs.next()) {
                cycle = build(rs);
                collection.add(cycle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Cycle get(int id) {
        connect();

        Cycle cycle = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from ciclo where idciclo = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                cycle = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return cycle;
    }
    
    private Cycle build(ResultSet rs) throws SQLException {
        return new Cycle(
                rs.getInt("idciclo"),
                rs.getInt("anio"),
                rs.getInt("numero"),
                rs.getDate("fecha_inicio"),
                rs.getDate("fecha_fin"));
    }
}
