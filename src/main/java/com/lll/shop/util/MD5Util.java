package com.lll.shop.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

	/**
	 * md5加密
	 * @param par
	 * @return
	 */
	public static String Md5(String par) {
		return DigestUtils.md5DigestAsHex(par.getBytes());
	}
}
