<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sucess.jsp</title>
</head>
<body>
	<fieldset>
		<legend>유효성 검증 결과 페이지</legend>
		<ul style="list-style-type:upper-roman;">
			<li>이름:${command.name }</li>
			<li>나이:${command.years }</li>
			<li>성별:${command.gender }</li>
			<li>관심사항:${command.inters }</li>
			<li>학력:${command.grade }</li>
			<li>자기소개:${command.self }</li>
		</ul>
	</fieldset>
</body>
</html>