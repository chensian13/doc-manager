package csa.app.doc.ui.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

import csa.app.doc.ui.common.ImageShowWay;

/**
 * 
 * @author csa
 *
 */
public abstract class MyJPanel extends JPanel implements IRule{
	//背景图片
	private Image image;
	private int imageWidth;
	private int imageHeight;
	//显示背景图片的方式
	private String showWay=ImageShowWay.ORIGIN;
	
	
	public MyJPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		onCreate();
	}

	public MyJPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		onCreate();
	}

	public MyJPanel(LayoutManager layout) {
		super(layout);
		onCreate();
	}

	public MyJPanel() {
		onCreate();
	}
	
	private void onCreate(){
		init();
		bindData();
		
		addListener();
		makeOpaque();
	}

	/**
	 * 加入图像
	 * boolean drawlmage(Image img , int x , int y , int width , int height , ImageObserver observer)
	 * observer 绘制进程中以通告为目的的对象（ 可能为 null )
	 */
	@Override
	public void paintComponent(Graphics g) {
		//图片路径没有初始化
		if(image==null){
			super.paintComponent(g);
			return ;
		}
		//显示背景图片
		if(ImageShowWay.ORIGIN.equals(showWay)){
			//图片原先大小
			g.drawImage(image, 0, 0, image.getWidth(this), image.getHeight(this), null);
		}else if(ImageShowWay.COVER.equals(showWay)){
			//覆盖组件
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		}else if(ImageShowWay.SELF.equals(showWay)){
			//自定义宽高
			if(imageHeight<0){
				imageHeight=this.getWidth();
			}
			if(imageWidth<0){
				imageWidth=this.getWidth();
			}
			g.drawImage(image, 0, 0, imageWidth, imageHeight, null);
		}
		
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image,String showWay,int imageWidth,int imageHeight) {
		this.image = image;
		this.showWay=showWay;
		this.imageWidth=imageWidth;
		this.imageHeight=imageHeight;
		this.repaint();
	}

	
	public void makeOpaque() {
		setOpaque(false);
	}
	
	private JComponent nowComponent;
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
	public void setNowComponent(JComponent nowComponent) {
		this.nowComponent = nowComponent;
	}


}
