<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form id="f1" action="uploadPreview" method="post" enctype="multipart/form-data">
		작성자 이름 : <input type="text" name="userid" value="${sessionScope.member.userid }"><br> 
		파일 선택 : <input type="file" name="file" id="file" multiple="multiple"><br>
		<input type="submit" value="전송">
	</form>
	
	<div id="dropBox">
		
	</div>
	
	<script type="text/javascript">
		$("#file").change(function(){
			$("#dropBox").empty();
			
			var reader = new FileReader();
			var target1 = $(this)[0];
			//var imgObj= "";
			var i=0;
			var length = $(this)[0].files.length;
			reader.onload = function(e){
				var imgObj = $("<img>").attr("src",e.target.result);
				$("#dropBox").append(imgObj);
				i++;
				if(i<length){
					reader.readAsDataURL(target1.files[i]);
				}else{
					return;
				}	
			}
			
			//$(this)[0] 제이쿼리를 자바스크립트로 바꿔줌
			//var file = document.getElementById("file");
			//file.files[0]
			
			//  alert(length);
			
			reader.readAsDataURL($(this)[0].files[0]);
			
		})
	</script>
</body>
</html>