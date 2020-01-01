package csa.app.doc.utils;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class WinSystem {
	/**
	 * 屏幕大小的信息
	 * @return
	 */
	public static Dimension getScreen(){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		//得到屏幕大小的信息,比如最为重要的宽度和高度
		Dimension screen=toolkit.getScreenSize();
		return screen;
	}
	
	public static void openFile(File file,String msg){
		try {
			Desktop.getDesktop().open(file); // 启动已在本机桌面上注册的关联应用程序，打开文件文件file
		} catch (IOException e) {
			DialogUtil.error(msg);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
