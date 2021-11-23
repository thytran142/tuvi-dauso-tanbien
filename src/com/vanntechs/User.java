package com.vanntechs;

public class User {
    private String name;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private TuVi can;
    private TuVi chi;
    private String hourOfBirth;
    private String tuoiAmHayDuong;
    private String gender;
    private String menh;

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

    public TuVi getCan() {
        return can;
    }

    public void setCan(TuVi can) {
        this.can = can;
    }

    public TuVi getChi() {
        return chi;
    }

    public void setChi(TuVi chi) {
        this.chi = chi;
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

    public String getMenh() {
        return menh;
    }

    public void setMenh(String menh) {
        this.menh = menh;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                ", can='" + can.toString() + '\'' +
                ", chi='" + chi.toString() + '\'' +
                ", hourOfBirth='" + hourOfBirth + '\'' +
                ", tuoiAmHayDuong='" + tuoiAmHayDuong + '\'' +
                ", gender='" + gender + '\'' +
                ", menh='" + menh + '\'' +
                '}';
    }
}
