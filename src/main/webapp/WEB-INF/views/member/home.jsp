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
	.imgList{
		float: left;
		width: 25%;
		border: 1px solid gray;
		padding: 20px;
		margin:20px;
		text-align: center;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<c:if test="${sessionScope.member==null}">
		<a href="join">회원가입</a>
		<a href="login">로그인</a>
	</c:if>
	
	
	
	<c:if test="${sessionScope.member!=null}">
		<a href="logoutHome">로그아웃</a>
		<a href="uploadPreviewForm">파일업로드</a>
		
		<ul>
			<li>아이디 : ${sessionScope.member.userid }</li>
			<li>이름 : ${sessionScope.member.username }</li>
			<li>이메일 : ${sessionScope.member.email }</li>
			<li>폰번호 : ${sessionScope.member.phone }</li>
		</ul>
		
		
	
			
		<div id="list">
			
			<c:forEach var="filelist" items="${filelist}">
				<div class="imgList">
					<script type="text/javascript">
						var path = "${filelist.fullName}";
						var a = path.substring(51);
						document.write("파일이름 : "+a);
					</script>
					<br>
					업로드일 : <fmt:formatDate value="${filelist.regdate}" pattern="yyyy-MM-dd"/><br>
					<img src="displayFile?filename=${filelist.fullName}" data-path="${filelist.fullName}" class="img"><br>
					<button class="del" data-path="${filelist.fullName}">삭제</button>
					<br>
				</div>
			</c:forEach>
			
			
			
			
			
			<div >
				<img id="result">
			</div>
			
			
		</div>
	</c:if>
	
	<script>
		$(function(){
			
			$(".img").on("click",function(){
				var path = $(this).attr("data-path");
				
				
				var s1= path.substring(0,12);
				var s2 = path.substring(14);
				
				$("#result").attr("src","displayFile?filename="+s1+s2);
			})
			
			
			$(".del").on("click",function(){
		         if(confirm("정말 삭제하시겠습니까?")){
		            var path = $(this).attr("data-path");
		            //alert(path);
		            $(location).attr('href', "deleteFile?filename="+path);
		            
		         }else{
		            return;
		         }
		      });
		
		})
		
	</script>

</body>
</html>