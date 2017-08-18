<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>UploadComplete.jsp</title>
</head>
<body>
	<fieldset>
		<legend>파일 업로드 결과</legend>
		<ul style="list-style-type: upper-roman;">
			<li>올린이:${writer}</li>
			<li>제목:${title}</li>
			<li>원래 파일명:${originalName}</li>
			<li>실제 저장된 파일명:${realFilename}</li>
			<li>컨텐츠 타입:${contentType}</li>
			<li>파일 크기:${fileSize}KB</li>
		</ul>
	</fieldset>
</body>
</html>