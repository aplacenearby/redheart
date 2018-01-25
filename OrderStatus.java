package cn.woonton.business.enums;

public enum OrderStatus {
	/**
	 * 未付款
	 */
	PAY_NON(1,"未付款"),
	/**
	 * 已付款,待接单
	 */
	PAY_END(2,"已付款"),
	/*
	 * 咨询中
	 */
	ORDER_ING(3,"咨询中"),
	/**
	 * 申诉中
	 */
	COMPLAIN_ING(4,"申诉中"),
	/**
	 * 申诉完成
	 */
	COMPLAIN_END(5,"申诉完成"),
	/**
	 * 申诉驳回
	 */
	COMPLAIN_REJECT(6,"申诉驳回"),
	/**
	 * 待评价
	 */
	EVAL_NON(7,"待评价"),
	/**
	 * 已评价
	 */
	EVAL_END(8,"已评价"),
	/**
	 * 已过期
	 */
	EXPIRE(9,"已过期"),
	/**
	 * 已撤销
	 */
	CANCEL(10,"已撤销"),
	/**
	 * 空值
	 */
	NULL(-1,"空值"); 

    private int value = 0;
    private String text=""; 
    private OrderStatus(int value,String text) {   
        this.value = value;
        this.text=text;
    }
    public static OrderStatus valueStrOf(String value) {  
       int vl=Integer.valueOf(value);
       return valueOf(vl);
    }
    public static OrderStatus valueOf(int value) {  
        switch (value) {
        case -1:
        	return NULL;
        case 1:
            return PAY_NON;
        case 2:
            return PAY_END;
        case 3:
            return ORDER_ING;
        case 4:
            return COMPLAIN_ING;
        case 5:
            return COMPLAIN_END;
        case 6:
            return COMPLAIN_REJECT;
        case 7:
            return EVAL_NON;
        case 8:
            return EVAL_END;
        case 9:
            return EXPIRE;
        case 10:
            return CANCEL;
        default:
            return NULL;
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
