package com.demo.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 字符串处理工具
 * 
 * @author wzb
 * 
 */
public class StringManipulation {
	/**
	 * 对字符串进行加密，以base64编码形式返回结果
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String passwordWithMD5ToBase64(String password, String salt) {
		Md5Hash md5 = new Md5Hash(password, salt, 2);
		return md5.toBase64();
	}
	
	public static void main(String[] args) {
		System.out.println(passwordWithMD5ToBase64("123", "15901399014"));
	}
}
