package com.devepkm.dao;

import com.devepkm.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO {

    public static int update(Connection conn, String sql, Object... args) {

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, null);
        }

        return 0;
    }


    public static <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();

            if (rs.next()) {

                // get meta data for putting result to orm class
                ResultSetMetaData mDate = rs.getMetaData();
                int count = mDate.getColumnCount();
                T t = clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    Object value = rs.getObject(i + 1);
                    String label = mDate.getColumnLabel(i + 1);
                    Field f = clazz.getDeclaredField(label);
                    f.setAccessible(true);
                    f.set(t, value);

                }
                return t;

            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }


        return null;
    }

    public static <T> List<T> getInstanceList(Connection conn, Class<T> clazz, String sql, Object... args) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            List<T> tList = new ArrayList<>();

            while (rs.next()) {

                // get meta data for putting result to orm class
                ResultSetMetaData mDate = rs.getMetaData();
                int count = mDate.getColumnCount();
                T t = clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    Object value = rs.getObject(i + 1);
                    String label = mDate.getColumnLabel(i + 1);
                    Field f = clazz.getDeclaredField(label);
                    f.setAccessible(true);
                    f.set(t, value);

                }
                tList.add(t);

            }
            return tList;

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }


        return null;
    }

}
