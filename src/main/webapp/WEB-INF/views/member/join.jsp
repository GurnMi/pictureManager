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
	.error, .error1, .error2,.error3, .error4{
		color: red;
		padding: 0;
		margin: 0 0 0 90px;
		font-size: 12px;
		display: none;
		
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("form[name='f1']").submit(function(){
			var regId =/^[a-z]+[a-z0-9]{5,15}$/;
			var userid = $("input[name='userid']").val();
			
			if(!regId.test(userid)){				
				//alert(pw);
				$(".error4").css("display","block");
				return false;
			}else{
				$(".error4").css("display","none");
			}
			
			
			var pw = $("input[name='userpw']").val();
			var reg =/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
				
			if(!reg.test(pw)){				
				//alert(pw);
				$(".error1").css("display","block");
				return false;
			}else{
				$(".error1").css("display","none");
			}
			
			if($("input[name='userpw']").val()!=$("input[name='confirmPassword']").val()){
				$(".error2").css("display","block");
				$("input[name='confirmPassword']").focus();
				return false;
			}else{
				$(".error2").css("display","none");
			}
			
			var regName =/^[가-힣]{2,10}$/;
			var username = $("input[name='username']").val();
			if(!regName.test(username)){				
				$(".error3").css("display","block");
				return false;
			}else{
				$(".error3").css("display","none");
			}
			
			
			
		})
		
		$("#id").click(function(){
			var id = $("input[name='userid']").val();
			if(id==""){
				$(".error4").css("display","block");
				return false;
			}
			$.ajax({
				url:"idCheck?id="+id,
				type:"get",
				success:function(result){
					if(result=="true"){
						alert("이미존재하는 아이디 입니다");
						$("input[name='userid']").val("");
					}else{
						alert("사용가능한 아이디 입니다");
					}
				}
			})
			
		})
		
	})
	
	
</script>
</head>
<body>
	

	
	<form method="post" action="join" name="f1">
		<p>
			<label>아이디</label>
			<input type="text" name="userid"><br>
			<span class="error4">다시 입력해주세요</span>
			<button id="id">중복체크</button>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="userpw"><br>
			<span class="error1">다시 입력해주세요</span>
		</p>
		<p>
			<label>비번 확인</label>			
			<input type="password" name="confirmPassword"><br>
			<span class="error2">다시 입력해주세요</span>
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="username"><br>
			<span class="error3">다시 입력해주세요</span>
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
		<p>
			<input type="submit" value="가입">
			
		</p>
	</form>
	

</body>
</html>