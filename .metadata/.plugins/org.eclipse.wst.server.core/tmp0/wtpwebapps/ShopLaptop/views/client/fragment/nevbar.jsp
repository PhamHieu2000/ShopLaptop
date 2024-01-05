<%@page import="java.io.Console"%>
<%@page import="java.util.List"%>
<%@page import="model.Cart"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:url value="/views/client" var="url"></c:url>
<%
	User user = (User)session.getAttribute("user");
	request.setAttribute("user", user);
	List<Cart> listCart = (List<Cart>)session.getAttribute("listCart");
	request.setAttribute("listCart", listCart);
	long total=0;
	if(listCart != null){	for(Cart cart : listCart){
		total=total+(cart.getDiscount()*cart.getQuantityCart());
	}
}
	request.setAttribute("total", total);

%>
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
 <style>
             /* Thêm CSS để tùy chỉnh menu và modal */
        #accountMenu {
            position: relative;
            display: inline-block;
        }

        #accountModal {
            display: none;
            position: absolute;
            top: 100%;
            left: 80%;
            transform: translateX(-50%);
            padding: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            z-index: 1000;
            width:140px;
        }

        /* Hiển thị modal khi hover vào menu */
        #accountMenu:hover #accountModal {
            display: block;
        }
       #accountModal p:hover {
            color: #D10024; /* Thay đổi màu chữ thành màu đỏ khi hover */
        }
         #accountModal p {
         cursor: pointer;
         }
    </style>
    </head>
	<body>
	
		<!-- HEADER -->
		<header>
			<!-- TOP HEADER -->
			<div id="top-header">
				<div class="container">
					<ul class="header-links pull-left">
						<li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
						<li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
						<li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
					</ul>
					<ul class="header-links pull-right">		
					<c:if test="${user == null}">
						<li><a href="#" onclick="showLoginModal()"><i class="fa-solid fa-right-to-bracket"></i> Đăng nhập</a></li>
 						 <li><a href="#" onclick="showRegisterModal()"><i class="fa fa-user-plus"></i> Đăng ký</a></li>
					</c:if>			
  					<c:if test="${user != null}">
					<div id="accountMenu" class="header-links pull-right">
					<li><a href="#" ><i class="fa fa-user-o"></i> <c:out value='${user.username}' /></a></li>
					
				    <div id="accountModal">
				        <p onclick="showÌnorUserModal()">Tài khoản của tôi</p>
				        <p  ><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></p>
				    </div>
				</div>					
				</c:if>
			
					</ul>
				</div>
			

				
				<div id="overlay"></div>			
				
			</div>
			<!-- /TOP HEADER -->

			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-2">
							<div class="header-logo">
								<a href="#" class="logo">
									<img src="views/client/img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form>
								
									<input id="input-search" class="input col-md-10" style="width: 70%" placeholder="Tìm Kiếm ...">
									<label onclick="filterByName()" style="display: flex;justify-content: center;align-items: center;" class="search-btn col-md-2"><i style="cursor:pointer;" class="fa-solid fa-magnifying-glass"></i></label>
								</form>
							</div>
						</div>
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-4 clearfix">
							<div class="header-ctn">
								<div onclick="getOrder()" >
									<a >
										<i class="fa-solid fa-bag-shopping"></i>
										<span>Đơn hàng</span>
									</a>
								</div>
								<!-- Wishlist -->
								<div>
									<a href="${pageContext.request.contextPath}/wishlist">
										<i class="fa fa-heart-o"></i>
										<span>Yêu Thích</span>
									</a>
								</div>
								<!-- /Wishlist -->

								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Giỏ Hàng</span>
									</a>
									<div class="cart-dropdown">
										<div class="cart-list">
										
							<c:forEach var="cart" items="${listCart}">
											<div class="product-widget">
												<div class="product-img">
													<img src="image/${cart.thumbnail}" alt="">
												</div>
												<div class="product-body">
												<h3 class="product-name"><a  href="${pageContext.request.contextPath}/product?id=${product.id}">${cart.name}</a></h3>
												<h4 class="product-price"><span class="qty">${cart.quantityCart}x</span>${cart.discount}</h4>
												</div>
											</div>
							
							</c:forEach>
											
											
										</div>
										<div class="cart-summary">
										<c:set var="arrayLength" value="${fn:length(listCart)}" />
										
											<small>${arrayLength} sản phẩm </small>
											<h5>Tổng tiền: ${total}</h5>
										</div>
										<div class="cart-btns">
											<a href="${pageContext.request.contextPath}/showcart">Xem giỏ hàng</a>
											<a href="${pageContext.request.contextPath}/checkout">Thanh toán  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->

								<!-- Menu Toogle -->
								<div class="menu-toggle">
									<a href="#">
										<i class="fa fa-bars"></i>
										<span>Menu</span>
									</a>
								</div>
								<!-- /Menu Toogle -->
							</div>
						</div>
						<!-- /ACCOUNT -->
						<!-- LOGIN MODAL -->
						<div id="login-modal" class="modal fade" role="dialog">
						  <div class="modal-dialog">
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title" style="color:#D10024">Đăng nhập</h4>
						      </div>
						      <div class="modal-body" >
						        <!-- Thêm form đăng nhập ở đây -->
						        <!-- Ví dụ: -->
					       	 <form id="form-login" method="get" action="${pageContext.request.contextPath}/login" >
						          <label for="username">Tên đăng nhập:</label>
						          <input type="text" id="username" name="username">
						
						          <label for="password">Mật khẩu:</label>
						          <input type="password" id="password" name="password">
						
						          <button  type="submit" >Đăng nhập</button>
						        </form>
						      </div>
						    </div>
						  </div>
						</div>
						<!-- /ACCOUNT -->
						<!-- REGISTER MODAL -->
						<!-- REGISTER MODAL -->
					<div id="register-modal" class="modal fade" role="dialog">
					  <div class="modal-dialog">
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title" style="color:#D10024">Đăng ký</h4>
					      </div>
					      <div class="modal-body">
					        <!-- Thêm form đăng ký ở đây -->
					        <!-- Ví dụ: -->
					        <form id="form-addUser" method="post" action="${pageContext.request.contextPath}/adduser" >
					         <div class="form-group">
					            <label for="register-username">Họ và tên:</label>
					            <input type="text" id="register-fullname" name="register-fullname" class="form-control">
					          </div>
					
					          <div class="form-group">
					            <label for="register-username">Tên đăng nhập:</label>
					            <input type="text" id="register-username" name="register-username" class="form-control">
					          </div>
					          <div class="form-group">
					            <label for="register-password">Mật khẩu:</label>
					            <input type="password" id="register-password" name="register-password" class="form-control">
					          </div>
					 			  <div class="form-group">
					            <label for="register-email">Email:</label>
					            <input type="email" id="register-email" name="register-email" class="form-control">
					          </div>
					            <div class="form-group">
					            <label for="register-email">Số điện thoại:</label>
					            <input type="number" id="register-numberphone" name="register-numberphone" class="form-control">
					          </div>
					              <div class="form-group">
					            <label for="register-address">Địa chỉ:</label>
					            <input type="text" id="register-address" name="register-address" class="form-control">
					          </div>
					          <button type="submit" >Đăng ký</button>
					        </form>
					      </div>
					    </div>
					  </div>
					</div>	
					<div id="infor-modal" class="modal fade" role="dialog">
					  <div class="modal-dialog">
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title" style="color:#D10024">Thông tin tài khoản</h4>
					      </div>
					      <div class="modal-body">
					        <!-- Thêm form đăng ký ở đây -->
					        <!-- Ví dụ: -->
					        <form id="form-addUser" method="post" action="${pageContext.request.contextPath}/editinfor" >
					            <div hidden class="form-group">
					           	<input hidden type="text" id="id"  name="id" value="${user.id }" class="form-control">

					          </div>
					           <div hidden class="form-group">
					         	<input hidden type="text" id="role"  name="role" value="${user.role_id }" class="form-control">

					          </div>
					         <div class="form-group">
					            <label for="register-username">Họ và tên:</label>
					            <input type="text" id="fullname"  name="fullname" value="${user.fullname }" class="form-control">
					         	<p id="erro-fullname" style="color:red"></p>
					         
					          </div>
					
					          <div class="form-group">
					            <label for="register-username">Tên đăng nhập:</label>
					            <input type="text" id="username"  value="${user.username }" name="username" class="form-control">
					          	<p id="erro-username" style="color:red"></p>
					          
					          </div>
					          <div class="form-group">
					            <label for="register-password">Mật khẩu:</label>
					            <input type="password" id="password"  value="${user.password }" name="password" class="form-control">
					          	<p id="erro-password" style="color:red"></p>
					          
					          </div>
					 			  <div class="form-group">
					            <label for="register-email">Email:</label>
					            <input type="email" id="email" value="${user.email }" name="email" class="form-control">
					          	<p id="erro-email" style="color:red"></p>
					          
					          </div>
					            <div class="form-group">
					            <label for="register-email">Số điện thoại:</label>
					            <input type="number" id="numberphone" value="${user.phonenumber }" name="numberphone" class="form-control">
					          	<p id="erro-numberphone" style="color:red"></p>
					          
					          </div>
					              <div class="form-group">
					            <label for="register-address">Địa chỉ:</label>
					            <input type="text" id="address" value="${user.address }" name="address" class="form-control">
					          	<p id="erro-address" style="color:red"></p>
					          
					          </div>
					          <div>
					          <button  class="btn btn-success"  type="submit" >Lưu</button>
					          </div>
					        </form>
					      </div>
					    </div>
					  </div>
					</div>	
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
		</header>
		<!-- /HEADER -->

		<!-- NAVIGATION -->
		<nav class="form-group" id="navigation">
			<!-- container -->
			<div class="container">
				<!-- responsive-nav -->
				<div id="responsive-nav">
					<!-- NAV -->
					<ul class="main-nav nav navbar-nav">
						<li ><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
							<c:forEach var="loai" items="${sessionScope.listCategory}">
								<li ><a  href="${pageContext.request.contextPath}/list_product?id=${loai.id}">${loai.name}</a></li>
							</c:forEach>
							<c:if test="${user.id != null && user.id != '' && user.role_id == 1}">
								<li ><a href="${pageContext.request.contextPath}/getallorder">Danh sách đơn hàng</a></li>
						<li ><a href="${pageContext.request.contextPath}/getalluser">Danh sách tài khoản</a></li>							</c:if>						
						
					</ul>
					<!-- /NAV -->
				</div>
				<!-- /responsive-nav -->
			</div>
			<!-- /container -->
		</nav>
		<!-- /NAVIGATION -->
		<script>
		
		  function showLoginModal() {
		    $('#login-modal').modal('show');
		  }
		 function showRegisterModal() {
			    $('#register-modal').modal('show');
			  }

		 function filterByName() {
			    var keyname = document.getElementById("input-search").value;
			    if(keyname.trim()==""){return;}
		          var contextPath="<c:out value='${pageContext.request.contextPath}' />";
		        	window.location.href = contextPath + "/filterbyname?key="+keyname;

				
		}
		 function showÌnorUserModal() {
			    $('#infor-modal').modal('show');

		}

		</script>

		
		<!-- jQuery Plugins -->
		<script src="${url}/js/jquery.min.js"></script>
		<script src="${url}/js/bootstrap.min.js"></script>
		<script src="${url}/js/slick.min.js"></script>
		<script src="${url}/js/nouislider.min.js"></script>
		<script src="${url}/js/jquery.zoom.min.js"></script>
		<script src="${url}/js/main.js"></script>
	
		
