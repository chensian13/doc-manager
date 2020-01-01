package csa.app.doc.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import csa.app.doc.analyser.DocumentAnalyser;
import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Document;
import csa.app.doc.domain.MyFile;
import csa.app.doc.io.FileHelper;
import csa.app.doc.presenter.EditDocumentPresenter;
import csa.app.doc.ui.view.CoordinateView;
import csa.app.doc.ui.view.DocListView;
import csa.app.doc.ui.view.MyJPanel;
import csa.app.doc.utils.DialogUtil;
import csa.app.doc.utils.LogUtil;

public class SearchApp extends MyJPanel{
	CoordinateView coordinateView;
	DocListView docListView;
	EditDocumentPresenter presenter=new EditDocumentPresenter();
	private final String loc_store=ConfigProperties.getConfig().getLocStore();

	public void addListener() {
		coordinateView.configBtnOper("搜索", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc=coordinateView.getDocument();
				String path=DocumentAnalyser.getPathByDocumentDir(doc);
				LogUtil.info("坐标："+path);
				if(!FileHelper.exists(path)){
					DialogUtil.info("该坐标不存在！");
					return;
				}
				//绑定数据
				docListView.setNowFile(new MyFile(path));
				MyFile[] myFiles=null;
				try{
					myFiles=presenter.searchMyFileByDocument(path,doc.getDocName());
				}catch(RuntimeException e1){
					myFiles=presenter.searchMyFileByDocument(path,null);
				}
				docListView.bindData(myFiles);
			} //end fn
		});
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		setLayout(new GridLayout(1,2));
		
		
		
		coordinateView=new CoordinateView();
		docListView=new DocListView();
		add(coordinateView);
		add(docListView);
		setVisible(true);
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

}
