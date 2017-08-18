package controller.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Required어노테이션]
 * -설정파일에서 반드시 주입을 해줘라
 *  라는 어노테이션  
 * -만약에 property를 통한 Injection(Setter Injection)
 *  을 안해주면 에러
 * 
 * STEP1]설정파일에 @Required어노테이션을 사용하기 위한 빈 등록
 *  <bean 
 class=
 "org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
 혹은 <context:annotaion-config/>만 등록

 STEP2]컨트롤러에서는 Setter Injection을 해주어야 한다
       (Setter Injection하지 않으면 프레임워크가 빈 생성시
       에러를 발생시킴)
       
 ※Setter계열 메소드 위에만 적용 가능 
 ※반드시 Setter Injection로 주입을 받을
   속성이 있을 경우 사용     
 * 
 */
//컨트롤러 클래스]
@Controller
public class RequiredController {

	private String message;
	/*프로그램 로직상 세터주입을 반드시 받아야 한다.
	반드시 setter injection 을 통해 주입 받겠다는 의미
	단,설정파일에 RequiredAnnotationBeanPostProcess를
	빈으로 등록하거나,<context:annotation-config/>등록*/
	@Required
	public void setMessage(String message) {
		this.message = message;
	}
	//컨트롤러 메소드]
	@RequestMapping("/Annotation/Required.do")
	public String execute(Map map) throws Exception{
		//데이타 저장]
		map.put("message",message);
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}///////////////////////////////////
}
