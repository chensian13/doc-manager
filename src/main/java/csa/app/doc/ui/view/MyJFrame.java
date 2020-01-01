package csa.app.doc.ui.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;


/**
 * 代表系统一切顶级窗口父类
 * @author 陈思安
 *
 */
public abstract class MyJFrame extends JFrame implements IRule{
	//屏幕大小的信息
	private Dimension screen;
	private int initWidth;
	private int initHeight;
	private JComponent nowComponent;
	
	
	public MyJFrame() throws HeadlessException {
		onCreate();
	}
	public MyJFrame(GraphicsConfiguration gc) {
		super(gc);
		onCreate();
	}
	public MyJFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		onCreate();
	}
	public MyJFrame(String title) throws HeadlessException {
		super(title);
		onCreate();
	}
	/**
	 * 代码块：完成相应初始化工作
	 * 1）screen初始化
	 */
	{
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		//得到屏幕大小的信息,比如最为重要的宽度和高度
		screen=toolkit.getScreenSize();
	}
	
	/**
	 * 初始化方案
	 */
	private void onCreate(){
		//置窗口是关闭
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置标题
		setTitle();
		setIcon();
		//设置jar图标
		setWindowIcon();
		//子类来实现
		init();
		//绑定事件
		addListener();
		makeOpaque();
	}
	
	
	/**
	 * 设置框架图标
	 * @param iconPath图标路径
	 */
	public void setIcon(String iconPath){
		super.setIconImage(new ImageIcon(iconPath).getImage());
	}

	/**
	 * 适中窗口大小和位置方案
	 * @param w是所占屏幕宽度的比例
	 * @param h是所占屏幕高度度的比例
	 */
	public void suitableJFrameBoundWithClose(double ratio){
		if(ratio>=1) return;
		initWidth=(int) (getScreen().width*ratio);
		initHeight=(int) (getScreen().height*ratio);
		//居中位置
		super.setBounds((getScreen().width-initWidth)/2, (getScreen().height-initHeight)/2, 
				initWidth, initHeight);
	}
	
	/**
	 * 适中窗口大小和位置方案
	 * @param width是自定义宽度
	 * @param height是自定义高度
	 */
	public void suitableJFrameBoundWithClose(int width,int height){
		initWidth=width;
		initHeight=height;
		//居中位置
		super.setBounds((getScreen().width-initWidth)/2, (getScreen().height-initHeight)/2, 
				initWidth, initHeight);
	}
	
	/**
	 * 替换容器中的组件
	 * @param old
	 * @param newC
	 */
	public void replaceComponent(JComponent newC){
		try{
			if(nowComponent!=null) remove(nowComponent);
			repaint();
			add(newC);
			validate();
			setNowComponent(newC);
		}catch(Exception e){
			
		}
	}
	
	
	public Dimension getScreen() {
		return screen;
	}


	public void setScreen(Dimension screen) {
		this.screen = screen;
	}
	
	protected void setWindowIcon(){
		
	}
	
	public void makeOpaque() {
		setOpacity(true);
	}
	
	private void setOpacity(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setNowComponent(JComponent nowComponent) {
		this.nowComponent = nowComponent;
	}
	
	
	

}
