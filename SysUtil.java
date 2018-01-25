package cn.woonton.business.util;

import java.util.Formatter;
import java.util.Random;
import java.util.UUID;

public class SysUtil {
	/**
	 * GET UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	public static String getFullUUID() {
		return UUID.randomUUID().toString();
	}
	/**
	 * 
	 * 返回首字母
	 * 
	 * @param strChinese
	 * 
	 * @param bUpCase
	 * 
	 * @return
	 */

	public static String getPYIndexStr(String strChinese, boolean bUpCase) {

		try {
			StringBuffer buffer = new StringBuffer();
			byte b[] = strChinese.getBytes("GBK");// 把中文转化成byte数组
			for (int i = 0; i < b.length; i++) {
				if ((b[i] & 255) > 128) {
					int char1 = b[i++] & 255;
					char1 <<= 8;// 左移运算符用“<<”表示，是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n次方
					int chart = char1 + (b[i] & 255);
					buffer.append(getPYIndexChar((char) chart, bUpCase));
					continue;
				}
				
				char c = (char) b[i];
				//数字
			    if((b[i] & 255) >= 48&&(b[i] & 255) < 58){
					c = '#';
				}
			    else if (!Character.isJavaIdentifierPart(c))// 确定指定字符是否可以是 Java
			    {
			    	c = '#';
			    }
				buffer.append(c);
			}
			return bUpCase?buffer.toString().toUpperCase():buffer.toString();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 
	 * 得到首字母
	 * 
	 * @param strChinese
	 * 
	 * @param bUpCase
	 * 
	 * @return
	 */

	private static char getPYIndexChar(char strChinese, boolean bUpCase) {
		int charGBK = strChinese;
		char result;
		if (charGBK >= 45217 && charGBK <= 45252)
			result = 'A';
		else if (charGBK >= 45253 && charGBK <= 45760)
			result = 'B';
		else if (charGBK >= 45761 && charGBK <= 46317)
			result = 'C';
		else if (charGBK >= 46318 && charGBK <= 46825)
			result = 'D';
		else if (charGBK >= 46826 && charGBK <= 47009)
			result = 'E';
		else if (charGBK >= 47010 && charGBK <= 47296)
			result = 'F';
		else if (charGBK >= 47297 && charGBK <= 47613)
			result = 'G';
		else if (charGBK >= 47614 && charGBK <= 48118)
			result = 'H';
		else if (charGBK >= 48119 && charGBK <= 49061)
			result = 'J';
		else if (charGBK >= 49062 && charGBK <= 49323)
			result = 'K';
		else if (charGBK >= 49324 && charGBK <= 49895)
			result = 'L';
		else if (charGBK >= 49896 && charGBK <= 50370)
			result = 'M';
		else if (charGBK >= 50371 && charGBK <= 50613)
			result = 'N';
		else if (charGBK >= 50614 && charGBK <= 50621)
			result = 'O';
		else if (charGBK >= 50622 && charGBK <= 50905)
			result = 'P';
		else if (charGBK >= 50906 && charGBK <= 51386)
			result = 'Q';
		else if (charGBK >= 51387 && charGBK <= 51445)
			result = 'R';
		else if (charGBK >= 51446 && charGBK <= 52217)
			result = 'S';
		else if (charGBK >= 52218 && charGBK <= 52697)
			result = 'T';
		else if (charGBK >= 52698 && charGBK <= 52979)
			result = 'W';
		else if (charGBK >= 52980 && charGBK <= 53688)
			result = 'X';
		else if (charGBK >= 53689 && charGBK <= 54480)
			result = 'Y';
		else if (charGBK >= 54481 && charGBK <= 55289)
			result = 'Z';
		else
			result = (char) (65 + (new Random()).nextInt(25));
		if (!bUpCase)
			result = Character.toLowerCase(result);
		return result;
	}

	/**
	 * 获取MD5加密
	 * 
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes("UTF8"));
			java.math.BigInteger number = new java.math.BigInteger(1,
					messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 获取MD5加密
	 * 
	 * @param input
	 * @return
	 */
	public static String getMD5(String input,String code) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes(code));
			java.math.BigInteger number = new java.math.BigInteger(1,
					messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
}
