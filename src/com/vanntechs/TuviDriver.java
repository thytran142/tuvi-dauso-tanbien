package com.vanntechs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TuviDriver {

    private HashMap<String, Cung> cungs = new HashMap<>();
    private HashMap<String, Integer> canValues = new HashMap<>();
    private HashMap<String, Integer> chiValues = new HashMap<>();
    private HashMap<Integer, String> menhValues = new HashMap<>();
    private User user;

    public TuviDriver() {
        this.cungs.put(TuVi.TI.toString(), new Cung());
        this.cungs.put(TuVi.SUU.toString(), new Cung());
        this.cungs.put(TuVi.DAN.toString(), new Cung());
        this.cungs.put(TuVi.MEO.toString(), new Cung());
        this.cungs.put(TuVi.THIN.toString(), new Cung());
        this.cungs.put(TuVi.TY.toString(), new Cung());
        this.cungs.put(TuVi.NGO.toString(), new Cung());
        this.cungs.put(TuVi.MUI.toString(), new Cung());
        this.cungs.put(TuVi.THAN.toString(), new Cung());
        this.cungs.put(TuVi.DAU.toString(), new Cung());
        this.cungs.put(TuVi.TUAT.toString(), new Cung());
        this.cungs.put(TuVi.HOI.toString(), new Cung());
        this.canValues.put(TuVi.GIAP.toString(), 1);
        this.canValues.put(TuVi.AT.toString(), 1);
        this.canValues.put(TuVi.BINH.toString(), 2);
        this.canValues.put(TuVi.DINH.toString(), 2);
        this.canValues.put(TuVi.MAU.toString(), 3);
        this.canValues.put(TuVi.KY.toString(), 3);
        this.canValues.put(TuVi.CANH.toString(), 4);
        this.canValues.put(TuVi.TAN.toString(), 4);
        this.canValues.put(TuVi.NHAM.toString(), 5);
        this.canValues.put(TuVi.QUY.toString(), 5);

        this.chiValues.put(TuVi.TI.toString(), 0);
        this.chiValues.put(TuVi.SUU.toString(), 0);
        this.chiValues.put(TuVi.NGO.toString(), 0);
        this.chiValues.put(TuVi.MUI.toString(), 0);
        this.chiValues.put(TuVi.DAN.toString(), 1);
        this.chiValues.put(TuVi.MEO.toString(), 1);
        this.chiValues.put(TuVi.THAN.toString(), 1);
        this.chiValues.put(TuVi.DAU.toString(), 1);
        this.chiValues.put(TuVi.THIN.toString(), 2);
        this.chiValues.put(TuVi.TY.toString(), 2);
        this.chiValues.put(TuVi.TUAT.toString(), 2);
        this.chiValues.put(TuVi.HOI.toString(), 2);

        this.menhValues.put(1, TuVi.KIM.toString());
        this.menhValues.put(2, TuVi.THUY.toString());
        this.menhValues.put(3, TuVi.HOA.toString());
        this.menhValues.put(4, TuVi.THO.toString());
        this.menhValues.put(5, TuVi.MOC.toString());

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
        this.user.setTuoiAmHayDuong(DuongLichAmLichUtility.tuoiAmHayDuong(user.getCan()));
        int menhInt = this.canValues.get(this.user.getCan()) + this.chiValues.get(this.user.getChi());
        if (menhInt > 5) {
            menhInt = menhInt - 5;
        }
        this.user.setMenh(this.menhValues.get(menhInt));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        this.cungs.get(position.toString()).setName(TuVi.MENH.toString());
        System.out.println("Cung menh: " + position.toString());
    }
    private void setCungThan(TuVi position) {
        this.cungs.get(position.toString()).setThanMenhDongCung(true);
        System.out.println("Cung Than " + position.toString());
    }
    private boolean isGioSinhMatched(int index) {
        List<TuVi> list = Arrays.asList(TuVi.TI, TuVi.SUU, TuVi.DAN, TuVi.MEO, TuVi.THIN,
                TuVi.TY, TuVi.NGO, TuVi.MUI, TuVi.THAN, TuVi.DAU, TuVi.TUAT, TuVi.HOI);
        for(int i = 0; i < list.size(); i++) {
            if (this.user.getHourOfBirth().equals(list.get(i).toString())) {
                return index == i;
            }
        }
        return false;
    }
}
