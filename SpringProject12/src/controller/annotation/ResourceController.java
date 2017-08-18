package controller.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Resource어노테이션
 * 
 * - @Autowired어노테이션과 같다.
 *   즉 자동으로 주입을 받는다
 *   단,와이어링 시 Name기반.
 *   즉 @Resource(name="설정파일에 등록한 빈의 id값") 식으로
 *   와이어링
 * 
 * -@Autowired어노테이션과의 차이점:
 *  1.Name기반
 *  2.required 속성이 없음 즉 만약 설정파일에 
 *    와이어링 하고자 하는 빈이 등록이 되어 
 *    있지 않으면 예외 발생
 * -@Autowired어노테이션 공통점:
 *  주입받을 클래스에 Setter 그리고 설정파일에서 주입
 *  불필요.
 * -@Resource 어노테이션을 사용시에는
 *  빈 설정파일에
 *  <context:annotation-config/>태그 등록 
 */
// 컨트롤러 클래스]
@Controller
public class ResourceController {
	/*빈 설정파일의 주입하고자 하는 빈의 id명과
	   속성명을 일치시킬 필요없다*/
	@Resource(name="command_first")
	private Command first;
	@Resource(name="command_second")
	private Command second;
	
	@RequestMapping("/Annotation/Resource.do")
	public String execute(ModelMap model) throws Exception{
		//데이타 저장]
		model.addAttribute("message",
		String.format("[첫번째 객체:%s,두번째 객체:%s]",
				first.getName(),second.getName()));
		//뷰정보 반환]
		return "/Annotation_07/Annotation.jsp";
	}
}
