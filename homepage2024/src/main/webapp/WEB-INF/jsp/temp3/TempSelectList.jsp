<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/common.css" rel ="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
table{border-collapse: collapse;}
th{font-weight:bold; border:1px solid #000;}
th,td{padding 5px;}
</style>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>TEMP_ID</th>
			<th>TEMP_VAL</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items = "${resultList}">
			<tr>
				<td><c:out value="${result.tempId}"/></td>
				<td>
					<c:url var="viewUrl" value="/temp3/select.do">
						<c:param name = "tempId" value="${result.tempId}"/>
					</c:url>
					<a href="${viewUrl}"><c:out value="${result.tempVal}"/></a>
				</td>
				<td>
					<c:url var="delUrl" value="/temp3/delete.do">
						<c:param name ="tempId" value="${result.tempId}"/>
					</c:url>
					<a href="${delUrl}" class="btn-del">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>				
</table>	
<div id="paging_div">
	<ul class= "paging_align">
		<c:url var="pageUrl" value="temp3/selectList.do?"/>
		<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
	   <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
	</ul>
</div>	
<button type="button" id="btn-reg" data-href="/temp3/tempRegist.do">등록하기</button>					
<script>
$(document).ready(function() { /* HTML 랜더링(위→아래)을 하고 나서 적용 */
	$("#btn-reg").click(function() {
		location.href = $(this).data("href"); /* "/temp3/tempRegist.do" 경로로 이동 */
	});
	
	$(".btn-del").click(function() {
		if (!confirm("삭제하시겠습니까?")) {
			return false;
		}	
	});
});									
</script>									
</body>
</html>