package csa.app.doc.ui.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.io.FileHelper;
import csa.app.doc.ui.common.ImageShowWay;
import csa.app.doc.ui.view.MyJPanel;
import csa.app.doc.utils.EmptyUtil;

/**
 * 
 * @author csa
 *
 */
public class BgPanel extends MyJPanel{
	Config config;

	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		config=ConfigProperties.getConfig();
		
		setLayout(new BorderLayout());
		if(!EmptyUtil.isEmpty(config.getBg()) 
				&& FileHelper.exists(config.getBg())){
			setImage(new ImageIcon(config.getBg()).getImage(), ImageShowWay.COVER, 0, 0);
		}
		
		
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

}
