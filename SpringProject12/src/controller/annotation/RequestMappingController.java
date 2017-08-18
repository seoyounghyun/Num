package controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//컨트롤러 클래스]
@Controller
public class RequestMappingController {
	//컨트롤러 메소드]	
	/* @RequestMapping("/요청명")
	 * -주로 요청을 처리하는 메소드 앞에 단다.
	 * -컨텍스트 루트를 제외한 /로 시작하는 요청URL
	 * -GET방식 및 POST방식 둘다 처리 가능
	*/
	/*
	@RequestMapping("/Annotation/RequestMappingBoth.do")
	public String both(HttpServletRequest req,Model model) throws Exception{
		//데이타 저장]
		model.addAttribute("UserID", req.getParameter("UserID"));
		model.addAttribute("UserPWD", req.getParameter("UserPWD"));
		
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}//////////////////////both
	*/
	/* @RequestMapping(value="/요청명",mehtod=전송방식지정)
	 * -둘중 하나만 처리 가능
	 */
	/*
	@RequestMapping(value="/Annotation/RequestMappingOne.do",method=RequestMethod.POST)
	public String one(HttpServletRequest req) throws Exception{
		//데이타 저장]-개발자가 직접 리퀘스트 영역에 저장
		req.setAttribute("UserID", req.getParameter("UserID"));
		req.setAttribute("UserPWD", req.getParameter("UserPWD"));
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}///////////////one
	*/
	/*
	 * @RequestMapping(value={"요청명1","요청명2",....})
	 * 위는 여러 요청을 하나의 컨트롤러 메소드가 처리한다.
	 */
	/*
	@RequestMapping({"/Annotation/RequestMappingBoth.do","/Annotation/RequestMappingOne.do"})
	public String multi(@RequestParam Map map,Model model) throws Exception{
		//데이타 저장]
		model.addAllAttributes(map);
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}/////////////////multi()
	*/
	/*
	 *@PathVariable로 URL패턴을 변수형태로 치환
	 *반드시  @PathVariable의 변수명과 {변수명}을 일치해야 한다
	 *여러요청을 동시에 처리할때 사용
	 */
	@RequestMapping("/Annotation/{path}")
	public String path(
			@PathVariable String path,
			@RequestParam Map map,Model model) throws Exception{
		//데이타 저장]
		model.addAllAttributes(map);
		model.addAttribute("message",path.toUpperCase().indexOf("BOTH")!=-1? "Both.do요청" : "One.do요청");
		
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}///////////////path()
}
