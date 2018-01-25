package cn.woonton.business.enums;

public enum ChatOwners {
	/**
	 * 1：医生--->用户
	 */
	D_TO_U(1),
	/**
	 * 2：用户--->医生
	 */
	U_TO_D(2),
	/**
	 * 3：用户--->用户
	 */
	U_TO_U(3),
	/**
	 * 4：医生--->医生
	 */
	D_TO_D(4);
	
	private int value = 1;

	private ChatOwners(int value) {
		this.value = value;
	}

	public static ChatOwners valueOf(int value) {
		switch (value) {
		case 1:
			return D_TO_U;
		case 2:
			return U_TO_D;
		case 3:
			return U_TO_U;
		case 4:
			return D_TO_D;
		default:
			return null;
		}
	}

	public int value() {
		return this.value;
	}

}
