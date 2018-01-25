package cn.woonton.business.util;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.text.StrBuilder;

public class StringHelper {
	public static final String EMPTY = "";
	public static boolean isNullOrEmpty(String toTest) {
		return (toTest == null || toTest.length() == 0);
	}
	 @SuppressWarnings("rawtypes")
	public static String join(Collection collection , String separator) {
	        Iterator iterator=collection.iterator();
	        // handle null, zero and one elements before building a buffer
	        if (iterator == null) {
	            return null;
	        }
	        if (!iterator.hasNext()) {
	            return EMPTY;
	        }
	        Object first = iterator.next();
	        if (!iterator.hasNext()) {
	            return ObjectUtils.toString(first);
	        }

	        // two or more elements
	        StrBuilder buf = new StrBuilder(256); // Java default is 16, probably too small
	        if (first != null) {
	            buf.append(first);
	        }

	        while (iterator.hasNext()) {
	            if (separator != null) {
	                buf.append(separator);
	            }
	            Object obj = iterator.next();
	            if (obj != null) {
	                buf.append(obj);
	            }
	        }
	        return buf.toString();
	    }
}
