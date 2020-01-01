package csa.app.doc.ui.view;

import java.awt.Component;

import javax.swing.JScrollPane;

/**
 * 
 * @author csa
 *
 */
public class MyJScrollPane extends JScrollPane implements IRule{


	public MyJScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		init();
	}

	public MyJScrollPane(Component view) {
		super(view);
		init();
	}

	public MyJScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		init();
	}
	
	public void init() {
		defaultScrollBarPolicy();
	}
	
	public void defaultScrollBarPolicy(){
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

	public void makeOpaque() {
		// TODO Auto-generated method stub
		
	}
	

}
