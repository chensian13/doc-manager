package csa.app.doc.analyser;

import java.io.File;
import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.domain.Document;
import csa.app.doc.domain.MyFile;
import csa.app.doc.io.FileHelper;
import csa.app.doc.utils.EmptyUtil;

/**
 * 文档的路径格式：仓库路径+文档类型+文档名称（包括版本号）
 * 文档坐标解析器
 * @author csa
 *
 */
public class DocumentAnalyser {
	static Config config=ConfigProperties.getConfig();
	
	public static String getCompletPath(Document doc){
		String path=getStoreTypeNamePath(doc)+File.separator
				+doc.getDocName()+doc.getFileType();
		return path;
	}
	public static MyFile getCompletFile(Document doc){
		return new MyFile(getCompletPath(doc));
	}
	
	
	
	public static String getTypePath(Document doc){
		return doc.getType().replace(".", File.separator);
	}
	public static String getStoreTypePath(Document doc){
		return config.getLocStore()+File.separator
				+getTypePath(doc);
	}
	
	public static String getTypeNamePath(Document doc){
		return getTypePath(doc)+File.separator
				+doc.getName();
	}
	public static String getStoreTypeNamePath(Document doc){
		String path=config.getLocStore()+File.separator
				+getTypeNamePath(doc);
		return path;
	}
	
	
	/**
	 * 依据文件解析出文档对象
	 * @param file
	 * @return
	 */
	public static Document getDocument(MyFile file){
		Document doc=new Document();
		String path=file.getAbsolutePath().replace(config.getLocStore()+File.separator, "");
		String[] ss=path.replace(File.separator, "/").split("/");
		if(ss.length<3){
			throw new RuntimeException("文档坐标不合法");
		}
		String docName=FileHelper.getNameNoSuffix(file.getName());
		//name
		doc.setName(ss[ss.length-2]);
		//version
		String version=docName.replace(doc.getName(),"")
				.replace("-", "");
		doc.setVersion(version);
		//文档类型
		doc.setFileType(FileHelper.getSuffix(file.getName()));
		String type="";
		for(int i=0;i<ss.length-2;i++){
			type=type+ss[i];
			if(i<ss.length-3){
				type=type+".";
			}
		}
		//type
		doc.setType(type);
		return doc;
	}
	
	/**
	 * 将doc转换成路径
	 * @param doc
	 * @return
	 */
	public static String getPathByDocumentDir(Document doc){
		String path=config.getLocStore();
		if(!EmptyUtil.isEmpty(doc.getType())){
			//输入type
			path=DocumentAnalyser.getStoreTypePath(doc);
			if(!EmptyUtil.isEmpty(doc.getName())){
				//输入name
				path=DocumentAnalyser.getStoreTypeNamePath(doc);
			} //end if
		}
		return path;
	}
	
	
	

}
