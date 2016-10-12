package com.lsh.test;

/**
 * Created by LSH on 2016/10/12.
 */

public class Cinema {

    private String name;
    private String address;
    private String grade;
    private String screenings;

    public String getScreenings() {
        return screenings;
    }

    public void setScreenings(String screenings) {
        this.screenings = screenings;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Cinema() {
    }

    public Cinema(String name, String address, String grade, String screenings) {
        this.name = name;
        this.address = address;
        this.grade = grade;
        this.screenings = screenings;
    }
}
