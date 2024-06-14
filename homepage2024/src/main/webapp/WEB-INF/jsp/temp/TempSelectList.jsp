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
<style>
	table {
		border-collapse: collapse; 
	}
	
	th {
		font-weight: bold;
	}
	
	th, td {
		padding: 5px;
		border: 1px solid #000;
	}
</style>
</head>
<body>
게시물 총 수 : <c:out value="${totCnt }" />건
	<table>
		<thead>
			<tr>
				<th>TEMP_ID</th>
				<th>TEMP_VAL</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}">
				<tr>
					<td><c:out value="${result.tempId }" /></td>
					<td>
						<c:url var="viewUrl" value="/temp/select.do">
							<c:param name="tempId" value="${result.tempId }" />
						</c:url>
						<a href="${viewUrl }">
							<c:out value="${result.tempVal }" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/temp/tempRegist.do">등록하기</a>
</body>
</html>