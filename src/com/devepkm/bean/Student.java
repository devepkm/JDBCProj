package com.devepkm.bean;



import java.sql.Date;

// Bean obj for reflection
// Bean obj: empty constructor, getter, setter
//optional: toString
public class Student {

    private String hkid;
    private String name;
    private Date birth;
    private String admissionID;

    public Student() {
    }

    public Student(String hkid, String name, Date birth, String admissionID) {
        this.hkid = hkid;
        this.name = name;
        this.birth = birth;
        this.admissionID = admissionID;
    }

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(String admissionID) {
        this.admissionID = admissionID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "hkid='" + hkid + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", admissionID='" + admissionID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return hkid.equals(student.hkid) &&
                name.equals(student.name) &&
                birth.equals(student.birth) &&
                admissionID.equals(student.admissionID);
    }


}
