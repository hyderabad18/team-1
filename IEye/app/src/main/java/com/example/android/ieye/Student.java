package com.example.android.ieye;

public class Student {
    public String username,password;
    public String first_name;
    public String last_name;
    public String month;
    public String year;
    public String day;
    public String mobile;
    public String work;
    public String add_lane_1;
    public String add_lane_2;
    public String country;
    public String state;
    public String pin_code;


    public Student(String username, String password, String first_name, String last_name, String month, String year, String day,
                String mobile, String work, String add_lane_1, String add_lane_2, String country, String state, String pin_code)
    {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.month = month;
        this.year = year;
        this.day = day;
        this.mobile = mobile;
        this.work = work;
        this.add_lane_1 = add_lane_1;
        this.add_lane_2 = add_lane_2;
        this.country = country;
        this.state = state;
        this.pin_code = pin_code;
    }

    public Student()
    {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAdd_lane_1() {
        return add_lane_1;
    }

    public void setAdd_lane_1(String add_lane_1) {
        this.add_lane_1 = add_lane_1;
    }

    public String getAdd_lane_2() {
        return add_lane_2;
    }

    public void setAdd_lane_2(String add_lane_2) {
        this.add_lane_2 = add_lane_2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }
}
