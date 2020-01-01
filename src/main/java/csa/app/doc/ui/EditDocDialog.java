package csa.app.doc.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import csa.app.doc.App;
import csa.app.doc.analyser.DocumentAnalyser;
import csa.app.doc.domain.Document;
import csa.app.doc.domain.MyFile;
import csa.app.doc.io.FileHelper;
import csa.app.doc.presenter.EditDocumentPresenter;
import csa.app.doc.ui.common.ConstantSize;
import csa.app.doc.ui.view.CoordinateView;
import csa.app.doc.ui.view.DocListView;
import csa.app.doc.ui.view.IRule;
import csa.app.doc.utils.DialogUtil;
import csa.app.doc.utils.LogUtil;
import csa.app.doc.utils.WinSystem;

/**
 * 
 * @author csa
 *
 */
public class EditDocDialog extends JDialog implements IRule{
	private CoordinateView coordinateView;
	EditDocumentPresenter presenter=new EditDocumentPresenter();
	Document doc;
	DocListView docListView;

	public EditDocDialog(DocListView docListView) {
		super(App.getApp(),"坐标编辑");
		this.docListView=docListView;
		init();
		addListener();
	}

	public void addListener() {
		coordinateView.configBtnOper("保存", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				MyFile src=DocumentAnalyser.getCompletFile(doc);
				Document doc=coordinateView.getDocument();
				doc.setFileType(FileHelper.getSuffix(src.getName()));
				MyFile obj=DocumentAnalyser.getCompletFile(doc);
				LogUtil.info("修改前路径："+src.getAbsolutePath());
				LogUtil.info("修改后路径："+obj.getAbsolutePath());
				if(src.equals(obj)){
					//没有修改坐标
					return;
				}
				//先复制 再删除
				try{
					presenter.modDocument(src,
							coordinateView.getDocument());
					//之后的工作
					DialogUtil.info("保存成功！");
					//重置
					coordinateView.reset();
					docListView.setNowFile(obj.getParentMyFile());
					docListView.bindData(obj.getParentMyFile().listMyFiles());
					setVisible(false);
				}catch(RuntimeException e){
					DialogUtil.error(e.getMessage());
				}
			}
		});
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}
	public void bindData(Document doc) {
		this.doc=doc;
		coordinateView.bindData(doc);
	}

	public void init() {
		coordinateView=new CoordinateView();
		add(coordinateView);
		
		Dimension screen=WinSystem.getScreen();
		int w=(int)(screen.width*ConstantSize.EDIT_W_RATIO);
		int h=(int)(screen.height*ConstantSize.EDIT_H_RATIO);
		setBounds((screen.width-w)/2, (screen.height-h)/2, w, h);
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
