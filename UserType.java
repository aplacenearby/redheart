package cn.woonton.business.enums;

import java.io.Serializable;

public enum UserType implements Serializable{
	/**
	 * 医生
	 */
	DOCTOR(1), 
	/**
	 * 患者
	 */
	MEMBER(2),
	/**
	 * 未知
	 */
	NONE(-1);
	
	 private int value = -1;

    private UserType(int value) {    
        this.value = value;
    }

    public static UserType valueOf(int value) {  
        switch (value) {
        case 1:
            return DOCTOR;
        case 2:
            return MEMBER;
        default:
            return NONE;
        }
    }

    public int value() {
        return this.value;
    }
}
