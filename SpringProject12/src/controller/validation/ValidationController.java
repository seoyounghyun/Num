package controller.validation;

import java.util.StringTokenizer;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


//컨트롤러 클래스]
@Controller
public class ValidationController {
	//컨트롤러 메소드]
	/*
	@RequestMapping("/Validation/ValidationCheck.do")
	
	//방법1]스프링 API사용하지 않고 유효성 검증하기
	public String execute(FormCommand command,Model model) throws Exception{
		
		if(!validate(command, model)){//유효성 실패]
			//뷰정보 반환]-다시 입력폼으로 이동
			return "/Validation_10/Index.jsp";
		}
		//데이타 저장]
		//줄바꿈
		command.setSelf(command.getSelf().replace("\r\n", "<br/>"));
		model.addAttribute("command", command);
		//뷰정보 반환]-성공페이지로 이동
		return "/Validation_10/Sucess.jsp";
	}/////////////////////
	//내가 만든 유효성 검증용 메소드]
	private boolean validate(FormCommand command,Model model) {
		if(command.getName().trim().equals("")){
			model.addAttribute("nameError", "이름을 입력하세요!!");
			return false;
		}
		if(command.getYears().trim().length()==0){
			model.addAttribute("yearsError", "나이를 입력하세요!!");
			return false;
		}
		else{
			try {
				Integer.parseInt(command.getYears());
			} catch (Exception e) {
				model.addAttribute("yearsError", "나이는 숫자만 입력하세요!!");
				return false;
			}
		}
		if(command.getGender() ==null){
			model.addAttribute("genderError", "성별을 선택하세요!!");
			return false;
		}
		//체크한값 유지용]
		model.addAttribute("inters", command.getInters());
		if(command.getInters() == null){
			model.addAttribute("intersError", "관심사항을 선택하세요!!");
			return false;
		}
		else{
			StringTokenizer tokens = new StringTokenizer(command.getInters(),",");
			if(tokens.countTokens() < 2){
				model.addAttribute("intersError", "관심사항은 2개 이상 선택하세요!!");
				return false;
			}
		}
		if(command.getGrade().length()==0){
			model.addAttribute("gradeError", "학력을 선택하세요!!");
			return false;
		}
		if(command.getSelf().trim().equals("")){
			model.addAttribute("selfError", "자기소개를 입력하세요!!");
			return false;
		}
		return true;
	}//////////////////////validate()
	*/
	//방법2]스프링 API사용
	//Validator주입 ]
	@Resource(name="validator")
	private FormValidator validator;
    /* 매개변수 순서 :  
     FormCommand다음에 BindingResult순으로 */	
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand command,BindingResult errors, Model model) throws Exception{
		
		/*
		  내가 만든 Validator클래스의 validate()호출		  
		  validate()메소드 첫번째 매개변수에 
		  유효성 검증 해달라고
		  커맨드 객체 넣어주고
		  두번째 매개변수에는 에러정보를 담아 달라고 
		  Errors타입 전달
		*/
		validator.validate(command, errors);
		/*
		  FormValidator에서 한번이라도 
		  rejectValue()를 한다면
		  BindingResult타입의 hasErrors()메소드는 true반환
		  */
		if(errors.hasErrors()){
			//인덱스 페이지에서 체크박스값 보존용]
			model.addAttribute("inters", command.getInters());
			//뷰정보 반환]-다시 입력폼으로 이동
			return "/Validation_10/Index.jsp";
			
		}
		//데이타 저장]
		//줄바꿈
		command.setSelf(command.getSelf().replace("\r\n", "<br/>"));
		model.addAttribute("command", command);
		//뷰정보 반환]-성공페이지로 이동
		return "/Validation_10/Sucess.jsp";
	}//////////////////////////////
}
