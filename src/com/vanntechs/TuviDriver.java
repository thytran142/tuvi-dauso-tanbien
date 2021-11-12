package com.vanntechs;

import java.util.ArrayList;

public class TuviDriver {

    private ArrayList<Cung> cungs;

    public TuviDriver() {
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
    }
}
