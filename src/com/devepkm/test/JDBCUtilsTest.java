package com.devepkm.test;

import com.devepkm.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class JDBCUtilsTest {

    @org.junit.Test
    public void getConnection() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.closeResource(conn, null, null);
        System.out.println(conn.isClosed());
    }


}