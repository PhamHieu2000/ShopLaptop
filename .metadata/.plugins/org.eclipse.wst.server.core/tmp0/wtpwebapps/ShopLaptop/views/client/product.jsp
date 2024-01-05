<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/views/client" var="url"></c:url>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro - HTML Ecommerce Template</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="${url}/css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="${url}/css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="${url}/css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="${url}/css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
 		<link rel="stylesheet" href="${url}/css/font-awesome.min.css">

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="${url}/css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

    </head>
      <%
	User user = (User)session.getAttribute("user");
	request.setAttribute("user", user);
	
%>
	<body>
					<jsp:include page="fragment/nevbar.jsp"></jsp:include>
	
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- Product main img -->
					<div class="col-md-6 ">
						<div id="product-main-img">
							<div class="product-preview">
								<img src="image/${product.thumbnail}"  alt="">
							</div>

							<div class="product-preview">
								<img src="" alt="">
							</div>

							<div class="product-preview">
								<img src="" alt="">
							</div>

							<div class="product-preview">
								<img src="" alt="">
							</div>
						</div>
					</div>
					<!-- /Product main img -->

					
					<!-- Product details -->
					<div class="col-md-6">
						<div class="product-details">
							<h2 class="product-name">${product.name }</h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
							</div>
							<div>
								<h3 class="product-price">${product.discount }<del class="product-old-price">${product.price }</del></h3>
								<span class="product-available">
								<c:choose>
									  <c:when test="${product.quantity >0}">
									<c:out value = "Còn Hàng"/>
									  </c:when>
									 
									  <c:otherwise>
									 <c:out value = "Hết hàng"/>
									  </c:otherwise>
									</c:choose>
								  
								</span>
							</div>

							

							<div class="add-to-cart">
								<div class="qty-label">
									Số Lượng
									<div class="input-number">
										<input type="number">
										<span class="qty-up">+</span>
										<span class="qty-down">-</span>
									</div>
								</div>
								<button onclick="addCart(${product.id})"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ</button>
							</div>

							<ul class="product-btns">
								<li onclick="addWishlist(${product.id})" ><a href="#"><i class="fa fa-heart-o"></i> Yêu Thích</a></li>
							</ul>

							<ul class="product-links">
								<li>Share:</li>
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#"><i class="fa fa-envelope"></i></a></li>
							</ul>

						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Giới Thiệu</a></li>
								<li><a data-toggle="tab" href="#tab2">Chi Tiết</a></li>
								<li><a data-toggle="tab" href="#tab3">Đánh Giá</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">
											<p>${product.description}</p>
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<div class="col-md-12">
											<p>${product.short_description}</p>
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								<!-- tab3  -->
								<div id="tab3" class="tab-pane fade in">
									<div class="row">
										
										<!-- Reviews -->
										<div class="col-md-9">
											<div id="reviews">
												<ul class="reviews">
												<c:forEach var="feedback" items="${feedbacks}">
												<li>
														<div class="review-heading">
															<h5 class="name">${feedback.name}</h5>
															<p class="date">${feedback.created_at}</p>
															<c:if test="${feedback.rating==5}"><div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
															</div></c:if>
															<c:if test="${feedback.rating==4}"><div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star "></i>
																<i class="fa fa-star-o empty"></i>
															</div></c:if>
															<c:if test="${feedback.rating==3}"><div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
															</div></c:if>
															<c:if test="${feedback.rating==2}"><div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
															</div></c:if>
															<c:if test="${feedback.rating==1}"><div class="review-rating">
																<i class="fa fa-star"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
																<i class="fa fa-star-o empty"></i>
															</div></c:if>
														</div>
														<div class="review-body">
															<p>${feedback.message}</p>
														</div>
													</li></c:forEach>
													
												</ul>
												<ul class="reviews-pagination">
													<li class="active">1</li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#">4</a></li>
													<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												</ul>
											</div>
										</div>
										<!-- /Reviews -->

										<!-- Review Form -->
										<div class="col-md-3">
											<div id="review-form">
												<form class="review-form" id="review-form" method="post" action="${pageContext.request.contextPath}/addreview" >
													<div hidden><input class="input" id="produc_id" name="product_id" value="${product.id }" type="text" placeholder="Tên">
													</div>
											
													<input class="input" id="name_review" name="name" type="text" placeholder="Tên">
													<input class="input" id="email_review" name="email" type="email" placeholder=" Email">
													<textarea class="input" id="review" name="review" placeholder="Đánh giá của bạn"></textarea>
													<div class="input-rating">
														<span>Your Rating: </span>
														<div class="stars">
															<input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
															<input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
															<input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
															<input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
															<input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
														</div>
													</div>
													<button class="primary-btn">Submit</button>
												</form>
											</div>
										</div>
										<!-- /Review Form -->
									</div>
								</div>
								<!-- /tab3  -->
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		
		<!-- /Section -->

			<jsp:include page="fragment/footer.jsp"></jsp:include>

		<!-- jQuery Plugins -->
		<script src="${url}/js/jquery.min.js"></script>
		<script src="${url}/js/bootstrap.min.js"></script>
		<script src="${url}/js/slick.min.js"></script>
		<script src="${url}/js/nouislider.min.js"></script>
		<script src="${url}/js/jquery.zoom.min.js"></script>
		<script src="${url}/js/main.js"></script>
		<script >
		 function addWishlist(id) {
			  // Hiển thị cảnh báo
		        var isConfirmed = confirm("Thêm sản phẩm vào danh sách yêu thích?");
		          var contextPath="<c:out value='${pageContext.request.contextPath}' />";
				var user_id ="<c:out value='${user.id}' />"
				console.log(user_id)
		        // Nếu người dùng nhấn OK (đồng ý), thực hiện xóa
		        if (isConfirmed) {
		        	  // Chuyển hướng đến URL
		        	window.location.href = contextPath + "/add_wishlist?id="+id+"&user_id="+user_id;
		        }
	            //window.location.href =contextPath+"/filterbyprice?key="+value;
	        }
		  function deleteById(id,category_id) {
			  // Hiển thị cảnh báo
		        var isConfirmed = confirm("Xóa sản phẩm?");
		          var contextPath="<c:out value='${pageContext.request.contextPath}' />";

		        // Nếu người dùng nhấn OK (đồng ý), thực hiện xóa
		        if (isConfirmed) {
		        	  // Chuyển hướng đến URL
		        	window.location.href = contextPath + "/deleteById?category_id=" + category_id + "&id=" + id;
		        }
	            //window.location.href =contextPath+"/filterbyprice?key="+value;
	        }
		  function addCart(product) {
			  // Hiển thị cảnh báo
		        var isConfirmed = confirm("Thêm sản phẩm vào giỏ hàng?");
		          var contextPath="<c:out value='${pageContext.request.contextPath}' />";
				var user_id ="<c:out value='${user.id}' />"
				var currentUrl = window.location.href;

					
				console.log(user_id)
		        // Nếu người dùng nhấn OK (đồng ý), thực hiện xóa
		        if (isConfirmed) {
		        	  // Chuyển hướng đến URL
		        	window.location.href = contextPath + "/add_cart?product_id="+product+"&user_id="+user_id;
		        }
	            //window.location.href =contextPath+"/filterbyprice?key="+value;
	        }
		  document.getElementById("review-form").addEventListener("submit", function(event) {
				var name =document.getElementById("name_review").value;
				var email =document.getElementById("email_review").value;
				var review =document.getElementById("review").value;
			
				if(name.trim()===""){
					 event.preventDefault(); 
					 alert("Hãy điền tên" )
			 	    return;
				}
				if(email.trim()===""){
					 event.preventDefault(); 
					 alert("Hãy điền email" )
			 	    return;
				}
				if(review.trim()===""){
					 event.preventDefault(); 
					 alert("Hãy điền đánh giá" )
			 	    return;
				}
				alert("Thêm đánh giá thành công")
				}
			);
		  </script>
	</body>
</html>
