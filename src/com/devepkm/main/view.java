package com.devepkm.main;

import com.devepkm.bean.Result;
import com.devepkm.bean.Student;
import com.devepkm.bean.StudentResult;
import com.devepkm.bean.Teacher;
import com.devepkm.dao.ResultDAOImp;
import com.devepkm.dao.StudentDAOImp;
import com.devepkm.dao.StudentResultDAOImp;
import com.devepkm.dao.TeacherDAOImp;
import com.devepkm.utils.JDBCUtils;
import com.devepkm.utils.KeyboardUtils;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.List;

public class view {

    static Connection conn = JDBCUtils.getConnection();


    public static void main(String[] args) {
        new view().run();

    }

    private void run() {
        Connection conn = JDBCUtils.getConnection();


        while (true) {

            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");
            int i = KeyboardUtils.selectUser();

            if (i == 1) {
                Student s = verifyStudent(conn);
                if (s != null) {
                    Result rs = getStdResult(conn, s.getHkid());
                    System.out.println(rs);
                }

            } else if (i == 2) {
                boolean verifyTeacher = verifyTeacher(conn);
                if (verifyTeacher) {
                    System.out.println("1. Get all Students Information");
                    System.out.println("2. Get all Students's result");
                    System.out.println("3. modify student's result");
                    int option = KeyboardUtils.readOption();
                    switch (option) {
                        case 1:
                            getAllStudents(conn);
                            break;
                        case 2:
                            getAllStudentResults(conn);
                            break;
                        case 3:
                            modifyStudentResult();
                            break;
                        default:
                            break;
                    }
                }
            } else {
                break;
            }
        }
        JDBCUtils.closeResource(conn, null, null);


    }

    private void modifyStudentResult() {
        Student s = verifyStudent(conn);
        if (s != null) {
            String id = s.getHkid();
            modifyResult(id);


        } else {
            printError();
        }


    }

    private void modifyResult(String hkid) {

        ResultDAOImp rsImp = new ResultDAOImp();
        Result rs = new Result();

        System.out.println("Chinese");
        rs.setChinese(String.valueOf(KeyboardUtils.readResult()));

        System.out.println("English");
        rs.setEnglish(String.valueOf(KeyboardUtils.readResult()));

        System.out.println("Maths");
        rs.setMaths(String.valueOf(KeyboardUtils.readResult()));

        System.out.println("Liberal Studies");
        rs.setLiberalStudies(String.valueOf(KeyboardUtils.readResult()));
        rsImp.modifyResult(conn,hkid,rs);

    }


    private void getAllStudentResults(Connection conn) {
        StudentResultDAOImp resultDAO = new StudentResultDAOImp();
        List<StudentResult> allResult = resultDAO.getAllResult(conn);
        for (StudentResult s : allResult) {
            System.out.println(s);
        }

    }

    private void getAllStudents(Connection conn) {
        StudentDAOImp studentDAOImp = new StudentDAOImp();
        List<Student> allStudents = studentDAOImp.getAllStudent(conn, Student.class);
        for (Student s : allStudents) {
            System.out.println(s);
        }

    }


    public Student verifyStudent(Connection conn) {
        Student stdInfo = getStdInfo();
        if (stdInfo != null) {
            StudentDAOImp stdImp = new StudentDAOImp();
            String sql = "SELECT HKID hkid, Name name, Birth birth, AdmissionID admissionID FROM student WHERE HKID = ? AND Name = ? AND Birth = ? AND AdmissionID = ?";
            boolean verify = stdImp.verify(conn, Student.class, sql, stdInfo);

            if (verify) {
                return stdInfo;

            } else {
                printError();
            }

        } else {
            printError();

        }
        return null;
    }

    private Student getStdInfo() {
        Student s = new Student();
        System.out.println("Enter HKID: ");
        String hkid = KeyboardUtils.readString();
        s.setHkid(hkid);
        System.out.println("Enter Name: ");
        String name = KeyboardUtils.readString();
        s.setName(name);
        System.out.println("Enter Date of birth(YYYY-MM-DD): ");
        String dob = KeyboardUtils.readString();
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf1.parse(dob);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            s.setBirth(sqlStartDate);
        } catch (ParseException e) {
            return null;
        }
        System.out.println("Enter admissionID: ");
        String admissionID = KeyboardUtils.readString();
        s.setAdmissionID(admissionID);

        return s;
    }

    private Result getStdResult(Connection conn, String hkid) {
        ResultDAOImp rsImp = new ResultDAOImp();
        String sql = "Select HKID hkid, Chinese chinese, English english, Maths maths, LiberalStudies liberalStudies from result where hkid = ?";
        Object[] ojs = new Object[1];
        ojs[0] = hkid;
        Result result = rsImp.getResult(conn, Result.class, sql, ojs);
        return result;
    }

    private void printError() {
        System.out.println("Invalid Input!");
        System.out.println("Try again!");
        System.out.println();
        System.out.println();
        System.out.println();

    }

    public boolean verifyTeacher(Connection conn) {
        Object[] techerInfo = getTecherInfo();
        if (techerInfo != null) {
            String sql = "SELECT ID id, Password password from teacher where id = ? AND password = ?";
            TeacherDAOImp teacherDAOImp = new TeacherDAOImp();
            boolean verifyTeacher = teacherDAOImp.verifyTeacher(conn, Teacher.class, sql, techerInfo);
            if (verifyTeacher) {
                return true;

            } else {
                printError();
            }


        } else {
            printError();

        }

        return false;


    }

    private Object[] getTecherInfo() {
        Object[] objs = new Object[2];
        System.out.println("Enter Teacher ID: ");
        String id = KeyboardUtils.readString();
        objs[0] = id;
        System.out.println("Enter password: ");
        String pass = KeyboardUtils.readString();
        objs[1] = pass;
        return objs;

    }


}
