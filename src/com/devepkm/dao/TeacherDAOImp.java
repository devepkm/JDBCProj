package com.devepkm.dao;




import com.devepkm.bean.Teacher;

import java.sql.Connection;

public class TeacherDAOImp extends DAO implements TeacherDAO {

    @Override
    public boolean verifyTeacher(Connection conn, Class<Teacher> clazz, String sql, Object... args) {


        Teacher tinstance = getInstance(conn, Teacher.class, sql, args);

        return (tinstance == null) ? false : true;
    }
}
