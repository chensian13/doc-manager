package csa.app.doc.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import csa.app.doc.analyser.DocumentAnalyser;
import csa.app.doc.domain.MyFile;
import csa.app.doc.presenter.EditDocumentPresenter;
import csa.app.doc.ui.EditDocDialog;
import csa.app.doc.utils.DialogUtil;

/**
 * 弹出菜单
 * @author csa
 *
 */
public class PopupMenuView extends JPopupMenu implements IRule{
	JMenuItem edit=new JMenuItem("编辑坐标");
	JMenuItem del=new JMenuItem("删除");
	EditDocDialog dialog;
	private MyFile docFile;
	private DocListView docListView;
	
	EditDocumentPresenter presenter=new EditDocumentPresenter();
	
	public PopupMenuView(DocListView docListView) {
		this.docListView=docListView;
		init();
	}
	
	
	
	public void addListener() {
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DialogUtil.confirm("是否删除 "+docFile.getName()+"?")){
					MyFile file=presenter.delDocument(docFile);
					//回退删除后的目录
					docListView.bindData(file.listMyFiles());
				}
			}
		});
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				dialog.bindData(DocumentAnalyser.getDocument(docFile));
			}
		});
	}
	
	public void bindData() {
		
	}
	public void init() {
		add(edit);
		add(del);
		
		dialog=new EditDocDialog(docListView);
		addListener();
	}
	public void setTitle() {
		// TODO Auto-generated method stub
		
	}
	public void setIcon() {
		// TODO Auto-generated method stub
		
	}
	
	public void setNowFile(MyFile docFile) {
		this.docFile = docFile;
	}



	public void makeOpaque() {
		// TODO Auto-generated method stub
		
	}

}
