<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title>Layouts.jsp</title>    
	<meta charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Styles/divLayout.css"/>	

</head>
<body >
    <div class="allWrap">
        <div class="partWrap">
            <!-- 탑메뉴 및 로고 감싸는 div 시작 -->
            <div class="header">                
               <tiles:insertAttribute name="header"/>
            </div>
            <!-- 탑메뉴 및 로고 감싸는 div 끝 -->
            <!--Left메뉴 및 실제 내용 감싸는 div시작-->
            <div class="section">              
                <tiles:insertAttribute name="left"/>
                <div class="body">
                    <div class="content">    
                    	<tiles:insertAttribute name="body"/>           
                    </div>
                </div>
            </div>
            <!--Left메뉴 및 실제 내용 감싸는 div끝-->
            <!--footer를 감싸는 div 시작-->
            <tiles:insertAttribute name="footer"/>
            <!--footer를 감싸는 div 끝-->
        </div>
    </div>
</body>
</html>
