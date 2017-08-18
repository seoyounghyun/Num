package controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 클래스]
@Controller
public class OneClassMultiMethod {
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/List.do")
	public String list(ModelMap model) throws Exception{
		//데이타 저장]
		model.addAttribute("message", "목록요청입니다");
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}///////////////list
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/Edit.do")
	public String edit(ModelMap model) throws Exception{
		//데이타 저장]
		model.addAttribute("message", "수정요청입니다");
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}///////////////edit
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/Delete.do")
	public String delete(ModelMap model) throws Exception{
		//데이타 저장]
		model.addAttribute("message", "삭제요청입니다");
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}///////////////delete
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneClass/View.do")
	public String view(ModelMap model) throws Exception{
		//데이타 저장]
		model.addAttribute("message", "상세보기요청입니다");
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}///////////////view
	
	
}
