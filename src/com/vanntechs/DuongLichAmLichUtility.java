package com.vanntechs;

import java.util.Calendar;

import static java.lang.Math.PI;

public class DuongLichAmLichUtility {
    private static double LOCAL_TIMEZONE = 7.0; // VIETNAM

    public static int INT(double d) {
        return (int) Math.floor(d);
    }

    public static int MOD(int x, int y) {
        int z = x - (int) (y * Math.floor(((double) x / y)));
        if (z == 0) {
            z = y;
        }
        return z;
    }

    /**
     * Đổi ngày dương lịch ra số ngày Julius
     *
     * @param D
     * @param M
     * @param Y
     * @return UniversalToJD(1, 1, 2000) = 2451544.5; UniversalToJD(4, 10, 1582) = 2299159.5; UniversalToJD(15, 10, 1582) = 2299160.5;
     */
    public static double UniversalToJD(int D, int M, int Y) {
        double JD;
        if (Y > 1582 || (Y == 1582 && M > 10) || (Y == 1582 && M == 10 && D > 14)) {
            JD = 367 * Y - INT(7 * (Y + INT((M + 9) / 12)) / 4) - INT(3 * (INT((Y + (M - 9) / 7) / 100) + 1) / 4) + INT(275 * M / 9) + D + 1721028.5;
        } else {
            JD = 367 * Y - INT(7 * (Y + 5001 + INT((M - 9) / 7)) / 4) + INT(275 * M / 9) + D + 1729776.5;
        }
        return JD;
    }

    /**
     * Đổi số ngày Julius ra ngày dương lịch
     *
     * @param JD
     * @return Ví dụ: UniversalFromJD(2451544.5) = (1, 1, 2000); UniversalFromJD(2451544.2083333335) = (31, 12, 1999); UniversalFromJD(2299160.5) = (15, 10, 1582); UniversalFromJD(2299159.5) = (4, 10, 1582)
     */
    public static int[] UniversalFromJD(double JD) {
        int Z, A, alpha, B, C, D, E, dd, mm, yyyy;
        double F;
        Z = INT(JD + 0.5);
        F = (JD + 0.5) - Z;
        if (Z < 2299161) {
            A = Z;
        } else {
            alpha = INT((Z - 1867216.25) / 36524.25);
            A = Z + 1 + alpha - INT(alpha / 4);
        }
        B = A + 1524;
        C = INT((B - 122.1) / 365.25);
        D = INT(365.25 * C);
        E = INT((B - D) / 30.6001);
        dd = INT(B - D - INT(30.6001 * E) + F);
        if (E < 14) {
            mm = E - 1;
        } else {
            mm = E - 13;
        }
        if (mm < 3) {
            yyyy = C - 4715;
        } else {
            yyyy = C - 4716;
        }
        return new int[]{dd, mm, yyyy};
    }

    /**
     * Chuyển đổi số ngày Julius / ngày dương lịch theo giờ địa phương
     *
     * @param JD
     * @return LocalFromJD(2451544.2083333335) = (1, 1, 2000).
     */
    public static int[] LocalFromJD(double JD) {
        return UniversalFromJD(JD + LOCAL_TIMEZONE / 24.0);
    }

    /**
     * NewMoon(1236) = 2451520.4393767994, UniversalFromJD(2451520.4393767994) = (7, 12, 1999)
     * còn theo múi giờ thứ 7 của Việt Nam là LocalFromJD(2451520.4393767994) = (8, 12, 1999).
     * (Số ngày Julius 2451520.4393767994 tương ứng với 7/12/1999 22:32:42 GMT hay 8/12/1999 5:32:42 giờ Việt Nam).
     * Như thế theo giờ GMT thì Sóc cuối cùng trong năm 1999 (Sóc thứ 1236 tính từ 1/1/1900) xảy ra vào ngày 7/12/1999 nhưng theo múi giờ thứ 7 thì Sóc này rơi vào ngày 8/12/1999.
     * Tương tự, NewMoon(1237) = 2451550.2601371277;
     * LocalFromJD(2451550.2601371277) = (7, 1, 2000);
     * NewMoon(1238) = 2451580.0448043263;
     * LocalFromJD(2451580.0448043263) = (5, 2, 2000);
     * NewMoon(1239) = 2451609.721434823;
     * LocalFromJD(2451609.721434823) = (6, 3, 2000) v.v.
     * Như thế, theo giờ Việt Nam thì Sóc đầu tiên trong năm 2000 rơi vào ngày 7/1/2000,
     * Sóc thứ hai vào ngày 5/2/2000 và Sóc thứ ba vào ngày 6/3/2000.
     * Với những số liệu này ta đã có thể suy đoán được rằng có một tháng âm lịch bắt đầu ngày 8/12/1999 và các tháng sau đó bắt đầu vào ngày 7/1/2000, 5/2/2000 và 6/3/2000.
     *
     * @param D
     * @param M
     * @param Y
     * @return LocalToJD(1, 1, 2000) = 2451544.2083333335
     */
    public static double LocalToJD(int D, int M, int Y) {
        return UniversalToJD(D, M, Y) - LOCAL_TIMEZONE / 24.0;
    }

