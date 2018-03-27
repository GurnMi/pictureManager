<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta content="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#dropBox{
		width:300px;
		height:300px;
		border:1px solid #ccc;
		overflow:auto;
	}
	#dropBox img{
		max-width: 100%;
		max-height: 100%;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

	<div>
		작성자 : ${writer}<br>
		<c:forEach var="item" items="${filename}">
			파일이름 : ${item}<br>
			<img src="displayFile?filename=${item}" data-path="${item}" class="img"><br>
		</c:forEach>	
		
		<%-- <img src="displayFile?filename=${filename }" data-path="${filename2 }" id="img"> --%>
	</div>
	
	<div >
		<img id="result">
	</div>
	
	<script>
		$(function(){
			$(".img").on("click",function(){
				
				var path = $(this).attr("data-path");
				
				
				
				var s1= path.substring(0,12);
				var s2 = path.substring(14);
				//alert(s1);
				
				$("#result").attr("src","displayFile?filename="+s1+s2);
			})
		})
		
	</script>
</body>
</html>