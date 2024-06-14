<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri= "http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty result.crudId }">
			<c:set var="actionUrl"  value="/temp4/update.do" />
		</c:when>
		<c:otherwise>
			<c:set var="actionUrl"  value="/temp4/insert.do" />
		</c:otherwise>
	</c:choose>
	
	<form action="${actionUrl }" method="post" name="temp4VO">
		<input type="hidden" name="crudId" value="${result.crudId }">
		<label for="crudSj">제목 : </label>
		<input type="text" id="crudSj" name="crudSj" value="${result.crudSj }"/>
		<label for="crudSj">작성자 : </label>
		<input type="text" id="userNm" name="userNm" value="${result.userNm }"/>
		<label for="crudCn">내용 : </label>
		<input type="text" id="crudCn" name="crudCn" value="${result.crudCn }"/>
		<br>
		<c:choose>
			<c:when test="${not empty result.crudId }">
				<button type="submit">수정</button>
			</c:when>
			<c:otherwise>
				<button type="submit">등록</button>
				<a href="/temp4/selectList.do">취소</a>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>