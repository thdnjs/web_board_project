<%@page import="test.gallery.dto.GalleryDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>

<div class="container">
	<a href="private/upload_form.do">사진 올리기</a>
	<h3>사진 Gallery 입니다.</h3>
	
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>이미지 </th>
				<th>caption</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.writer }</td>
					<td><img src="${cPath }${tmp.imagePath}" alt="이미지!!" /></td>
					<%-- <td><img src="<%=cPath %><%=tmp.getImagePath() %>" alt="이미지!" /></td> --%>
					<td>${tmp.caption }</td>
					<td>${tmp.regdate }</td>
					<c:if test="${id eq tmp.writer}">
						<td><a href="javascript:deleteConfirm(${tmp.num })">삭제</a></td><!-- 자기꺼만 삭제 -->
					</c:if>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	
</div>
<script>
function deleteConfirm(num){
	var isDelete = confirm(num+"번 파일을 진짜로 삭제 하시겠습니까?");
	if(isDelete){
		location.href="private/delete.do?num="+num;	
	}
}
</script>
	
</body>
</html>