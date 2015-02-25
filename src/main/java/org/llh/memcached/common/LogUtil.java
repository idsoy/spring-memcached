package org.llh.memcached.common;

import org.apache.log4j.Logger;

public class LogUtil {
	private static Logger infoLogger=Logger.getLogger("zxd.info");
	private static Logger errorLogger=Logger.getLogger("zxd.error");
	private static Logger debugLogger=Logger.getLogger("zxd.debug");
	private static Logger warnLogger=Logger.getLogger("zxd.warn");
	
	/**
	 * 
	 * <记录INFO级别日志>
	 * 
	 * @param message 日志内容
	 */
	public static Logger getInfoLogger(){
		return LogUtil.infoLogger;
	}
	
	/**
	 * 
	 * <记录DEBUG级别日志>
	 * 
	 * @param message 日志内容
	 */
	public static Logger getDebugLogger(){
		return LogUtil.debugLogger;
	}
	
	/**
	 * 
	 * <记录WARN级别日志>
	 * 
	 * @param message 日志内容
	 */
	public static Logger getWarnLogger(){
		return LogUtil.warnLogger;
	}
	
	/**
	 * 
	 * <记录ERROR级别日志>
	 * 
	 * @param message 日志内容
	 */
	public static Logger getErrorLogger(){
		return LogUtil.errorLogger;
	}
	
}
