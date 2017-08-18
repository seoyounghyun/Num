package controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


//[컨트롤러 클래스]
public class ControllerByAbstractController extends AbstractController {
	
	//[컨트롤러 메소드]-사용자 요청을 처리하는 메소드
	@Override
	protected ModelAndView handleRequestInternal(
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1]요청분석 - 파라미터 받기
		String message = req.getParameter("message");
		//2]모델(로직) 호출 및 결과값 받기
		//3]결과값 리퀘스트 영역에 저장- 프레임워크가 담당.
		//4]뷰선택후 포워딩-포워딩은 프레임워크가 담당
		//※개발자는 뷰선택하고 데이타만 다루면 된다.
		//5]ModelAndView객체에 뷰정보와 데이타 저장후
		//  디스패처서블릿에게 전달
		return new ModelAndView("/index.jsp", "message", message);
	}//////////////////////handleRequestInternal

}
