package controller.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//컨트롤러 클래스]
public class SimpleUrlSecondController implements Controller {

	//컨틀로러 메소드]
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView(
				"/HandlerMapping_01/HandlerMapping.jsp",
				"message",
				"[SimpleUrlSecond.do]"
				);
	}////////////////////////////////

}
