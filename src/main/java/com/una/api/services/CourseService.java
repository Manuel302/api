package com.una.api.services;

import com.una.api.models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseService extends Service implements IService<Course> {

    @Override
    public List<Course> getAll() {
        connect();

        List<Course> collection = new ArrayList<>();
        Course course;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from curso");
            while(rs.next()) {
                course = new Course(
                        rs.getString("nombrecurso"),
                        rs.getInt("creditos"),
                        rs.getInt("horas_semanales"),
                        rs.getString("idcurso"),
                        rs.getInt("carrera_idcarrera"),
                        rs.getInt("anio_deseado"),
                        rs.getString("ciclo_deseado"));
                collection.add(course);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Course get(Long id) {
        connect();

        Course course = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from curso where idcurso = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                course = new Course(
                        rs.getString("nombrecurso"),
                        rs.getInt("creditos"),
                        rs.getInt("horas_semanales"),
                        rs.getString("idcurso"),
                        rs.getInt("careaa_idcarrera"),
                        rs.getInt("anio_deseado"),
                        rs.getString("ciclo_deseado"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return course;
    }
}
