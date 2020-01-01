package csa.app.doc.domain;

import java.io.File;

/**
 * 配置文件对象
 * @author csa
 *
 */
public class Config {
	//本地仓库路径
	private String locStore;
	private String bg;
	private String size;
	
	
	
	public String getLocStore() {
		return locStore;
	}

	public void setLocStore(String locStore) {
		this.locStore = locStore.replace("/", File.separator).replace("\\", File.separator);
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	

}
