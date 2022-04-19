package com.una.api.services;

import com.una.api.models.Professor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService extends Service implements IService<Professor> {

    @Override
    public List<Professor> getAll() {
        connect();

        List<Professor> collection = new ArrayList<>();
        Professor professor;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from profesores");
            while(rs.next()) {
                professor = build(rs);
                collection.add(professor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Professor get(int id) {
        connect();

        Professor professor = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from profesores where idprofesores = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                professor = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return professor;
    }

    @Override
    public void post(Professor obj) {

    }

    @Override
    public void put(Professor obj) {
    }

    private Professor build(ResultSet rs) throws SQLException {
        return new Professor(
                rs.getInt("idprofesores"),
                rs.getString("nombre_profe"),
                rs.getString("email_profe"),
                rs.getString("telefono_profe"),
                rs.getString("password_profe"));
    }
}
