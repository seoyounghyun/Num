<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="logo">
    <img src="<c:url value='/Images/logo.png'/>" alt="로고이미지" />
</div>
<div class="topMenu">
    <ul>  
        <li><a href="<c:url value='/'/>">HOME</a></li>
        <c:if test="${sessionScope.id == null }" var="isNotMember">
        	<li><a href="<c:url value='/ReplyBBS/Login/Login.bbs'/>">로그인</a></li>  
        </c:if>    
        <c:if test="${not isNotMember }">
        	<li><a href="<c:url value='/ReplyBBS/Login/Logout.bbs'/>">로그아웃</a></li> 
        </c:if>         
        <li><a href="<c:url value='/ReplyBBS/BBS/List.bbs'/>">답변형 게시판</a></li>
    </ul>
</div>    
