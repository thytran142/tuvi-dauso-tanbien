package com.vanntechs;

public enum TuVi {
    TI("Tí"),
    SUU("Sửu"),
    DAN("Dần"),
    MEO("Mẹo"),
    THIN("Thìn"),
    TY("Tỵ"),
    NGO("Ngọ"),
    MUI("Mùi"),
    THAN("Thân"),
    DAU("Dậu"),
    TUAT("Tuất"),
    HOI("Hợi"),

    CANH("Canh"),
    TAN("Tân"),
    NHAM("Nhâm"),
    QUY("Quý"),
    GIAP("Giáp"),
    AT("Át"),
    BINH("Bính"),
    DINH("Đinh"),
    MAU("Mậu"),
    KY("Kỷ"),

    CHU_NHAT("Chủ nhật"),
    THU_HAI("Thứ hai"),
    THU_BA("Thứ ba"),
    THU_TU("Thứ tư"),
    THU_NAM("Thứ năm"),
    THU_SAU("Thứ sáu"),
    THU_BAY("Thứ bảy"),

    DUONG("Dương"),
    AM("Âm"),

    NAM("Nam"),
    NU("Nữ");




    private final String name;

    private TuVi(String s) {
        name = s;
    }
    public String toString() {
        return this.name;
    }
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }
}
