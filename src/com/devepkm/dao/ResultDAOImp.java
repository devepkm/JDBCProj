package com.devepkm.dao;


import com.devepkm.bean.Result;

import java.sql.Connection;
import java.util.List;


import java.sql.Connection;
import java.util.List;

public class ResultDAOImp extends DAO implements ResultDAO{


    @Override
    public Result getResult(Connection conn, Class<Result> clazz, String sql, Object... args) {


        return getInstance(conn, clazz, sql, args);
    }



}