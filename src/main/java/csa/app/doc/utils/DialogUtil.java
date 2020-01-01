package csa.app.doc.utils;

import javax.swing.JOptionPane;

/**
 * 弹出层
 * @author csa
 *
 */
public class DialogUtil {
	
	/**
	 * 确认
	 * @param msg
	 * @return
	 */
	public static boolean confirm(String msg){
		int i=JOptionPane.showConfirmDialog(null, msg,"友情提示",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if(i==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void info(String msg){
		JOptionPane.showMessageDialog(null, msg,"友情提示",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void error(String msg){
		JOptionPane.showMessageDialog(null, msg,"友情提示",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public static void success(String msg){
		JOptionPane.showMessageDialog(null, msg,"友情提示",
				JOptionPane.INFORMATION_MESSAGE);
	}
	

}
