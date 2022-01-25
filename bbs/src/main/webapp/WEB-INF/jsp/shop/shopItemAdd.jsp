<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="ckeditor/ckeditor.js"></script>
<script>
	$(document).ready(function() {
		CKEDITOR.replace('item_desc',{
			filebrowserUploadUrl: 'shopItemUpload.do'
		});
	});
</script>
<form action="shopItemUpload2.do" method="post" enctype="multipart/form-data">
<table border="1">
	<tr>
		<th>상품이름</th>
		<td><input type="text" name="item_name"></td>
	</tr>
	<tr>
		<th>상품설명</th>
		<td><textarea name="item_desc"></textarea></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="text" name="origin_price"></td>
	</tr>
	<tr>
		<th>할인가격</th>
		<td><input type="text" name="sale_price"></td>
	</tr>
	<tr>
		<th>평점</th>
		<td><input type="text" name="like_it"></td>
	</tr>
	<tr>
		<th>상품이미지</th>
		<td><input type="file" name="image"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="업로드">
			<input type="reset" value="초기화">
		</td>
	</tr>
</table>
</form>