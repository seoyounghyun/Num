package controller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
※스프링에서 Controller를 만드는 방법]

Controller 인터페이스를 상속받거나
Controller 계열 클래스를 상속받거나
어노테이션으로 컨트롤러 지정하거나.....

*/
//컨트롤러 클래스]
public class ControllerByInterface implements Controller {

	//컨트롤러 메소드]
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//실제 사용자 요청 처리 로직 작성]
		//디스패처 서블릿에게 뷰정보 및 데이타 반환]
		return new ModelAndView(
				"/Controller_02/Controller.jsp",//뷰정보
				"message",//속성명(키값)
				"[Controller 인터페이스]"//키값과 쌍인 데이타
				);
	}////////////////////////////////////

}
