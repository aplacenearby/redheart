package cn.woonton.business.util;
import java.security.SecureRandom;  
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;  
import javax.crypto.SecretKey; 
public class AESHelper {
	 /** 
     * ���ܺ��� 
     * @param content   ���ܵ����� 
     * @param strKey    ��Կ 
     * @return          ���ض������ַ����� 
     * @throws Exception 
     */  
	public static byte[] enCrypt(String content, String strKey)
			throws Exception {
		KeyGenerator keygen;
        SecretKey desKey;  
        Cipher c;         
        byte[] cByte;  
        String str = content;  
          
        keygen = KeyGenerator.getInstance("AES");  
        keygen.init(128, new SecureRandom(strKey.getBytes()));  
          
        desKey = keygen.generateKey();        
        c = Cipher.getInstance("AES/ECB/PKCS5Padding");  
          
        c.init(Cipher.ENCRYPT_MODE, desKey);  
          
        cByte = c.doFinal(str.getBytes("UTF-8"));         
          
        return cByte;  
    }  
      
    /** ���ܺ��� 
     * @param src   ���ܹ�Ķ������ַ����� 
     * @param strKey  ��Կ 
     * @return 
     * @throws Exception 
     */  
    public static String deCrypt (byte[] src,String strKey) throws Exception{  
        KeyGenerator keygen;          
        SecretKey desKey;  
        Cipher c;         
        byte[] cByte;     
          
        keygen = KeyGenerator.getInstance("AES");  
        keygen.init(128, new SecureRandom(strKey.getBytes()));  
          
        desKey = keygen.generateKey();  
        c = Cipher.getInstance("AES");  
          
        c.init(Cipher.DECRYPT_MODE, desKey);  
          
          
        cByte = c.doFinal(src);   
          
        return new String(cByte,"UTF-8");  
    }  
      
      
    /**2����ת����16���� 
     * @param buf 
     * @return 
     */  
    public static String parseByte2HexStr(byte buf[]) {  
    	StringBuffer sb = new StringBuffer();  
    	             for (int i = 0; i < buf.length; i++) {  
    	                     String hex = Integer.toHexString(buf[i] & 0xFF);  
    	                     if (hex.length() == 1) {  
    	                             hex = '0' + hex;  
    	                     }  
    	                     sb.append(hex.toUpperCase());  
    	             }  
    	             return sb.toString();
        }  
      
      
    /**��16����ת��Ϊ������ 
     * @param hexStr 
     * @return 
     */       
    public static byte[] parseHexStr2Byte(String hexStr) {   
            if (hexStr.length() < 1)   
                    return null;   
            byte[] result = new byte[hexStr.length()/2];   
            for (int i = 0;i< hexStr.length()/2; i++) {   
                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);   
                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);   
                    result[i] = (byte) (high * 16 + low);   
            }   
            return result;   
    }   
}
