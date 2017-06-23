<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>Upload</button>
	
	</form>
	
	<hr>
	
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>Upload</button>
	
	</form>
	
	<hr>
	
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>Upload</button>
	
	</form>
	<hr>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<div id="file">
		
		</div>
		<input type="button" id="add" value="파일추가">
		<button>Upload</button>
	
	</form>
	<script type="text/javascript">
		var i = 0;
		
		$("#add").click(function(){
			if(i<5){
			i++;
			var data = '<p class="test"><input type="file" name="f'+i+'"><span class="delete">X</span></p>';
			$("#file").append(data);
			}else{
				alert("최대 5개 까지 가능");
			}
		});
		$("#file").on("click",".delete",function(){

			$(this).parent().remove();
			i--;
		});
		
		
		
		
		
	</script>

</body>
</html>