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
<p><strong>${id }</strong>님 로그인 중...</p>
<h3>파일 업로드 폼입니다.</h3>
<form action="upload.do" method = "post" enctype="multipart/form-data">
	<label for="title">제목</label>
	<input type="text" name ="title" id = "title" /><br />
	<label for="myFile">첨부파일</label>
	<input type="file" name ="myFile" id = "myFile"/><br />
	<button type = "submit">업로드</button>
</form>
</body>
</html>