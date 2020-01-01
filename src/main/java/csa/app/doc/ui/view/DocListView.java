package csa.app.doc.ui.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.MyFile;
import csa.app.doc.ui.common.TextFactory;
import csa.app.doc.utils.DialogUtil;
import csa.app.doc.utils.DocChooser;
import csa.app.doc.utils.WinSystem;

/**
 * 文档列表
 * @author csa
 *
 */
public class DocListView extends MyJPanel{
	private JList<MyFile> docs;
	private ListModel dataModel;
	private JPanel panel;
	private MyButton b_back;
	PopupMenuView popupMenuView;
	//当前目录
	MyFile nowFile;

	public void addListener() {
		docs.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				int index=docs.locationToIndex(e.getPoint());
				if(index<0)return;
				nowFile=(MyFile)dataModel.getElementAt(index);
				if(e.isMetaDown()){
					//右键
					if(nowFile==null || nowFile.isDirectory()) return;
					popupMenuView.show(e.getComponent(),e.getX(), e.getY());
					popupMenuView.setNowFile(nowFile);
				}else if(e.getClickCount()==2){
					//双击
					if(nowFile.isDirectory()){
						bindData(nowFile.listMyFiles(new DocChooser()));
					}else{
						//文档
						WinSystem.openFile(nowFile,"文档打开异常！");
					}
				} //end else
			}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {}
		});
		b_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nowFile==null) return;
				if(nowFile.isSimplePath(new MyFile(ConfigProperties.getConfig().getLocStore()))){
					DialogUtil.info("已到根目录！");
					return;
				}
				nowFile=nowFile.getParentMyFile();
				bindData(nowFile.listMyFiles());
			}
		});
	}

	public void bindData(MyFile[] myFiles) {
		//this.nowFile=myFile;
		dataModel = new DefaultComboBoxModel(myFiles);
		docs.setModel(dataModel);
	}

	public void init() {
		setLayout(new BorderLayout());
		docs=new JList<MyFile>();
		panel=new JPanel();
		FlowLayout flowLayout=new FlowLayout(FlowLayout.LEFT);
		panel.setLayout(flowLayout);
		b_back=new MyButton("<<");
		b_back.setFont(TextFactory.getDefaultFont());
		MyJScrollPane s = new MyJScrollPane(docs);
		popupMenuView=new PopupMenuView(this);
		
		panel.add(b_back);
		add(panel,BorderLayout.NORTH);
		add(s,BorderLayout.CENTER);
		
		panel.setOpaque(false);
		
		
		setVisible(true);
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}
	
	

	public void setNowFile(MyFile nowFile) {
		this.nowFile = nowFile;
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

}
