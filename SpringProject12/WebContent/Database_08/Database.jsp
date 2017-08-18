<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Database.jsp</title>
</head>
<body>
	<fieldset>
		<legend>데이타베이스 연동<span style="font-size:2em;color:red">${message}</span></legend>
		<ul style="list-style-type: decimal;">			
			<li><a href="<c:url value='/Database/JDBCConnection.do?method=JDBC'/>">스프링 JDBC API사용(스프링 DAO모듈에 포함됨.)</a></li>
			<li><a href="<c:url value='/Database/JNDIConnection.do?method=JNDI'/>">스프링 JNDI API사용(스프링 CONTEXT모듈에 포함됨.)</a></li>
		</ul>
	</fieldset>
</body>
</html>