<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>

<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<script>
	function formSubmit(id) {
		document.forms.frm.id.value = id;
		document.forms.frm.submit();
	}
</script>
<form id="frm" name="frm" action="${pageContext.request.contextPath }/bulletinSelect.do" method="post">
	<input type="hidden" name="id">
</form>

<table id="example" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="bulletin" items="${bulletinList }">
			<tr onclick="formSubmit(${bulletin.bbsId })">
				<td>${bulletin.bbsId }</td>
				<td>${bulletin.bbsTitle }</td>
				<td>${bulletin.bbsWriter }</td>
				<td>${bulletin.bbsCreateDate }</td>
				<td>${bulletin.bbsHit }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>