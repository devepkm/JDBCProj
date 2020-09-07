package com.devepkm.bean;

import java.sql.Date;

public class StudentResult {
    private String hkid;
    private String name;
    private Date birth;
    private String admissionID;
    private String chinese;
    private String english;
    private String maths;
    private String liberalStudies;

    @Override
    public String toString() {
        return "StudentResult{" +
                "hkid='" + hkid + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", admissionID='" + admissionID + '\'' +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", maths='" + maths + '\'' +
                ", liberalStudies='" + liberalStudies + '\'' +
                '}';
    }
}