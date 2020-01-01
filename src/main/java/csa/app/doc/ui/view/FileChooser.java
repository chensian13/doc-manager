package csa.app.doc.ui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

/**
 * 文档选择器
 * @author csa
 *
 */
public class FileChooser extends MyButton{
	private JFileChooser chooser;
	
	public void addListener() {
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser.showDialog(new JLabel(), "选择");
				File file=chooser.getSelectedFile();
				if(file==null || file.isDirectory())return;
				if(chooseListener!=null) chooseListener.choose(file);
			}
		});
	}
	public void bindData() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		super.init();
		setText("选择");
		
		chooser=new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}
	public void setTitle() {
		// TODO Auto-generated method stub
		
	}
	public void setIcon() {
		// TODO Auto-generated method stub
		
	}

	public interface OnChooseListener{
		public void choose(File file);
	}
	private OnChooseListener chooseListener;
	public void setChooseListener(OnChooseListener chooseListener) {
		this.chooseListener = chooseListener;
	}
	
	
	
	
	public void setFileFilter(FileFilter fileFilter){
		chooser.setFileFilter(fileFilter);
	}
	

}
