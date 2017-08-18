package controller.ajax;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.impl.ReplyBBSDao;

@Controller
public class AjaxController {
	//ReplyBbsDAO주입]
	@Resource(name="dao")
	private ReplyBBSDao dao;
	
	@RequestMapping("/Ajax/NoAjax.do")
	//[ajax 미 사용]-새로고침이 됨.
	/* 반환타입 void:직접 웹브라우저에 출력 스트림으로 결과값 출력
	 * 반환타입 String:디스패처서블릿에게 뷰와 모델정보 반환
	 *                결과값은 모델에 저장
	 */	
	/*
	//반환타입이 void일때]
	public void noajax(
			@RequestParam Map map,
			HttpServletResponse resp ) throws Exception{
		//1]컨텐츠 타입 설정
		resp.setContentType("text/html; charset=UTF-8");
		//2]웹브라우저에 출력하기위한 출력스트림 얻기
		PrintWriter out= resp.getWriter();
		//3]비지니스 로직 호출
		boolean flag=dao.login(map);
		dao.close();
		if(flag){
			out.print("<h2>"+map.get("id")+"님 즐감하세요</h2>");
		}
		else{
			out.print("<script>");
			out.print("alert('아뒤/비번 불일치');");
			out.print("history.back();");
			out.print("</script>");
			
		}
		//4]웹브라우저와 연결된 스트림 닫기
		out.close();
	}///////////////////noajax()
	*/
	//반환타입이  String일때]
	public String noajax(@RequestParam Map map,Model model)
	throws Exception{
		//1]비지니스 로직 호출
		boolean flag=dao.login(map);
		dao.close();
		//2]데이타 저장
		model.addAttribute("member", flag==true?"회원님 반갑습니다":"비회원입니다");
		//3]뷰 정보 반환
		return "/Ajax_12/Ajax.jsp";
	}////////////////////////////
	//[AJAX 사용]
	/*
	 * 반환타입은 void이거나 
	 * 반환타입이 String인 경우는
	 * @ResponseBody()어노테이션 사용
	 */	
	 //[TEXT로 응답할때]		
	//반환 타입 void]
	/*
	@RequestMapping("/Ajax/AjaxText.do")
	public void ajaxText(@RequestParam Map map,HttpServletResponse resp) throws Exception{
		//1]컨텐츠 타입 설정
		resp.setContentType("text/html; charset=UTF-8");
		//2]웹브라우저에 출력하기위한 출력스트림 얻기
		PrintWriter out= resp.getWriter();
		//3]비지니스 로직 호출
		boolean flag=dao.login(map);
		dao.close();
		//3-1]웹브라우저에 출력
		//-Y 혹은 N 값으로 응답할때 
		//out.print(flag==true ? "Y" :"N");	
		//-메시지로 응답할때
		out.print(flag==true ? map.get("id")+"님 즐 쇼핑!!" :"가입하고 와");	
		//4]웹브라우저와 연결된 스트림 닫기
		out.close();
	}/////////////////////ajaxText()
	*/
	//반환 타입 String]
	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxText.do",produces="text/html;charset=UTF-8")
	public String ajaxText(@RequestParam Map map) throws Exception{
		//비지니스 로직 호출]
		boolean flag=dao.login(map);
		dao.close();		
		//-Y 혹은 N 값으로 응답할때 
		//return flag==true ? "Y" : "N";
		//-메시지로 응답할때
		return flag ? "환영합니다" : "다음에 오세요";
	}/////////////////////ajaxText()
	//[JSON으로 응답할때]
	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxJson.do",produces="text/html;charset=UTF-8")
	public String ajaxJson(@RequestParam Map map) 
			throws Exception{
		//비지니스 로직 호출]
		boolean flag=dao.login(map);
		dao.close();		
		//JSON데이타 타입으로 반환하기위해 JSONObject객체 생성
		JSONObject json = new JSONObject();
		//JSON객체의 put("키값","값")메소드로 저장하면
		//{"키값":"값"} JSON형태의 데이타로 저장됨.
		json.put("isLogin",flag ? "방가 방가" : "다음 기회에");
		System.out.println(json.toJSONString());
		return json.toJSONString();//{isLogin:"방가 방가"}반환
	}//////////////////////ajaxJson()
	//[JSON 배열로 응답할때]
	@ResponseBody
	@RequestMapping(value="/Ajax/AjaxJsonArray.do",produces="text/html;charset=UTF-8")
	public String ajaxJsonArray() throws Exception{
		//비지니스 로직 호출]
		Map map = new HashMap();
		map.put("start", 1);
		map.put("end", 10);
		List<ReplyBBSDto> records= dao.selectList(map);
		dao.close();
		/*JSONArray의 정적 메소드인 toJSONString(List계열 컬렉션)
		호출시에는 List계열 컬렉션에 반드시 Map계열 컬렉션이 저장되어야 한다]		
		ReplyBBSDTO를 Map으로 변경]
		
		ReplyBbsDTO를 Map으로 저장해서
		List계열 컬렉션에 저장
		*/
		List<Map> collections= new Vector<Map>();
		for(ReplyBBSDto dto:records){
			Map bbsmap = new HashMap();
			bbsmap.put("title",dto.getTitle());
			bbsmap.put("name", dto.getName());
			bbsmap.put("postdate", dto.getPostdate().toString());
			collections.add(bbsmap);
		}
		
		/*
		 * ※아래 형태로 반환됨
		 * [{"no":"23","name":"이길동","postdate":"2017-01-17","title":"TJUTYJ"},{"no":"25","name":"김길동","postdate":"2017-01-17","title":"gfhdg"},{"no":"22","name":"김길동","postdate":"2017-01-17","title":"AAAAAAAAAAAA"},{"no":"21","name":"김길동","postdate":"2017-01-17","title":"7878787"},{"no":"20","name":"김길동","postdate":"2017-01-17","title":"676767"},{"no":"18","name":"김길동","postdate":"2017-01-17","title":"99999999"},{"no":"13","name":"김길동","postdate":"2017-01-16","title":"674"},{"no":"17","name":"이길동","postdate":"2017-01-17","title":"FGFDGF"},{"no":"16","name":"이길동","postdate":"2017-01-17","title":"767647"},{"no":"15","name":"이길동","postdate":"2017-01-17","title":"465ytrey"}]
		 */
		System.out.println(JSONArray.toJSONString(collections));
		return JSONArray.toJSONString(collections);
		
	
	}//////////////////////////////ajaxJsonArray()
}
