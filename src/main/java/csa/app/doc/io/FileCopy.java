package csa.app.doc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import csa.app.doc.utils.LogUtil;

/**
 * 文件复制
 * @author csa
 *
 */
public class FileCopy {
	//
	private final static int vessel=8*1024;
	
	/**
	 * 
	 * @param src
	 * @param obj
	 */
	public static void copy(String src,String obj){
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		int len=-1;
		byte[] bs=new byte[vessel];
		try {
			LogUtil.info("源文档："+src);
			LogUtil.info("目标文档："+obj);
			bis=new BufferedInputStream(new FileInputStream(src));
			bos=new BufferedOutputStream(new FileOutputStream(obj));
			while((len=bis.read(bs))!=-1){
				bos.write(bs,0,len);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {}
		}
	}
	
	

}
