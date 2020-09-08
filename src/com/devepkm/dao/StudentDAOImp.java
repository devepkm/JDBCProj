package com.devepkm.dao;



import com.devepkm.bean.Student;

import java.sql.Connection;
import java.util.List;

public class StudentDAOImp extends DAO implements StudentDAO {


    @Override
    public boolean verify(Connection conn, Class<Student> clazz, String sql, Object... args) {
        Student instance = getInstance(conn, clazz, sql, args);
        return (instance == null) ? false : true;
    }

    @Override
    public List<Student> getAllStudent(Connection conn, Class<Student> clazz) {
        String sql = "select HKID hkid, Name name, Birth birth, AdmissionID admissionID  from student";
        return getInstanceList(conn,clazz,sql,null);
    }
}
