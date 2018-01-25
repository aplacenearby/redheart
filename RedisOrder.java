package cn.woonton.business.enums;

public enum RedisOrder {
	ASC(1),
	DESC(2);

    private int value = 1;

    private RedisOrder(int value) {  
        this.value = value;
        
    }
    public static RedisOrder valueOf(int value) {  
    	switch (value) {
        case 1:
            return ASC;
        case 2:
            return DESC;
        default:
            return ASC;
    }
    }
    public int value() {
        return this.value;
    }
}
