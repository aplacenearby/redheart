package cn.woonton.business.enums;

public enum SmsType {  
	/**公用，用于给医生发送短信,参数doctor,notice_msg**/
	COMMON("doctor_notice_common"),
	/**发送动态码**/
	NORMAL("doctor_valid"),
    /**密码重置**/
	RESETPASSWORD("doctor_pswreset"),
	/**发起咨询提醒**/
	NOTICE("doctor_notice"),
	/**医生审核,参数doctor,flag,msg**/
	AUDIT("doctor_audit"),
	/**医生提现失败**/
	WITHDRAW("doctor_withdrawals"),
	/**医生结算信息**/
	STATEMENT("doctor_notice_statement"),
	/**医生注册完善资料提醒**/
	NOTICEREG("doctor_reg"),
	/**医生收到好友添加提醒**/
	CONTACTS("doctor_contacts"),
	/**提醒医生投保免费医责险**/
	POLICY("doctor_notice_policy"),
	/**通知管理员短信**/
	ADMIN("woonton_admin"),
	/**通知管理员短信**/
	KEEPER("woonton_keeper"), 
	/**患者短信**/
	MEMBER("woonton_member"); 
   private String value = "doctor_valid";
    private SmsType(String value) {    //    必须是private的，否则编译错误
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
