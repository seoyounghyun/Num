package controller.modelandview;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

//컨트롤러 클래스]여러 요청을 처리
@Controller
public class ModelAndViewController {

	//매개변수가 없는 컨트롤러 메소드]
	@RequestMapping("/ModelAndView/NoParam.do")
	public ModelAndView noparam() throws Exception{
		//1]데이타 및 뷰 정보를 저장할 ModelAndView객체 생성
		ModelAndView mav = new ModelAndView();
		//2]데이타 저장:addObject("키값",Object타입의 value)
		mav.addObject("UserID", "KOSMO");
		mav.addObject("UserPWD", "1234");
		//3]뷰 정보 저장
		//3-1]setViewName(String):컨텍스트 루트를 제외한 /로 시작하는 경로
		//mav.setViewName("/ModelAndView_03/ModelAndView.jsp");
		//3-2]setView(View)
		//JSP를 기본 뷰로 사용하는 InternalResourceView객체 생성
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/ModelAndView_03/ModelAndView.jsp");		
		mav.setView(view);
		
		//4]ModelAndView객체를 디스패처 서블릿에게 반환
		//데이타는 리퀘스트 영역에 저장해주고
		//받은 뷰정보로 뷰리졸버에게 문의
		return mav;
	}/////////////////noparam()
	
	//매개변수가 있는 컨트롤러 메소드]
	@RequestMapping("/ModelAndView/YesParam.do")
	public ModelAndView yesparam(
			Model model,
			Map map,
			ModelMap modelmap) throws Exception{
		/*
		 * 매개변수를 Map,Model혹은 ModelMap을 사용할때는
		 * 데이타(모델)를 ModelAndView객체에 저장 불필요
		 * 뷰정보만 ModelAndView객체에 저장만 하면됨.
		 */
		//1]뷰 정보를 저장할 ModelAndView객체 생성
		ModelAndView mav = new ModelAndView();
		//2]데이타 저장-ModelAndMap이 아닌 매개변수로 지정한 
		//             Map이나 혹은 Model혹은 ModelMap에 저장
		//2-1]Map:put(Object 키,Object 값)	
		//map.put("UserID", "SPRING");
		//map.put("UserPWD", "9999");
		//2-2]Model:addAttribute(String 키,Object 값)
		//model.addAttribute("UserID", "JSP");
		//model.addAttribute("UserPWD", "7777");
		//2-3]ModelMap:addAttribute(String 키,Object 값)
		modelmap.addAttribute("UserID", "JQEURY");
		modelmap.addAttribute("UserPWD", "8989");
		
		//3]뷰 정보만 ModelAndView객체에 저장
		mav.setViewName("/ModelAndView_03/ModelAndView.jsp");
		return mav;
	}//////////////////////////////////yesparam
	//컨트롤러메소드-포워드방식(디폴트)]
	 /*
	  * 요청으로 전달된 파라미터를 받을때 
	  * 아래 어노테이션을 사용하면 모든 파라미터가
	  * Map에 저장된다.(파라미터명:키값,사용자가 입력한 값:value가 됨)
	  * @RequestParam Map map
	  * 
	  */
	@RequestMapping("/ModelAndView/Forward.do")
	public ModelAndView forward(@RequestParam Map map,Map dismap,Model model) throws Exception{
		/*  @RequestParam Map map여기서 Map은 파라미터를 받을때 
		 *  사용한 Map으로 Map에 데이타를 저장해봤자
		     프레임워크가 리퀘스트 영역에 저장을 하지 않는다.
	    */
		//map.put("UserID", "SPRING");
		//map.put("UserPWD", "9999");
		/*1]데이타 저장
		Map disMap는 디스패처서블릿이 전달해준 맵 즉
		여기에 데이타를 저장하면 리퀘스트 영역에 저장해준다.*/
		//dismap.put("UserID", "SPRING");
		//dismap.put("UserPWD", "9999");
		//1-2]disMap대신에 model사용.
		//model.addAttribute("UserID", "SPRING");
		//model.addAttribute("UserPWD", "9999");
		//addAllAttributes(Collection<> arg)사용
		model.addAllAttributes(map);
		//3]뷰 정보만 디스패처 서블릿에게 반환
		/*
		   * 뷰정보를 지정할때 JSP페이지뿐만 아니라 
		   * 요청명(.do)도
		   * 지정 가능하다
		   * -뷰지정시 "forward:뷰명" forward:는 생략가능(디폴트임으로)
		   */
		//3-1]JSP페이지로 포워드	
		//return new ModelAndView("forward:/ModelAndView_03/ModelAndView.jsp");
		//3-2].do로 포워드
		return new ModelAndView("forward:/ModelAndView/NoParam.do");
	}///////////////////////////forward
	//컨트롤러메소드-리다이렉트 방식]
	@RequestMapping("/ModelAndView/Redirect.do")
	public ModelAndView redirect(@RequestParam Map map,ModelMap model) throws Exception{
		//1]데이타 저장
		map.put("UserID", "UID");
		map.put("UserPWD", "UPWD");
		model.addAllAttributes(map);
		
		//2]뷰 정보만 디스패처 서블릿에게 반환
		/*
	    * 뷰정보를 지정할때 JSP페이지뿐만 아니라 
	    * 요청명(.do)도
	    * 지정 가능하다
	    * 
	    * -뷰지정시 "redirect:뷰명" 리다렉트시  redirect:는 생략불가
	    * 
	    * ※리다렉트시 Map 혹은 Model, ModelMap에 저장된
	    *   데이타는 디스패처 서블릿에게 반환시
	    *   각 키값=값의 쌍으로 쿼리스트링으로
	    *   최종URL로 전달된다.
	    */
		//3-1]JSP페이지로 리다이렉트 
		//return new ModelAndView("redirect:/ModelAndView_03/ModelAndView.jsp");
		//3-2].do로 리다이렉트
		//return new ModelAndView("redirect:/ModelAndView/NoParam.do");
		/*
	   * RedirectView(String url ,boolean contextRelative)
	   * contextRelative는 false가 디폴트
	   * 만약 false라면 즉 RedirectView(String url)로 생성했다면
	   * url에 컨텍스트 루트 포함해야 됨.
	   * 
	   */
		RedirectView view = new RedirectView("/ModelAndView_03/ModelAndView.jsp");
		view.setContextRelative(true);
		return new ModelAndView(view);
		
	}/////////////////////////////////
	
}
