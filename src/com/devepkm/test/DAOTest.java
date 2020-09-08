package com.devepkm.test;

import com.devepkm.bean.Result;
import com.devepkm.dao.DAO;
import com.devepkm.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class DAOTest {

    @Test
    public void update() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "UPDATE Result set `Maths` = 7 WHERE `HKID` = ?";
        Object[] args = new Object[1];
        args[0] = new String("Y583039(a)");
        DAO.update(conn, sql, args);
        JDBCUtils.closeResource(conn, null, null);


    }

    @Test
    public void getInstance() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "Select HKID hkid, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from result where `HKID` = ?";
        Object[] args = new Object[1];
        args[0] = new String("Y583039(a)");
        Result rs = new Result();

        Result instance = DAO.getInstance(conn, rs.getClass(), sql, args);
        System.out.println(instance);

        JDBCUtils.closeResource(conn, null, null);
    }

    @Test
    public void getInstanceList() {
        Connection conn = JDBCUtils.getConnection();

        String sql = "Select HKID hkid, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from result";
        Result rs = new Result();


        List<? extends Result> instanceList = DAO.getInstanceList(conn, rs.getClass(), sql, null);

        for (Result a : instanceList) {
            System.out.println(a);
        }


        JDBCUtils.closeResource(conn, null, null);

    }
}