package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dao.OrderDetailDao;
import model.Cart;
import model.Order;
import model.OrderDetail;
@WebServlet(urlPatterns = {"/addorder"})

public class AddOrderControlller extends HttpServlet{
	int id=0;
	int orderDetail_id=0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
	
		OrderDetailDao orderDetailDao=new OrderDetailDao();
		OrderDao orderDao=new OrderDao();
		HttpSession session =req.getSession(); 
		List<Cart> listCart = (List<Cart>)session.getAttribute("listCart");		
		List<Order> orders=new ArrayList<>();
		List<OrderDetail> orderDetails=new ArrayList<>();
		orders=orderDao.getAll();
		System.out.println(orders);

		orderDetails=orderDetailDao.getAll();
		System.out.println(orderDetails);
		System.out.println("size :"+orders.size());

		if(orders.size()>0) {
			id=orders.get(orders.size() - 1).getId();
		}
		if(orderDetails.size()>0) {
			orderDetail_id=orderDetails.get(orderDetails.size() - 1).getId();
		}
		System.out.println("test id:"+id);
		id++;
		int order_id=id;
		int userId=Integer.parseInt(req.getParameter("userId")); 
		String fullname=req.getParameter("name-user");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String note=req.getParameter("note");
		String phonenumber=req.getParameter("tel");
		Long total=Long.parseLong(req.getParameter("totalOrder")); 
		Order order=new Order();
		order.setId(order_id);
		order.setFullname(fullname);
		order.setEmail(email);
		order.setAddress(address);
		order.setPhonenumber(phonenumber);
		order.setNote(note);
		order.setStatus(1);
		order.setUser_id(userId);
		order.setTotal(total);
		LocalDate  create_at= LocalDate.now();
		order.setOrderdate(create_at);
		System.out.println(order.toString());
		
		orderDao.insert(order);
		
		//add orderdetail
		if(listCart != null){	
			for(Cart cart : listCart){
				orderDetail_id++;
				OrderDetail orderDetail=new OrderDetail();
				orderDetail.setId(orderDetail_id);
				orderDetail.setOrder_id(order_id);
				orderDetail.setPrice(cart.getDiscount());
				orderDetail.setQuantity(cart.getQuantityCart());
				orderDetail.setTotal(cart.getDiscount()*cart.getQuantityCart());
				orderDetail.setProduct_id(cart.getId());
				orderDetail.setStatus(1);
				orderDetailDao.insert(orderDetail);
				System.out.println(cart);
			
		}
		req.getRequestDispatcher("/views/client/thanhtoan.jsp").forward(req, resp);

	}
		}
}
