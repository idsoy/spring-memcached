//<<<<<<< .mine
//package com.zxd.console.portal.common;
//
//import java.util.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.danga.MemCached.MemCachedClient;
//
///**
// * 
// * <Memcached工具类>
// * <存放对象时可在该类中添加cacheXXX()方法，取值可添加getXXX()，删除可添加delXXX()方法，可参见User对象的存取>
// * 
// * 作    者:hujie 
// * 版    本:V1.0
// * 时 间:2014-4-28下午6:30:53
// */
//public class MemcachedUtil {
//
//	// change in spring when db changed
//	private static int cacheCode = 0;
//
//	private static MemCachedClient memcachedClient = null;
//	private static int cacheExpireTime = 60 * 60 * 24 * 14;
//	private static int maxCacheExpireTime = 60 * 60 * 24 * 30;
//
//	public static int getCacheCode() {
//		return cacheCode;
//	}
//
//	public static void setCacheCode(int cacheCode) {
//		MemcachedUtil.cacheCode = cacheCode;
//	}
//
//	public static void setMemcachedClient(MemCachedClient memcachedClient) {
//		MemcachedUtil.memcachedClient = memcachedClient;
//	}
//
//	public static void setCacheExpireTime(int cacheExpireTime) {
//		MemcachedUtil.cacheExpireTime = cacheExpireTime;
//	}
//
//	public static void init() {
//		logger.info("MemcachedUtil init.");
//		if (memcachedClient == null) {
//			logger.fatal("Memcached Client not initialized.");
//			return;
//		}
//		logger.info("MemcachedUtil init success.");
//	}
//
//	/**
//	 * 获取memcached中的值
//	 */
//	public static Object getObject(String key) {
//		try {
//			if (key != null && memcachedClient != null) {
//				key = key.trim();
//				// memcached max key length 250
//				if (key.length() > 200) {
//					key = key.substring(0, 200);
//				}
//				Object o = memcachedClient.get(cacheCode + key);
//				// retry once
//				return o == null ? memcachedClient.get(cacheCode + key) : o;
//			}
//		} catch (Exception e) {
//			logger.warn(e, e);
//		}
//		return null;
//	}
//
//	/**
//	 * 在memcached 中存入一个值
//	 */
//	public static boolean setObject(String key, Object value) {
//		return setObject(key, value, cacheExpireTime);
//	}
//
//	/**
//	 * 在memcached 中存入一个值
//	 */
//	public static boolean setObject(String key, Object value,
//			int cacheExpireTime) {
//		try {
//			if (key != null && value != null && memcachedClient != null) {
//				key = key.trim();
//				// memcached max key length 250
//				if (key.length() > 200) {
//					key = key.substring(0, 200);
//				}
//				// retry once
//				return memcachedClient.set(cacheCode + key, value,
//						cacheExpireTime) ? true : memcachedClient.set(cacheCode
//						+ key, value, cacheExpireTime);
//			}
//		} catch (Exception e) {
//			logger.warn(e, e);
//		}
//		return false;
//	}
//
//	/**
//	 * 在memcached 中存入一个值
//	 * Date为过期时间，如一秒后过期，new Date(System.currentTimeMillis()+1000)
//	 */
//	public static boolean setObject(String key, Object value,
//			Date cacheExpireDate) {
//		try {
//			if (key != null && value != null && memcachedClient != null) {
//				key = key.trim();
//				// memcached max key length 250
//				if (key.length() > 200) {
//					key = key.substring(0, 200);
//				}
//				// retry once
//				return memcachedClient.set(cacheCode + key, value,
//						cacheExpireDate) ? true : memcachedClient.set(cacheCode
//						+ key, value, cacheExpireDate);
//			}
//		} catch (Exception e) {
//			logger.warn(e, e);
//		}
//		return false;
//	}
//	
//	/**
//	 * 在memcached 中删除一个值
//	 */
//	public static boolean delObject(String key) {
//		try {
//			if (key != null && memcachedClient != null) {
//				key = key.trim();
//				// memcached max key length 250
//				if (key.length() > 200) {
//					key = key.substring(0, 200);
//				}
//				// retry once
//				return memcachedClient.delete(cacheCode + key) ? true
//						: memcachedClient.delete(cacheCode + key);
//			}
//		} catch (Exception e) {
//			logger.warn(e, e);
//		}
//		return false;
//	}
//
//	/**
//	 * 释放memcached所有的对象
//	 **/
//	public static boolean flushAll() {
//		try {
//			if (memcachedClient != null) {
//				memcachedClient.flushAll();
//				logger.info("MemcachedUtil flushAll.");
//			}
//		} catch (Exception e) {
//			logger.error(e, e);
//			return false;
//		}
//		return true;
//	}
//
//	/**
//	 * 停止memcached
//	 **/
//	/*
//	 * public static boolean shutdown() { try { if (memcachedClient != null) {
//	 * memcachedClient.shutdown(); memcachedClient = null;
//	 * logger.info("MemcachedUtil shutdown."); } } catch (Exception e) {
//	 * logger.error(e, e); return false; } return true; }
//	 */
//
//	/*// 存入user对象
//	public static boolean cacheUser(UserDTO user) {
//		return setObject(UserDTO.USER_PREFIX + user.getUserName(), user);
//	}
//
//	// 取user对象
//	public static UserDTO getUser(String nickname) {
//		Object o = getObject(UserDTO.USER_PREFIX + nickname.toLowerCase());
//		return (o instanceof UserDTO) ? (UserDTO) o : null;
//	}
//
//	//删除user对象
//	public static boolean delUser(String nickname) {
//		return delObject(UserDTO.USER_PREFIX + nickname.toLowerCase());
//	}*/
//}
//=======
package org.llh.memcached.common;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;

