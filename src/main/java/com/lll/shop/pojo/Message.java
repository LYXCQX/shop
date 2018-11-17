package com.lll.shop.pojo;

/**
 * WebSocket 聊天消息类
 */
public class Message {

	public static final String ENTER = "ENTER";
	public static final String CP = "CP";
	public static final String QUIT = "QUIT";

	private String type;// 消息类型
	private String userName;// 消息类型

	private String sendUserId; // 发送人
	
	private Integer pid;
	
	private String toUserId;

	private String msg; // 发送消息

	private int onlineCount; // 在线用户数
	
	private Object data;

	@Override
	public String toString() {
		return "Message [type=" + type + ", userName=" + userName + ", sendUserId=" + sendUserId + ", pid=" + pid
				+ ", toUserId=" + toUserId + ", msg=" + msg + ", onlineCount=" + onlineCount + ", data=" + data + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(int onlineCount) {
		this.onlineCount = onlineCount;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
