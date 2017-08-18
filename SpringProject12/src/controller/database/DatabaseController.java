package controller.database;

import java.sql.Connection;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//컨트롤러 클래스]
@Controller
public class DatabaseController {
	
	@Resource(name="datasourceByJDBC")
	//데이타 소스를 자동으로 주입 받기 위한(와이어링) 멤버변수(속성) 선언]
	private DataSource datasourceByJDBC;	
	@Resource(name="datasourceByJNDI")
	private DataSource datasourceByJNDI;
	
	
	//컨트롤러 메소드]
	@RequestMapping("/Database/JDBCConnection.do")
	public String jdbc(@RequestParam String method,Map map) throws Exception{
		
		
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn= datasourceByJDBC.getConnection();
		//데이타 저장]
		map.put("message",conn==null? "[데이타베이스 연결 실패]" : "[데이타베이스 연결 성공:"+method+"]");
		//커넥션 객체 메모리 해제
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "/Database_08/Database.jsp";
	}///////////////////jdbc
	
	@RequestMapping("/Database/JNDIConnection.do")
	public String jndi(@RequestParam String method,Map map) throws Exception{
		
		
		//주입받은 DataSource객체로 Connection객체 얻기]
		Connection conn= datasourceByJNDI.getConnection();
		//데이타 저장]
		map.put("message",conn==null? "[데이타베이스 연결 실패]" : "[데이타베이스 연결 성공:"+method+"]");
		//커넥션 객체 메모리 해제
		if(conn !=null) conn.close();
		//뷰정보 반환]
		return "/Database_08/Database.jsp";
	}///////////////////jdbc
	
	
}
