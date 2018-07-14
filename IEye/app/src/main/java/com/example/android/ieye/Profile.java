package com.example.android.ieye;

public class Profile
{
    private int id;
    private String first_name;
    private String last_name;
    private String month;
    private String year;
    private String day;

    private String email;
    private String phone_no;
    private String work_no;

    private String add_lane_1;
    private String add_lane_2;
    private String country;
    private String state;
    private String pin_code;

    public Profile(int id, String first_name, String last_name, String month, String year, String day,
                   String email, String phone_no, String work_no,
                   String add_lane_1, String add_lane_2, String country, String state, String pin_code) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.month = month;
        this.year = year;
        this.day = day;
        this.email = email;
        this.phone_no = phone_no;
        this.work_no = work_no;
        this.add_lane_1 = add_lane_1;
        this.add_lane_2 = add_lane_2;
        this.country = country;
        this.state = state;
        this.pin_code = pin_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getWork_no() {
        return work_no;
    }

    public void setWork_no(String work_no) {
        this.work_no = work_no;
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

