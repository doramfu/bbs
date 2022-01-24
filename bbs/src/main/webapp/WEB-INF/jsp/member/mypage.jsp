<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="myUpdate.do" method="post">
	<input type="hidden" name="id" value="${member.id }">
<table border="1">
	<tr>
		<th>아이디</th>
		<td>${member.id }</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
		<c:choose>
				<c:when test="${uri == '/myUpdate.do' }">
					${member.passwd }
				</c:when>
				<c:otherwise>
					<input type="text" name="passwd" value="${member.passwd }"></td>
				</c:otherwise>
			</c:choose>
	</tr>
	<tr>
		<th>이름</th>
		<td>
			<c:choose>
				<c:when test="${uri == '/myUpdate.do' }">
					${member.name }
				</c:when>
				<c:otherwise>
					<input type="text" name="name" value="${member.name }"></td>
				</c:otherwise>
			</c:choose>
	</tr>
	<tr>
		<th>메일</th>
		<td>
		<c:choose>
				<c:when test="${uri == '/myUpdate.do' }">
					${member.mail }
				</c:when>
				<c:otherwise>
				<input type="text" name="mail" value="${member.mail }"></td>
				</c:otherwise>
			</c:choose>
	</tr>
	<c:choose>
		<c:when test="${uri == '/myUpdate.do'}">
			<a href="bulletinList.do">목록으로</a>
		</c:when>
		<c:otherwise>
	<tr>
		<td colspan="2">
			<input type="submit" value="변경">
			<input type="reset" value="초기화">
		</td>
	</tr>
		</c:otherwise>
	</c:choose>
</table>
</form>