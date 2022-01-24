<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/styles_item.css" rel="stylesheet">
<script>
	$(document).ready(function() {
		// 전체 데이터 출력 -> json -> object 타입으로 변경.	
		$.ajax({
			url: 'itemListJson.do',
			type: 'get',
			dataType: 'json',
			success: function(result) {
				console.log(result);
				result.forEach(function(item) {
					let div = makeDiv(item);
					$('#shopList').append(div);
				});
			},
			error: function(err) {
				console.log(err);
			}
		});
	});
</script>

<div id='show'>
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				id="shopList" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<!-- 상품리스트 출력. -->
					<div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Fancy Product</h5>
                                    <!-- Product price-->
                                    $40.00 - $80.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$20.00</span>
                                    $18.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <script>
                    function makeDiv(item) {
                    	var outerDiv = $('<div>').addClass("col mb-5");
                    	var midDiv = $('<div>').addClass("card h-100");
                  		var h5 = $('<h5>').text(item.itemName);
                  		midDiv.append(h5);
                  		
                    	outerDiv.append(midDiv);
                    	return outerDiv;
                    }
                    </script>
			</div>
		</div>
	</section>
</div>
