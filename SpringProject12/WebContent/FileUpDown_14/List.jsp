<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List.jsp</title>
</head>
<body>
	<fieldset>
		<legend>파일 목록</legend>
		<h2>File[]배열</h2>
		<ul style="list-style-type:decimal;">
			<c:forEach items="${files}" var="file">
			<li>파일명:<a href="<c:url value='/FileUpDown/Download.do?filename=${file.name }'/>">${file.name }</a>,파일크기:${file.length()}바이트</li>
			</c:forEach>
		</ul>
		<h2>컬렉션</h2>
		<ul style="list-style-type:decimal;">
			<c:forEach items="${lists}" var="list">
			<li>파일명:${list.name },파일크기:${list.size}KB</li>
			</c:forEach>
		</ul>
	</fieldset>
</body>
</html>