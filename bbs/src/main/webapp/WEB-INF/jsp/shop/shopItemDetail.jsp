
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<h4>상품 상세</h4>
<table border="1">
	<tr>
		<th>상품이름</th>
		<td>${shopItem.itemName }</td>
	</tr>
	<tr>
		<th>상품설명</th>
		<td>${shopItem.itemDesc }</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>${shopItem.originPrice }</td>
	</tr>
	<tr>
		<th>할인가격</th>
		<td>${shopItem.salePrice }</td>
	</tr>
	<tr>
		<th>평점</th>
		<td>${shopItem.likeIt }</td>
	</tr>
	<tr>
		<th>상품이미지</th>
		<td><img src="upload/${shopItem.image }"></td>
	</tr>
</table>