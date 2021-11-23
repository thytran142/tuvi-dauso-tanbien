package com.vanntechs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TuviDriver {

    private HashMap<TuVi, Cung> cungs = new HashMap<>();
    private HashMap<TuVi, Integer> canValues = new HashMap<>();
    private HashMap<TuVi, Integer> chiValues = new HashMap<>();
    private HashMap<Integer, TuVi> menhValues = new HashMap<>();
    private User user;
    private List<TuVi> congiaps = Arrays.asList(TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN,
            TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI);

    public TuviDriver() {
        for (TuVi tuvi: congiaps) {
            this.cungs.put(tuvi, new Cung());
        }
        this.canValues.put(TuVi.GIAP, 1);
        this.canValues.put(TuVi.AT, 1);
        this.canValues.put(TuVi.BINH, 2);
        this.canValues.put(TuVi.DINH, 2);
        this.canValues.put(TuVi.MAU, 3);
        this.canValues.put(TuVi.KY, 3);
        this.canValues.put(TuVi.CANH, 4);
        this.canValues.put(TuVi.TAN, 4);
        this.canValues.put(TuVi.NHAM, 5);
        this.canValues.put(TuVi.QUY, 5);

        this.chiValues.put(TuVi.TI, 0);
        this.chiValues.put(TuVi.SUU, 0);
        this.chiValues.put(TuVi.NGO, 0);
        this.chiValues.put(TuVi.MUI, 0);
        this.chiValues.put(TuVi.DAN, 1);
        this.chiValues.put(TuVi.MEO, 1);
        this.chiValues.put(TuVi.THAN, 1);
        this.chiValues.put(TuVi.DAU, 1);
        this.chiValues.put(TuVi.THIN, 2);
        this.chiValues.put(TuVi.TY, 2);
        this.chiValues.put(TuVi.TUAT, 2);
        this.chiValues.put(TuVi.HOI, 2);

        this.menhValues.put(1, TuVi.KIM);
        this.menhValues.put(2, TuVi.THUY);
        this.menhValues.put(3, TuVi.HOA);
        this.menhValues.put(4, TuVi.THO);
        this.menhValues.put(5, TuVi.MOC);

        this.user = new User();
    }
    public void buildUser(String fullname, int yearOfBirth, int monthOfBirth, int dayOfBirth, double hourOfBirth, int gender) {
        this.user.setName(fullname);
        if (gender == 1) {
            this.user.setGender(TuVi.NAM.toString());
        } else {
            this.user.setGender(TuVi.NU.toString());
        }
        int[] solarToLunar = DuongLichAmLichUtility.Solar2Lunar(dayOfBirth, monthOfBirth, yearOfBirth);
        this.user.setMonthOfBirth(solarToLunar[1]);
        this.user.setYearOfBirth(solarToLunar[2]);
        this.user.setDayOfBirth(solarToLunar[0]);
        this.user.setCan(DuongLichAmLichUtility.defineCanOfYear(user.getYearOfBirth()));
        this.user.setChi(DuongLichAmLichUtility.defineChi(user.getYearOfBirth()));
        this.user.setHourOfBirth(DuongLichAmLichUtility.defineLunarHour(hourOfBirth));
        this.user.setTuoiAmHayDuong(DuongLichAmLichUtility.tuoiAmHayDuong(user.getCan().toString()));
        int menhInt = this.canValues.get(this.user.getCan()) + this.chiValues.get(this.user.getChi());
        if (menhInt > 5) {
            menhInt = menhInt - 5;
        }
        this.user.setMenh(this.menhValues.get(menhInt).toString());
    }

    public User getUser() {
        return user;
    }


    public void setCungMenhAndThan() {
        HashMap<Integer, List<TuVi>> menhMaps = new HashMap<>();
        HashMap<Integer, List<TuVi>> thanMaps = new HashMap<>();
        menhMaps.put(1, Arrays.asList(TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO));
        thanMaps.put(1, Arrays.asList(TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU));
        menhMaps.put(2, Arrays.asList(TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN));
        thanMaps.put(2, Arrays.asList(TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN));
        menhMaps.put(3, Arrays.asList(TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY));
        thanMaps.put(3, Arrays.asList(TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO));
        menhMaps.put(4, Arrays.asList(TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO));
        thanMaps.put(4, Arrays.asList(TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN));
        menhMaps.put(5, Arrays.asList(TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN));
        thanMaps.put(5, Arrays.asList(TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MENH, TuVi.THIN, TuVi.TY));
        menhMaps.put(6, Arrays.asList(TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN));
        thanMaps.put(6, Arrays.asList(TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO));
        menhMaps.put(7, Arrays.asList(TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TY, TuVi.HOI, TuVi.TUAT, TuVi.DAU));
        thanMaps.put(7, Arrays.asList(TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI));
        menhMaps.put(8, Arrays.asList(TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT));
        thanMaps.put(8, Arrays.asList(TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN));
        menhMaps.put(9, Arrays.asList(TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI, TuVi.HOI));
        thanMaps.put(9, Arrays.asList(TuVi.TUAT, TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU));
        menhMaps.put(10, Arrays.asList(TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU, TuVi.TI));
        thanMaps.put(10, Arrays.asList(TuVi.HOI, TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT));
        menhMaps.put(11, Arrays.asList(TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN, TuVi.SUU));
        thanMaps.put(11, Arrays.asList(TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI));
        menhMaps.put(12, Arrays.asList(TuVi.SUU, TuVi.TI, TuVi.HOI, TuVi.TUAT, TuVi.DAU, TuVi.THAN, TuVi.MUI, TuVi.NGO, TuVi.TY, TuVi.THIN, TuVi.MEO, TuVi.DAN));
        thanMaps.put(12, Arrays.asList(TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN, TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI, TuVi.TI));
        boolean isSetCungMenh = false;
        boolean isSetCungThan = false;
        for (Integer key : menhMaps.keySet()) {
            if (this.user.getMonthOfBirth() == key) {
                for (int i = 0; i < menhMaps.get(key).size(); i++) {
                    TuVi tuvi = menhMaps.get(key).get(i);
                    if (isGioSinhMatched(i)) {
                        setCungMenh(tuvi);
                        isSetCungMenh = true;
                        break;
                    }
                }
            }
            if (isSetCungMenh) break;
        }
        for (Integer key : thanMaps.keySet()) {
            if (this.user.getMonthOfBirth() == key) {
                for (int i = 0; i < thanMaps.get(key).size(); i++) {
                    if (isGioSinhMatched(i)) {
                        setCungThan(thanMaps.get(key).get(i));
                        isSetCungThan = true;
                        break;
                    }
                }
            }
            if (isSetCungThan) break;
        }
    }
    private void setCungMenh(TuVi position) {
        this.cungs.get(position).setName(TuVi.MENH.toString());
        System.out.println("Cung mệnh: " + position.toString());
    }
    private void setCungThan(TuVi position) {
        this.cungs.get(position).setThanMenhDongCung(true);
        System.out.println("Cung thân: " + position.toString());
    }
    private boolean isGioSinhMatched(int index) {
        for(int i = 0; i < congiaps.size(); i++) {
            if (this.user.getHourOfBirth().equals(congiaps.get(i).toString())) {
                return index == i;
            }
        }
        return false;
    }
    private TuVi findPositionOfCungByName(String name) {
        for (TuVi key: this.cungs.keySet()) {
            Cung cung = this.cungs.get(key);
            if (null != cung.getName() && cung.getName().equals(name)) {
                return key;
            }
        }
        return null;
    }
    private int findIndexByClockWise(TuVi currentPosition, int byManyPositions) {
        int index = -1;
        for (int i = 0; i < this.congiaps.size(); i++) {
            TuVi currentCongiap = this.congiaps.get(i);
            if (currentCongiap == currentPosition) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("Cannot get the current index of a current position " + currentPosition.toString());
        }
        int indexClockWise = index + byManyPositions;
        if (indexClockWise >= this.congiaps.size()) {
            indexClockWise -= this.congiaps.size();
        }
        return indexClockWise;
    }
    public void setCungPhuMau() {
        TuVi positionOfCungMenh = findPositionOfCungByName(TuVi.MENH.toString());
        if (positionOfCungMenh == null) {
            throw new RuntimeException("Cannot find cung menh!");
        }
        int indexOfCungPhuMau = findIndexByClockWise(positionOfCungMenh, 1);
        this.cungs.get(this.congiaps.get(indexOfCungPhuMau)).setName(TuVi.PHU_MAU.toString());
        System.out.println("Cung phụ mẫu: " + this.congiaps.get(indexOfCungPhuMau).toString());
    }
}
