package com.vanntechs;

import java.util.ArrayList;
import java.util.HashMap;

public class TuviDriver {

    private ArrayList<Cung> cungs;
    private HashMap<String, Integer> canValues;
    private HashMap<String, Integer> chiValues;
    private HashMap<Integer, String> menhValues;
    private User user;

    public TuviDriver(User user) {
        this.cungs = new ArrayList<>(){{
            add(new Cung(TuVi.TI.toString()));
            add(new Cung(TuVi.SUU.toString()));
            add(new Cung(TuVi.DAN.toString()));
            add(new Cung(TuVi.MEO.toString()));
            add(new Cung(TuVi.THIN.toString()));
            add(new Cung(TuVi.TY.toString()));
            add(new Cung(TuVi.NGO.toString()));
            add(new Cung(TuVi.MUI.toString()));
            add(new Cung(TuVi.THAN.toString()));
            add(new Cung(TuVi.DAU.toString()));
            add(new Cung(TuVi.TUAT.toString()));
            add(new Cung(TuVi.HOI.toString()));
        }};
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

        this.user = user;
    }
}
