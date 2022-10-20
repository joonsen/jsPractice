package chatt;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting")
public class WebSocketServer {

	
	private static Set<Session> clients =
			Collections.synchronizedSet(new HashSet<Session>());
	// private -- 이 클래스 밖에서는 사용할 수 없다 public 누구나 접근 가능
	// static 초기화는 한번밖에 안됨 모든 클래스가 접근해 사용할 수 있는 공통변수
	// set이 저장할 수 있는 데이터 유형은 session 한가지로 고정시키겠다
	//clients 실제 변수명 . 나만 쓰는 정적 변수형. 그곳의 데이터형은 Session.
	// set은 3차원 세계에서의 바구니와 공 -- 완전히 같은 공은 존재할 수 없다. 같은 객체로 저장 불가
	// 동기화는 두가지가 있다. 상호배타적 동기화는 동시간대 접속 한개만 허용.
	// new HashSet<t> 여기서 t는 type.
			
	
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("session open.....");
		clients.add(s);
	}
	//session은 브라우저라고 생각하라
	@OnClose
	public void onClose(Session s) {  
		System.out.println("session close.....");
		clients.remove(s);
	}
	
	@OnMessage
	public void onMessage(String msg, Session s) throws IOException {  
		System.out.println("message : " + msg);
		for(Session ss : clients) {
			ss.getBasicRemote().sendText(msg);
		}
	}
}
// java는 data type을 무조건 적어줘야한다
// throws 입출력 오류가 나면 던져버리겠다(?)













