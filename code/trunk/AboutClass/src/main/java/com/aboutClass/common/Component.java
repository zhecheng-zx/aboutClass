package com.aboutClass.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Component {
	
	protected static Logger logger = LoggerFactory.getLogger(Component.class);
	
	// 执行成功标识
	private String msg = "操作成功";
	// 执行成功/失败信息
	private Boolean success = true;
	// 状态吗
	private String code = "0";
	
	/**
	 * 获取执行成功/失败信息
	 * @return
	 */
	public String getMsg(){
		return msg;
	}

	/**
	 * 获取执行成功/失败信息CODE
	 * @return
	 */
	public String getMsgCode(){
		return code;
	}
	
	/**
	 * 获取执行状态
	 * @return
	 */
	public Boolean success(){
		return success;
	}
	
	/**
	 * 重置执行状态和信息
	 */
	public void resetStatus(){
		this.msg = "操作成功";
		this.code = "0";
		this.success = true;
	}
	
	/**
	 * 承接运行状态
	 * @param component 被承接的组件
	 */
	protected void undertake(Component component) {
		this.msg = component.msg;
		this.success = component.success;
	}
	
	/**
	 * 执行出错，设置错误信息
	 * @param msg 错误信息
	 */
	protected void executeFail(String msg){
		this.msg = msg;
		this.success = false;
	}
	
	/**
	 * 执行成功，设置成功信息
	 * @param msg 成功信息
	 */
	protected void executeSuccess(String msg){
		this.msg = msg;
		this.success = true;
	}
}
