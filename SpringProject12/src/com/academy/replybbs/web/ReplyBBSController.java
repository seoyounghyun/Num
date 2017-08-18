package com.academy.replybbs.web;

import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.academy.replybbs.service.ReplyBBSDto;
import com.academy.replybbs.service.impl.PagingUtil;
import com.academy.replybbs.service.impl.ReplyBBSServiceImpl;

//세션처리용]
@SessionAttributes("id")
@Controller
public class ReplyBBSController {
	//리소스파일(resource.properties)에서 읽어오기
	@Value("${PAGE_SIZE}")
	private int pageSize;
	@Value("${BLOCK_PAGE}")
	private int blockPage;
	
	//서비스 주입]
	@Resource(name="bbsService")
	private ReplyBBSServiceImpl service;
	//목록용]
	@RequestMapping("/ReplyBBS/BBS/List.bbs")
	public String list(
			HttpServletRequest req,//페이징용 메소드에 전달
			@RequestParam Map map,//검색용 파라미터 받기
			@RequestParam(required=false,defaultValue="1") int nowPage,//페이징용 nowPage파라미터 받기용
			Model model//리퀘스트 영역 저장용
			) throws Exception{
		//페이징을 위한 로직 시작]
		//전체 레코드 수
		int totalRecordCount=service.getTotalCount(map);		
		//전체 페이지수]
		int totalPage = (int)Math.ceil((double)totalRecordCount/pageSize);	
		//시작 및 끝 ROWNUM구하기]
		int start= (nowPage-1)*pageSize+1;
		int end = nowPage*pageSize;		
		//페이징을 위한 로직 끝]	
		map.put("start", start);
		map.put("end", end);		
		//서비스 호출]
		List<ReplyBBSDto> list= service.selectList(map);
		//페이징용 서비스 호출
		String pagingString=PagingUtil.pagingText(totalRecordCount, pageSize,blockPage, nowPage,req.getContextPath()+"/ReplyBBS/BBS/List.bbs?");
		//데이타 저장]		
		model.addAttribute("list", list);
		model.addAttribute("pagingString", pagingString);
		
		return "view/List.tiles";
	}//////////////////list()
	//작성폼으로 이동 및 입력처리용]
	@RequestMapping("/ReplyBBS/BBS/Write.bbs")
	public String write(@RequestParam Map map,//파라미터받기용
			            @ModelAttribute("id") String id//세션영역에서 읽기용
			            ) throws Exception{
		//입력폼으로 이동]
		if(map.get("mode") ==null) return "view/Write";
		//입력처리하기]
		//서비스호출]
		ReplyBBSDto dto = new ReplyBBSDto();
		dto.setContent(map.get("content").toString());
		dto.setId(id);
		dto.setTitle(map.get("title").toString());
		service.insert(dto);
		//뷰 정보 반환
		return "forward:/ReplyBBS/BBS/List.bbs";
	}//////////////////list()
	//상세보기]
	@RequestMapping("/ReplyBBS/BBS/View.bbs")
	public String view(ModelMap model,@RequestParam Map map) throws Exception{
		//서비스호출]
		ReplyBBSDto dto = service.selectOne(map);
		//데이타 저장]
		//줄바꿈
		dto.setContent(dto.getContent().replace("\r\n", "<br/>"));
		model.addAttribute("dto",dto);
		//뷰 정보 반환]
		return "view/View.tiles";
	}//////////////////////////////
	//답변 폼으로 이동 및 답변처리]
	@RequestMapping("/ReplyBBS/BBS/Reply.bbs")
	public String reply(HttpServletRequest req,@RequestParam Map map,HttpSession session) throws Exception{
		if(req.getMethod().toUpperCase().equals("GET")){//답변 폼으로 이동
			//서비스 호출]
			ReplyBBSDto dto= service.selectOne(map);
			//데이타 저장]
			req.setAttribute("dto", dto);
			return "view/Reply.tiles";
		}
		//답변 처리]
		//서비스 호출]
		//답변 작성한 아이디값 설정
		map.put("id", session.getAttribute("id"));
		service.reply(map);
		
		//뷰정보 반환]
		return "forward:/ReplyBBS/BBS/List.bbs";
		
	}//////////////////////////////
	//수정폼 이동 및 수정처리]
	@RequestMapping("/ReplyBBS/BBS/Edit.bbs")
	public String edit(HttpServletRequest req,@RequestParam Map map) throws Exception{
		if(req.getMethod().toUpperCase().equals("GET")){
			//서비스 호출]
			ReplyBBSDto dto= service.selectOne(map);
			//데이타 저장]
			req.setAttribute("dto", dto);
			return  "view/Edit.tiles";
		}
		//수정 처리]
		//서비스 호출]
		ReplyBBSDto dto = new ReplyBBSDto();
		dto.setNo(map.get("no").toString());
		dto.setTitle(map.get("title").toString());
		dto.setContent(map.get("content").toString());		
		int count=service.update(dto);
		//데이타 저장]
		req.setAttribute("WHERE", "EDT");
		req.setAttribute("SUC_FAIL",count);
		req.setAttribute("no",map.get("no"));
		//뷰정보 반환
		return "view/Message";
	}/////////////////////////////////
	//삭제 처리]
	@RequestMapping("/ReplyBBS/BBS/Delete.bbs")
	public String delete(ReplyBBSDto dto,Model model) throws Exception{
		//서비스 호출
		int count=service.delete(dto);
		//데이타 저장		
		model.addAttribute("SUC_FAIL",count);
		model.addAttribute("no",dto.getNo());
		//뷰정보 반환
		return "view/Message";
	}////////////////////////////
	
}
