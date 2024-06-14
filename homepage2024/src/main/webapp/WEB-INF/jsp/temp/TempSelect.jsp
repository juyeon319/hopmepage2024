<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${result.tempId} : ${result.tempVal}
	<br>
	<c:url var="uptUrl" value="/temp/tempRegist.do">
		<c:param name="tempId" value="${result.tempId }" />
	</c:url>
	<a href="${uptUrl }">수정</a>
	
	<c:url var="delUrl" value="/temp/delete.do">
		<c:param name="tempId" value="${result.tempId }" />
	</c:url>
	<a href="${delUrl }">삭제</a>
	
	<a href="/temp/selectList.do">목록</a>
</body>
</html>