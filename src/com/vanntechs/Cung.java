package com.vanntechs;

public class Cung {
    private String name;
    private boolean isThanMenhDongCung;
    public Cung() {
        this.isThanMenhDongCung = false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isThanMenhDongCung() {
        return isThanMenhDongCung;
    }

    public void setThanMenhDongCung(boolean thanMenhDongCung) {
        isThanMenhDongCung = thanMenhDongCung;
    }
}
