package com.academy.replybbs.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.academy.replybbs.service.impl.ReplyBBSServiceImpl;
import com.sun.org.apache.xerces.internal.util.Status;
/*
 * .jsp로 이동:.tiles로
 * .bbs는 :forward:사용, tiles미적용
 *  타일이 필요없는 .jsp(Message.jsp)는 
 *  prefix/suffix그대로 적용(InternalResourceViewResolver)
 */

@SessionAttributes("id")
@Controller
public class LoginController {
	
	//서비스 주입]
	@Resource(name="bbsService")
	private ReplyBBSServiceImpl bbsService;
	
	//로그인 폼으로 이동]
	@RequestMapping("/ReplyBBS/Login/Login.bbs")
	public String login() throws Exception{
		return "login/Login.tiles";
	}///////////////////////login()
	//로그인 처리]
	@RequestMapping("/ReplyBBS/Login/LoginProcess.bbs")
	public String process(@RequestParam Map map,Model model) throws Exception{
		//서비스 호출]
		boolean isLogin=bbsService.login(map);
		if(isLogin){//회원인 경우
			//로그인 처리-세션영역에도(리퀘스트 영역과 함께) 저장
			model.addAllAttributes(map);
		}
		else{//비회원
			model.addAttribute("loginError","회원가입후 이용바람..");
			//뷰(JSP)정보 반환]- 다시 로그인으로 이동
			return "forward:/ReplyBBS/Login/Login.bbs";
		}
		//뷰(JSP)정보 반환]-목록으로 이동
		return "forward:/ReplyBBS/BBS/List.bbs";
	}///process
	@RequestMapping("/ReplyBBS/Login/Logout.bbs")
	//로그아웃 처리]
	public String logout(SessionStatus status) throws Exception{
		//로그 아웃처리-세션영역에 속성 삭제]
		status.setComplete();
		//뷰(JSP)정보 반환]- 로그인으로 이동
		return "forward:/ReplyBBS/Login/Login.bbs";
	}///////////////////logout
}//////////////////////////////////
