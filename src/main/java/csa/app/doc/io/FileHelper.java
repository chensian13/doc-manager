package csa.app.doc.io;

import java.io.File;

/**
 * 
 * @author csa
 *
 */
public class FileHelper {
	
	/**
	 * 
	 * @param path
	 */
	public static void mkdirs(String path){
		new File(path).mkdirs();
	}
	
	/**
	 * 
	 * @param path
	 */
	public static boolean exists(String path){
		return new File(path).exists();
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String getName(String path){
		return new File(path).getName();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getSuffix(String name){
		return name.substring(name.lastIndexOf("."));
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getNameNoSuffix(String name){
		return name.substring(0,name.lastIndexOf("."));
	}
	
	
	

}
