package com.lll.shop.pojo;

public enum ResCode {
	SUCCESS(0,"操作成功"), 
	SYSTEMERROR(2, "老哥别急,刷新一下试试"), 
	USER_HASUSER(11,"该用户已存在"),
	USER_NOREGISTER(12,"该用户不存在,请先进行注册..."),
	USER_PASSWORDERROR(13,"密码错误"),
	USER_NOTLOGIN(14,"登录已过期，请重新登录"),
	USER_UPLOADHEAD(14,"上传头像失败，请重新上传"),
	CODE_ERROR(20,"验证码错误"),
	CODE_SEND_ERROR(21,"发送验证码失败"),
	CODE_NO_SEND(22,"请先发送验证码"),
	;
	private int key;
	private String value;

	private ResCode(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getValue(int key) {
		for (ResCode c : ResCode.values()) {
			if (c.getKey() == key) {
				return c.value;
			}
		}
		return null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}