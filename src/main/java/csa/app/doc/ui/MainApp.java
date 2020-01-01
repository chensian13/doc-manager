package csa.app.doc.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.ui.common.ConstantSize;
import csa.app.doc.ui.view.BgPanel;
import csa.app.doc.ui.view.MenuView;
import csa.app.doc.ui.view.MyJFrame;

public class MainApp extends MyJFrame{
	UploadApp uploadApp;
	SearchApp searchApp;
	MenuView menuView;
	AboutApp aboutApp;
	
	BgPanel bgPanel;
	
	Config config;
	

	public void addListener() {
		menuView.setUploadListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bgPanel.replaceComponent(uploadApp);
			}
		});
		
		menuView.setSearchListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bgPanel.replaceComponent(searchApp);
			}
		});
		
		menuView.setAboutListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bgPanel.replaceComponent(aboutApp);
			}
		});
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		config=ConfigProperties.getConfig();
		if("big".equals(config.getSize())){
			suitableJFrameBoundWithClose(ConstantSize.SHELL_RATIO_BIG);
		}else{
			suitableJFrameBoundWithClose(ConstantSize.SHELL_RATIO);
		}
		
		menuView=MenuView.getMenuView();
		setJMenuBar(menuView);
		
		bgPanel=new BgPanel();
		
		setLayout(new BorderLayout());
		uploadApp=new UploadApp();
		searchApp=new SearchApp();
		aboutApp=new AboutApp();
		
		bgPanel.setNowComponent(searchApp);
		bgPanel.add(searchApp,BorderLayout.CENTER);
		
		add(bgPanel);
		setVisible(true);
	}

	public void setTitle() {
		setTitle("文档行家");
	}

	public void setIcon() {
		setIcon("img/icon.png");
	}
	
	
	/** 
     * 设置窗口图标 
     */  
    protected void setWindowIcon()  {  
        
    }

	

}
