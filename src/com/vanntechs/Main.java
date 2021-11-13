package com.vanntechs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên:");
        String fullname = scanner.nextLine();
        System.out.println("Nhập giới tính:");
        System.out.println("(1) Nam");
        System.out.println("(2) Nữ");
        int gender = scanner.nextInt();
        System.out.println("Nhập ngày tháng năm sinh giờ sinh phút sinh *Dương lịch.");
        System.out.println("Nhập năm sinh: ");
        int yearOfBirth = scanner.nextInt();
        System.out.println("Nhập tháng sinh: ");
        int monthOfBirth = scanner.nextInt();
        System.out.println("Nhập ngày sinh: ");
        int dayOfBirth = scanner.nextInt();
        System.out.println("Nhập giờ sinh (0h -> 24h)");
        int hour = scanner.nextInt();
        System.out.println("Nhập phút sinh (0m -> 60m");
        int minute = scanner.nextInt();
        double hourOfBirth = ((double) minute) / 60 + (double)hour;
        User user = buildUser(fullname, yearOfBirth, monthOfBirth, dayOfBirth, hourOfBirth, gender);
        System.out.println(user.toString());
    }
    private static User buildUser(String fullname, int yearOfBirth, int monthOfBirth, int dayOfBirth, double hourOfBirth, int gender) {
        User user = new User();
        user.setName(fullname);
        if (gender == 1) {
            user.setGender(TuVi.NAM.toString());
        } else {
            user.setGender(TuVi.NU.toString());
        }
        int[] solarToLunar = DuongLichAmLichUtility.Solar2Lunar(dayOfBirth, monthOfBirth, yearOfBirth);
        user.setMonthOfBirth(solarToLunar[1]);
        user.setYearOfBirth(solarToLunar[2]);
        user.setDayOfBirth(solarToLunar[0]);
        user.setCan(DuongLichAmLichUtility.defineCanOfYear(user.getYearOfBirth()));
        user.setChi(DuongLichAmLichUtility.defineChi(user.getYearOfBirth()));
        user.setChiOfMonth(DuongLichAmLichUtility.defineChiForMonth(monthOfBirth));
        user.setCanOfMonth(DuongLichAmLichUtility.defineCanOfMonth(yearOfBirth, monthOfBirth));
        user.setHourOfBirth(DuongLichAmLichUtility.defineLunarHour(hourOfBirth));
        user.setTuoiAmHayDuong(DuongLichAmLichUtility.tuoiAmHayDuong(user.getCan()));

        return user;
    }

}
