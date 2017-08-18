package controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//[컨트롤러 클래스]
@Controller
public class SRCController {
	//[컨트롤러 메소드]
	@RequestMapping("/Basic/SRC.daum")
	public String execute(@RequestParam String message,Model model) throws Exception{
		//Model에 데이타 저장]
		model.addAttribute("message", message);
		//디스패처 서블릿에게 뷰 정보 반환]
		return "/index.jsp";
	}///////////////////////
}
