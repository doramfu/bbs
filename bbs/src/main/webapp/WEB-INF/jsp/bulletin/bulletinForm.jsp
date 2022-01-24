<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
function submitForm(){
    event.preventDefault();//전송기능을 차단

    document.querySelector('[name=title]').value // 네임 속성이 타이틀인 
    var title = $('[name="title"]').val();
    var writer= $('[name="writer"]').val();
    var content= $('[name="content"]').val();
    var image= $('[name="image"]').val();
    //필수 입력항목체크
    if(title == '' || writer == ''|| content == ''|| image == ''){
        alert('입력항목을 확인하세요')
        return;
    }

    document.forms.frm.submit();//전송처리

}
</script>


<h3>글등록</h3>
<form name="frm" action="${pageContext.request.contextPath }/bulletinAdd.do"
	method="post" enctype="multipart/form-data" onsubmit="submitForm()">
	<table border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td><input class="form-control" type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input class="form-control" type="text" name="writer" value="${sessionId }" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control" name="content" cols="20" rows="4"></textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input class="form-control" type="file" name="image"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="제출"> <input
					type="reset"></td>
			</tr>
		</tbody>
	</table>
</form>