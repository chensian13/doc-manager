package csa.app.doc.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csa.app.doc.presenter.EditDocumentPresenter;
import csa.app.doc.ui.view.CoordinateView;
import csa.app.doc.ui.view.DocChooserPanel;
import csa.app.doc.ui.view.MyJPanel;
import csa.app.doc.utils.DialogUtil;

public class UploadApp extends MyJPanel{
	CoordinateView coordinateView;
	DocChooserPanel docChooserPanel;
	EditDocumentPresenter presenter=new EditDocumentPresenter();

	public void addListener() {
		coordinateView.configBtnOper("上传", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//上传
				try{
					presenter.addDocument(docChooserPanel.getDocFile(), coordinateView.getDocument());
					DialogUtil.info("上传成功！");
					//重置
					coordinateView.reset();
					docChooserPanel.reset();
				}catch(RuntimeException e){
					DialogUtil.error(e.getMessage());
				}
			}
		});
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		setLayout(new GridLayout(1,2));
		
		//setImage(new ImageIcon("img/bg.jpg").getImage(), ImageShowWay.COVER, 0, 0);
		
		coordinateView=new CoordinateView();
		docChooserPanel=new DocChooserPanel();
		
		add(coordinateView);
		add(docChooserPanel);
		setVisible(true);
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

}
