package controller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//컨트롤러 클래스]
public class ControllerByAbstract extends AbstractController {
	//컨트롤러 메소드]
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//실제 사용자 요청 처리 로직 작성]
		//디스패처 서블릿에게 뷰정보 및 데이타 반환]
		return new ModelAndView(
				"/Controller_02/Controller.jsp",//뷰정보
				"message",//속성명(키값)
				"[AbstractController 클래스]"//키값과 쌍인 데이타
				);
	}

}///////////////////////////////////
