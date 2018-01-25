package cn.woonton.business.enums;

public enum DeviceType {
	/**
	 * IOS
	 */
	IOS(1), 
	/**
	 * android
	 */
	ANDROID(2),
	/**
	 * 所有
	 */
	ALL(0),
	NONE(-1);
	
	 private int value = -1;

    private DeviceType(int value) {    
        this.value = value;
    }

    public static DeviceType valueOf(int value) {  
        switch (value) {
        case -1:
            return NONE;
        case 0:
            return ALL;
        case 1:
            return IOS;
        case 2:
            return ANDROID;
        default:
            return NONE;
        }
    }

    public int value() {
        return this.value;
    }
}
