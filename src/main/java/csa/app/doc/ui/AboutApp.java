package csa.app.doc.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import csa.app.doc.domain.About;
import csa.app.doc.ui.common.ImageShowWay;
import csa.app.doc.ui.common.TextFactory;
import csa.app.doc.ui.view.MyJPanel;

/**
 * 
 * @author csa
 *
 */
public class AboutApp extends MyJPanel{
	private JLabel l_appName;
	private JLabel l_author;
	private JLabel l_designer;
	private JLabel l_version;
	private JLabel l_tel;
	
	private JTextField t_appName;
	private JTextField t_author;
	private JTextField t_designer;
	private JTextField t_version;
	private JTextField t_tel;
	private JPanel myJPanel;
	

	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		((FlowLayout)getLayout()).setAlignment(FlowLayout.LEFT);
		
		myJPanel=new JPanel();
		About about=new About();
		l_appName=new JLabel("软件名称");
		l_author=new JLabel("开发者");
		l_designer=new JLabel("设计人");
		l_tel=new JLabel("联系方式");
		l_version=new JLabel("版本号");
		t_appName=new JTextField(about.getAppName(),12);
		t_author=new JTextField(about.getAuthor(),12);
		t_designer=new JTextField(about.getDesigner(),12);
		t_version=new JTextField(about.getVersion(),12);
		t_tel=new JTextField(about.getTel(),12);
		
		l_appName.setFont(TextFactory.getDefaultFont());
		l_author.setFont(TextFactory.getDefaultFont());
		l_designer.setFont(TextFactory.getDefaultFont());
		l_tel.setFont(TextFactory.getDefaultFont());
		l_version.setFont(TextFactory.getDefaultFont());
		
		t_appName.setEditable(false);
		t_author.setEditable(false);
		t_designer.setEditable(false);
		t_version.setEditable(false);
		t_tel.setEditable(false);
		
		myJPanel.setLayout(new GridLayout(5, 2, 20, 5));
		myJPanel.add(l_appName);
		myJPanel.add(t_appName);
		myJPanel.add(l_author);
		myJPanel.add(t_author);
		myJPanel.add(l_designer);
		myJPanel.add(t_designer);
		myJPanel.add(l_version);
		myJPanel.add(t_version);
		myJPanel.add(l_tel);
		myJPanel.add(t_tel);
		myJPanel.setOpaque(false);
	
		add(myJPanel);
		
		setVisible(true);
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

}
