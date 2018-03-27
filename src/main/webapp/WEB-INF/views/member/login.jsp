<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta content="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form{
		width: 300px;
		border: 1px solid gray;
	}
	label{
		width: 80px;
		float: left;
		padding-left: 10px;
	}
	p:LAST-CHILD {
		text-align: center;
	}
</style>
</head>
<body>
	
	<form method="post" action="login">
		<p>
			<label>아이디</label>
			<input type="text" name="userid"><br>
			<!-- <span class="error">다시 입력해주세요</span> -->
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="userpw"><br>
		</p>
		<p>
			<input type="submit" value="로그인">
		</p>
	</form>
	
	<c:if test="${error != null}">
		<h1>${error} 확인</h1>
		
	</c:if>
</body>
</html>