package controller.fileupdown;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/*
 *  View가 되려면 View계열 인터페이스 나
 *  클래스 상속 해야 함]
 * -다운로드 처리용 View클래스
 */
public class DownLoadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		/*
	    *다운로드 요청을 처리하는 다운로드 컨트롤러에서
	    *모델계열(Model,Map,ModelMap)에 저장한 파일객체가
	    *
	    *첫번째 매개변수인 Map에 전달됨.  
	   */
		 //다운로드 로직 구현]
		FileUpDownUtils.download(req, resp, ((File)map.get("downfile")).getName(), "/Upload");
	}/////////////////////////////////

}