    public static double NewMoon(int k) {
        double T = k / 1236.85; // Time in Julian centuries from 1900 January 0.5
        double T2 = T * T;
        double T3 = T2 * T;
        double dr = PI / 180;
        double Jd1 = 2415020.75933 + 29.53058868 * k + 0.0001178 * T2 - 0.000000155 * T3;
        Jd1 = Jd1 + 0.00033 * Math.sin((166.56 + 132.87 * T - 0.009173 * T2) * dr); // Mean new moon
        double M = 359.2242 + 29.10535608 * k - 0.0000333 * T2 - 0.00000347 * T3; // Sun's mean anomaly
        double Mpr = 306.0253 + 385.81691806 * k + 0.0107306 * T2 + 0.00001236 * T3; // Moon's mean anomaly
        double F = 21.2964 + 390.67050646 * k - 0.0016528 * T2 - 0.00000239 * T3; // Moon's argument of latitude
        double C1 = (0.1734 - 0.000393 * T) * Math.sin(M * dr) + 0.0021 * Math.sin(2 * dr * M);
        C1 = C1 - 0.4068 * Math.sin(Mpr * dr) + 0.0161 * Math.sin(dr * 2 * Mpr);
        C1 = C1 - 0.0004 * Math.sin(dr * 3 * Mpr);
        C1 = C1 + 0.0104 * Math.sin(dr * 2 * F) - 0.0051 * Math.sin(dr * (M + Mpr));
        C1 = C1 - 0.0074 * Math.sin(dr * (M - Mpr)) + 0.0004 * Math.sin(dr * (2 * F + M));
        C1 = C1 - 0.0004 * Math.sin(dr * (2 * F - M)) - 0.0006 * Math.sin(dr * (2 * F + Mpr));
        C1 = C1 + 0.0010 * Math.sin(dr * (2 * F - Mpr)) + 0.0005 * Math.sin(dr * (2 * Mpr + M));
        double deltat;
        if (T < -11) {
            deltat = 0.001 + 0.000839 * T + 0.0002261 * T2 - 0.00000845 * T3 - 0.000000081 * T * T3;
        } else {
            deltat = -0.000278 + 0.000265 * T + 0.000262 * T2;
        }
        ;
        double JdNew = Jd1 + C1 - deltat;
        return JdNew;
    }

    /**
     * Ví dụ: kinh độ mặt trời vào lúc 00:00 giờ Hà Nội ngày 8/12/1999 (ngày Julius 2451520.2083333335) là SunLongitude(2451520.2083333335) = 4.453168980086705.
     * Kinh độ mặt trời lúc 00:00 ngày 7/1/2000 (giờ Hà Nội) là SunLongitude(2451520.2083333335) = 4.986246180809974.
     * Vì 4.453168980086705 < 3*PI/2 (= 4.71238898038469) < 4.986246180809974 nên tháng âm lịch bắt đầu vào ngày 8/12/1999 chứa Đông chí.
     *
     * @param jdn
     * @return
     */
    public static double SunLongitude(double jdn) {
        double T = (jdn - 2451545.0) / 36525; // Time in Julian centuries from 2000-01-01 12:00:00 GMT
        double T2 = T * T;
        double dr = PI / 180; // degree to radian
        double M = 357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2; // mean anomaly, degree
        double L0 = 280.46645 + 36000.76983 * T + 0.0003032 * T2; // mean longitude, degree
        double DL = (1.914600 - 0.004817 * T - 0.000014 * T2) * Math.sin(dr * M);
        DL = DL + (0.019993 - 0.000101 * T) * Math.sin(dr * 2 * M) + 0.000290 * Math.sin(dr * 3 * M);
        double L = L0 + DL; // true longitude, degree
        L = L * dr;
        L = L - PI * 2 * (INT(L / (PI * 2))); // Normalize to (0, 2*PI)
        return L;
    }

    /**
     * Tính tháng âm lịch chứa ngày Đông chí
     *
     * @param Y
     * @return
     */
    public static int[] LunarMonth11(int Y) {
        double off = LocalToJD(31, 12, Y) - 2415021.076998695;
        int k = INT(off / 29.530588853);
        double jd = NewMoon(k);
        int[] ret = LocalFromJD(jd);
        double sunLong = SunLongitude(LocalToJD(ret[0], ret[1], ret[2])); // sun longitude at local midnight
        if (sunLong > 3 * PI / 2) {
            jd = NewMoon(k - 1);
        }
        return LocalFromJD(jd);
    }

