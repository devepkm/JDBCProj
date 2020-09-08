package com.devepkm.dao;


import com.devepkm.bean.Result;


import java.sql.Connection;

public interface ResultDAO {
    Result getResult(Connection conn, Class<Result> clazz, String sql, Object... args);
}
