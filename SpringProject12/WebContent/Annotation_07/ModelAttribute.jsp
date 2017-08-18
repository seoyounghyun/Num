<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ModelAttribute.jsp</title>
</head>
<body>
	<fieldset>
		<legend>@ModelAttribute어노테이션 결과 페이지</legend>
		<table bgcolor="gray" cellspacing="1" width="60%" >
		     <tr bgcolor="white">
		      <td>이름</td>
		      <td>${cmd.name }</td>
		     </tr>
		     <tr bgcolor="white">
		      <td>나이</td>
		      <td>${cmd.years }</td>
		     </tr>
		     <tr bgcolor="white">
		      <td>성별</td>
		      <td>
		     	${cmd.gender }
		      </td>
		     </tr>
		     <tr bgcolor="white">
		      <td>관심사항</td>
		      <td>
		      <c:forEach items="${cmd.inters }" var="item">
		      	${item }&nbsp;
		      </c:forEach>		      
		      </td>
		     </tr>
		     <tr bgcolor="white">
		      <td>학력</td>
		      <td>
		      ${cmd.grade }
		      </td>
		     </tr>
		     <tr bgcolor="white">
		      <td>자기소개</td>
		      <td>
		      ${cmd.self }
		      </td>
		     </tr>		     
		 </table> 
	</fieldset>
</body>
</html>