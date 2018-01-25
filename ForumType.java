package cn.woonton.business.enums;

public enum ForumType {
	/**
	 * 正常帖子
	 */
	NORMAL(1),
	/**
	 * 匿名帖子
	 */
	ANONYMOUS(2),
    /**
	 * 系统帖子
	 */
    SYSTEM(3);
    
	private int value = 1;

	private ForumType(int value) {
		this.value = value;
	}

	public static ForumType valueOf(int value) {
		switch (value) {
		case 1:
			return NORMAL;
		case 2:
			return ANONYMOUS;
		case 3:
			return SYSTEM;
		default:
			return NORMAL;
		}
	}

	public int value() {
		return this.value;
	}
}
