package com.devepkm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static Connection conn;

    public static Connection getConnection() {

        if (conn == null) {
            InputStream is = null;

            try {

                is = JDBCUtils.class.getClassLoader().getResourceAsStream("com/devepkm/dbResource/config.properties");
                Properties pros = new Properties();
                pros.load(is);
                String user = pros.getProperty("user");
                String password = pros.getProperty("password");
                String url = pros.getProperty("url");
                String driverClass = pros.getProperty("driverClass");

                Class.forName(driverClass);

                conn = DriverManager.getConnection(url, user, password);

                return conn;
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        return conn;

    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
