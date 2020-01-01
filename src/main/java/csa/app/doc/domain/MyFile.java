package csa.app.doc.domain;

import java.io.File;
import java.io.FileFilter;

public class MyFile extends File{

	public MyFile(String pathname) {
		super(pathname);
	}

	@Override
	public String toString() {
		return getName();
	}
	
	public MyFile[] listMyFiles(){
		File[] files=super.listFiles();
		MyFile[] myFiles=new MyFile[files.length];
		for (int i=0;i<files.length;i++) {
			myFiles[i]=new MyFile(files[i].toString());
		}
		return myFiles;
	}
	public MyFile[] listMyFiles(FileFilter fileFilter){
		File[] files=super.listFiles(fileFilter);
		MyFile[] myFiles=new MyFile[files.length];
		for (int i=0;i<files.length;i++) {
			myFiles[i]=new MyFile(files[i].toString());
		}
		return myFiles;
	}
	
	
	public MyFile getParentMyFile() {
		return new MyFile(super.getParent());
	}
	
	public boolean isSimplePath(MyFile file){
		if(this.equals(file)){
			return true;
		}
		return false;
	}
	
}
