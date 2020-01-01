package csa.app.doc.ui.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import csa.app.doc.domain.Document;
import csa.app.doc.ui.common.TextFactory;

/**
 * 文档坐标
 * @author csa
 *
 */
public class CoordinateView extends MyJPanel{
	private JPanel p_type;
	private JPanel p_name;
	private JPanel p_version;
	private JPanel p_btn;
	
	private JLabel l_type;
	private JLabel l_name;
	private JLabel l_version;
	
	private JTextField t_type;
	private JTextField t_name;
	private JTextField t_version;
	
	private int field;
	private Document doc;
	
	private MyButton b_oper;
	
	public Document getDocument(){
		doc=new Document(t_type.getText(), t_name.getText(), t_version.getText());
		return doc;
	}

	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}
	
	public void bindData(Document doc) {
		t_name.setText(doc.getName());
		t_type.setText(doc.getType());
		t_version.setText(doc.getVersion());
	}

	public void init() {
		field=12;
		
		p_name=new JPanel();
		p_type=new JPanel();
		p_version=new JPanel();
		p_btn=new JPanel();
		l_type=new JLabel("类型");
		l_name=new JLabel("名称");
		l_version=new JLabel("版本");
		t_type=new JTextField(field);
		t_name=new JTextField(field);
		t_version=new JTextField(field);
		b_oper=new MyButton("搜索");

		//设置透明
		p_name.setOpaque(false);
		p_type.setOpaque(false);
		p_version.setOpaque(false);
		p_btn.setOpaque(false);
		l_type.setOpaque(false);
		l_name.setOpaque(false);
		l_version.setOpaque(false);
		
		Font font=TextFactory.getDefaultFont();
		l_name.setFont(font);
		l_type.setFont(font);
		l_version.setFont(font);
		
//		l_name.setForeground(Color.white);
//		l_type.setForeground(Color.white);
//		l_version.setForeground(Color.white);
//		t_type.setOpaque(false);
//		t_name.setOpaque(false);
//		t_version.setOpaque(false);
//		b_oper.setOpaque(false);
		
		//设置布局
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p_type.add(l_type);
		p_type.add(t_type);
		p_name.add(l_name);
		p_name.add(t_name);
		p_version.add(l_version);
		p_version.add(t_version);
		p_btn.add(b_oper);
		add(p_type);
		add(p_name);
		add(p_version);
		add(p_btn);
		
		setVisible(true);
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 */
	public void reset(){
		t_name.setText(null);
		t_type.setText(null);
		t_version.setText(null);
	}
	
	/**
	 * 
	 */
	public void configBtnOper(String oper,ActionListener actionListener){
		b_oper.setText(oper);
		b_oper.addActionListener(actionListener);
	}

}
