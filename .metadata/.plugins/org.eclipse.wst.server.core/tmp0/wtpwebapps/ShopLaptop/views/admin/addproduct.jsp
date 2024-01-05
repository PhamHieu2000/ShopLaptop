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
	<body>
				<jsp:include page="fragment/nevbar.jsp"></jsp:include>
		<div class="container">
		<div class="col-md-12">
						<!-- Billing Details -->
						<form id="form-addproduct" method="post" action="${pageContext.request.contextPath}/addproduct"  enctype="multipart/form-data">
						<div class="billing-details">
							
							<div class="form-group">
							<label>Loại Mặt Hàng:</label>
										<select name="loaihang-select" style="width:100%" class="input-select">
											<c:forEach var="loai" items="${sessionScope.listCategory}">
										<option value="${ loai.id}">${loai.name }</option>
											</c:forEach>
							
										</select>					
							</div>
							<div class="form-group">
							<label>Tên Mặt Hàng:</label>
								<input class="input" type="text" id="name-product" name="name-product" placeholder="Tên mặt hàng">
								<p id="erro-ten" style="color:red"></p>
								
							</div>
							<div  class="form-group">
							<label>Hình Ảnh Hiển Thị:</label>
								<!-- Thẻ input với type="file" để chọn ảnh -->
								  <input id="imageInput" multiple onchange="previewImage(this)" name="file" accept="image/*" type="file" name="file" accept="image/*">
								<div id="image-add">
								
								<!-- Hiển thị các ảnh đã chọn và nút xóa -->
								</div>							
								</div>
							<div class="form-group">
								<label>Giá tiền(VNĐ/Sản Phẩm):</label>
								<input class="input" id="price" type="number" name="price" placeholder="...">
								<p id="erro-gia" style="color:red"></p>
								
							</div>
								<div class="form-group">
								<label>Giảm giá(%/Sản Phẩm):</label>
								<input class="input" id="discount" type="number" name="discount" placeholder="...">
								<p id="erro-giamgia" style="color:red"></p>
								
							</div>
								<div class="form-group">
								<label>Số Lượng:</label>
								<input class="input" id="quantity" type="number" name="quantity" placeholder="...">
								<p id="erro-soluong" style="color:red"></p>
								
							</div>
							<div class="order-notes">
							<label>Mô tả mặt hàng:</label>
							<textarea id="product_description" name="product_description" class="input" placeholder="..."></textarea>
							<p id="erro-mota" style="color:red"></p>
							
						</div>
						<div class="form-group" style="text-align: end;">
                           <button type="submit"  class="btn btn-sm btn-success">Thêm Sản Phẩm</button>
						</div>
						</div>
						</form>
						<!-- /Billing Details -->

						<!-- /Shiping Details -->

						<!-- Order notes -->
					
						<!-- /Order notes -->
					</div>
		</div>
					<jsp:include page="fragment/footer.jsp"></jsp:include>
		
		<!-- jQuery Plugins -->
		<script src="${url}/js/jquery.min.js"></script>
		<script src="${url}/js/bootstrap.min.js"></script>
		<script src="${url}/js/slick.min.js"></script>
		<script src="${url}/js/nouislider.min.js"></script>
		<script src="${url}/js/jquery.zoom.min.js"></script>
		<script src="${url}/js/main.js"></script>

<script>
		document.getElementById("form-addproduct").addEventListener("submit", function(event) {
			var ten =document.getElementById("name-product").value;
			var gia =document.getElementById("price").value;
			var giamgia =document.getElementById("discount").value;
			var soluong =document.getElementById("quantity").value;
			var mota =document.getElementById("product_description").value;
			console.log(ten);
			console.log(gia);
			console.log(giamgia);
			console.log(soluong);
			console.log(mota);

			if(ten.trim()===""){
				 event.preventDefault(); 
		 	    document.getElementById("erro-ten").innerHTML ="Hãy điền tên mặt hàng.";
		 	    return;
			}
			if(parseInt(gia)<0|| gia ===""){
				 event.preventDefault(); 
			    document.getElementById("erro-gia").innerHTML ="Giá của mặt hàng phải lớn hơn 0.";
		 	    return;

				}
			if(parseInt(giamgia)<0||parseInt(giamgia)>100||giamgia===""){
		  		 event.preventDefault(); 
		   	    document.getElementById("erro-giamgia").innerHTML ="% Giảm giá phải lớn hơn 0 và nhỏ hơn 100%";
		 	    return;

		  		}
			if(parseInt(soluong)<0||soluong===""){
		 		 event.preventDefault(); 
		  	    document.getElementById("erro-soluong").innerHTML ="Số lượng mặt hàng phải lớn hơn 0";
		 	    return;

		 		}
			if(mota.trim()===""){
				 event.preventDefault(); 
		 	    document.getElementById("erro-mota").innerHTML ="Hãy viết mô tả mặt hàng";
		 	    return;

				}
			alert("Thêm mặt hàng thành công")
			}
		);
	
    // Hàm xem trước ảnh
    function previewImage(input) {
        var preview = document.getElementById('image-add');

        // Kiểm tra xem đã chọn tệp ảnh chưa
        for (var i = 0; i < input.files.length; i++) {
        if (input.files && input.files[0]) {
        	 var reader = new FileReader();

             reader.onload = function (e) {
                 // Tạo thẻ img để hiển thị ảnh xem trước
                 var imgElement = document.createElement('img');
                 imgElement.src = e.target.result;
                 imgElement.style.maxWidth = '100%';
                 imgElement.style.maxHeight = '200px'; // Có thể điều chỉnh chiều cao theo ý muốn

                 // Thêm thẻ img vào div xem trước
                 preview.appendChild(imgElement);
             };


            reader.readAsDataURL(input.files[0]);
        }
        }
    }
    
</script>

	</body>
</html>
