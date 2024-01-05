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
					<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Giá:</h3>
							<div class="checkbox-filter">

								<div class="input-checkbox">
									<input type="radio" name="price" value="5000000-7000000" onchange="filterbyprice(this)" id="category-1">
									<label for="category-1">
										<span></span>
										5,000.000-7,000.000
									</label>
								</div>

								<div class="input-checkbox">
									<input type="radio" name="price" value="7000000-10000000" onchange="filterbyprice(this)" id="category-2">
									<label for="category-2">
										<span></span>
										7,000.000-10,000.000
									</label>
								</div>

								<div class="input-checkbox">
									<input type="radio" name="price" value="10000000-15000000" onchange="filterbyprice(this)" id="category-3">
									<label for="category-3">
										<span></span>
									10,000.000-15,000.000

									</label>
								</div>

								<div class="input-checkbox">
									<input type="radio" name="price" value="15000000-20000000" onchange="filterbyprice(this)" id="category-4">
									<label for="category-4">
										<span></span>
										15,000.000-20,000.000

									</label>
								</div>

								<div class="input-checkbox">
									<input type="radio" name="price" value="20000000-25000000" onchange="filterbyprice(this)" id="category-5">
									<label for="category-5">
										<span></span>
									20,000.000-25,000.000
									</label>
								</div>

									<div class="input-checkbox">
									<input type="radio" checked name="price" value="all" onchange="filterbyprice(this)" id="category-5">
									<label for="category-5">
										<span></span>
									Tất cả
									</label>
								</div>
							</div>
						</div>
						<!-- /aside Widget -->

					</div>
					<!-- /ASIDE -->

					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store top filter -->
						<div class="store-filter clearfix" style="text-align:end">
							<c:if test="${user.id != null && user.id != '' && user.role_id == 1}">
							<i  style="font-size:16px;color: #2c6bd8;cursor:pointer"  class="fa-solid fa-circle-plus"></i>
							<a href="${pageContext.request.contextPath}/addproduct" style="font-size:16px;">Thêm Mặt Hàng</a>
							</c:if>
							
													</div>
						<!-- /store top filter -->

						<!-- store products -->
					
							<!-- product -->
							<c:forEach var="product" items="${listProduct}">
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
							
							
						</div>
						<!-- /store products -->

					</div>
					<!-- /STORE -->
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

	</body>
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
		  function filterbyprice(element) {
	          var value =element.value;
	          var contextPath="<c:out value='${pageContext.request.contextPath}' />";
	          
	          // Chuyển hướng đến URL
	            window.location.href =contextPath+"/filterbyprice?key="+value;
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
</html>
