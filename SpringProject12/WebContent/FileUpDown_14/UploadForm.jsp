<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>UploadForm.jsp</title>
</head>
<body>
	<fieldset>
		<legend>파일업로드 폼</legend>
		   <a href="<c:url value='/FileUpDown/List.do'/>">파일 목록</a>
		   <form	action="<c:url value='/FileUpDown/Upload.do'/>" 
		     		method="post" 
		     		enctype="multipart/form-data">
		     <table cellspacing="1" bgcolor="gray">
		      <tr bgcolor="white">
		       <td>올린이</td>
		       <td><input type="text" name="writer" /></td>
		      </tr>
		      <tr bgcolor="white">
		       <td>제목</td>
		       <td><input type="text" name="title" size="50"/></td>
		      </tr>
		      <tr bgcolor="white">
		       <td>첨부파일</td>
		       <td><input type="file" name="upload" size="30"/></td>
		      </tr>
		      <tr bgcolor="white" align="center">
		       <td colspan="2"><input type="submit" value="업로드"/></td>
		      </tr>
		     </table> 
		   </form> 
	
	</fieldset>
</body>
</html>