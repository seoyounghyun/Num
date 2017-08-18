package controller.fileupdown;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	@RequestMapping("/FileUpDown/Upload.do")
	/*
	 * 파일 업로드시 MultipartFile API사용
	 * 주요 메소드:
	 * getOriginalFilename()-사용자가 올린 파일명
	 * getSize()-파일 크기(바이트)
	 * getContent()-파일 컨텐트 타입
	 * getName()-input type="file"의 name속성에 지정한 값
	 * ※MultipartFile객체의 transferTo(File f)메소드 호출만으로
		 업로드 처리됨.
	 */
	//방법1]MultipartFile을 매개변수로 사용
	/* 파라미터가 여러개일때 아래 어노테이션 추가해서
	 * input type="file"을 제외한 파라미터를 받자
	 * @RequestParam Map map
	 * 
	 * ※enctype="multipart/form-data" 일때
	 * Map은 input type="file"을 받지 못한다.
	 * 또한 checkbox(여러개 선택해도) 는 하나만 받는다.
	 */
	/*
	public String upload(
			HttpServletRequest req,
			@RequestParam Map map,//type="file"이외의 폼 하위요소값 받기용
			@RequestParam MultipartFile upload
			) throws Exception{
		//1]서버의 물리적 경로 얻기
		String phisicalPath=req.getServletContext().getRealPath("/Upload");
		//2]File객체 생성
		File file = new File(phisicalPath+File.separator+upload.getOriginalFilename());
		//3]업로드 처리
		upload.transferTo(file);
		//4]리퀘스트 영역에 데이타 저장
		req.setAttribute("writer",map.get("writer"));
		req.setAttribute("title",map.get("title"));
		 //파일과 관련된 정보]
		req.setAttribute("originalName",upload.getOriginalFilename());
		req.setAttribute("fileSize",Math.ceil(upload.getSize()/1024.0));
		req.setAttribute("contentType",upload.getContentType());
		
		//뷰정보 반환]
		return "/FileUpDown_14/UploadComplete.jsp";
	}//////////////////////upload()
	*/
	/*방법2]MultipartHttpServletRequest사용
	MultipartHttpServletRequest는 MultipartFile과
	HttpServletRequest가 합쳐진 클래스 
	※input type="file" name="파라미터명"을 받을때는 
	  getFile("파라미터명")
	  기타 파라미터 받을때는 getParameter("파라미터명")로 
	  받는다.
	*/
	/*
	public String upload(MultipartHttpServletRequest msr) throws Exception{
		//1]서버의 물리적 경로 얻기
		String phisicalPath=msr.getServletContext().getRealPath("/Upload");
		//1-1]MultipartHttpServletRequest객체의 getFile("파라미터명")메소드로
		//    MultipartFile객체 얻기
		MultipartFile upload= msr.getFile("upload");
		//2]File객체 생성
		//2-1] 파일 중복시 이름 변경
		String realFilename=FileUpDownUtils.getNewFileName(phisicalPath, upload.getOriginalFilename());
		File file = new File(phisicalPath+File.separator+realFilename);
				
		//3]업로드 처리
		upload.transferTo(file);
		
		//4]리퀘스트 영역에 데이타 저장
		msr.setAttribute("writer",msr.getParameter("writer"));
		msr.setAttribute("title",msr.getParameter("title"));
		 //파일과 관련된 정보]
		msr.setAttribute("originalName",upload.getOriginalFilename());
		msr.setAttribute("fileSize",Math.ceil(upload.getSize()/1024.0));
		msr.setAttribute("contentType",upload.getContentType());
		msr.setAttribute("realFilename",realFilename);
		
		//뷰정보 반환]
		return "/FileUpDown_14/UploadComplete.jsp";
	}//////////////////////
	*/
	//방법3]커맨드 객체 사용
	public String upload(
			UploadCommand command,
			Model model,
			HttpSession session) throws Exception{
		//1]서버의 물리적 경로 얻기
		String phisicalPath=session.getServletContext().getRealPath("/Upload");
		//2]File객체 생성
		//2-1] 파일 중복시 이름 변경
		String realFilename=FileUpDownUtils.getNewFileName(phisicalPath,command.getUpload().getOriginalFilename());
		File file = new File(phisicalPath+File.separator+realFilename);
		//3]업로드 처리
		command.getUpload().transferTo(file);
		//4]리퀘스트 영역에 데이타 저장
		model.addAttribute("writer",command.getWriter());
		model.addAttribute("title",command.getTitle());
		 //파일과 관련된 정보]
		model.addAttribute("originalName",command.getUpload().getOriginalFilename());
		model.addAttribute("fileSize",Math.ceil(command.getUpload().getSize()/1024.0));
		model.addAttribute("contentType",command.getUpload().getContentType());
		model.addAttribute("realFilename",realFilename);
		
		//뷰정보 반환]
		return "/FileUpDown_14/UploadComplete.jsp";
	}/////////////////////
	
	@RequestMapping("/FileUpDown/List.do")
	public String list(HttpServletRequest req) throws Exception{
		//1]서버의 물리적 경로 얻기
		String phisicalPath=req.getServletContext().getRealPath("/Upload");
		//2]File객체 생성
		File file = new File(phisicalPath);
		//방법1]File[]배열 저장
		File[] files=file.listFiles();
		req.setAttribute("files", files);
		//방법2]컬렉션 저장
		List<Map> lists = new Vector<Map>();
		for(File f :files){
			//파일명 저장
			Map map = new HashMap();
			map.put("name", f.getName());
			map.put("size",(int)Math.ceil(f.length()/1024.0));
			lists.add(map);			
		}
		req.setAttribute("lists", lists);
		//뷰정보 반환]
		return "/FileUpDown_14/List.jsp";
		
		
	}/////////////////////////////////////
	
	
}