    public static final double[] SUNLONG_MAJOR = new double[]{
            0, PI / 6, 2 * PI / 6, 3 * PI / 6, 4 * PI / 6, 5 * PI / 6, PI, 7 * PI / 6, 8 * PI / 6, 9 * PI / 6, 10 * PI / 6, 11 * PI / 6
    };

    /**
     * Tính năm âm lịch
     *
     * @param Y
     * @return
     */
    public static int[][] LunarYear(int Y) {
        int[][] ret = null;
        int[] month11A = LunarMonth11(Y - 1);
        double jdMonth11A = LocalToJD(month11A[0], month11A[1], month11A[2]);
        int k = (int) Math.floor(0.5 + (jdMonth11A - 2415021.076998695) / 29.530588853);
        int[] month11B = LunarMonth11(Y);
        double off = LocalToJD(month11B[0], month11B[1], month11B[2]) - jdMonth11A;
        boolean leap = off > 365.0;
        if (!leap) {
            ret = new int[13][5];
        } else {
            ret = new int[14][5];
        }
        ret[0] = new int[]{month11A[0], month11A[1], month11A[2], 0, 0};
        ret[ret.length - 1] = new int[]{month11B[0], month11B[1], month11B[2], 0, 0};
        for (int i = 1; i < ret.length - 1; i++) {
            double nm = NewMoon(k + i);
            int[] a = LocalFromJD(nm);
            ret[i] = new int[]{a[0], a[1], a[2], 0, 0};
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i][3] = MOD(i + 11, 12);
        }
        if (leap) {
            initLeapYear(ret);
        }
        return ret;
    }

    static void initLeapYear(int[][] ret) {
        double[] sunLongitudes = new double[ret.length];
        for (int i = 0; i < ret.length; i++) {
            int[] a = ret[i];
            double jdAtMonthBegin = LocalToJD(a[0], a[1], a[2]);
            sunLongitudes[i] = SunLongitude(jdAtMonthBegin);
        }
        boolean found = false;
        for (int i = 0; i < ret.length; i++) {
            if (found) {
                ret[i][3] = MOD(i + 10, 12);
                continue;
            }
            double sl1 = sunLongitudes[i];
            double sl2 = sunLongitudes[i + 1];
            boolean hasMajorTerm = Math.floor(sl1 / PI * 6) != Math.floor(sl2 / PI * 6);
            if (!hasMajorTerm) {
                found = true;
                ret[i][4] = 1;
                ret[i][3] = MOD(i + 10, 12);
            }
        }
    }

    /**
     * Đổi ngày dương lịch ra âm lịch
     * Sau khi đã tính được tất cả các tháng âm lịch trong một năm ta có thể dễ dàng tìm ra tháng âm lịch chứa một ngày dương lịch d/m/y bất kỳ.
     * Hàm Solar2Lunar đổi ngày D/M/Y dương lịch ra ngày âm lịch (dd,mm,yy,leap) tương ứng: ngày dd tháng mm năm yy âm lịch; mm là tháng nhuận nếu leap=1.
     *
     * @param D
     * @param M
     * @param Y
     * @return
     */
    public static int[] Solar2Lunar(int D, int M, int Y) {
        int yy = Y;
        int[][] ly = LunarYear(Y); // Please cache the result of this computation for later use!!!
        int[] month11 = ly[ly.length - 1];
        double jdToday = LocalToJD(D, M, Y);
        double jdMonth11 = LocalToJD(month11[0], month11[1], month11[2]);
        if (jdToday >= jdMonth11) {
            ly = LunarYear(Y + 1);
            yy = Y + 1;
        }
        int i = ly.length - 1;
        while (jdToday < LocalToJD(ly[i][0], ly[i][1], ly[i][2])) {
            i--;
        }
        int dd = (int) (jdToday - LocalToJD(ly[i][0], ly[i][1], ly[i][2])) + 1;
        int mm = ly[i][3];
        if (mm >= 11) {
            yy--;
        }
        return new int[]{dd, mm, yy, ly[i][4]};
    }

    public static String calculateThu(int D, int M, int Y) {
        int X = MOD((int) (UniversalToJD(D, M, Y) + 2.5), 7);
        if (X == 1) return TuVi.CHU_NHAT.toString();
        if (X == 2) return TuVi.THU_HAI.toString();
        if (X == 3) return TuVi.THU_BA.toString();
        if (X == 4) return TuVi.THU_TU.toString();
        if (X == 5) return TuVi.THU_NAM.toString();
        if (X == 6) return TuVi.THU_SAU.toString();
        if (X == 7) return TuVi.THU_BAY.toString();
        return "";
    }

    public static TuVi defineCanOfYear(int y) {
        TuVi can = null;
        switch (y % 10) {
            case 0:
                can = TuVi.CANH;
                break;
            case 1:
                can = TuVi.TAN;
                break;
            case 2:
                can = TuVi.NHAM;
                break;
            case 3:
                can = TuVi.QUY;
                break;
            case 4:
                can = TuVi.GIAP;
                break;
            case 5:
                can = TuVi.AT;
                break;
            case 6:
                can = TuVi.BINH;
                break;
            case 7:
                can = TuVi.DINH;
                break;
            case 8:
                can = TuVi.MAU;
                break;
            case 9:
                can = TuVi.KY;
                break;
        }
        return can;
    }

    public static TuVi defineChi(int year) {
        int lastTwoDigits = Integer.parseInt(Integer.toString(year).substring(2));
        TuVi chi = null;
        switch (lastTwoDigits % 12) {
            case 0:
                chi = TuVi.TI;
                break;
            case 1:
                chi = TuVi.SUU;
                break;
            case 2:
                chi = TuVi.DAN;
                break;
            case 3:
                chi = TuVi.MEO;
                break;
            case 4:
                chi = TuVi.THIN;
                break;
            case 5:
                chi = TuVi.TY;
                break;
            case 6:
                chi = TuVi.NGO;
                break;
            case 7:
                chi = TuVi.MUI;
                break;
            case 8:
                chi = TuVi.THAN;
                break;
            case 9:
                chi = TuVi.DAU;
                break;
            case 10:
                chi = TuVi.TUAT;
                break;
            case 11:
                chi = TuVi.HOI;
                break;
        }
        return chi;
    }

    public static String defineChiForMonth(int m) {
        switch (m) {
            case 11:
                return TuVi.TI.toString();
            case 12:
                return TuVi.SUU.toString();
            case 1:
                return TuVi.DAN.toString();
            case 2:
                return TuVi.MEO.toString();
            case 3:
                return TuVi.THIN.toString();
            case 4:
                return TuVi.TY.toString();
            case 5:
                return TuVi.NGO.toString();
            case 6:
                return TuVi.MUI.toString();
            case 7:
                return TuVi.THAN.toString();
            case 8:
                return TuVi.DAU.toString();
            case 9:
                return TuVi.TUAT.toString();
            case 10:
                return TuVi.HOI.toString();
            default:
                return "";
        }
    }

    public static String defineCanOfMonth(int Y, int M) {
        int X = (Y * 12 + M + 3) % 10;
        return defineCan(X);
    }

    private static String defineCan(int X) {
        String can = "";
        if (X == 0) can = TuVi.GIAP.toString();
        if (X == 1) can = TuVi.AT.toString();
        if (X == 2) can = TuVi.BINH.toString();
        if (X == 3) can = TuVi.DINH.toString();
        if (X == 4) can = TuVi.MAU.toString();
        if (X == 5) can = TuVi.KY.toString();
        if (X == 6) can = TuVi.CANH.toString();
        if (X == 7) can = TuVi.TAN.toString();
        if (X == 8) can = TuVi.NHAM.toString();
        if (X == 9) can = TuVi.QUY.toString();
        return can;
    }

    public static String defineLunarHour(double h) {
        if (23 < h || h <= 1) {
            return TuVi.TI.toString();
        }
        if (1 < h && h <= 3) {
            return TuVi.SUU.toString();
        }
        if (3 < h && h <= 5) {
            return TuVi.DAU.toString();
        }
        if (5 < h && h <= 7) {
            return TuVi.MEO.toString();
        }
        if (7 < h && h <= 9) {
            return TuVi.THIN.toString();
        }
        if (9 < h && h <= 11) {
            return TuVi.TY.toString();
        }
        if (11 < h && h <= 13) {
            return TuVi.NGO.toString();
        }
        if (13 < h && h <= 15) {
            return TuVi.MUI.toString();
        }
        if (15 < h && h <= 17) {
            return TuVi.THAN.toString();
        }
        if (17 < h && h <= 19) {
            return TuVi.DAU.toString();
        }
        if (19 < h && h <= 21) {
            return TuVi.TUAT.toString();
        }
        if (21 < h && h <= 23) {
            return TuVi.HOI.toString();
        }
        return "";
    }
    public static String tuoiAmHayDuong(String can) {
        if (can.equals(TuVi.GIAP.toString()) || can.equals(TuVi.BINH.toString())
            || can.equals(TuVi.MAU.toString()) || can.equals(TuVi.CANH.toString())
            || can.equals(TuVi.NHAM.toString())) {
            return TuVi.DUONG.toString();
        } else {
            return TuVi.AM.toString();
        }
    }
}
