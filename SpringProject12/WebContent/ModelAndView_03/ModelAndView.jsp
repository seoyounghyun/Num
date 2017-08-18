<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ModelAndView.jsp</title>
</head>
<body>
	<fieldset>
		<legend>ModelAndView</legend>
		<ul style="list-style-type: decimal;">			
			<li><a href="<c:url value='/ModelAndView/NoParam.do'/>">매개변수가 없는 컨트롤러 메소드</a></li>
			<li><a href="<c:url value='/ModelAndView/YesParam.do'/>">매개변수가 있는 컨트롤러 메소드</a></li>
			<li><a href="<c:url value='/ModelAndView/Forward.do?paramvar=SPRING&UserID=JQUERY&UserPWD=8989'/>">포워드(디폴트)</a></li>
			<li><a href="<c:url value='/ModelAndView/Redirect.do?paramvar=SPRING'/>">리다이렉트</a></li>		
		</ul>
		<h2>리퀘스트 영역</h2>
		<ul style="list-style-type: decimal;">	
			<li>\${requestScope.UserID } : ${requestScope.UserID }</li>
			<li>\${requestScope.UserPWD } : ${requestScope.UserPWD }</li>
		</ul>
		<h2>파라미터</h2>
		<ul style="list-style-type: decimal;">	
			<li>\${param.paramvar } : ${param.paramvar }</li>
			<li>\${param.UserID } : ${param.UserID }</li>
			<li>\${param.UserPWD } : ${param.UserPWD }</li>
		</ul>
	</fieldset>
</body>
</html>