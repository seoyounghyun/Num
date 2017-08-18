package controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

	@RequestMapping("/Annotation/RequestHeader.do")
	/*
	//방법1]서블릿 API사용으로 요청헤더값 알아내기
	public String execute(HttpServletRequest req) throws Exception{
		//user-agent헤더명에 따른 헤더값 얻기]
		String browser = req.getHeader("user-agent");
		//리퀘스트 영역에 저장]
		req.setAttribute("browser", browser);
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}////////////////////////////////
	*/
	//방법2]서블릿 API 미 사용,어노테이션 사용으로 요청헤더값 알아내기
	/*
	 * 헤더명 미 존재시 오류:
	 * required=false로 해결
	 */
	public String execute(
			@RequestHeader(
					value="user-agent",
					required=false,
					defaultValue="헤더명 미 존재시 대체값") 
			        String browser,Model model) throws Exception{
		//데이타 저장]
		model.addAttribute("browser", browser);	
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";		
	}////////////////////////
}