<script>

</script>
	</body>
	<script>
		document.getElementById("form-addUser").addEventListener("submit", function(event) {
			var fullname =document.getElementById("fullname").value;
			var username =document.getElementById("username").value;
			var email =document.getElementById("email").value;
			var password =document.getElementById("password").value;
			var address =document.getElementById("address").value;
			var numberphone =document.getElementById("numberphone").value;
			console.log(fullname);
			console.log(username);
			console.log(email);
			console.log(password);
			console.log(address);
			console.log(numberphone);

			if(fullname.trim()===""){
				 event.preventDefault(); 
				 alert("Hãy điền họ và tên.")
		 	    return;
			}
			if(username.trim()===""){
				 event.preventDefault(); 
				 alert("Hãy điền tên tài khoản.")
		 	    return;

				}
			if(!validateEmail(email)){
		  		 event.preventDefault(); 
				 alert("Email không hợp lệ.")
		 	    return;

		  		}
			if(!validatePassword(password)){
		 		 event.preventDefault(); 
				 alert("Mật khẩu không hợp lệ.")
		 	    return;

		 		}
			if(address.trim()===""){
				 event.preventDefault(); 
				 alert("Hãy điền địa chỉ.")
		 	    return;

				}
			if(numberphone.trim()===""){
				 event.preventDefault(); 
				 alert("Hãy điền số điện thoại.")
		 	    return;

				}
			alert("Lưu thông tin thành công")
			}
			
		);
		 
    // Hàm xem trước ảnh
    function validateEmail(email) {
        // Biểu thức chính quy kiểm tra định dạng email
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        
        // Kiểm tra xem địa chỉ email có phù hợp với biểu thức chính quy không
        return emailRegex.test(email);
    }
    function validatePassword(password) {
        // Độ dài tối thiểu là 8 ký tự
        const minLength = 8;

        // Ít nhất một chữ cái viết thường
        const hasLowercase = /[a-z]/.test(password);

        // Ít nhất một chữ cái viết hoa
        const hasUppercase = /[A-Z]/.test(password);

        // Ít nhất một số
        const hasNumber = /\d/.test(password);


        // Kiểm tra độ dài tối thiểu và sự xuất hiện của các yếu tố cần thiết
        return (
            password.length >= minLength &&
            hasLowercase &&
            hasUppercase &&
            hasNumber 
        );
    }
   
    function getOrder() {
    	var user_id ="<c:out value='${user.id}' />"
            var contextPath="<c:out value='${pageContext.request.contextPath}' />";

    		if(user_id==null || user_id==""){
    			alert("Hãy đăng nhập để xem đơn hàng của bạn.")
    		}else {
    	        window.location.href = contextPath + "/orderdetail";

    		}
    }
    function getWishlist() {
    	var user_id ="<c:out value='${user.id}' />"
            var contextPath="<c:out value='${pageContext.request.contextPath}' />";

    		if(user_id==null || user_id==""){
    			alert("Hãy đăng nhập để xem danh sách yêu thích của bạn.")
    		}else {
    	        window.location.href = contextPath + "/wishlist";

    		}
    }
</script>
</html>
