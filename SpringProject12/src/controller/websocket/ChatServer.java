package controller.websocket;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatServer extends TextWebSocketHandler {

	Map<String,WebSocketSession> clients 
		= new HashMap<String,WebSocketSession>();
	
	//클라이언트와 연결이 끊었졌을때 호출되는 콜백 메소드]
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+"가 연결을 끊었어요");
		clients.remove(session.getId());
	}////////////////////////
	//클라이언트와 연결이 되었을때 호출되는 콜백 메소드]
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId()+"가 접속했어요");
		clients.put(session.getId(),session);
	}
	//클라이언트로 부터 메시지를 받았을때 자동 호출되는 콜백 메소드]
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId()+"로부터 받은 메시지:"+message.getPayload());
		//접속한 모든 클라이언트에게 session.getId()가 보낸
		//메시지 뿌려주기
		for(WebSocketSession client : clients.values()){			
			client.sendMessage(message);
			System.out.println(client.getId()+"에게 메시지 전송");
		}
	}//////////////////
    //클라이언트와 통신장애시 자동으로 호출되는 메소드]
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println(session.getId()+"와 통신에러 발생:"+exception.getMessage());
	}
	
}
