package csa.app.doc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import csa.app.doc.domain.Config;
import csa.app.doc.utils.LogUtil;

/**
 * 读取配置文件
 * @author csa
 *
 */
public class ConfigProperties {
	//配置文件路径
	private static final String path="config/setting.properties";
	private static Config config=new Config();
	static {
		Properties pros=new Properties();
		InputStreamReader isr=null;
		try {
			isr=new InputStreamReader(new FileInputStream(path),"utf-8");
			pros.load(isr);
			
			//封装配置信息
			config.setLocStore(pros.getProperty("loc_store"));
			config.setBg(pros.getProperty("bg"));
			config.setSize(pros.getProperty("size"));
		} catch (IOException e) {
			LogUtil.warn("读取配置文件失败！");
			throw new RuntimeException(e);
		}finally{
			try {
				isr.close();
			} catch (IOException e) {
			}
		}
	}
	
	
	
	/**
	 * 获取配置文件的信息对象
	 * @return
	 */
	public static Config getConfig() {
		return config;
	}
	
	
	
	

}
