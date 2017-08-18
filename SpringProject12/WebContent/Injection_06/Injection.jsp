<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Injection.jsp</title>
</head>
<body>
	<c:if test="${not empty personInfo }">
		<span style="color:green;font-size:1.2em;font-weight:bold">${personInfo }</span>
	</c:if>
	<fieldset>
		<legend>Dependency Injection(의존성 주입)</legend>
		<ul style="list-style-type: decimal;">			
			<li><a href="<c:url value='/Injection/Constructor.do'/>">생성자 인젝션(Constructor Injection)</a></li>
			<li><a href="<c:url value='/Injection/Setter.do'/>">세터 인젝션(Setter Injection)</a></li>
		</ul>
	</fieldset>
	
	
	<!-- 
	문1]빈 설정파일에 아래 요청을 처리하기 위한 클래스를 등록하여라
	    (클래스명:InjectionController)
	문2]InjectionController클래스는 생성자 인젝션을 통해 Person타입을
	    주입받도록 하여라.단, Person의 기본 생성자로 생성된 객체를 주입하여라
	문3]아래 폼에 입력한 값을  InjectionController클래스의 컨트롤러
	    메소드에서 받아서 그 값으로 주입받은 Person객체의 속성들을 다시 설정하여라
	문4]다시 설정한 Person객체를 "personInfo"라는  키값으로 저장하고
	    Injection.jsp로 포워딩 하여라
	
	
	 -->
	<fieldset>
		<legend>DI로 객체 사용하기</legend>		
		<form action="<c:url value='/Injection/Injection.do'/>" method="post">
			<table style="border-spacing:1px;background-color:gray;width:450px">
				<tr style="background-color:white">
					<td style="width:25%">이름</td>
					<td><input type="text" name="name" style="width:80%"/></td>
				</tr>
				<tr style="background-color:white">
					<td style="width:25%">주소</td>
					<td><input type="text" name="addr" style="width:80%"/></td>
				</tr>
				<tr style="background-color:white">
					<td style="width:25%">나이</td>
					<td><input type="text" name="age" style="width:80%"/></td>
				</tr>
				<tr style="background-color:white;text-align:center">
					<td colspan="2"><input type="submit" value="확인"/></td>
				</tr>
			</table>		
		</form>
	
	</fieldset>
</body>
</html>