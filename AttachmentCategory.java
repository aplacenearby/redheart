package cn.woonton.business.enums;

public enum AttachmentCategory {
	/**
	 * 电子病例
	 */
	MEDICAL(1,"电子病例"),
	/**
	 *儿科帖子
	 */
	PEDS_FORUM(2,"儿科帖子"),
	/*
	 * 已删除
	 */
	PEDS_ARTICLE(3,"儿科文章");

    private int value = 0;
    private String text=""; 
    private AttachmentCategory(int value,String text) {   
        this.value = value;
        this.text=text;
    }
    public static AttachmentCategory valueStrOf(String value) {  
       int vl=Integer.valueOf(value);
       return valueOf(vl);
    }
    public static AttachmentCategory valueOf(int value) {  
        switch (value) {
        case 1:
            return MEDICAL;
        case 2:
            return PEDS_FORUM;
        case 3:
            return PEDS_ARTICLE;
        default:
            return PEDS_ARTICLE;
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
