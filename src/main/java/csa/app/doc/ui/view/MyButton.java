package csa.app.doc.ui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.Border;

/**
 * 
 * @author csa
 *
 */
public class MyButton extends JButton implements IRule{

	public MyButton() {
		super();
		onCreate();
	}
	public MyButton(String text) {
		super(text);
		onCreate();
	}
	
	private void onCreate(){
		init();
		
		addListener();
	}
	
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	public void bindData() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		// 设置原来按钮背景透明
		setOpaque(false);
		defaultBorder();
	}
	public void setTitle() {
		// TODO Auto-generated method stub
		
	}
	public void setIcon() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void defaultBorder(){
		setBorder(new Border() {
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				g.setColor(Color.gray);
				g.drawRoundRect(0, 0, c.getWidth()-1 , c.getHeight()-1 , 6, 6);
			}
			
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(3, 8, 3, 8);
			}
		});
	}
	public void makeOpaque() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
