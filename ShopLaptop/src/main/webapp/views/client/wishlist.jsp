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
				<div class="container">
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col"></th>
				      <th scope="col">Tên Sản Phẩm</th>
				      <th scope="col">Giá</th>
				      <th scope="col">Thao Tác</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var ="data" items="${Wishlist}">
				  
				  <tr>
				      
				      <td><img style="width: 90px;height: 100px;" src="image/${data.thumbnail}" ></td>
				      <td><a href="${pageContext.request.contextPath}/product?id=${data.product_id}" style="cursor: pointer;">${data.name_product}</a></td>
				      <td><p ><s>${data.price}</s></p><p>${data.discount}</p></td>
				       <td class="text-center"><i onclick="deleteWishlist(${data.wishlist_id})" class="fa-solid fa-x" style="color:red;cursor: pointer;"></i></td>
				    </tr>
				   
				  </c:forEach>
				    
				  </tbody>
			</table>
				</div>
				<jsp:include page="fragment/footer.jsp"></jsp:include>
				

</body>
</html>
<script>
	function deleteWishlist(id) {
        var isConfirmed = confirm("Xóa sản phẩm khỏi danh sách yêu thích?");
          var contextPath="<c:out value='${pageContext.request.contextPath}' />";

        // Nếu người dùng nhấn OK (đồng ý), thực hiện xóa
        if (isConfirmed) {
        	  // Chuyển hướng đến URL
        	window.location.href = contextPath + "/deletewishlist?id="+id;
        }
        //window.location.href =contextPath+"/filterbyprice?key="+value;
	}
</script>