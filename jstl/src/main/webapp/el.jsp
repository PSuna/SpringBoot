<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el</title>
</head>
<body>
<%
	session.setAttribute("name", "session_홍길동");
	request.setAttribute("name", "request_홍길동");
	//Cookie cookie = new Cookie("popup","yes");
	//response.addCookie(cookie);
%>
<%= session.getAttribute("name") %> => ${sessionScope.name}<br>
<%= request.getAttribute("name") %> => ${name}<br>
<%= request.getParameter("name") %> => ${param.name}<br>
<%= request.getHeader("User-Agent") %> <hr> => ${header["User-Agent"]}<br>
${cookie.popup.value }<br>

</body>
</html>