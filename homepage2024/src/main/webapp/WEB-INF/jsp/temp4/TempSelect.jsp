<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
        td {
            vertical-align: top;
        }
        .content {
            height: 150px;
        }
    </style>
</head>
<body>
<table>
        <tr>
            <th>제목</th>
            <td>${result.crudSj }</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${result.userNm }</td>
        </tr>
        <tr>
            <th>작성일</th>
            <td>${result.frstRegistPnttm}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td class="content">${result.crudCn }</td>
        </tr>
    </table>
<div class="box-btn">
	<c:url var="uptUrl" value="/temp4/tempRegist.do">
		<c:param name="crudId" value="${result.crudId }" />
	</c:url>
	<a href="${uptUrl }">수정</a>

	<c:url var="delUrl" value="/temp4/delete.do">
		<c:param name="tempId" value="${result.crudId }" />
	</c:url>
	<a href="${delUrl }" class="btn-del">삭제</a>

	<a href="/temp4/selectList.do">목록</a>
</div>
<script>
	$(document).ready(function(){
		$(".btn-del").click(function(){
			if(!confirm("삭제하시겠습니까?")){
				return false;
			}
		});
	});
</script>		
</body>
</html>