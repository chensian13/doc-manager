package csa.app.doc.ui.view;

public interface IRule {
	/**
	 * 添加事件监听
	 */
	public void addListener();
	
	/**
	 * 加载界面数据渲染
	 */
	public void bindData();
	
	/**
	 * 窗口初始化方案
	 */
	public void init();
	
	/**
	 * 
	 */
	public void setTitle();
	
	public void setIcon();
	
	public void makeOpaque();

}
