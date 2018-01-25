package cn.woonton.business.enums;

public enum ArticleCategory {
	/**
	 * 文章
	 */
	ARTICLE(1), 
	/**
	 * 帮助
	 */
	HELP(2),
	/**
	 * banner图
	 */
	BANNER(3),
	/**
	 * 就医指南
	 */
	GUIDE(4),
	/**
	 * 用户协议
	 */
	AGREEMENT(5),
	/**
	 * 关于
	 */
	ABOUT(6);
	
	 private int value = -1;

    private ArticleCategory(int value) {    
        this.value = value;
    }

    public static ArticleCategory valueOf(int value) {  
        switch (value) {
	        case 1:
	            return ARTICLE;
	        case 2:
	            return HELP;
	        case 3:
	            return BANNER;
	        case 4:
	            return GUIDE;
	        case 5:
	            return AGREEMENT;
	        case 6:
	            return ABOUT;
        }
		return null;
    }

    public int value() {
        return this.value;
    }
}
