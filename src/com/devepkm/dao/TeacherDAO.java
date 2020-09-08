package com.devepkm.dao;

import com.devepkm.bean.Teacher;

import java.sql.Connection;

public interface TeacherDAO {
    boolean verifyTeacher(Connection conn, String sql, Object... args);
}
