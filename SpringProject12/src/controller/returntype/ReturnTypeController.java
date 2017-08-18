package controller.returntype;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//[컨트롤러 클래스]
@Controller
public class ReturnTypeController {
	//[컨트롤러 메소드]반환타입-ModelAndView
	@RequestMapping("/ReturnType/ModelAndView.do")
	public ModelAndView modelandview(@RequestParam Map map,Model model) throws Exception{
		//데이타 저장]
		model.addAllAttributes(map);//파라미터로 받은 데이타를 리퀘스트 영역에 저장
		model.addAttribute("message",String.format("[파라미터:%s]",map.get("returntype")));
		//뷰정보 반환]
		return new ModelAndView("forward:/ReturnType_05/ReturnType.jsp");
	}///////////modelandview()
	//[컨트롤러 메소드]반환타입-String
	@RequestMapping("/ReturnType/String.do")
	public String string(@RequestParam String returntype,Map map) throws Exception{
		//데이타 저장]
		map.put("message", String.format("[파라미터:%s]", returntype));
		//파라미터로 받은 데이타를 리퀘스트 영역에 저장
		map.put("returntype",returntype);
		//뷰정보 반환]
		return "forward:/ReturnType_05/ReturnType.jsp";
	}////////////////////string
	//[컨트롤러 메소드]반환타입-void
	@RequestMapping("/ReturnType/Void.do")
	public void noreturn(@RequestParam String returntype,HttpServletResponse resp) throws Exception{
		/*
		 * -Ajax에서 주로 사용
		 * -DispatcherServlet에게 모델 및 뷰정보 전달 안함
		 *  즉 ViewResolver를 거치지 않음 
		 * -웹브라우저에 바로 출력시 사용 
		 *  즉 Http응답바디에 데이타 출력시 사용
		 */
		//응답헤더에 컨텐트 타입 설정]-그래야 한글이 안깨짐
		resp.setContentType("text/html; charset=UTF-8");
		//웹브라우저에 출력하기 위한 출력 스트림 얻기]
		PrintWriter out=resp.getWriter();
		out.println("<h2>반환타입:void</h2>");
		out.println("<fieldset>");
		out.println("<legend>파라미터:"+returntype+"</legend>");
		out.println("웹브라우저에 직접 출력합니다");
		out.println("</fieldset>");
		//스트림 닫기
		out.close();
		
	}//////////////////noreturn
	
	
}//////////////////////////////
