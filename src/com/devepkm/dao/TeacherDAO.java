package com.devepkm.dao;

import com.devepkm.bean.Teacher;

import java.sql.Connection;

public interface TeacherDAO {
    boolean verifyTeacher(Connection conn, Class<Teacher> clazz, String sql, Object... args);
}
