package controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//[컨트롤러 클래스]
@Controller
public class AnotherDispatcherController {
	//컨트롤러 메소드]
	@RequestMapping("/Basic/AnotherDispatcher.kosmo")
	public ModelAndView execute(@RequestParam String message) throws Exception{
		//1]ModelAndView객체 생성
		ModelAndView mav = new ModelAndView();
		//2]데이터 저장
		mav.addObject("message",message);
		//3]뷰 정보 저장
		mav.setViewName("/index.jsp");
		//4]디스패처 서블릿에게 ModelAndView반환
		return mav;
	}////////////////////
	
}
