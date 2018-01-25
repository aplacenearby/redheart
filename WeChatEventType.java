package cn.woonton.business.enums;

public enum WeChatEventType {
	LOCATION("location"),
	SUBSCRIBE("subscribe"),
	UNSUBSCRIBE("unsubscribe"),
	SCAN("scan"),
	VIEW("view"),
	/**
	 * 模版消息回执
	 */
	TEMPLATESENDJOBFINISH("templatesendjobfinish"),
	NONE("none");

    private String value = "NONE";

    private WeChatEventType(String value) {  
        this.value = value;
        
    }
    public static WeChatEventType castEventType(String eventType) {  
    	try 
    	{
    		return valueOf(eventType.toUpperCase()); 
    	}
        catch (Exception ex) {
    		return NONE;
    	}
    }
    public String value() {
        return this.value;
    }
}
