package com.una.api.services;

import com.una.api.models.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupService extends Service implements IService<Group> {

    @Override
    public List<Group> getAll() {
        connect();

        List<Group> collection = new ArrayList<>();
        Group group;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from grupos");
            while(rs.next()) {
                group = build(rs);
                collection.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return collection;
    }

    @Override
    public Group get(int id) {
        connect();

        Group group = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from grupos where idgrupos = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                group = build(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
        return group;
    }

    @Override
    public void post(Group obj) {
        connect();

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into grupos (idgrupos, id_profe, horario, ciclo_idciclo, curso_idcurso) " +
                            "values (?, ?, ?, ?, ?)");
            stmt.setInt(1, obj.getId());
            stmt.setInt(2, obj.getProfessor());
            stmt.setString(3, obj.getSchedule());
            stmt.setInt(4, obj.getCycle());
            stmt.setInt(5, obj.getCourse());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    @Override
    public void put(Group obj) {
        connect();

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "update grupos " +
                            "set id_profe = ?, horario = ?, ciclo_idciclo = ?, curso_idcurso = ? " +
                            "where idgrupos = ?");
            stmt.setInt(1, obj.getProfessor());
            stmt.setString(2, obj.getSchedule());
            stmt.setInt(3, obj.getCycle());
            stmt.setInt(4, obj.getCourse());
            stmt.setInt(5, obj.getId());
            int rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    private Group build(ResultSet rs) throws SQLException {
        return new Group(
                rs.getInt("idgrupos"),
                rs.getInt("id_profe"),
                rs.getString("horario"),
                rs.getInt("ciclo_idciclo"),
                rs.getInt("curso_idcurso"));
    }
}
