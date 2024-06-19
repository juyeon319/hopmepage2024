<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/template/header.do" charEncoding="utf-8">
	<c:param name="title" value="게시판" />
</c:import>

<%-- 기본 URL --%>
<c:url var="_BASE_PARAM" value="">
	<c:if test="${not empty searchVO.searchCondition}"><c:param name="searchCondition" value="${searchVO.searchCondition }" /></c:if>
	<c:if test="${not empty searchVO.searchKeyword}"><c:param name="searchKeyword" value="${searchVO.searchKeyword }" /></c:if>
</c:url>

<c:choose>
	<c:when test="${not empty searchVO.boardId }">
		<c:set var="actionUrl" value="/board/update.do" />
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="/board/insert.do" />
	</c:otherwise>
</c:choose>

<div class="container">
	<div id="contents">
		<form action="${actionUrl }" method="post" id="frm" name="frm" onsubmit="return regist()" enctype="multipart/form-data">
			<input type="hidden" name="boardId" value="${result.boardId }" />
			
			<table class="chart2">
				<caption>게시글 작성</caption>
				<colgroup>
					<col style="width:120px" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">제목</th>
						<td><input type="text" id="boardSj" name="boardSj" title="제목입력" class="q3" value="<c:out value="${result.boardSj }"/>"/></td>
					</tr>
					<tr>
						<th scope="row">공지여부</th>
						<td>
							<label for="noticeAtY">예 : </label>
							<input type="radio" id="noticeAt" value="Y" name="noticeAt" <c:if test="${result.noticeAt eq 'Y'}">checked="checked"</c:if>/>
							&nbsp;&nbsp;&nbsp;
							<label for="noticeAtN">아니오 : </label>
							<input type="radio" id="noticeAtN" value="N" name="noticeAt" <c:if test="${result.noticeAt ne 'Y'}">checked="checked"</c:if>/>
						</td>
					</tr>
					<tr>
						<th scope="row">비공개여부</th>
						<td>
							<label for="othbcAtY">예 : </label>
							<input type="radio" id="othbcAtY" value="Y" name="othbcAt" <c:if test="${result.othbcAt eq 'Y'}">checked="checked"</c:if>/>
							&nbsp;&nbsp;&nbsp;
							<label for="othbcAtN">아니오 : </label>
							<input type="radio" id="othbcAtN" value="N" name="othbcAt" <c:if test="${result.othbcAt ne 'Y'}">checked="checked"</c:if>/>
						</td>
					</tr>
					<tr>
						<th scope="row">작성자ID</th>
						<td><c:out value="${USER_INFO.id}" /></td>
					</tr>
					<tr>
						<th scope="row">내용</th>
						<td>
							<textarea id="boardCn" name="boardCn" rows="15" title="내용입력"><c:out value="${result.boardCn }"/></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btn-cont ar">
				<c:choose>
					<c:when test="${not empty searchVO.boardId }">
						<c:url var="uptUrl" value="/board/update.do">
							<c:param name="boardId" value="${result.boardId }" />
						</c:url>
						<a href="${uptUrl }" id="btn-reg" class="btn">수정</a>
						
						<c:url var="delUrl" value="/board/delete.do">
							<c:param name="boardId" value="${result.boardId }" />
						</c:url>
						<a href="${delUrl }" id="btn-del" class="btn"><i class="ico-del"></i>삭제</a>
					</c:when>
					<c:otherwise>
						<a href="#none" id="btn-reg" class="btn spot">등록</a>
					</c:otherwise>
				</c:choose>
				<c:url var="listUrl" value="/board/selectList.do${_BASE_PARAM }" />
				<a href="${listUrl }" class="btn">취소</a>
			</div>
		</form>
	</div>
</div>

<script>
$(document).ready(function(){
	//게시글 등록
	$("#btn-reg").click(function() {
		$("#frm").submit();
		return false;
	});
	
	//게시글 삭제
	$("#btn-del").click(function() {
		if(!confirm("삭제하시겠습니까?")){
			return false;
		}
	});
});

function regist(){
	if(!$("#boardSj").val()){
		alert("제목을 입력해주세요");
		$("#boardSj").focus();
		return false;
	}
}
</script>

<c:import url="/template/footer.do" charEncoding="utf-8" />