<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link href="css/styles_item.css" rel="stylesheet">

<script>
<section>
	$(document).ready(function() {
		var divs = $('div.card-body.p-4>div.text-center>div');
		for (let i = 0; i < divs.length; i++) {
			console.log($(divs[i]).attr('cnt'));
			var point = $(divs[i]).attr('cnt');
			like_it($(divs[i]), point);
		}
	});

	//평점 계산.
	function like_it(parent, point) {
		//point : 4.5, 4
		var pointInt = Math.floor(point);
		var pointFlt = point - pointInt;
		//별(1) 반복.
		for (let i = 0; i < pointInt; i++) {
			$(parent).append($('<div>').addClass("bi-star-fill"));
		}
		// 별(.5) 계산
		if (pointFlt) {
			$(parent).append($('<div>').addClass("bi-star-half"));
		}
	}
	// 통화단위 표현.
	function currencyFormat(won) {
		return new Intl.NumberFormat('ko-kr', {
			style : 'currency',
			currency : 'KRW'
		}).format(won);
	}
</script>
<!-- 상품리스트출력 -->
<section class="py-5">
   <div class="container px-4 px-lg-5 mt-5">
      <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
         <c:forEach items="${shopList}" var="item">
            <div class="col mb-5">
               <div class="card h-100">
                  <div class='badge bg-dark text-white position-absolute' style="top: 0.5rem; right: 0.5rem">sale</div>
                  <!-- Product image-->
                  <a href="shopItemDetail.do?id=${item.itemId }"><img class="card-img-top" src="upload/${item.image}" alt="..."></a>
                  <!-- Product details-->
                  <div class="card-body p-4">
                     <div class="text-center">
                        <!-- Product name-->
                        <h5 class="fw-bolder">${item.itemName}</h5>
                        <!-- Product reviews-->
                        <div class="d-flex justify-content-center small text-warning mb-2">
                           <c:forEach begin="1" end="${Math.floor(item.likeIt)}" step="1">
                              <div class="bi-star-fill"></div>
                           </c:forEach>
                           <c:if test="${item.likeIt% Math.floor(item.likeIt) >=0.5}">
                              <div class="bi-star-half"></div>
                           </c:if>
                        </div>
                        <!-- Product price-->
                        <span class="text-muted text-decoration-line-through">
                                    <fmt:formatNumber value="${item.originPrice}" type="currency"  currencySymbol="￦" />
                                    </span>
                                   <fmt:formatNumber value="${item.salePrice}" type="currency"  currencySymbol="￦" />
                                </div>
                            </div>
                  <!-- Product actions-->
                  <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                     <div class="text-center">
                        <a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
                     </div>
                  </div>
               </div>
            </div>
         </c:forEach>
      </div>
   </div>
</section>



<a href="shopItemAdd.do">상품등록</a>
