package com.yaya.demo.plugin.utils;

import java.security.MessageDigest;

/**
 * 数据相关工具类
 * 
 * @author ChW 2016-04-25 13:52:29
 *
 */
public class DataUtil {

	/**
	 * md5码加密
	 *
	 * @param src
	 * @return
     */
	public static String md5(String src){
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			byte[] bytes = src.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] targ = md.digest(bytes);
			for(byte b: targ){
				buffer.append(chars[(b >> 4) & 0x0F]);
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
}
