package cn.woonton.business.enums;

/**
 * 附件分类
 * @author Administrator
 *
 */
public enum AttachType {
	/**
	 * 电子病历 
	 */
	MedicalRecord(1),
	/**
	 * 论坛贴子 
	 */
	Post(2);
	
    private int value = 0;

    private AttachType(int value) {  
        this.value = value;
    }

    public static AttachType valueOf(int value) {   
        switch (value) {
        case 1:
            return MedicalRecord;
        case 2:
            return Post;
        default:
            return null;
        }
    }
    public int value() {
        return this.value;
    }
}
