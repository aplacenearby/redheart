package cn.woonton.business.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.mysql.jdbc.StringUtils;

import cn.woonton.business.bean.WXRefund;
import cn.woonton.business.bean.chat.Lcfile;
import cn.woonton.business.bean.chat.Message;
import cn.woonton.business.bean.chat.PullMessage;
import cn.woonton.business.bean.chat.PushMessage;
import cn.woonton.business.enums.Lctype;
public class tools {
	public tools(){
		System.out.println("tools");
	}
	 public static final String CONV = "https://api.leancloud.cn/1.1/classes/_Conversation";  
	  public static final String LOGS="https://leancloud.cn/1.1/rtm/messages/logs";
	  public static final String MESSAGE="https://leancloud.cn/1.1/rtm/messages";
	  public static final String PUT_MESSAGE="https://leancloud.cn/1.1/push";
	  public static final String ONLINE="https://leancloud.cn/1.1/rtm/online";
	public static void main(String[] args) throws Exception {
		//System.out.println(Base64Helper.encode("12345".getBytes()));
		//System.out.println(SysUtil.getPYIndexStr("周佳冰".substring(0,1), true));
		//wyCreate();
		//String str = "{\"code\":414,\"msg\":\"bad param 'callerAcc'\"}";
		//rlCall();
//		String[] mobile={"15305712960"};//,"13685779494"18072985515
//		String[] param={"吾桐用户"};
//		NeteaseAPI.sendMsg("bec718cb24467f7ba9bb2c62062441ac", "67b822a04bb5", "3031406", mobile, param);
		//wyCreate();
		//wyCall();
		//String ret = NeteaseAPI.queryBySession("72f190099bc0576e69a9da6d76a5e442","ac914d589f0b","735512cc-c226-41c1-b8b3-c90fed4d533f");
		//System.out.println(ret);
//		long t1=System.currentTimeMillis();
//		System.out.println((int)(7/5.0));
		String convId = "59706e7a44d9040057ec5e0e";
		getConvLogs(convId);
	}
	public static String thumbnailImg(String filepath,int width,int height){
		File f = new File(filepath);
		BufferedImage bufferedImage; 
		
		return "";
	}
	public static void getConvLogs(String convId){
		List<PullMessage> result=new ArrayList<PullMessage>();
		  String appKey="aTqrXj4gMR0IhPjeGwiQ3468";
		  String masterKey="g9XhywBuhGru2njlgyHpbCbI";
        
		  Map<String, String> header = new HashMap<String, String>();
		  header.put("X-LC-Id", appKey);
		  header.put("X-LC-Key", masterKey+",master");
		  header.put("Content-Type", "application/json");
			header.put("Content-Type", "application/json");
			String url=LOGS+"?convid="+convId+"&limit=1000";
			String callMsg = OkHttpHelper.get(url, header);
			if(!callMsg.equals("error")) {
				ObjectMapper mapper = new ObjectMapper();
				callMsg=callMsg.replace("\\\"", "\"").replace("\"{", "{").replace("}\"", "}");
				try {
					JsonNode root = mapper.readTree(callMsg);
					JsonNode node = root.path("error");
					if (node.isMissingNode()) {
						result=JsonHelper.jsonToListBean(PullMessage.class, callMsg);
						for(int i =0;i<result.size();i++){
							 System.out.println(result.get(i).getData().get_lctype()); 
							 System.out.println(result.get(i).getData().get_lctext());
							 System.out.println(new Date(result.get(i).getTimestamp()));
							 System.out.println("###########################");
						}
					} 
				} catch (IOException e) {
					
				}
			}
	}
	/***
	 * 根据IP获取地区信息
	 * @param ip
	 * @return
	 */
	public static String getIPMess(String ip){
		String ret="";
		try{
			if(StringHelper.isNullOrEmpty(ip))
				ret = "无信息";
			else{
				String s = HttpHelper.get2("http://ip.taobao.com/service/getIpInfo.php?ip="+ip, null);
				String temp = JsonHelper.getValue(s,"data").toString();
				ret=JsonHelper.getValue(temp,"region").toString()+","+JsonHelper.getValue(temp,"city").toString();
				//ret = JsonHelper.getTextToPath(s, new String[]{"data","region"})+","+JsonHelper.getTextToPath(s, new String[]{"data","city"});
			}
		}
		catch(Exception e1){
			ret="无信息";
		}
		return ret;
	}
	/***
	 * 根据手机号获取地区信息
	 * @param mobile
	 * @return
	 */
	public static String getMobileMess(String mobile){
		String ret="";
		try{
			if(StringHelper.isNullOrEmpty(mobile))
				ret = "无信息";
			else{
				String s = HttpHelper.get2("http://sj.apidata.cn/?mobile="+mobile, null);
				String temp = JsonHelper.getValue(s,"data").toString();
				ret = JsonHelper.getValue(temp,"province").toString()+","+
						JsonHelper.getValue(temp,"isp").toString()+","+
						JsonHelper.getValue(temp,"city").toString();
			}
		}
		catch(Exception e1){
			ret="无信息";
		}
		return ret;
	}
	
