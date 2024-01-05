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
	<body>
				<jsp:include page="fragment/nevbar.jsp"></jsp:include>
				<div class="container">
				<table class="table">
				  <thead>
				    <tr>
				    <th scope="col">Mã đơn hàng</th>
				      <th scope="col">Tên khách hàng</th>
				      <th scope="col">Số điện thoại</th>
				      <th scope="col">Email</th>
				      <th scope="col">Địa chỉ</th>
				      <th scope="col">Sản phẩm</th>
				      <th scope="col">Tổng tiền</th>
				      <th scope="col">Ngày đặt hàng</th>
				      <th scope="col">Tình trạng</th>
				      <th scope="col">Thao tác</th>
				      
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var ="data" items="${listOrder}">
				  
				  <tr>
				      
				    <tr>
				      <td> ${data.id}</td>
				      <td> ${data.fullname}</td>
				      <td> ${data.numberphone}</td>
				      <td> ${data.email}</td>
				      <td> ${data.address}</td>
				      <td><a href="${pageContext.request.contextPath}/product?id=${data.product_id}" style="cursor: pointer;">${data.name_product}</a></td>
				      <td>${data.total}</td>
				      <td>${data.orderDate}</td>
				      	<td>
				      	<select  class="form-select statusSelect" >
				      	<c:if test="${data.status_order==1}">
				      	  <option selected value="1">Đang xử lý</option>
						  <option value="2">Hoàn thành</option>
						  <option value="3">Hủy đơn</option>
						  </c:if>
						<c:if test="${data.status_order==2}">
				      	  <option  value="1">Đang xử lý</option>
						  <option selected value="2">Hoàn thành</option>
						  <option value="3">Hủy đơn</option>
						  </c:if>
						<c:if test="${data.status_order==3}">
				      	  <option  value="1">Đang xử lý</option>
						  <option value="2">Hoàn thành</option>
						  <option selected value="3">Hủy đơn</option>
						  </c:if>
						
						</select>
						</td>
				      <td><button type="button" onclick="editOrder(this,${data.order_id})"  class="btn btn-success">Lưu</button>
				     
				      
				      
				    </tr>
				    </tr>
				   
				  </c:forEach>
				    
				  </tbody>
			</table>
				</div>
				<jsp:include page="fragment/footer.jsp"></jsp:include>
				

</body>
</html>
<script>
	function editOrder(button,order_id) {
		 var isConfirmed = confirm("Sửa trạng thái?");
         var contextPath="<c:out value='${pageContext.request.contextPath}' />";
         var selectElement = button.parentNode.previousElementSibling.querySelector(".statusSelect");

       if (isConfirmed) {
       	  // Chuyển hướng đến URL
       	window.location.href = contextPath + "/editorder?id="+order_id+"&status="+ selectElement.value;
       }
       //window.location.href =contextPath+"/filterbyprice?key="+value;
	}
</script>