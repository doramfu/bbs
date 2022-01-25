<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />

<link href="css/style_item.css" rel="stylesheet">
<script>
	$(document).ready(function() {
		// 전체 데이터 출력 -> json -> object 타입으로 변경.	
		$.ajax({
			url : 'itemListJson.do',
			type : 'get',
			dataType : 'json',
			success : function(result) {
				console.log(result);
				result.forEach(function(item) {
					let div = makeDiv(item);
					$('#shopList').append(div);
				});
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
	
	function makeDiv(item) {
		var outerDiv = $('<div>').addClass("col mb-5");
		var midDiv = $('<div>').addClass("card h-100");
		var badgeDiv = $('<div>').addClass(
				"badge bg-dark text-white position-absolute").css({
			"top" : "0.5rem",
			"right" : "0.5rem"
		}).text("Sale");

		var img = $('<img>').addClass("card-img-top").attr('src',
				'upload/' + item.image);
		//상품상세정보
		var detailsDiv = $('<div>').addClass("card-body p-4");
		var centerDiv = $('<div>').addClass("text-center")

		var h5 = $('<h5>').addClass("fw-bolder")
				.text(item.itemName);
		var likeItDiv = $('<div>')
				.addClass(
						"d-flex justify-content-center small text-warning mb-2");
		var point = parseFloat(item.likeIt); //4.5
		var pointInt = Math.floor(point);//4.0
		var pointFlt = point - pointInt; // 0.5
		for (let i = 0; i < pointInt; i++) {
			likeItDiv.append($('<div>').addClass("bi-star-fill"));
		}
		if (pointFlt) {
			likeItDiv.append($('<div>').addClass("bi-star-half"));
		}
		var span = $('<span>').addClass(
				"text-muted text-decoration-line-through").text(
				currencyFormat(item.originPrice));

		centerDiv.text(' ' + currencyFormat(item.salePrice));
		centerDiv.prepend(h5, likeItDiv, span); //prepend 앞에 추가(append를하면 뒤에 추가)

		detailsDiv.append(centerDiv); //상품 상세 정보.

		//action 부분.
		var actionDiv = $('<div>').addClass(
				"card-footer p-4 pt-0 border-top-0 bg-transparent");
		var centerDiv2 = $('<div>').addClass("text-center");
		var a = $('<a>').addClass("btn btn-outline-dark mt-auto")
				.text("Add to Cart");
		
		a.on('click',addToCart);
		actionDiv.append(centerDiv2);
		centerDiv2.append(a);

		midDiv.append(badgeDiv, img, detailsDiv, actionDiv);

		outerDiv.append(midDiv);
		return outerDiv;
	}
	// 카트추가하는 콜백.
	function addToCart() {
		var span = $('form>button>span');
		var currentCnt = span.text();
		currenCnt = parseInt(currentCnt);
		span.text(++currentCnt);
	}
	function currencyFormat(won) {
		return new Intl.NumberFormat('ko-kr', {
			style : 'currency',
			currency : 'KRW'
		}).format(won);
	}
</script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form class="d-flex">
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</button>
			</form>
		</div>
	</div>
</nav>

<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div id="shopList"
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			
		</div>
	</div>
</section>
