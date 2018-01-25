package cn.woonton.business.enums;

public enum BusinessLogsType {  
	/**医生登录日志**/
	Login(1),
	/**医生审核日志**/
	Verify(2), 
	/**医生提交审核日志**/
	SubmitVerify(3),
	/**医生管家日志**/
	KeeperLog(4),
	/**医生注册提醒**/
	RegRemind(5),
	/**医生短信**/
	SmsSend(6),
	/**微信退款错误日志**/
	Refund(7),
	/**医生提现错误日志**/
	Withdraw(8),
	/**患者微信消息**/
	WeiXin(11),
	/**医生端日志**/
    ApiLog(21),
    /**专线电话日志**/
    CallLog(22);
    private int value = 0;

    private BusinessLogsType(int value) {    //    必须是private的，否则编译错误
        this.value = value;
    }

    public static BusinessLogsType valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
        case 1:
            return Login;
        case 2:
            return Verify;
        case 3:
            return SubmitVerify;
        case 4:
        	return KeeperLog;
        case 5:
        	return RegRemind;
        default:
            return null;
        }
    }

    public int value() {
        return this.value;
    }
}
