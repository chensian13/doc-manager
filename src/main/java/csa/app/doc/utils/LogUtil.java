package csa.app.doc.utils;

import java.util.logging.Logger;

public class LogUtil {
	private static Logger logger=Logger.getGlobal();
	
	/**
	 * 
	 * @param msg
	 */
	public static void info(String msg){
		logger.info(msg);
	}
	
	public static void warn(String msg){
		logger.warning(msg);
	}

}