/**
 * 
 * 项目名:zxd-console-portal
 * 文件名:MemcachedUtil.java
 * 描    述:Memcached工具类
 * 存放对象时可在该类中添加cacheXXX()方法，取值可添加getXXX()，删除可添加delXXX()方法，可参见User对象的存取
 * 作    者:hujie
 * 日    期:2014-4-28下午6:30:53
 * 版权所有:深圳市鼎丰在线金融服务有限公司
 * 版    本:V1.0
 */
public class MemcachedUtil {

	// change in spring when db changed
	private static int cacheCode = 0;

	private static MemCachedClient memcachedClient = null;
	private static int cacheExpireTime = 60 * 60 * 24 * 14;

	public static int getCacheCode() {
		return cacheCode;
	}

	public static void setCacheCode(int cacheCode) {
		MemcachedUtil.cacheCode = cacheCode;
	}

	public static void setMemcachedClient(MemCachedClient memcachedClient) {
		MemcachedUtil.memcachedClient = memcachedClient;
	}

	public static void setCacheExpireTime(int cacheExpireTime) {
		MemcachedUtil.cacheExpireTime = cacheExpireTime;
	}

	public static void init() {
		LogUtil.getInfoLogger().info("MemcachedUtil init.");
		if (memcachedClient == null) {
			LogUtil.getInfoLogger().info("Memcached Client not initialized.");
			return;
		}
		LogUtil.getInfoLogger().info("MemcachedUtil init success.");
	}

	/**
	 * 获取memcached中的值
	 */
	public static Object getObject(String key) {
		try {
			if (key != null && memcachedClient != null) {
				key = key.trim();
				// memcached max key length 250
				if (key.length() > 200) {
					key = key.substring(0, 200);
				}
				Object o = memcachedClient.get(cacheCode + key);
				// retry once
				return o == null ? memcachedClient.get(cacheCode + key) : o;
			}
		} catch (Exception e) {
			LogUtil.getErrorLogger().error(key, e);
		}
		return null;
	}

	/**
	 * 在memcached 中存入一个值
	 */
	public static boolean setObject(String key, Object value) {
		return setObject(key, value, cacheExpireTime);
	}

	/**
	 * 在memcached 中存入一个值
	 */
	public static boolean setObject(String key, Object value,
			int cacheExpireTime) {
		try {
			if (key != null && value != null && memcachedClient != null) {
				key = key.trim();
				// memcached max key length 250
				if (key.length() > 200) {
					key = key.substring(0, 200);
				}
				// retry once
				return memcachedClient.set(cacheCode + key, value,
						cacheExpireTime) ? true : memcachedClient.set(cacheCode
						+ key, value, cacheExpireTime);
			}
		} catch (Exception e) {
			LogUtil.getErrorLogger().error(key, e);
		}
		return false;
	}

	/**
	 * 在memcached 中存入一个值
	 * Date为过期时间，如一秒后过期，new Date(System.currentTimeMillis()+1000)
	 */
	public static boolean setObject(String key, Object value,
			Date cacheExpireDate) {
		try {
			if (key != null && value != null && memcachedClient != null) {
				key = key.trim();
				// memcached max key length 250
				if (key.length() > 200) {
					key = key.substring(0, 200);
				}
				// retry once
				return memcachedClient.set(cacheCode + key, value,
						cacheExpireDate) ? true : memcachedClient.set(cacheCode
						+ key, value, cacheExpireDate);
			}
		} catch (Exception e) {
			LogUtil.getErrorLogger().error(key, e);
		}
		return false;
	}
	
	/**
	 * 在memcached 中删除一个值
	 */
	public static boolean delObject(String key) {
		try {
			if (key != null && memcachedClient != null) {
				key = key.trim();
				// memcached max key length 250
				if (key.length() > 200) {
					key = key.substring(0, 200);
				}
				// retry once
				return memcachedClient.delete(cacheCode + key) ? true
						: memcachedClient.delete(cacheCode + key);
			}
		} catch (Exception e) {
			LogUtil.getErrorLogger().error(key, e);
		}
		return false;
	}

	/**
	 * 释放memcached所有的对象
	 **/
	public static boolean flushAll() {
		try {
			if (memcachedClient != null) {
				memcachedClient.flushAll();
				LogUtil.getInfoLogger().info("MemcachedUtil flushAll.");
			}
		} catch (Exception e) {
			LogUtil.getErrorLogger().error(e, e);
			return false;
		}
		return true;
	}

	/**
	 * 停止memcached
	 **/
	/*
	 * public static boolean shutdown() { try { if (memcachedClient != null) {
	 * memcachedClient.shutdown(); memcachedClient = null;
	 * LogUtil.getInfoLogger().info("MemcachedUtil shutdown."); } } catch (Exception e) {
	 * logger.error(e, e); return false; } return true; }
	 */

	/*// 存入user对象
	public static boolean cacheUser(UserDTO user) {
		return setObject(UserDTO.USER_PREFIX + user.getUserName(), user);
	}

	// 取user对象
	public static UserDTO getUser(String nickname) {
		Object o = getObject(UserDTO.USER_PREFIX + nickname.toLowerCase());
		return (o instanceof UserDTO) ? (UserDTO) o : null;
	}

	//删除user对象
	public static boolean delUser(String nickname) {
		return delObject(UserDTO.USER_PREFIX + nickname.toLowerCase());
	}*/
}
//>>>>>>> .r466
