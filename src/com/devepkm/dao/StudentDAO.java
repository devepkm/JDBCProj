package com.devepkm.dao;



import com.devepkm.bean.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDAO {

    boolean verify(Connection conn, Class<Student> clazz, String sql, Student s);

    List<Student> getAllStudent(Connection conn, Class<Student> clazz);

}
