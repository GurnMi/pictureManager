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
	
	
	<form method="post" action="join">
		<p>
			<label>아이디</label>
			<input type="text" name="userid"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="text" name="userpw"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
		<p>
			<label>비밀번호 확인</label>
			<input type="text" name="userpw1"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="username"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
		<p>
			<label>이메일</label>
			<input type="text" name="email"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
		<p>
			<label>전화번호</label>
			<input type="text" name="phone"><br>
			<span class="error">다시 입력해주세요</span>
		</p>
	</form>
	

</body>
</html>