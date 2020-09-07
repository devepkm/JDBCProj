package com.devepkm.bean;


// Bean obj for reflection
// Bean obj: empty constructor, getter, setter
// optional: toString
public class Result {
    private String hkid;
    private String chinese;
    private String english;
    private String maths;
    private String liberalStudies;

    public Result() {
    }

    public Result(String hkid, String chinese, String english, String maths, String liberalStudies) {
        this.hkid = hkid;
        this.chinese = chinese;
        this.english = english;
        this.maths = maths;
        this.liberalStudies = liberalStudies;
    }

    public String getHkid() {
        return hkid;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public String getLiberalStudies() {
        return liberalStudies;
    }

    public void setLiberalStudies(String liberalStudies) {
        this.liberalStudies = liberalStudies;
    }

    @Override
    public String toString() {
        return "Result{" +
                "hkid='" + hkid + '\'' +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", maths='" + maths + '\'' +
                ", liberalStudies='" + liberalStudies + '\'' +
                '}';
    }
}
