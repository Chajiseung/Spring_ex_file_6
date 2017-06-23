<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
var m = '${message}';
if(m != ''){
	alert(m);
}
</script>
<script type="text/javascript">
$(function() {
	
	$(".curPage").click(function(){
		 var curPage = $(this).attr("title");		
		$("#curPage").val(curPage); 
		$("#search").val("${listInfo.search}");
		$("#find").val("${listInfo.find}");
		$("#sfrm").submit();
		
		
	});
	
	
});
</script>
</head>
<body>
<h1>${board}</h1>

<div>
	<form action="./${board}List" id="sfrm">
		<select name="search" id="search" value="${listInfo.search}" >
			<option value="title">title</option>
			<option value="writer">writer</option>
			<option value="contents">contents</option>
		</select>
		<input type="hidden" id="curPage" name="curPage">
		<input type="text" id="find" name="find" value="${listInfo.find}">
		<input type="submit" value="search" > 
	</form>

</div>
<table>
<tr>
	<td>Num</td><td>Title</td><td>Writer</td><td>data</td><td>hit</td>
<tr>
<c:forEach items="${list}" var="dto">	
	<tr>
	<td>${dto.num}</td>	
	<td>
	<c:catch>
	<c:forEach begin="1" end="${dto.depth}">@</c:forEach>
	</c:catch>
	<a href="./${board}View?num=${dto.num}">${dto.title}</a>	
	</td>
	<td>${dto.writer}</td>
	<td>${dto.reg_date}</td>
	<td>${dto.hit}</td>
	</tr>
</c:forEach>
</table>

<c:if test="${listInfo.curBlock > 1}">
	<span class="curPage" title="${listInfo.startNum-1}">[이전]</span>
</c:if>
<c:forEach begin="${listInfo.startNum}" end="${listInfo.lastNum}" var="i" >
	<span class="curPage" title="${i }">${i }</span>
	
</c:forEach>
<c:if test="${listInfo.curBlock < listInfo.totalBlock }">
	<span class="curPage" title="${listInfo.lastNum+1}">[다음]</span>
	
</c:if>


<a href="./${board}Write">write</a>
<div>
	<p>curPage:${listInfo.curPage}</p>
	<p>search : ${listInfo.search }</p>
	<p>find : ${listInfo.find }</p>

</div>

</body>
</html>