<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta content="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="join">회원가입</a>
	<a href="login">로그인</a>
	<br><br>
	<c:if test="${member!=null}">
		<ul>
			<li>아이디 : ${member.userid }</li>
			<li>아이디 : ${member.username }</li>
			<li>아이디 : ${member.email }</li>
			<li>아이디 : ${member.phone }</li>
		</ul>
		
		<div id="upload">
			
		</div>
		
		<a href="uploadPreviewForm">로그인</a>
	</c:if>
</body>
</html>