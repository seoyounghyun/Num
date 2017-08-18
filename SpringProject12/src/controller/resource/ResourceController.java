package controller.resource;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {

	//@Value어노테이션 사용법 테스트]
	/*
	 * <context:component-scan />사용시 XML파일에 빈을 등록 안함으로
	 * SETTER인젝션 불가.그래서
	 * @Value어노테이션을 통해서 .properties(리소스파일)
	 * 에 있는 키값을 가져 올 수 있다
	 * 예]@Value("${키값}")
	 *    private 자료형 받을변수
	 * 
	 */
	//리소스파일에 설정한 상수 읽어 오기]	
	@Value("${name}")
	private String name;
	@Value("${pass}")
	private String pass;
	@Value("${user}")
	private String user;
	
	
	@Resource(name="command")
	private UserCommand command;
	
	@RequestMapping("/Resource/Resource.do")
	public String execute(Model model) throws Exception{
		//데이타 저장]
		model.addAttribute("resource", command);
		model.addAttribute("value",String.format("[@Value어노테이션:아뒤-%s,이름-%s,비번-%s]",user,name,pass));
		//뷰정보 반환]
		return "/Resource_09/Resource.jsp";
	}//////////////////
	
}
