package com.lll.shop.webScoket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lll.shop.config.ApplicationContextRegister;
import com.lll.shop.pojo.Message;
import com.lll.shop.pojo.ProductPojo;
import com.lll.shop.service.ShopService;

@Component
@ServerEndpoint(value = "/notify") // 标记此类为服务端
public class WebSocketServer {

	/**
	 * 全部在线会话 PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
	 */
	private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
	ApplicationContext act = ApplicationContextRegister.getApplicationContext();

	private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

	/**
	 * 当客户端打开连接：1.添加会话对象 2.更新在线人数
	 */
	@OnOpen
	public void onOpen(Session session) {
		onlineSessions.put(session.getId(), session);
		log.info(session.getId() + " 上线了，当前在线人数： " + onlineSessions.size());
//		sendMessageToAll(Message.jsonStr(Message.ENTER, "", "", onlineSessions.size()));
	}

	/**
	 * 当客户端发送消息：1.获取它的用户名和消息 2.发送消息给所有人
	 * <p>
	 * PS: 这里约定传递的消息为JSON字符串 方便传递更多参数！
	 */
	@OnMessage
	public void onMessage(Session session, String jsonStr) {
		try {
			Message message = JSON.parseObject(jsonStr, Message.class);
			if (Message.CP.equals(message.getType())) {
				ProductPojo pos = new ProductPojo().setId(message.getPid());
				ShopService shopService = act.getBean(ShopService.class);
				ProductPojo productPojo = shopService.getProductInfo(pos);
				message.setData(productPojo);
			}
			sendMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 当关闭连接：1.移除会话对象 2.更新在线人数
	 */
	@OnClose
	public void onClose(Session session) {
		onlineSessions.remove(session.getId());
		log.info(session.getId() + " 下线了，当前在线人数： " + onlineSessions.size());
//		sendMessageToAll(Message.jsonStr(Message.QUIT, "", "下线了！", onlineSessions.size()));
	}

	/**
	 * 当通信发生异常：打印错误日志
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
		log.error("通讯发生异常", error);
	}

	/**
	 * 公共方法：发送信息给所有人
	 * 
	 * @throws IOException
	 */
	private static void sendMessage(Message message) throws IOException {
		if (message.getToUserId() != null) {
			for (String userid : message.getToUserId().split(",")) {
				onlineSessions.get(userid).getBasicRemote().sendText(JSON.toJSONString(message));
			}
		} else {
			onlineSessions.forEach((id, session) -> {
				try {
					session.getBasicRemote().sendText(JSON.toJSONString(message));
				} catch (IOException e) {
					log.error("向用户" + id + "发送消息失败", e);
				}
			});
		} 
	}
}
