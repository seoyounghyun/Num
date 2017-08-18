<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ReturnType.jsp</title>
</head>
<body>
	<fieldset>
		<legend>컨트롤러 메소드의 반환타입${message !=null ? message :""}<span style="color:red;font-size:1.8em">${returntype ==null ? "" : returntype}</span></legend>
		<ul style="list-style-type:decimal;">
			<c:url var="url" value="/ReturnType/ModelAndView.do?returntype=ModelAndView!!!"/>
			<li><a href="${url }">ModelAndView반환(Spring2.5)</a></li>
			<c:url var="url" value="/ReturnType/String.do?returntype=String!!!"/>
			<li><a href="${url }">String반환 (Spring3.x/4.x)</a></li>
			<c:url var="url" value="/ReturnType/Void.do?returntype=void!!!"/>
			<li><a href="${url }">void(주로 ajax에서 활용시)</a></li>
		</ul>
	</fieldset>
</body>
</html>