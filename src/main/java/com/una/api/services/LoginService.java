package com.una.api.services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import oracle.jdbc.internal.OracleTypes;

public class LoginService extends Service {

    private static final String login = "{? = call login(?, ?)}";

    public boolean login(String user, String password) {
        boolean valid = false;
        connect();

        try {
            CallableStatement stmt = connection.prepareCall(login);
            //stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setString(2, user);
            stmt.setString(3, password);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(1);

            int reply = 0;
            while (rs.next()) {
                reply = rs.getInt("esta");
            }
            valid = reply != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return valid;
    }
}
