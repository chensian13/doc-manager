package csa.app.doc.utils;

import java.io.File;
import java.io.FileFilter;

public class DocChooser implements FileFilter{
	private boolean onlyFile=false;
	private String docName;
	

	public DocChooser setOnlyFile(boolean onlyFile) {
		this.onlyFile = onlyFile;
		return this;
	}

	public DocChooser setDocName(String docName) {
		this.docName = docName;
		return this;
	}


	public boolean accept(File f) {
		if(f.getName().startsWith("~$")) return false;
		if(f.isFile()){
			if(f.toString().endsWith(".doc") ||
					f.toString().endsWith(".docx") ||
					f.toString().endsWith(".pdf") ||
					f.toString().endsWith(".pptx") ||
					f.toString().endsWith(".xlsx") ||
					f.toString().endsWith(".txt") ||
					f.toString().endsWith(".sql") ||
					f.isDirectory()){
				if(EmptyUtil.isEmpty(docName)){
					return true;
				}else{
					//依据文档名称
					if(f.getName().contains(docName)){
						return false;
					}
				}
			}
			return false;
		}else{
			//只查询文件
			if(onlyFile){
				return false;
			}
			return true;
		}
	} //end fn

}
