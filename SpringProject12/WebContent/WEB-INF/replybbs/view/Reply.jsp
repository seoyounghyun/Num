<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/replybbs/common/isMember.jsp" />
   
<fieldset style="padding:20px 0 50px 20px">
<legend>답변하기</legend>
   <form action="<c:url value='/ReplyBBS/BBS/Reply.bbs'/>" method="post">
	<input type="hidden" name="no" value="${dto.no}"/>
	<input type="hidden" name="refer" value="${dto.refer}"/>
	<input type="hidden" name="step" value="${dto.step}"/>
	<input type="hidden" name="depth" value="${dto.depth}"/>
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
<textarea rows="10" style="width:98%" name="content">

[${dto.name }님이 작성한 글입니다]
${dto.content}
</textarea>
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
                   