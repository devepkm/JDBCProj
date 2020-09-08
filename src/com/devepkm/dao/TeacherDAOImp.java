package com.devepkm.dao;




import com.devepkm.bean.Teacher;

import java.sql.Connection;

public class TeacherDAOImp extends DAO<Teacher> implements TeacherDAO {

    @Override
    public boolean verifyTeacher(Connection conn, String sql, Object... args) {


        Teacher tinstance = getInstance(conn, sql, args);

        return (tinstance == null) ? false : true;
    }
}
