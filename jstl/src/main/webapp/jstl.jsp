<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl(Java Standard Tag Library)</title>
</head>
<body>
<% List<String> list = Arrays.asList("사과", "바나나", "포도"); 
	request.setAttribute("list", list);
%>

<%= request.getContextPath() %>
${pageContext.request.getContextPath()}
${pageContext.request.contextPath}
<!-- ★ 절대 경로를 걸어줄때 많이사용함 ★ -->
<a href="${pageContext.request.contextPath}/board">게시판</a>


총 갯수 : ${fn:length(list)} <br> <!-- fn 함수의 총 갯수 구하는 함수, 보통 fn은 문자열과 관려된게 많다 -->
<ul>
<c:forEach var="item" items="${list}" varStatus="st">
	<li>${st.count} ${item } <c:if test="${st.last}"> end </c:if></li>
</c:forEach>
<c:forEach begin="10" end="15" var="item" varStatus="st">
	<!-- index는 0부터시작 하지만 여기선 begin이 10이므로 10부터 시작 -->
	<!-- count는 무조건 1부터 시작 -->
	${st.index} ${st.count} <br> 
</c:forEach>
</ul>
</body>
</html>