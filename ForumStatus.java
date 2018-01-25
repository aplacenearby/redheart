package cn.woonton.business.enums;

public enum ForumStatus {
	/**
	 * 删除，隐藏
	 */
	DROP(-1),
	/**
	 * 通过
	 */
	PASSED(2),
    /**
	 * 审核中
	 */
    REVIEW(1),
    /**
     * 违规
     */
    ILLEGAL(0);
    
	private int value = -1;

	private ForumStatus(int value) {
		this.value = value;
	}

	public static ForumStatus valueOf(int value) {
		switch (value) {
		case -1:
			return DROP;
		case 0:
			return ILLEGAL;
		case 1:
			return REVIEW;
		case 2:
			return PASSED;
		default:
			return DROP;
		}
	}

	public int value() {
		return this.value;
	}
}
