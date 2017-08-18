<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ViewResolver.jsp</title>
</head>
<body>
	<fieldset>
		<legend>뷰 리졸버<span style="color:red;font-size:1.8em">${message }${param.message}</span></legend>		
		<a href="<c:url value='/ViewResolver/ViewResolver.vrv'/>">InternalResourceViewResolver(디폴트 뷰 리졸버)</a>
	</fieldset>
</body>
</html>