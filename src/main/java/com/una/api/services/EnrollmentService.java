package com.una.api.services;

import com.una.api.models.Enrollment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService extends Service implements IService<Enrollment> {

    @Override
    public List<Enrollment> getAll() {
        connect();

        List<Enrollment> collection = new ArrayList<>();
        Enrollment enrollment;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from matriculados");
            while(rs.next()) {
                enrollment = build(rs);
                collection.add(enrollment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Enrollment get(int id) {
        return null;
    }

    public Enrollment get(int groupId, int studentId) {
        connect();

        Enrollment enrollment = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from matriculados " +
                    "where grupos_idgrupos = ? and estudiantes_idestudiante = ?");
            stmt.setInt(1, groupId);
            stmt.setInt(2, studentId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                enrollment = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return enrollment;
    }

    @Override
    public void post(Enrollment obj) {
        connect();

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into matriculados (grupos_idgrupos, estudiantes_idestudiante, nota) " +
                            "values (?, ?, ?)");
            stmt.setInt(1, obj.getGroup());
            stmt.setInt(2, obj.getStudent());
            stmt.setString(3, obj.getNote());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    @Override
    public void put(Enrollment obj) {
        connect();

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "update matriculados " +
                            "set nota = ? " +
                            "where grupos_idgrupos = ? and estudiantes_idestudiante = ?");
            stmt.setString(1, obj.getNote());
            stmt.setInt(2, obj.getGroup());
            stmt.setInt(3, obj.getStudent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    public void delete(int groupId, int studentId) {
        connect();

        try {
            PreparedStatement stmt = connection.prepareStatement("delete from matriculados " +
                    "where grupos_idgrupos = ? and estudiantes_idestudiante = ?");
            stmt.setInt(1, groupId);
            stmt.setInt(2, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    private Enrollment build(ResultSet rs) throws SQLException {
        return new Enrollment(
                rs.getInt("grupos_idgrupos"),
                rs.getInt("estudiantes_idestudiante"),
                rs.getString("nota"));
    }
}
