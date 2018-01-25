package cn.woonton.business.enums;

public enum PushMessageType {
    /**
     * 系统通知
     */
    SYSTEM(1),
    /**
     * 订单列表
     */
    CONSULT_LIST(10),
    /**
     * 订单列状态更新
     */
    CONSULT_STATUS(11),
    /**
     * 联系人列表
     */
    CONTACTS_LIST(20),
    /**
     * 新联系人列表
     */
    CONTACTS_LIST_NEWS(21),
    /**
     * 同行列表
     */
    COLLEAGUE_LIST(22),
    /**
     * 新同行列表
     */
    COLLEAGUE_LIST_NEWS(23),
    /**
     * 通知列表
     */
    MESSAGE_LIST(30),
    /**
     * 好友聊天消息
     */
    CHAT_FRIEND_MESSAGE(50),
    /**
     * 同行聊天消息
     */
    CHAT_COLLEAGUE_MESSAGE(60),
    /**
     * 论坛消息
     */
    FORUM_MESSAGE(70),
    /**
     * 空
     */
    NULL(-1);

    private int value = 0;
    private PushMessageType(int value) {
        this.value = value;
    }
    public static PushMessageType valueStrOf(String value) {
        int vl=Integer.valueOf(value);
        return valueOf(vl);
    }
    public static PushMessageType valueOf(int value) {
        switch (value) {
            case 1:
                return SYSTEM;
            case 10:
                return CONSULT_LIST;
            case 11:
                return CONSULT_STATUS;
            case 20:
                return CONTACTS_LIST;
            case 21:
                return CONTACTS_LIST_NEWS;
            case 22:
                return COLLEAGUE_LIST;
            case 23:
                return COLLEAGUE_LIST;
            case 30:
                return MESSAGE_LIST;
            case 50:
                return CHAT_FRIEND_MESSAGE;
            case 60:
                return CHAT_COLLEAGUE_MESSAGE;
            case 70:
                return FORUM_MESSAGE;
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