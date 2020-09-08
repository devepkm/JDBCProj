package com.devepkm.dao;



import com.devepkm.bean.Student;

import java.sql.Connection;
import java.util.List;

public class StudentDAOImp extends DAO<Student> implements StudentDAO {


    @Override
    public boolean verify(Connection conn, String sql, Student s) {
        Object[] args = new Object[4];
        args[0] = s.getHkid();
        args[1] = s.getName();
        args[2] = s.getBirth();
        args[3] = s.getAdmissionID();
        Student instance = getInstance(conn, sql, args);
        return (instance == null) ? false : true;
    }

    @Override
    public List<Student> getAllStudent(Connection conn) {
        String sql = "select HKID hkid, Name name, Birth birth, AdmissionID admissionID  from student";
        return getInstanceList(conn,sql,null);
    }
}
