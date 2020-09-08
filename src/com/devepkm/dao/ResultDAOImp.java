package com.devepkm.dao;


import com.devepkm.bean.Result;

import java.sql.Connection;

public class ResultDAOImp extends DAO<Result> implements ResultDAO {


    @Override
    public Result getResult(Connection conn, String sql, Object... args) {


        return getInstance(conn, sql, args);
    }

    @Override
    public void modifyResult(Connection conn, String hkid, Result rs) {
        String sql = "UPDATE result SET chinese = ?, english = ?, maths = ?, LiberalStudies = ?  WHERE hkid = ?;";
        Object[] args = new Object[5];
        args[0] = rs.getChinese();
        args[1] = rs.getEnglish();
        args[2] = rs.getMaths();
        args[3] = rs.getLiberalStudies();
        args[4] = hkid;
        update(conn, sql, args);

    }


}


