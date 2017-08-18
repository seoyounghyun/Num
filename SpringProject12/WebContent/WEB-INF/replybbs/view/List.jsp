<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/replybbs/common/isMember.jsp" />
  
<fieldset style="padding:20px 0 50px 20px">
 <legend>답변형 게시판 목록(2/5)</legend>
    <table width="100%" >
      <tr align="right">
       <td><a href="<c:url value='/ReplyBBS/BBS/Write.bbs'/>">글작성</a></td>
      </tr>
    </table>
   <table width="100%" bgcolor="gray" cellspacing="1">
     <tr bgcolor="white" align="center">
      <th width="10%">번호</th>
      <th width="55%">제목</th>
      <th width="15%">작성자</th>		                         
      <th >작성일</th>
    </tr>
    
     <c:if test="${empty list }" var="isNotArticle">
       <tr bgcolor="white" align="center">
        <td colspan="4">등록된 글이 없어요</td>
       </tr>
     </c:if>
      <!-- 아래 반복 --> 
     <c:if test="${not isNotArticle }">
     	<c:forEach items="${list}" var="article" varStatus="loop">
        <tr bgcolor="white" align="center">
          <td>${article.no}</td>
          <td align="left">
          <c:forEach begin="1" end="${article.depth}" var="depth" varStatus="status">
          	
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          	<c:if test="${status.last }">
          	└☞
          	</c:if>
          </c:forEach>	
          <a href="<c:url value='/ReplyBBS/BBS/View.bbs?no=${article.no}'/>">${article.title }</a>
          
          
          </td>
          <td>${article.name }</td>		                             
          <td>${article.postdate}</td>
        </tr>   
      </c:forEach>                       
  	 </c:if> 
   </table> 
  <!-- 페이징 -->
  <table width="100%">
    <tr align="center">
      <td>${pagingString}</td>
    </tr>
  </table>
 <!-- 검색UI -->
  <form method="post" action="<c:url value='/ReplyBBS/BBS/List.bbs'/>">
    <table width="100%">
     <tr align="center">
      <td>
      <select name="searchColumn">
       <option value="title">제목</option>
       <option value="name">작성자</option>
       <option value="content">내용</option>
      </select>
      <input type="text" name="searchWord"/>
      <input type="submit" value="검색"/>
      </td>
     </tr>
    </table>
  </form> 
</fieldset>                      
                    