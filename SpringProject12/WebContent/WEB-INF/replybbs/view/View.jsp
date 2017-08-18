<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/replybbs/common/isMember.jsp" />
<script>
	function isDelete(){
		if(confirm("정말로 삭제 할래?")){
			location.href="<c:url value='/ReplyBBS/BBS/Delete.bbs?no=${dto.no}'/>";
		}//////////////////			
	}/////////////////////	
</script>
 
<fieldset style="padding:20px 0 50px 20px">
	<legend>게시글 보기</legend> 
	<table width="75%" bgcolor="gray" cellspacing="1">
		<tr bgcolor="white" >
			<td width="30%" align="center">작성자</td>
			<td >
			${dto.name}
			</td>
		</tr>
		<tr bgcolor="white" >
			<td width="30%" align="center">작성일</td>
			<td >
			${dto.postdate }
			</td>
		</tr>                  	
		<tr bgcolor="white" >
			<td width="30%" align="center">제목</td>
			<td >
			${dto.title}
			</td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">내용</td>
			<td>
			${dto.content}
			</td>
			
		</tr>
		<tr bgcolor="white" align="center">
			<td colspan="2">
			<c:if test="${sessionScope.id != dto.id }" var="isNotMyArticle">
			<a href="<c:url value='/ReplyBBS/BBS/Reply.bbs?no=${dto.no}'/>">답변</a> | 
			</c:if>
			<c:if test="${not isNotMyArticle }">
			<a href="<c:url value='/ReplyBBS/BBS/Edit.bbs?no=${dto.no}'/>">수정</a> | 
			<a href="javascript:isDelete()">삭제</a> | 
			</c:if>
			<a href="<c:url value='/ReplyBBS/BBS/List.bbs'/>">목록</a>
			</td>
		</tr>                  	
	</table> 

</fieldset>                        
                    