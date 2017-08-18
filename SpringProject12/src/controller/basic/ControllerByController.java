package controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//컨트롤러 클래스]
public class ControllerByController implements Controller {
	
	
	//[생성자]
	public ControllerByController(){
		System.out.println("[생성자]");
	}//////////////////////////
	//초기화 메소드]-해당 요청을 최초 처리시 한번만 호출
	public void init(){
		System.out.println("[초기화 메소드:init()]");
	}///////////////////////////
	//소멸 메소드]-서버 중지시:자원반납.스트림 닫기등...
	public void destroy(){
		System.out.println("[소멸 메소드:destroy()]");
	}/////////////

	//컨트롤러 메소드]-실제 사용자 요청을 처리-요청이 있을때마다 
	//               매번 호출됨
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		System.out.println("[컨트롤러 메소드:handleRequest]");
		
		//1]요청분석-파라미터 받기
		String message=req.getParameter("message");
		//2]로직을 갖고 있는 모델 호출 및 결과값 받기
		//3]필요한 값을 리퀘스트 영역에 저장
		ModelAndView mav = new ModelAndView();
		//4-1]뷰 선택. 즉  ModelAndView에 뷰 정보 저장
		mav.setViewName("/index.jsp");
		//4-1-2]모델(데이타를 의미)을  ModelAndView에 저장
		mav.addObject("message", message);
		
		return mav;
	}////////////////////////////handleRequest

}
