package csa.app.doc;

import csa.app.doc.config.ConfigProperties;
import csa.app.doc.domain.Config;
import csa.app.doc.io.FileHelper;
import csa.app.doc.ui.MainApp;
import csa.app.doc.utils.DialogUtil;
import csa.app.doc.utils.EmptyUtil;

/**
 * 启动类
 * 
 */
public class App {
	static MainApp app;
	static Config config;
	
	public static void main( String[] args ){
		try{
			if(init()) app=new MainApp();
		}catch(Exception e){
			e.printStackTrace();
			DialogUtil.error("程序出现异常，请重新安装!");
		}
    }

	public static MainApp getApp() {
		return app;
	}
	
	/**
	 * 初始化
	 * @return
	 */
	private static boolean init(){
		config=ConfigProperties.getConfig();
		if(!EmptyUtil.isEmpty(config.getLocStore())){
			if(!FileHelper.exists(config.getLocStore())){
				DialogUtil.info("文档仓库不存在!");
				return false;
			}
		}else{
			DialogUtil.info("请先配置本地仓库!");
			return false;
		}
		
		return true;
	}
	
	
}
