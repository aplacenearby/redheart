package cn.woonton.business.enums;

public enum PushMessageMethod {
	/**
	 * 刷新
	 */
	REFRASH(1),
	/**
	 * 无特别操作的
	 */
	NORMAL(0),
	NULL(-1); 

    private int value = 0;
    private PushMessageMethod(int value) {   
        this.value = value;
    }
    public static PushMessageMethod valueStrOf(String value) {  
       int vl=Integer.valueOf(value);
       return valueOf(vl);
    }
    public static PushMessageMethod valueOf(int value) {  
        switch (value) {
        case 1:
        	return REFRASH;
        default:
            return NULL;
        }
    }
    public int value() {
        return this.value;
    }
    public String valueStr() {
        return String.valueOf(this.value);
    }
}
