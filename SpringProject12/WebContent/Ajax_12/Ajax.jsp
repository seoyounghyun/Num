<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 제이쿼리 코어 -->
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ajax.jsp</title>
<script>
	$(function(){
		//1]AJAX 미사용
		$("#btn1").click(function(){
			//form태그의 action속성 및 method속성 설정]
			$("#frm").attr({action:"<c:url value='/Ajax/NoAjax.do'/>",method:"post"});
			//폼객체의 submit()함수로 서버로 전송]
			$("#frm").submit();
		});//////////////////////BTN1
		
		/*
		 2]AJAX사용-서버로 부터 응답은 TEXT로 받기 
		 
		   ※POST방식으로 전송시
		   type:"post" 그리고
		   contentType은 디폴트로 즉 설정 불필요
		   ※GET방식(디폴트)으로 전송시
		   type:"get"로
		   contentType는 전송하는 컨텐타입으로(생략가능)...
		   
		   ※전송할 데이타가 여러개인 경우
		   <form>태그로 감싸주고
		   
		   $("form선택자").serialize()함수 사용
		   이름1=값1&이름2=값2&이름3=값3.....쿼리 스트링 형태로 반환
		*/
		$("#btn2").click(function(){
			console.log("serialize()함수:"+$("#frm").serialize());
			//비동기 통신 방식으로 서버에 요청하기]
			$.ajax({
				url:"<c:url value='/Ajax/AjaxText.do'/>",//요청할 서버의 URL주소
				type:"post",//데이타 전송방식(디폴트는 get방식) 
				dataType:"text",//서버로 부터 응답 받을 데이타의 형식 설정
				data:
					//1]쿼리스트링 문자열로 전송-데이타가 적을때
					//"id="+$(":input:eq(0)").val()+"&pwd="+$(":input:eq(1)").val(),
					//2]JSON데이타 형식으로 전달-데이타가 적을때
					//{id:$(":text").val(),pwd:$(":password").val()},
					//3]$("form선택자").serialize()함수 사용-데이타가 많을때
					$("#frm").serialize(),
				success:function(data){
					console.log("서버로부터 받은 데이타:"+data);					
					/*여기안에 요청 결과를 표시해줄 코드 구현]
			     	서버로부터 정상적으로 응답을 받을때
				 	자동으로 호출되는 콜백 메소드]
				 	여기 안에서 서버로 부터 받은 데이타를
				 	원하는 위치에 뿌려주면 된다.
				 	※서버로 부터 받은 데이타는 매개변수로 전달됨(data)*/
				 	//서버에서 "Y" 혹은 "N"으로 응답할때]	
				 	//$("#lblDisplay").html(data=="Y"?$(":text").val()+"님 즐감":"회원이 아닙니다");
				 	//서버에서 메시지로 응답할때]
					$("#lblDisplay").html(data);
				},//서버로부터 정상적인 응답을 받았을때 처리할 함수
				error:function(data){
					console.log("에러:"+data);
				}//서버로부터 비정상적인 응답을 받았을때 처리할 함수
			});
			
		});//BTN2
		//3]AJAX사용-JSON데이타로 응답받기   
		$("#btn3").click(function(){
			
			$.ajax(
					{url:"<c:url value='/Ajax/AjaxJson.do'/>",
					 type:"post",
					 dataType:"text",
					 data:$("#frm").serialize(),
					 success:successCallback,//함수명(함수포인터)
					 error:function(data){
							console.log("에러:"+data);
						   }			
					}
				  );//.ajax
			
		});//btn3
		
		//4]AJAX사용 - 서버로 부터 응답은 JSON 배열로 받기 
		$("a:last").click(function(){
			
			$.ajax(
				{url:"<c:url value='/Ajax/AjaxJsonArray.do'/>",
				 type:"post",
				 dataType:"json",
				 success:successArrayCallback,
				 error:function(request,error){
						console.log("code:"+request.status)
						console.log("서버로부터 받은 데이타"+request.responseText);
						console.log("error:"+error);

								
					   }	
						
				}
			);
		});
		
	});////////////////////////////
	var successCallback = function(data){
		console.log("서버로부터 받은 데이타:"+data+",데이타 타입:"+typeof data);
		/*data는 서버측에서 전송한 데이타(JSON형식)
		data는 dataType:"json"로 지정했기때문에
		JSON데이타 타입임.
		만약 dataType:"text"로 설정하면 data는 string객체 타입임.
		string타입을 JSON타입으로 변환하려면
		JSON.parse(string객체)
		즉 data.키값 으로 value값을 꺼내온다.]
		{isMember:"메시지"}형태로 서버에서 응답 
		data=JSON.parse(data);//dataType:"text"일때   
		*/	
		$("#lblDisplay").html(data.isLogin);
	
	}	
	function successArrayCallback(data){
		
		console.log("서버로 부터 받은 데이타:"+data);		
		/*JSON배열을 출력할때는 $.each(data,function(index,list){}); 
		사용]
		data:서버로부터 전송받은 데이타(JSON배열타입)
		index:JSON배열의 인덱스(0부터 시작)	
		list:JSON배열에서 하나씩 꺼내온거를 담은 인자
		each함수:JSON배열인 data에서 하나씩 꺼내서 list에 저장하는 기능
		예] [{키값1:값1,키값2:값2,...},{},{},{},.......]
		읽어올때] list.키값 혹은 list["키값"]*/
		var tableString ="<table style='border-spacing:1px;background-color:green'>";
		tableString+="<tr style='background-color:white'>";
		tableString+="<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>";
		tableString+="</tr>";
		$.each(data,function(index,record){
			tableString+="<tr style='background-color:white'>";
			tableString+="<td>"+(index+1)+"</td><td>"+record.title+"</td><td>"+record.name+"</td><td>"+record["postdate"]+"</td>";
			tableString+="</tr>";			
		});
		
		tableString+="</table>";
		$("#list").html(tableString);
	}/////////////////////////////successArrayCallback

</script>
</head>
<body>
	<fieldset>
		<legend>jQuery Ajax(스프링 연동)</legend>
		<!-- 
	    ajax로 서버에 요청시에는
	    form태그가 의미 없다.
	    단, 전송할 데이타가 많을시에는 form태그 추가시
	    유리함.
	    (왜냐하면 자바스크립트 객체인 XMLHttpRequest가 서버에 요청하기 때문에)
	    --> 
	    <form id="frm">
	    	아이디 <input type="text" name="id"/>
	    	비빌번호 <input type="password" name="pwd"/>
	    	
	    </form>
	    <ul style="list-style-type:upper-roman;">
	    	<li><input type="button" id="btn1" value="회원여부(AJAX미사용)"/></li>
	    	<!-- 
			   Spring:반환타입을 void로 하거나
			                 반환타입을 String으로하고 @ResponseBody어노테이션 사용
			-->	
	    	<li><a href="#" id="btn2">회원여부(AJAX사용-TEXT로 응답받기)</a></li>
	    	<li><input type="button" id="btn3" value="회원여부(AJAX사용-JSON으로 응답받기)"/></li>
	    
	    </ul>
	    
	    <hr/>
	    <span id="lblDisplay" style="color:red;font-size:2em;font-weight:bold">${member}</span>
	    <h3>JSON형식(배열타입)</h3>
	    <a href="#">목록가져오기</a><br/>
	    <span id="list"></span>
	    
	</fieldset>
</body>
</html>