<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="scriptless"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="siteTitle"  %>
<c:url var="adminMain" value="/admin/main.jsp" />
<c:url var="boardList" value="/admin/board/index.jsp" />
<c:url var="boardConfig" value="/admin/board/config.jsp"/>
<fmt:setBundle basename="messages.common"/>
<layout:common siteTitle="${siteTitle }" isAdmin="true">
	<jsp:attribute name="header">
		<div class="admin_main">
			<a href="${adminMain}" class="menu"${menuCode == 'adminMain'? ' on' : ''}>
				<i class="xi-main">관리자 홈</i>
			</a>
		</div>
		<div class="admin_menu">
			<a href="${boardList}" class="menu${menuCode == 'boardList' ? ' on' : ''} }">
				<i class="xi-list">게시판 목록</i>
			</a>
			<a href="${boardConfig}" class="menu${menuCode == 'boardRegister' ? ' on' : ''}">
				<i class="xi-plus">게시판 등록</i>
			</a>
		</div>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<h2>copy@write...</h2>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody/>
	</jsp:body>
</layout:common>