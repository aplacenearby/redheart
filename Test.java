package cn.woonton.business.enums;

public enum Test {
      e1("一"),
      e2("二"),
      e3("三");
	  String code;
	  private Test(String value) {   
	        this.code = value;
	  }
	  public String value(){
		  return this.code;
	  }
}
