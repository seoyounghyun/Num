package controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExceptionController {

	@RequestMapping("/Exception/Exception.do")
	/*방법1]스프링 API 미사용.try~catch절로 예외처리
    	※단,파일 업로드시 용량초과는 경우, 
		@ModelAttribute(value="속성명") 어노테이션으로
    		세션영역에 저장된 속성을 읽어올때 저장된 속성이 없는 경우,
		@RequestParam int years일때 문자열을 입력하는 경우등
		try~catch절로 처리가 안됨으로 반드시 xml설정으로 처리 해야함.
	*/
	/*
	public String exception(@RequestParam String years,Model model) 
			throws Exception{
		//데이타 저장]
		try {
			model.addAttribute("message",
					String.format("[당신의 10년후 나이는 %d살입니다]",
							Integer.parseInt(years)+10));
		} catch (Exception e) {
			model.addAttribute("message","[나이는 숫자만...]");
		}
		//뷰 정보 반환]
		return "/Exception_13/Exception.jsp";
	}////////////////////////////
	*/
	/*방법2]xml에서 예외설정을 통한 예외처리
	-SimpleMappingExceptionResolver를 빈으로 등록
		-try~catch 불필요  
		-에러메시지 출력시에는
	 	 에러가 날만한 코드 위에서
  	 리퀘스트 영역에 에러메지지 저장.(HttpServletRequest객체로)
	  	 ※Model객체로 저장하면
  	 디스패처 서블릿에게 Model과View가 전달이 안됨으로
  	 디스패처 서블릿이 Model에 저장된 데이타를
  	 리퀘스트 영역에 저장할 수 없다.    
    -개발완료후 사용 권장
 */ 
	public String exception(
			@RequestParam String years,
			Model model,
			HttpServletRequest req
			) 
			throws Exception{
		//예외 발생전 코드에서 에러메시지 저장]
		model.addAttribute("message","[나이는 숫자만...Model객체]");//의미없다
		req.setAttribute("message","[나이는 숫자만...HttpServletRequest객체]");
		
		//데이타 저장]
		/*※ 아래 parseInt()에서 에러 발생시 
		 *  return문이 실행이 안되고 xml에 설정한 SimpleMappingExceptionResolver로 제어가 넘어간다.
		 */
		model.addAttribute("message",
				String.format("[당신의 10년후 나이는 %d살입니다]",
						Integer.parseInt(years)+10));
		
		
		//뷰 정보 반환]
		return "/Exception_13/Exception.jsp";
	}////////////////
}
