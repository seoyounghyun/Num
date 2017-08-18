package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스]
@Controller
public class ConstructorController {
	
	/*[현재 클래스에서 Person객체에 의존 즉 필요로 함]
	※new연산자로 Person객체를 직접 생성하지 않고
	  설정파일을 통해서 생성자로 주입을 받는다.
	생성자 인젝션을 받기위한 단계]
	STEP1]주입받는 타입의 갯수에 맞게 맴버변수 선언*/
	private Person per1,per2,per3;
	//STEP2]인자 생성자 정의
	public ConstructorController(Person per1, Person per2, Person per3) {		
		this.per1 = per1;
		this.per2 = per2;
		this.per3 = per3;
	}
	//기본 생성자]
	public ConstructorController(){}	
	//컨트롤러 메소드]
	@RequestMapping("/Injection/Constructor.do")
	public String execute(Map map) throws Exception{
		//데이타 저장]
		map.put("personInfo",per1.toString()+per2+per3);
		//뷰정보 반환]
		return "forward:/Injection_06/Injection.jsp";
	}///////////////////////
}
