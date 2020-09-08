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


    public void main(String[] args) {
        run();

    }

    private void run() {
        Connection conn = JDBCUtils.getConnection();


        while (true) {

            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");
            int i = KeyboardUtils.selectUser();

            if (i == 1) {
                verifyStudent(conn);
            } else if (i == 2) {
                boolean verifyTeacher = verifyTeacher(conn);
                if (verifyTeacher) {
                    System.out.println("1. Get all Students Information");
                    System.out.println("2. Get all Students's result");
                    System.out.println("3. modify student information");
                    System.out.println("4. modify student's result");
                    int option = KeyboardUtils.readOption();
                    switch (option) {
                        case 1:
                            getAllStudents(conn);
                            break;
                        case 2:
                            getAllStudentResults(conn);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                }
            } else {
                break;
            }
        }
        JDBCUtils.closeResource(conn, null, null);



    }

    private void getAllStudentResults(Connection conn) {
        StudentResultDAOImp resultDAO = new StudentResultDAOImp();
        List<StudentResult> allResult = resultDAO.getAllResult(conn);
        for (StudentResult s : allResult){
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


    public void verifyStudent(Connection conn) {
        Object[] stdInfo = getStdInfo();
        if (stdInfo != null) {
            StudentDAOImp stdImp = new StudentDAOImp();
            String sql = "SELECT HKID hkid, Name name, Birth birth, AdmissionID admissionID FROM student WHERE HKID = ? AND Name = ? AND Birth = ? AND AdmissionID = ?";
            boolean verify = stdImp.verify(conn, Student.class, sql, stdInfo);
            if (verify) {
                Result rs = getStdResult(conn, (String) stdInfo[0]);
                System.out.println(rs);

            } else {
                printError();
            }

        } else {
            printError();

        }
    }

    private Object[] getStdInfo() {
        Object[] objs = new Object[4];
        System.out.println("Enter HKID: ");
        String hkid = KeyboardUtils.readString();
        objs[0] = hkid;
        System.out.println("Enter Name: ");
        String name = KeyboardUtils.readString();
        objs[1] = name;
        System.out.println("Enter Date of birth(YYYY-MM-DD): ");
        String dob = KeyboardUtils.readString();
        try {
            objs[2] = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        } catch (ParseException e) {
            return null;
        }
        System.out.println("Enter admissionID: ");
        String admissionID = KeyboardUtils.readString();
        objs[3] = admissionID;

        return objs;
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
