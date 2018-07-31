<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess }">
		<p>글을 수정하였습니다.</p>
	</c:when>
	
	<c:otherwise>
		<p>글 수정을 실패하였습니다.</p>
	</c:otherwise>
</c:choose>
	<a href="../list.do">글 목록 보기</a>

</body>
</html>