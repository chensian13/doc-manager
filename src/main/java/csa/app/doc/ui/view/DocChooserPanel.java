package csa.app.doc.ui.view;

import java.io.File;

import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.domain.MyFile;
import csa.app.doc.ui.view.FileChooser.OnChooseListener;
import csa.app.doc.utils.DocChooser;

/**
 * 文档选择器
 * @author csa
 *
 */
public class DocChooserPanel extends MyJPanel{
	Config config=ConfigProperties.getConfig();
	private FileChooser chooser;
	private JTextField t_path;
	private MyFile docFile;
	
	public void addListener() {
		chooser.setChooseListener(new OnChooseListener() {
			public void choose(File file) {
				docFile=new MyFile(file.getAbsolutePath());
				t_path.setText(file.toString());
			}
		});
		
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean accept(File f) {
				return new DocChooser().setOnlyFile(true).accept(f);
			}
		});
	}

	public void bindData() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		t_path=new JTextField(12);
		chooser=new FileChooser();
		
		t_path.setEditable(false);
		
		add(chooser);
		add(t_path);
		
		setVisible(true);
		
	}

	public void setTitle() {
		// TODO Auto-generated method stub
		
	}
	
	public void reset(){
		t_path.setText(null);
	}

	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

	public MyFile getDocFile() {
		if(docFile==null){
			throw new RuntimeException("请先选择文档！");
		}
		if(docFile.getAbsolutePath().contains(config.getLocStore())){
			throw new RuntimeException("不能选择仓库内的文档！");
		}
		return docFile;
	}
	
	

}
