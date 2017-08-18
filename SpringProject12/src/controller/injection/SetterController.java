package controller.injection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetterController {
	/*현재 클래스가 Person객체 필요]
	-new하지않고 세터를 통해서 주입 받자
	 STEP1]멤버변수(속성) 선언*/
	private Person per1,per2;
	//STEP2]세터 정의
	public void setPer1(Person per1) {
		this.per1 = per1;
	}
	public void setPer2(Person per2) {
		this.per2 = per2;
	}
	//컨트롤러 메소드]
	@RequestMapping("/Injection/Setter.do")
	public String execute(Model model) throws Exception{
		//데이타 저장]
		model.addAttribute("personInfo",per1.toString()+per2);
		//뷰 정보 반환]
		return "forward:/Injection_06/Injection.jsp";
	}////////////////////////////
	
	
}
