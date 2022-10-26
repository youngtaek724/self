<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="header">
	<a href="index.html" class="logo">Altitude <span>by Pixelarity</span></a>
	<nav>
		<ul>
			<li><a href="#menu">Menu</a></li>
		</ul>
	</nav>
</header>

<!-- Nav -->
<nav id="menu">
	<ul class="actions stacked">
		<li><a href="${pageContext.request.contextPath}/member/join.me" class="button primary fit">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/member/login.me" class="button fit">로그인</a></li>
	</ul>
</nav>












