package csa.app.doc.presenter;

import java.io.File;
import java.io.FileFilter;

import csa.app.doc.analyser.DocumentAnalyser;
import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.domain.Document;
import csa.app.doc.domain.MyFile;
import csa.app.doc.io.FileCopy;
import csa.app.doc.io.FileHelper;
import csa.app.doc.utils.DocChooser;
import csa.app.doc.utils.EmptyUtil;

public class EditDocumentPresenter {
	Config config=ConfigProperties.getConfig();
	
	/**
	 * 上传文档
	 * @param srcDoc
	 * @param doc
	 */
	public void addDocument(MyFile srcDoc,Document doc){
		if(srcDoc==null || !srcDoc.exists()){
			throw new RuntimeException("请选择一个文档！");
		}
		doc.setFileType(FileHelper.getSuffix(srcDoc.getName()));
		if(EmptyUtil.isEmpty(doc.getType())){
			throw new RuntimeException("坐标系缺少类型！");
		}
		if(EmptyUtil.isEmpty(doc.getName())){
			throw new RuntimeException("坐标系缺少名称！");
		}
		if(FileHelper.exists(DocumentAnalyser.getCompletPath(doc))){
			throw new RuntimeException("文档坐标重复！");
		}
		//建立坐标目录
		FileHelper.mkdirs(DocumentAnalyser.getStoreTypeNamePath(doc));
		FileCopy.copy(srcDoc.getAbsolutePath(), 
				DocumentAnalyser.getCompletPath(doc));
	}
	
	/**
	 * 删除文档，返回文档回退目录
	 * @param file
	 */
	public MyFile delDocument(MyFile file){
		if(!file.delete()){
			return file;
		}
		return delDocument(file.getParentMyFile());
	}
	
	public void modDocument(MyFile srcDoc,Document doc){
		addDocument(srcDoc, doc);
		delDocument(srcDoc);
	}
	
	/**
	 * 依据坐标搜索文档或者目录
	 * @param doc
	 */
	public MyFile[] searchMyFileByDocument(String path,final String docName){
		//搜搜
		if(!EmptyUtil.isEmpty(docName)){
			return new MyFile(path).listMyFiles(new DocChooser()
					.setOnlyFile(true)
					.setDocName(docName));
		}else{
			return new MyFile(path).listMyFiles(new DocChooser());
		} //end else
	}

}
