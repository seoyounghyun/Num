<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.id }">
	<script>
		alert("로그인후 이용하세요!!!");
		location.href="<c:url value='/ReplyBBS/Login/Login.bbs'/>";	
	</script>
</c:if>
	