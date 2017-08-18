package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 클래스앞에 @Controller어노테이션을 붙임.
 * -컴파일러에게 해당 클래스가 컨트롤러 임을 
 *  알려주는 역할  
 */
//컨트롤러 클래스]어노테이션으로 구현
@Controller
public class ControllerByAnnotation {
	//컨트롤러 메소드]
	 /*
	  *  @RequestMapping(/로 시작하는 요청명) 어노테이션을
	  *  메소드 앞에 붙인다.(컨텍스트 루트 제외)
	  * -컴파일러에게 요청을 처리할 컨트롤러 메소드임을
	  *  알려주는 역할
	  * -메소드 생성 규칙
	  *  1.접근지정자는 public
	  *  2.반환타입은 ModelAndView 나 String 혹은 void등
	  *  3.메소드명은 임의로
	  *  4.매개변수는 임의로,단 매개변수로 넣어 줄 수 있는
	  *    타입은 교안 참조
	  *  5.Exception을 throws해줘라
	  */
	@RequestMapping("/Controller/Annotation.do")
	public String execute(Model model) throws Exception{
		//Model에 데이타 저장]
		model.addAttribute("message", "[어노테이션]");
		//디스패처 서블릿에게 뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}/////////////////////////////
}
