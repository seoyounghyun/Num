<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>HandlerMapping.jsp</title>
</head>
<body>
	<fieldset>
		<legend>HandlerMapping ${requestScope.message }</legend>
		<h2>디폴트(기본) 핸들러 매핑들</h2>
		<ul style="list-style-type: upper-roman;">			
			<li><a href='<c:url value="/HandlerMapping/BeanNameUrl.do"/>'>BeanNameUrlHandlerMapping</a></li>
			<li><a href='<c:url value="/HandlerMapping/Annotation.do"/>'>DefaultAnnotationHandlerMapping</a></li>
		</ul>
		<h2>SimpleUrlHandlerMapping[디폴트 핸들러 매핑이 아님]</h2>
		<ul style="list-style-type: upper-roman;">
			
			<li><a href="<c:url value='/HandlerMapping/SimpleUrlFirst.do'/>">SimpleUrlFirst.do</a></li>
			<li><a href="<c:url value='/HandlerMapping/SimpleUrlSecond.do'/>">SimpleUrlSecond.do</a></li>
		</ul>
	</fieldset>
</body>
</html>