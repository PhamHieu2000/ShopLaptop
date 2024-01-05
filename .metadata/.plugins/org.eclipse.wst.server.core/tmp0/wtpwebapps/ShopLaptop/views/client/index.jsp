<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/views/admin" var="url"></c:url>

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
    <script src="https://kit.fontawesome.com/052f2cbb8d.js" crossorigin="anonymous"></script>

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
					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="https://product.hstatic.net/200000722513/product/km047w_fe34ae67ecf844f094a5e716f73d8f42_medium.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Laptop<br>Văn Phòng</h3>
								<a href="${pageContext.request.contextPath}/list_product?id=1" class="cta-btn">Xem ngay <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="https://product.hstatic.net/200000722513/product/lp520w_dfddfcf4a46d43e4b82391209328e195_medium.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Laptop<br>Gaming</h3>
								
								<a href="${pageContext.request.contextPath}/list_product?id=2" class="cta-btn">Xem ngay <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->

					<!-- shop -->
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="data:image/jpeg;base64,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" alt="">
							</div>
							<div class="shop-body">
								<h3>Laptop<br>Phụ Kiện</h3>
								<a href="${pageContext.request.contextPath}/list_product?id=3" class="cta-btn">Xem ngay <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					<!-- /shop -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Sản Phẩm Mới</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
								
								
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-1">
									<c:forEach var="product" items="${productnew}">
											<div class="product">
											<div class="product-img">
												<img style="width: 260px;height: 300px;" src="image/${product.thumbnail}" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<h3 class="product-name"><a href="${pageContext.request.contextPath}/product?id=${product.id}">${product.name }</a></h3>
												<h4 class="product-price">${ product.discount} <del class="product-old-price">${product.price}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button onclick="addCart(${product.id})"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> </button>
													<button class="add-to-wishlist"><i onclick="addWishlist(${product.id})" class="fa fa-heart-o"></i><span class="tooltipp">Yêu Thích</span></button>
														<c:if test="${user.id != null && user.id != '' && user.role_id == 1}">
														<button ><a style="cursor:pointer"   href="${pageContext.request.contextPath}/update_product?id=${product.id}" class="sale"><i class="fa-solid fa-pen-to-square" style="font-size:15px"></i></a><span class="tooltipp">Sửa sản phẩm</span></button>
													<button ><i style="font-size:15px" onclick="deleteById(${product.id},${product.category_id})" class="fa-solid fa-trash"></i><span class="tooltipp">Xóa sản phẩm</span></button></c:if>
													
												
												</div>
											</div>
										
										</div>
										<!-- /product -->
											</c:forEach>
							
									

									</div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Sản Phẩm Bán Chạy</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
								
									
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab2" class="tab-pane fade in active">
									<div class="products-slick" data-nav="#slick-nav-2">
										<!-- product -->
							<c:forEach var="product" items="${bestSeller}">
								<div class="col-md-4 col-xs-6">
											<div class="product">
											<div class="product-img">
												<img style="    width: 250px;height: 300px;" src="image/${product.thumbnail}" alt="">
												<div class="product-label">
													<span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<h3 class="product-name"><a  href="${pageContext.request.contextPath}/product?id=${product.id}">${product.name }</a></h3>
												<h4 class="product-price"> ${ product.discount} <del class="product-old-price">${product.price}</del></h4>
												<div class="product-rating">
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
													<i class="fa fa-star"></i>
												</div>
												<div class="product-btns">
													<button onclick="addCart(${product.id})"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> </button>
													<button class="add-to-wishlist"><i onclick="addWishlist(${product.id})" class="fa fa-heart-o"></i><span class="tooltipp">Yêu Thích</span></button>
													<c:if test="${user.id != null && user.id != '' && user.role_id == 1}">
													
													<button ><a style="cursor:pointer"   href="${pageContext.request.contextPath}/update_product?id=${product.id}" class="sale"><i class="fa-solid fa-pen-to-square" style="font-size:15px"></i></a><span class="tooltipp">Sửa sản phẩm</span></button>
													<button ><i style="font-size:15px" onclick="deleteById(${product.id},${product.category_id})" class="fa-solid fa-trash"></i><span class="tooltipp">Xóa sản phẩm</span></button>
													</c:if>
													
												
												</div>
											</div>
											
										</div>
										</div>
										<!-- /product -->
											</c:forEach>
										<!-- /product -->										
										
									</div>
									<div id="slick-nav-2" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Laptop Văn Phòng Bán Chạy</h4>
							<div class="section-nav">
								<div id="slick-nav-3" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-3">
							<div>
							<c:forEach var="product" items="${productBSCategory1}">
											
										<div class="product-widget">
									<div class="product-img">
										<img src="image/${product.thumbnail}" alt="">
									</div>
									<div class="product-body">
										<h3 class="product-name"><a style="font-size:10px" href="${pageContext.request.contextPath}/product?id=${product.id}">${product.name }</a></h3>
										<h4 class="product-price"> ${ product.discount} <del class="product-old-price">${product.price}</del></h4>
									</div>
								</div>
											</c:forEach>
							
							</div>

							
						</div>
					</div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Laptop Gaming Bán Chạy</h4>
							<div class="section-nav">
								<div id="slick-nav-4" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-4">
						
							<div>
								<c:forEach var="product" items="${productBSCategory2}">
											
										<div class="product-widget">
									<div class="product-img">
										<img src="image/${product.thumbnail}" alt="">
									</div>
									<div class="product-body">
										<h3 class="product-name"><a style="font-size:10px" href="${pageContext.request.contextPath}/product?id=${product.id}">${product.name }</a></h3>
										<h4 class="product-price"> ${ product.discount} <del class="product-old-price">${product.price}</del></h4>
									</div>
								</div>
											</c:forEach>
							</div>
						</div>
					</div>

					<div class="clearfix visible-sm visible-xs"></div>

					<div class="col-md-4 col-xs-6">
						<div class="section-title">
							<h4 class="title">Phụ Kiện Bán Chạy</h4>
							<div class="section-nav">
								<div id="slick-nav-5" class="products-slick-nav"></div>
							</div>
						</div>

						<div class="products-widget-slick" data-nav="#slick-nav-5">
							<div>
								<c:forEach var="product" items="${productBSCategory3}">
											
										<div class="product-widget">
									<div class="product-img">
										<img src="image/${product.thumbnail}" alt="">
									</div>
									<div class="product-body">
										<h3 class="product-name"><a style="font-size:10px" href="${pageContext.request.contextPath}/product?id=${product.id}">${product.name }</a></h3>
										<h4 class="product-price"> ${ product.discount} <del class="product-old-price">${product.price}</del></h4>
									</div>
								</div>
											</c:forEach>
							</div>
						</div>
					</div>

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
			<jsp:include page="fragment/footer.jsp"></jsp:include>

		
		
		<!-- jQuery Plugins -->
		<script src="${url}/js/jquery.min.js"></script>
		<script src="${url}/js/bootstrap.min.js"></script>
		<script src="${url}/js/slick.min.js"></script>
		<script src="${url}/js/nouislider.min.js"></script>
		<script src="${url}/js/jquery.zoom.min.js"></script>
		<script src="${url}/js/main.js"></script>
		<script>
		function formatCurrency(number) {
		    // Kiểm tra nếu không phải là số hoặc không hợp lệ
		    if (isNaN(number) || number === null) {
		        return "Không hợp lệ";
		    }

		    // Làm tròn đến hai chữ số phần thập phân
		    const roundedNumber = Math.round(number * 100) / 100;

		    // Định dạng chuỗi tiền tệ
		    const formattedNumber = new Intl.NumberFormat('vi-VN', {
		        style: 'currency',
		        currency: 'VND'
		    }).format(roundedNumber);

		    return formattedNumber;
		}
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
				console.log(user_id)
		        // Nếu người dùng nhấn OK (đồng ý), thực hiện xóa
		        if (isConfirmed) {
		        	  // Chuyển hướng đến URL
		        	window.location.href = contextPath + "/add_cart?product_id="+product+"&user_id="+user_id;
		        }
	            //window.location.href =contextPath+"/filterbyprice?key="+value;
	        }

		</script>
	</body>
</html>
