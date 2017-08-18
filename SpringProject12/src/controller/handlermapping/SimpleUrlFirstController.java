package controller.handlermapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//컨트롤러 클래스]
public class SimpleUrlFirstController extends AbstractController {

	//컨트롤러 메소드]
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView(
				"/HandlerMapping_01/HandlerMapping.jsp",
				"message",
				"[SimpleUrlFirst.do]"
				);
	}///////////////////////////////

}
