<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Controller.jsp</title>
</head>
<body>
	<!-- 
		Spring 3.0부터 대부분의 Controller인터페이스를 상속받은
		Controller계열 클래스가 deprecated됨.
		(Spring 4점대부터는 클래스가 사라짐.)
		그래서 컨트롤러 구현시 어노테이션을 이용해서
		컨트롤러로 구현하도록 권장.	
	 -->
	<fieldset>
		<legend>컨트롤러 구현하기${requestScope.message}${param.paramvar}</legend>
		<ul style="list-style-type: upper-roman;">			
			<li><a href="<c:url value='/Controller/MoveByMe.do?paramvar=MoveByMe!!!'/>">페이지 이동 첫번째]내가 만든 컨트롤러로 이동</a></li>			
			<li><a href="<c:url value='/Controller/MoveBySpring.do?paramvar=MoveBySpring!!!'/>">페이지 이동 두번째]스프링에서 제공하는 컨트롤러로 이동</a></li>
			<li><a href="<c:url value='/Controller/ControllerInterface.do?paramvar=[Controller Interface]'/>">Controller 인터페이스로 컨트롤러 만들기</a></li>
			<li><a href="<c:url value='/Controller/AbstractController.do?paramvar=[AbstractController class]'/>">AbstractController 클래스로 컨트롤러 만들기</a></li>
			<li><a href="<c:url value='/Controller/Annotation.do?paramvar=[Annotation]'/>">Annotation으로 컨트롤러 만들기</a></li>
		</ul>
		<h2>하나의 컨트롤러 클래스로 여러 요청 처리하기(여러개의 컨트롤러 메소드 사용)</h2>
		<ul style="list-style-type:decimal;">			
			<li><a href="<c:url value='/Controller/OneClass/List.do'/>">목록요청</a></li>
			<li><a href="<c:url value='/Controller/OneClass/Edit.do'/>">수정요청</a></li>
			<li><a href="<c:url value='/Controller/OneClass/Delete.do'/>">삭제요청</a></li>
			<li><a href="<c:url value='/Controller/OneClass/View.do'/>">상세보기요청</a></li>
		</ul>
		<h2>하나의 컨트롤러 메소드로 여러 요청 처리하기</h2>
		
		<h3>파라미터로 구분</h3>
		<ul style="list-style-type:decimal;">			
			<li><a href="<c:url value='/Controller/OneMethod/List.do?paramvar=1'/>">목록요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethod/Edit.do?paramvar=2'/>">수정요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethod/Delete.do?paramvar=3'/>">삭제요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethod/View.do?paramvar=4'/>">상세보기요청</a></li>
		</ul>
		<h3>파라미터로 구분안하기</h3>
		<ul style="list-style-type:decimal;">			
			<li><a href="<c:url value='/Controller/OneMethodNoParam/List.do'/>">목록요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethodNoParam/Edit.do'/>">수정요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethodNoParam/Delete.do'/>">삭제요청</a></li>
			<li><a href="<c:url value='/Controller/OneMethodNoParam/View.do'/>">상세보기요청</a></li>
		</ul>
	
	</fieldset>
</body>
</html>