package com.lll.shop.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	public static Class toJava(Object obj,Class classz) {
		return (Class) JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(obj)), classz) ;
	}
}
