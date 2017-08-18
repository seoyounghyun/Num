<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/replybbs/common/isMember.jsp" />
   
<fieldset style="padding:20px 0 50px 20px">
	<legend>게시글 작성</legend>
    <form action="<c:url value='/ReplyBBS/BBS/Write.bbs'/>" method="post">
    	<input type="hidden" name="mode"/>
	<table width="75%" bgcolor="gray" cellspacing="1">                  	
		<tr bgcolor="white" >
			<td width="30%" align="center">제목</td>
			<td >
			<input type="text"  name="title" style="width:98%"/>
			</td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">내용</td>
			<td>
			<textarea rows="10" style="width:98%" name="content"></textarea>
			</td>
			
		</tr>
		<tr bgcolor="white" align="center">
			<td colspan="2">
			<input type="submit" value="등록"/>
			</td>
		</tr>                  	
	</table> 
</form>
</fieldset>                        
                    