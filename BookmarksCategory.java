package cn.woonton.business.enums;

public enum BookmarksCategory {
	/**
	 * 医生
	 */
	DOCTOR(1,"医生"),
	/**
	 * 论坛
	 */
	FORUM(2,"论坛"),
	/*
	 * 文章
	 */
	ARTICLE(3,"文章");

    private int value = 0;
    private String text=""; 
    private BookmarksCategory(int value,String text) {   
        this.value = value;
        this.text=text;
    }
    public static BookmarksCategory valueStrOf(String value) {  
       int vl=Integer.valueOf(value);
       return valueOf(vl);
    }
    public static BookmarksCategory valueOf(int value) {  
        switch (value) {
        case 1:
            return DOCTOR;
        case 2:
            return FORUM;
        case 3:
            return ARTICLE;
        default:
            return ARTICLE;
        }
    }
    public String text() {  
    	return this.text;
    }
    public int value() {
        return this.value;
    }
    public String valueStr() {
        return String.valueOf(this.value);
    }
}
