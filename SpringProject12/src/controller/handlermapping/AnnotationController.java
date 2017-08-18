package controller.handlermapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 클래스]
@Controller
public class AnnotationController {
	
	//컨틀로러 메소드]
	@RequestMapping("/HandlerMapping/Annotation.do")
	public ModelAndView handleRequest() throws Exception{
		return new ModelAndView(
				"/HandlerMapping_01/HandlerMapping.jsp",
				"message",
				"[DefaultAnnotationHandlerMapping]"
				);
	}/////////////////////
}
