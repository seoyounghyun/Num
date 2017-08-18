package controller.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//뷰정보 반환시 자동으로 포워딩방식으로
//페이지 이동
//컨트롤러 클래스]
@Controller
public class MoveByMeController {

	//컨트롤러 메소드]
	@RequestMapping("/Controller/MoveByMe.do")
	public String execute(Map map) throws Exception{
		/*
		   디스패처 서블릿이 매개변수에 전달한 
		   Map,Model혹은 ModelMap타입에  데이타(객체)를 저장하면
		   디스패처 서블릿이 리퀘스트 영역에 
		   데이타를 저장해줌(Call By Reference)		   
		*/		
		//Map에 데이타 저장]-리퀘스트 영역에 저장됨
		map.put("message", "[MoveByMe]");
		//디스패처 서블릿에게 뷰 정보만 반환]-자동으로 포워딩
		return "/Controller_02/Controller.jsp";
	}//////////////////////////////////////
}
