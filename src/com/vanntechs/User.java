package com.vanntechs;

public class User {
    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String can;
    private String chi;
    private String chiOfMonth;
    private String canOfMonth;
    private String hourOfBirth;
    private String tuoiAmHayDuong;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public String getChi() {
        return chi;
    }

    public void setChi(String chi) {
        this.chi = chi;
    }

    public String getChiOfMonth() {
        return chiOfMonth;
    }

    public void setChiOfMonth(String chiOfMonth) {
        this.chiOfMonth = chiOfMonth;
    }

    public String getCanOfMonth() {
        return canOfMonth;
    }

    public void setCanOfMonth(String canOfMonth) {
        this.canOfMonth = canOfMonth;
    }

    public String getHourOfBirth() {
        return hourOfBirth;
    }

    public void setHourOfBirth(String hourOfBirth) {
        this.hourOfBirth = hourOfBirth;
    }

    public String getTuoiAmHayDuong() {
        return tuoiAmHayDuong;
    }

    public void setTuoiAmHayDuong(String tuoiAmHayDuong) {
        this.tuoiAmHayDuong = tuoiAmHayDuong;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", can='" + can + '\'' +
                ", chi='" + chi + '\'' +
                ", chiOfMonth='" + chiOfMonth + '\'' +
                ", canOfMonth='" + canOfMonth + '\'' +
                ", hourOfBirth='" + hourOfBirth + '\'' +
                ", tuoiAmHayDuong='" + tuoiAmHayDuong + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
