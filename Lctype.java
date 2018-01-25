package cn.woonton.business.enums;

public enum Lctype {
	text(-1),
	pic(-2),
	redio(-3),
	media(-4),
	position(-5),
	file(-6);
    private int value = -1;

    private Lctype(int value) {  
        this.value = value;
    }

    public static Lctype valueOf(int value) {   
        switch (value) {
        case -1:
            return text;
        case -2:
            return pic;
        case -3:
            return redio;
        case -4:
            return media;
        case -5:
            return position;
        case -6:
            return file;
        default:
            return null;
        }
    }
    public int value() {
        return this.value;
    }
}
