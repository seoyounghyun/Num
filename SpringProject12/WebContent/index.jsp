<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>index.jsp</title>
</head>
<body>
	<fieldset>
		<legend>스프링 프레임워크 테스트 하기</legend>
		<!--		
			빈 설정파일명:서블릿명-servlet.xml
			빈 설정파일의 위치:web.xml하고 같은 위치 즉 WEB-INF 바로 밑.
			그래야 프레임워크가 설정파일을 읽을 수 있다.
		 -->
		<h2>[기본 DispatcherServlet사용]${message }</h2>
		<ul style="list-style-type: upper-roman;">			
			<li><a href="<c:url value='/Basic/Controller.do?message=Hello Spring Controller Interface!!!'/>">Controller인터페이스로 컨트롤러 구현</a></li>
			<li><a href="<c:url value='/Basic/AbstractController.do?message=Hello Spring AbstractController Class!!!'/>">AbstractController클래스로 컨트롤러 구현</a></li>
			<li><a href="<c:url value='/Basic/Annotation.do?message=Hello Spring Annotation!!!'/>">Annotation으로 컨트롤러 구현</a></li>		
		</ul>
		<h2>[또 다른 DispatcherServlet사용]</h2>
		<c:url value="/Basic/AnotherDispatcher.kosmo?message=Hello Spring Another Dispatcher!!!" var="url"/>
		<a href="${url}">Another Dispatcher</a>
		<h2>[DispatcherServlet과 관련된 설정 파일 및 위치 변경]</h2>
		<!-- 서블릿 초기화 파라미터 사용]
            -설정파일의 이름 및 위치 변경 가능
     
     		1]WEB-INF인 경우 : /로 시작  
		    <param-value>
		     /WEB-INF/폴더/임의의 이름.xml    
		    </param-value>
    
		    2]src 밑에 위치한 경우:classpath: 
		           패키지 구분은 /로
    	-->
		<ul style="list-style-type: upper-roman;">			
			<li><a href="<c:url value='/Basic/WEBINF.nate?message=Hello Spring WEB-INF!!!'/>">WEB-INF에 폴더 생성후 빈 설정파일 위치시키기</a></li>			
			<li><a href="<c:url value='/Basic/SRC.daum?message=Hello Spring SRC!!!'/>">src(클래스 패스)에 패키지 생성후 빈 설정파일 위치시키기</a></li>
		</ul>
	</fieldset>
</body>
</html>