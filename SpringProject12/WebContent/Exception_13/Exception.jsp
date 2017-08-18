<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Exception.jsp</title>
</head>
<body>
	<!-- try~catch로 예외처리가 안되는 예외들은
	      설정파일을 통해서 예외 처리 할 수 있다.
	     (단, 모든 프로젝트 완료후)
	 -->
	 <fieldset>
		  <legend>예외 처리${message}</legend>  
		  <form method="post" action="<c:url value='/Exception/Exception.do'/>">
		   나이를 입력하세요?
		   <input type="text" name="years"/>
		   <input type="submit" value="확인"/>
		  </form>
 	</fieldset>
	 
</body>
</html>