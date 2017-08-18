package controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ModelAttribute;
/*
@SessionAttributes() 어노테이션]

- 서블릿 API를 사용하지 않고 세션처리를 하기위한
   어노테이션
- 클래스 앞에 붙인다.
- 세션변수에 값을 저장하려면 
   메소드의 매개변수중 모델계열(Model,Map,ModelMap)
   을 추가하여 add계열("세변변수명",값)으로
   저장하면 그 이름으로
   세션영역에도 저장된다.(리퀘스트 영역뿐만 아니라)

예] @SessionAttributes("세션변수명")
 ※세션변수명이 여러개일때
 @SessionAttributes({"세션변수명1","세션변수명2",...})




-세션영역에서 값 읽어올때

 컨트롤러 메소드(@ModelAttribute(value="세션변수명")  String 세션값방을변수)




-세션해제

컨트롤러 메소드(SessionStatus session){
session.setComplete();

}
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


//컨트롤러 클래스]
//1.문자열 사용시-맵으로 아이디/비번을 받을시
//               세션영역에 저장할 속성명은 파라미터명과 일치시켜라
//@SessionAttributes({"user","pass"})
//2.커맨드 객체 사용시-※빈 설정파일에 <mvc:annotation-driven/>반드시 추가

@Controller
@SessionAttributes(types=LoginCommand.class)
public class SessionAttributeController {
	/*
	//[서블릿 API 사용]
	@RequestMapping("/Annotation/SessionAttributeLogin.do")
	public String login(@RequestParam Map map,Model model,HttpSession session) throws Exception{
		//데이타 저장]
		//회원여부 판단]
		if("KIM".equals(map.get("user")) && 
		   "1234".equals(map.get("pass"))){
			//로그인 처리-세션영역에 필요값 저장
			session.setAttribute("user", map.get("user"));
			session.setAttribute("pass",map.get("pass"));
		}
		else{
			model.addAttribute("errorMessage","회원이 아닙니다");
		}
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}///////////////login
	@RequestMapping("/Annotation/SessionAttributeLogout.do")
	public String logout(HttpSession session) throws Exception{
		//로그아웃 처리-세션영역에 저장된 속성 삭제]
		session.invalidate();
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}//////////////////logout
	@RequestMapping("/Annotation/isLogin.do")
	public String isLogin(HttpSession session,Model model) throws Exception{
		//문]로그인 여부 판단후 로그인 되었으면 "로그인 되었습니다"
		//         로그인이 안되어 있으면 "로그인하세요"라는 메시지를 
		//     "isLoginMessage"를 키값으로 하여 저장하여라
		//데이타 저장]
		//로그인 여부 판단-세션영역에 존재 유무로 판단]
		model.addAttribute("isLoginMessage",
				session.getAttribute("user")!=null ? 
				"[로그인 되었습니다]":
				"[로그인 하세요]");
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}/////////////////isLogin
	*/
	//[@SessionAttribute 어노테이션 사용]
	//로그인처리]
	@RequestMapping("/Annotation/SessionAttributeLogin.do")
	//1.문자열 사용시]
	//public String login(@RequestParam Map map,Model model) throws Exception{
	//2.커맨드 객체 사용시]
	public String login(LoginCommand command, Model model,SessionStatus status) throws Exception{
	

		//회원여부 판단]
		/*
		//1.문자열 사용시]
		if("KIM".equals(map.get("user")) &&
		   "1234".equals(map.get("pass"))){
			//로그인 처리-세션영역에 필요값 저장
			//세션 및 리퀘스트 두 영역에 저장됨. 
			model.addAllAttributes(map);
		}		
		else{//비회원
			model.addAttribute("errorMessage","비회원입니다");			
		}
		*/
		
		//2.커맨드 객체 사용시]
		//※키값은 자동으로 소문자로 시작하는 커맨드 클래스명이  키값(loginCommand)이 됨			
		//  매개변수의 LoginCommand객체가 자동으로 세션 영역에 저장됨
		//  예]session.setAttribute("loginCommand",command)식으로 저장됨
		
		
		if(!("KIM".equals(command.getUser()) && 
			 "1234".equals(command.getPass()))){
			model.addAttribute("errorMessage","비회원입니다");		
			//무조건 커맨드객체를 세션영역에 저장하기때문에
			//회원이 아닌 경우는 삭제 해줘야한다
			status.setComplete();
		}
		
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}////////////////login
	//로그아웃]
	@RequestMapping("/Annotation/SessionAttributeLogout.do")
	public String logout(SessionStatus session) throws Exception{
		//로그아웃]-세션영역에 있는 로그인과 관련된 속성 삭제
		session.setComplete();
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}////////////////////logout
	//로그인 여부 판단]
	/*※매개변수로 @ModelAttribute("UserID") String userID,
	 * 지정시 세션영역에 UserID키값이 없는 경우 에외 발생
	 * (try~catch로도 처리불가)
	 * 단,UserID키값이 세션영역에 존재시에는 
	 * 매개변수 userID에 세션값이 저장됨
	 * 
	 * 방법1]서블릿 API사용(HttpSession)
	 * 방법2]빈 설정파일에서 예외 처리-try~catch불가
	 * <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
			<property name="exceptionMappings">
			<props>
				<prop key="org.springframework.web.HttpSessionRequiredException">로그인 페이지</prop>
			</props>
			</property>
	   </bean>
	
	 */
	@RequestMapping("/Annotation/isLogin.do")
	/*
	//1.문자열 사용시
	public String isLogin(@ModelAttribute(value="UserID") String id,
						  @ModelAttribute(value="UserPWD") String pwd,
						  Map map
			) throws Exception{
	*/
	//2.커맨드 객체 사용시
	public String isLogin(@ModelAttribute(value="loginCommand") LoginCommand command,						  
						  Map map
			) throws Exception{
	
		//데이타 저장]
		//1.문자열 사용시
		//map.put("isLoginMessage",id == null ? "[비 로그인 상태]" : "[로그인 상태]");
		//2.커맨드 객체 사용시
		map.put("isLoginMessage",command.getUser() == null ? "[비 로그인 상태]" : "[로그인 상태]");
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}////////////////////////isLogin
	
}
