package csa.app.doc.utils;

/**
 * 对象判空
 * @author csa
 *
 */
public class EmptyUtil {
	
	public static boolean isEmpty(String s){
		if(s==null || "".equals(s.trim())){
			return true;
		}
		return false;
	}

}
