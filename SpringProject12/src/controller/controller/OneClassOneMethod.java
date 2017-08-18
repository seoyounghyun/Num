package controller.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//컨트롤러 클래스]
@Controller
public class OneClassOneMethod {
	//컨트롤러 메소드]
	@RequestMapping(
			{"/Controller/OneMethod/List.do",
			 "/Controller/OneMethod/Edit.do",
			 "/Controller/OneMethod/Delete.do",
			 "/Controller/OneMethod/View.do"})
	public String parameter(@RequestParam int paramvar,Map map) throws Exception{
		//데이타 저장]
		switch(paramvar){
			case 1:map.put("message", "목록 요청");break;
			case 2:map.put("message", "수정 요청");break;
			case 3:map.put("message", "삭제 요청");break;
			default:map.put("message", "상세보기 요청");
		}
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}//////////////////parameter
	//컨트롤러 메소드]
	@RequestMapping("/Controller/OneMethodNoParam/{path}")
	public String noparam(@PathVariable String path,Map map) throws Exception{
		//데이타 저장]
		switch(path){
			case "List":map.put("message", "목록 요청");break;
			case "Edit":map.put("message", "수정 요청");break;
			case "Delete":map.put("message", "삭제 요청");break;
			default:map.put("message", "상세보기 요청");		
		}
		//뷰정보 반환]
		return "/Controller_02/Controller.jsp";
	}////////////////
}
