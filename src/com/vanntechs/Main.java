package com.vanntechs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TuviDriver tuviDriver = new TuviDriver();

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
        System.out.println("Nhập phút sinh (0m -> 60m)");
        int minute = scanner.nextInt();
        double hourOfBirth = ((double) minute) / 60 + (double)hour;

        tuviDriver.buildUser(fullname, yearOfBirth, monthOfBirth, dayOfBirth, hourOfBirth, gender);
        tuviDriver.setCungMenhAndThan();
        tuviDriver.setCungPhuMau();
        tuviDriver.setCungPhucDuc();
        tuviDriver.setCungDienTrach();
        tuviDriver.setCungQuanLoc();
        tuviDriver.setCungNoBoc();
        tuviDriver.setCungThienDi();
        tuviDriver.setCungTatAch();
        tuviDriver.setCungTaibach();
        tuviDriver.setCungTuTuc();
        tuviDriver.setCungPhuThe();
        tuviDriver.setCungHuynhDe();


        System.out.println(tuviDriver.getUser().toString());
    }


}
