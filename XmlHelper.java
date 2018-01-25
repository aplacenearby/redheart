package cn.woonton.business.util;


import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import cn.woonton.business.bean.WXPayInfo;
import cn.woonton.business.bean.WXRefund;

public class XmlHelper {
	/**
	* 扩展xstream使其支持CDATA
	*/
	private static XStream xstream = new XStream(new XppDriver() {
	 public HierarchicalStreamWriter createWriter(Writer out) {
	 return new PrettyPrintWriter(out) {
	  //增加CDATA标记
	  boolean cdata = true;
	  @SuppressWarnings("rawtypes")
	  public void startNode(String name, Class clazz) {
	  super.startNode(name, clazz);
	  }
	  protected void writeText(QuickWriter writer, String text) {
	  if (cdata) {
	   writer.write("<![CDATA[");
	   writer.write(text);
	   writer.write("]]>");
	  } else {
	   writer.write(text);
	  }
	  }
	 };
	 }
	});
	public static String payInfoToXML(WXPayInfo pi) {
	 xstream.alias("xml", pi.getClass());
	 return xstream.toXML(pi).replaceAll("__", "_");
	}
	
	public static String refundToXML(WXRefund obj) {
		 xstream.alias("xml", obj.getClass());
		 return xstream.toXML(obj).replaceAll("__", "_");
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(String xml) throws Exception {
	 Map<String, String> map = new HashMap<String, String>();
	 Document document = DocumentHelper.parseText(xml);
	 Element root = document.getRootElement();
	 List<Element> elementList = root.elements();
	 for (Element e : elementList)
	 map.put(e.getName(), e.getText());
	 return map;
	} 
	
	@SuppressWarnings("rawtypes")
	public static String parse(String protocolXML,String root,String tag) throws DocumentException {  
            Document doc=(Document)DocumentHelper.parseText(protocolXML);   
            Element books = doc.getRootElement();   
            Iterator Elements = books.elementIterator(root);//指定获取那个元素   
            String val="";
           while(Elements.hasNext()){   
               Element head = (Element)Elements.next();   
               val = head.elementTextTrim(tag);
               if(val!=null&&!val.equals(""))
            	   break;
             }   
             return val;
	}
}
