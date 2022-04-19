package com.una.api.services;

import com.una.api.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentService extends Service implements IService<Student> {

    @Override
    public List<Student> getAll() {
        connect();

        List<Student> collection = new ArrayList<>();
        Student student;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from estudiantes");
            while(rs.next()) {
                student = build(rs);
                collection.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Student get(int id) {
        connect();

        Student student = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from estudiantes where idestudiante = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                student = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return student;
    }

    @Override
    public void post(Student obj) {

    }

    @Override
    public void put(Student obj) {
    }

    private Student build(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("idestudiante"),
                rs.getString("password_est"),
                rs.getString("correo_estudiante"),
                rs.getString("nombre"),
                rs.getString("telefono_est"),
                rs.getInt("carrera_idcarrera"),
                rs.getDate("facha_nacimiento"));
    }
}