	/**网易云信双人专线通话**/
	public static void wyCall(){
		Map<String, String> header = new HashMap<String, String>();
		String AppKey="72f190099bc0576e69a9da6d76a5e442";
		String Nonce=SysUtil.getMD5(String.valueOf(new Date().getTime()));
		String CurTime = String.valueOf(new Date().getTime()/1000);
		header.put("content-type","application/x-www-form-urlencoded;charset=utf-8");
		header.put("AppKey",AppKey);
		header.put("Nonce", Nonce);
		header.put("CurTime", CurTime);
		header.put("CheckSum", getCheckSum("ac914d589f0b",Nonce,CurTime));
		String poststr = "callerAcc=13685779494&caller=057186778825&callee=13685779494&maxDur=30&record=true";
		String ret =HttpHelper.post3("https://api.netease.im/call/ecp/startcall.action", poststr, header);
		System.out.println(ret);
	}
	public static void wyCall2(){
		Map<String, String> header = new HashMap<String, String>();
		String AppKey="bec718cb24467f7ba9bb2c62062441ac";
		String Nonce=SysUtil.getMD5(String.valueOf(new Date().getTime()));
		String CurTime = String.valueOf(new Date().getTime()/1000);
		header.put("content-type","application/x-www-form-urlencoded;charset=utf-8");
		header.put("AppKey",AppKey);
		header.put("Nonce", Nonce);
		header.put("CurTime", CurTime);
		header.put("CheckSum", getCheckSum("67b822a04bb5",Nonce,CurTime));
		String poststr = "callerAcc=15305712960&caller=15305712960&callee=[\"13685779494\"]&maxDur=60";
		String ret =HttpHelper.post3("https://api.netease.im/call/ecp/startconf.action", poststr, header);
		System.out.println(ret);
	}
	/**网易云信创建账户**/
	public static void wyCreate(){
		Map<String, String> header = new HashMap<String, String>();
		String AppKey="72f190099bc0576e69a9da6d76a5e442";
		String Nonce=SysUtil.getMD5(String.valueOf(new Date().getTime()));
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String CurTime = String.valueOf(cal.getTimeInMillis()/1000-20);
		
		System.out.println("Time:"+DateUtils.getDateStr(cal.getTime(), "yyyy-MM-dd HH:mm:ss SS"));
		header.put("content-type","application/x-www-form-urlencoded;charset=utf-8");
		header.put("AppKey",AppKey);
		header.put("Nonce", Nonce);
		header.put("CurTime", CurTime);
		String CheckSum = getCheckSum("ac914d589f0b",Nonce,CurTime);
		header.put("CheckSum", CheckSum);
		String poststr = "accid=13685779494&name=13685779494";
		System.out.println("AppKey:"+AppKey);
		System.out.println("Nonce:"+Nonce);
		System.out.println("CurTime:"+CurTime);
		System.out.println("CheckSum:"+CheckSum);
		System.out.println("url:https://api.netease.im/nimserver/user/create.action   "+poststr);
		String ret =HttpHelper.post3("https://api.netease.im/nimserver/user/create.action", poststr, header);
		System.out.println(ret);
	}
	/***************************荣联云通讯账户**********************************/
	/****创建荣联云通讯账户****/
	public static void rlCreate(){
		String appId="8a216da857087494015708de0a9c00f8";
		String sid="8a216da857087494015708de0a0600f3";
		 String url="https://app.cloopen.com:8883/2013-12-26/Accounts/"+sid+"/SubAccounts";
		 String timestamp=DateUtils.getDateStr(new Date(), "yyyyMMddHHmmss");
		 url+="?sig="+SysUtil.getMD5(sid+
		 "87683a2694e54775ba735ac491d0eaac"+
		 timestamp);
		 Map<String, String> header = new HashMap<String, String>();
		 header.put("Accept","application/json");
		 header.put("Content-Type","application/json;charset=utf-8");
		 header.put("Content-Length","1256");
		 String auth=sid+":"+timestamp;
		 header.put("Authorization",Base64Helper.encode(auth.getBytes()));
		 String poststr = "{'appId':'8a216da857087494015708de0a9c00f8','friendlyName':'15305712960'}";
		 String ret =HttpHelper.post3(url, poststr, header);
		 System.out.println(ret);
	}
	public static void rlGetInfo(){
		String appId="8a216da857087494015708de0a9c00f8";
		String sid="8a216da857087494015708de0a0600f3";
		 String url="https://sandboxapp.cloopen.com:8883/Accounts/"+sid+"/AccountInfo";
		 String timestamp=DateUtils.getDateStr(new Date(), "yyyyMMddHHmmss");
		 url+="?sig="+SysUtil.getMD5(sid+
		 "87683a2694e54775ba735ac491d0eaac"+
		 timestamp).toUpperCase();
		 Map<String, String> header = new HashMap<String, String>();
		 header.put("Host","192.168.0.1");
		 header.put("Accept","application/xml");
		 header.put("Content-Type","application/xml;charset=utf-8");
		 String auth=sid+":"+timestamp;
		 header.put("Authorization",Base64Helper.encode(auth.getBytes()));
		 String ret =HttpHelper.get2(url, header);
		 System.out.println(ret);
	}
	public static void rlCall(){
		String appId="8a216da857087494015708de0a9c00f8";
		String subsid="794ed29e763111e6997a6c92bf2c165d";
		 String url="https://sandboxapp.cloopen.com:8883/SubAccounts/"+subsid+"/Calls/Callback";
		 String timestamp=DateUtils.getDateStr(new Date(), "yyyyMMddHHmmss");
		 url+="?sig="+SysUtil.getMD5(subsid+
		 "cd9cd4792adb6b2591bfede3e8dd39ea"+
		 timestamp);
		 Map<String, String> header = new HashMap<String, String>();
		 header.put("Accept","application/xml");
		 header.put("Content-Type","application/xml;charset=utf-8");
		 header.put("Content-Length","256");
		 String auth=subsid+":"+timestamp;
		 header.put("Authorization",Base64Helper.encode(auth.getBytes()));
		 //String poststr = "{'from':'15305712960','to':'13685779494'}";
		 String poststr = "<?xml version='1.0' encoding='utf-8'?><CallBack>"+
		 "<from>15305712960</from><to>13685779494</to>"+
		 "</CallBack>";
		 String ret =HttpHelper.post3(url, poststr, header);
		 System.out.println(ret);
	}
	/***************************荣联云通讯账户  end**********************************/
	
