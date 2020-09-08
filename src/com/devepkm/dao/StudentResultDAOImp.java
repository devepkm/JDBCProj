package com.devepkm.dao;

import com.devepkm.bean.StudentResult;

import java.sql.Connection;
import java.util.List;

public class StudentResultDAOImp extends DAO{
    public List<StudentResult> getAllResult(Connection conn){
        String sql = "select student.HKID hkid, Name name, Birth birth, AdmissionID admissionID, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from student, result where student.HKID = result.HKID";
        return getInstanceList(conn, StudentResult.class, sql, null);
    }
}
