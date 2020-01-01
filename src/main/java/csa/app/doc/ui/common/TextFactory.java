package csa.app.doc.ui.common;

import java.awt.Font;

/**
 * 字体工厂
 * @author csa
 *
 */
public class TextFactory {
	
	public static Font getDefaultFont(){
		return new Font(FontFamily.sansSerif, Font.PLAIN, 12);
	}

}
