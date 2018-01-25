package cn.woonton.business.enums;

public enum WeChatMsgType {
	TEXT("text"),
	IMAGE("image"), 
	VOICE("voice"),
	EVENT("event"),
    NONE("none");
    private String value = "text";

    public static WeChatMsgType castMsgType(String msgType) {  
    	try 
    	{
    		return valueOf(msgType.toUpperCase()); 
    	}
        catch (Exception ex) {
    		return NONE;
    	}
    }
    private WeChatMsgType(String value) {  
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