	/**** 计算并获取CheckSumCheckSum****/
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }
    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
    
    
	public static String getEncode(String str){
		try {
			return Base64Helper.encode(DESHelper.encrypt(str, "Wt123456"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	public static boolean sendMsg(){
		Lctype _lctype=Lctype.text;
		String content = "换个姿势再来一次";
		  boolean result=false;
		  Map<String, String> header = new HashMap<String, String>();
		  header.put("X-LC-Id", "aTqrXj4gMR0IhPjeGwiQ3468");
			header.put("X-LC-Key", "g9XhywBuhGru2njlgyHpbCbI,master");
			header.put("Content-Type", "application/json");
			Message message=new Message();
			message.set_lctype(_lctype.value());
			if(_lctype.equals(Lctype.text)){
				message.set_lctext(content);
			}
			else{
				message.set_lctext("file");
				message.set_lcfile(new Lcfile(content));
			}
			
			PushMessage pushMsg=new PushMessage();
			pushMsg.set__transient(false);
			pushMsg.setConv_id("56b05c0471cfe4005c61fafc");
			pushMsg.setFrom_peer("1B2FD48DE459498795A34483BBB1AF57");
			pushMsg.setMessage(JsonHelper.beanToJson(message));
			String jsonPost=JsonHelper.beanToJson(pushMsg);
			String callMsg = HttpHelper.post("https://leancloud.cn/1.1/rtm/messages", jsonPost, header);
			if(!callMsg.equals("error")) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root;
				try {
					root = mapper.readTree(callMsg);
					result=root.getTextValue()==null;
				 } catch (IOException e) 
				 {
				 }
			}
			return result;
		  
	  }
	public static void getMsg(){
		List<PullMessage> result=new ArrayList<PullMessage>();
		  Map<String, String> header = new HashMap<String, String>();
			header.put("X-LC-Id", "aTqrXj4gMR0IhPjeGwiQ3468");
			header.put("X-LC-Key", "g9XhywBuhGru2njlgyHpbCbI,master");
			header.put("Content-Type", "application/json");
			String url="https://leancloud.cn/1.1/rtm/messages/logs?convid=56b05c0471cfe4005c61fafc&limit=3";
			String callMsg = HttpHelper.get(url, header);
			if(!callMsg.equals("error")) {
				ObjectMapper mapper = new ObjectMapper();
				callMsg=callMsg.replace("\\\"", "\"").replace("\"{", "{").replace("}\"", "}");
				//System.out.println("ret:"+callMsg);
				try {
					JsonNode root = mapper.readTree(callMsg);
					JsonNode node = root.path("error");
					if (node.isMissingNode()) {
						result=JsonHelper.jsonToListBean(PullMessage.class, callMsg);
					} 
				} catch (IOException e) {
					
				}
			}
		System.out.println("ret:"+JsonHelper.beanToJson(result));
		//	System.out.println("ret:"+callMsg);
	}
	
}
