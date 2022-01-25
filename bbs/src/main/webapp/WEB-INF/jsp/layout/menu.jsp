<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  메뉴  -->

<div class="list-group list-group-flush">
   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/noticeList.do">공지사항</a>
   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/bulletinList.do">자유게시판</a>
   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/main.do">홈으로</a>
	<c:choose>
	<c:when test="${sessionId == null }">
   			<a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/loginForm.do">로그인</a>
	</c:when>
	<c:otherwise>
			   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/logOut.do">로그아웃</a>
			   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/mypage.do?id=${sessionId}">마이페이지</a>
	</c:otherwise>
	</c:choose>
	   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/shopItemList.do">전체상품보기(ajax)</a>
	   <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/shopItemList2.do">전체상품보기</a>
	
</div>
