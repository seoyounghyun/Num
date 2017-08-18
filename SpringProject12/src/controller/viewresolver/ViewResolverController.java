package controller.viewresolver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//컨트롤러 클래스]
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
@Controller
public class ViewResolverController {

	//컨트롤러 메소드]
	@RequestMapping("/ViewResolver/ViewResolver.vrv")
	//반환타입이 String인 경우]
	//public String execute(Model model) throws Exception{
	//반환타입이 ModelAndView인 경우]
	public ModelAndView execute(Model model) throws Exception{
	
		//Model에 데이타 저장]
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		model.addAttribute("message", simple.format(new Date()));
		//뷰정보 반환]	
		//접두어와 접미어를 뺀 논리적인 이름만 반환
		//return "ViewResolver";
		/*
		 * ※InternalResourceViewResolver를 통한 접두어 접미어에 
		 *   영향을 안받으려면
		 *   return 시 "forward:" 이나 "redirect:"나
		 *   혹은 ModelAndView객체(View객체)로 반환하면 된다.
		 * 
		 */
		//반환타입이 String인 경우]
		//1]forward:로 리턴시
		//return "forward:/ViewResolver_04/ViewResolver.jsp";
		//2]redirect:로 리턴시
		//return "redirect:/ViewResolver_04/ViewResolver.jsp";
		
		//반환타입이 ModelAndView인 경우]
		//-뷰정보를 View객체나 스트링인 경우는 
		//  forward:나 redirect: 이 붙은 String으로
		
		//뷰정보를 String으로 반환 [x]-접두어,접미어가 붙음
		//return new ModelAndView("/ViewResolver_04/ViewResolver.jsp");
		//뷰정보 String이나 forward:[o]
		//return new ModelAndView("forward:/ViewResolver_04/ViewResolver.jsp");
		//뷰정보 String이나 redirect:[o]
		//return new ModelAndView("redirect:/ViewResolver_04/ViewResolver.jsp");
		//뷰정보로 View객체:[o]
		return new ModelAndView(new InternalResourceView("/ViewResolver_04/ViewResolver.jsp"));
	}//////////////////////////////
	
}
