package csa.app.doc.domain;

import csa.app.doc.utils.EmptyUtil;

/**
 * 
 * @author csa
 *
 */
public class Document {
	private String type;
	private String name;
	private String version;
	private String fileType; //文件类型
	
	
	public Document(String type, String name, String version) {
		super();
		this.type = charFilter(type);
		this.name = charFilter(name);
		this.version = charFilter(version);
	}
	public Document() {
		super();
	}
	
	public boolean isOk(){
		if(!EmptyUtil.isEmpty(fileType)
				&& !EmptyUtil.isEmpty(type)
				&& !EmptyUtil.isEmpty(name)){
			return true;
		}
		return false;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = charFilter(type);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = charFilter(name);
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version =  charFilter(version);
	}
	
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	@Override
	public String toString() {
		return getDocName();
	}
	
	private String charFilter(String str){
		if(str!=null){
			str=str.trim();
		}
		return str;
	}
	
	
	public String getDocName() {
		if(EmptyUtil.isEmpty(name)){
			throw new RuntimeException("文档坐标缺失name!");
		}
		StringBuffer sb=new StringBuffer(name);
		if(EmptyUtil.isEmpty(version)){
			return sb.toString();
		}else{
			return sb.append("-").append(version).toString();
		}
	}
	
}
