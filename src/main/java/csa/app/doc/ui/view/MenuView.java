package csa.app.doc.ui.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import csa.app.doc.ui.common.TextFactory;
import csa.app.doc.utils.Constant;
import csa.app.doc.utils.WinSystem;

/**
 * 菜单栏
 * @author csa
 *
 */
public class MenuView extends JMenuBar{
	private JMenu store=new JMenu("文档仓库");
	private JMenu helper=new JMenu("帮助");
	
	private JMenuItem upload=new JMenuItem("上传文档");
	private JMenuItem search=new JMenuItem("搜索仓库");
	private JMenuItem des=new JMenuItem("使用说明");
	private JMenuItem about=new JMenuItem("关于");
	{
		//设置菜单项字体
		Font font=TextFactory.getDefaultFont();
		store.setFont(font);
		helper.setFont(font);
		upload.setFont(font);
		search.setFont(font);
		des.setFont(font);
		about.setFont(font);
	}
	
	private static MenuView menuView;
	
	/**
	 * 采用单例模式
	 * @return
	 */
	public static MenuView getMenuView(){
		synchronized (MenuView.class) {
			if(menuView==null){
				menuView=new MenuView();
				return menuView;
			}else{
				return menuView;
			}
		}
	}
	
	/**
	 * 构造器
	 */
	private MenuView() {
		//初始化
		init();
		//添加监听事件
		addListener();
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		store.add(upload);
		store.addSeparator();
		store.add(search);
		
		helper.add(des);
		helper.addSeparator();
		helper.add(about);
		
		add(store);
		add(helper);
		
		setVisible(true);
	}
	
	public void addListener(){
		des.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinSystem.openFile(new File(Constant.DOC_HTML_PATH), "HTML文档打开异常！");
			}
		});
	}
	
	//事件绑定
	public void setUploadListener(ActionListener actionListener){
		upload.addActionListener(actionListener);
	}
	
	public void setSearchListener(ActionListener actionListener){
		search.addActionListener(actionListener);
	}
	
	public void setAboutListener(ActionListener actionListener){
		about.addActionListener(actionListener);
	}
	
	public void setDesListener(ActionListener actionListener){
		des.addActionListener(actionListener);
	}
	
	
}
