package com.devepkm.dao;


import com.devepkm.bean.Result;


import java.sql.Connection;

public interface ResultDAO {
    Result getResult(Connection conn, String sql, Object... args);
    void modifyResult(Connection conn, String hkid, Result rs);
}
