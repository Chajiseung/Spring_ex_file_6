<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, '%', '%');
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer, contents);
		});
		
		$("#btnView").click(function() {
			memoView(1);
		});
		
		
	});
	
</script>
</head>
<body>
	<div>
		<form action="">
			<p><input type="text" id="writer"></p>
			<p><textarea rows="" cols="" id="contents"></textarea></p>
			<input type="button" value="WRITE" id="btn">
		</form>
	</div>
	<div id="result"></div>
	<button id="btnView">View</button>

</body>
</html>