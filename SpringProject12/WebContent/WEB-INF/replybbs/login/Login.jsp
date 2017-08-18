<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset style="height:100px;padding:20px">
 	<legend>로그인 화면</legend>	
 	<c:if test="${empty sessionScope.id }" var="isNotMember">					 						 
   		<form method="post" action='<c:url value="/ReplyBBS/Login/LoginProcess.bbs"/>'>
        	아이디 <input type="text" name="id"/>
        	비밀번호 <input type="password" name="pwd"/>
       		<input type="submit" value="로그인"/>  
    	</form>  
    	<span style="color:red;font-size:1.4em;font-weight: bold">${loginError }</span>
  	</c:if>
    <c:if test="${not isNotMember }">
   		<span style="color:green;font-size:1.4em;font-weight: bold">${sessionScope.id}</span>님 반갑습니다.즐~~~~~~                          
    </c:if>  						 
</fieldset>                       
                    