<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <title>Websocket.jsp</title>
	<meta charset="utf-8" />
    <script>
        var wsocket;
		var nickname;
		
        var sendMessage = function () {

            var nickname = document.getElementById("nickname").value;
            var msg = document.getElementById("message").value;
            wsocket.send("msg:" + nickname + ":" + msg);
            document.getElementById("message").value = "";
        }

        window.onload = function () {

            document.getElementById("message").onkeypress = function (event) {
                var keycode = (event.keyCode ? event.keyCode : event.which);
                if (keycode == '13') {
                    sendMessage();
                }
                event.stopPropagation();
            }

            document.getElementById("sendBtn").onclick = function () {

                sendMessage();

            }
            document.getElementById("enterBtn").onclick = function () {
                //jWebSocket 서버]
                wsocket = new WebSocket("ws://localhost:8080${pageContext.request.contextPath}/chat-ws.do");
                wsocket.onopen = onOpen;
                wsocket.onmessage = onMessage;
                wsocket.onclose = onClose;
                //사용자 닉네임 저장]
                nickname = $("#nickname").val();

            }
            document.getElementById("exitBtn").onclick = function () {
            	wsocket.send("msg:"+nickname+"이 퇴장 했어요");
            	wsocket.close();

            }

        }

        function onOpen(evt) {
        	wsocket.send("msg:"+nickname+"이 입장 했어요");
            appendMessage("연결되었습니다.");
        }
        function onMessage(evt) {
            var data = evt.data;
            if (data.substring(0, 4) == "msg:") {
                appendMessage(data.substring(4));
            }
        }
        function onClose(evt) {
            appendMessage("연결을 끊었습니다.");
        }


        function appendMessage(msg) {

            document.getElementById("chatMessage").innerHTML += msg + "<br>";
            document.getElementById("chatArea").scrollTop = document.getElementById("chatArea").scrollHeight;

        }


    </script>
</head>
<body>
    <fieldset>
        <legend>웹소켓 클라이언트</legend>
        <h2>닉네임</h2>
        <input type="text" id="nickname" style="width:400px">
        <input type="button" id="enterBtn" value="입장" >
        <input type="button" id="exitBtn" value="퇴장">

        <h2>대화 영역</h2>
        <div id="chatArea" style="width: 600px; height: 200px;overflow:auto;  border: 1px solid black;">
            <div id="chatMessage"></div>
        </div>
        <h2>메시지 입력</h2>
        <input type="text" id="message" style="width:400px">
        <input type="button" id="sendBtn" value="전송">

    </fieldset>
</body>
</html>
