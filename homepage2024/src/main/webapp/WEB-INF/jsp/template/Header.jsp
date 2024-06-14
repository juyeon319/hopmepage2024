<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,miximum=scale=1.0,user-scalable=no" />
<title><c:out value="${param.title }" /></title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- BBS Style '0' 12개 -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet">
<!-- 공통 Style '0' 13개 -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet">
<link href="/asset/TYPETMP_02/style.css" rel="stylesheet">

</head>
<body>
<header class="site-header">
	<div class="util">
		<div class="wrap">
			<ul>
				<li><a href="/">HOME</a></li>
				<c:choose>
					<c:when test="${empty USER_INFO.id }">
						<li><a href="/uat/uia/egovLoginUsr.do">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><strong><c:out value="${USER_INFO.name }" /></strong>님 환영합니다</li>
						<li><a href="/uat/uia/actionLogout.do">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	<div class="header-cont wrap">
		<nav class="site-gnb">
			<ul>
				<li>
					<a href="/board/selectList.do">게시판</a>
				</li>
			</ul>
		</nav>
	</div>
</header>