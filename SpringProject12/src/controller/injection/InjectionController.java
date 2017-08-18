package controller.injection;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//컨트롤러 클래스]
@Controller
public class InjectionController {
	
	private Person person;
	//생성자를 통해서 상기 멤버(속성)를 주입 받자]
	public InjectionController(Person person){
		this.person = person;
	}/////////////////
	
	//컨트롤러 메소드]
	@RequestMapping("/Injection/Injection.do")
	public String execute(@RequestParam Map map,Model model) throws Exception{
		/*
		 * 문3]아래 폼에 입력한 값을  InjectionController클래스의 컨트롤러
	           메소드에서 받아서 그 값으로 주입받은 Person객체의 속성들을 다시 설정하여라
		 */
		person.setAddr(map.get("addr").toString());
		person.setAge(Integer.parseInt(map.get("age").toString()));
		person.setName(map.get("name").toString());
		/*
		문4]다시 설정한 Person객체를 "personInfo"라는  키값으로 저장하고
	    Injection.jsp로 포워딩 하여라
	    */
		model.addAttribute("personInfo", person);
		//뷰 정보 반환]
		return "forward:/Injection_06/Injection.jsp";
	}/////////////
}
