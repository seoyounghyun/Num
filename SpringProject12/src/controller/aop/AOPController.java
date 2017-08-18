package controller.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOPController {

	//대상 클래스 주입]
	@Resource(name="targetObject")
	private TargetObject target;
	
	@RequestMapping("/AOP/AOPController.do")
	public String execute(Model model) throws Exception
	{
		//대상 클래스의 핵심 메소드 호출]	
		model.addAttribute("total",target.getTotal());		
		return "/AOP_15/AOP.jsp";
	}
}
