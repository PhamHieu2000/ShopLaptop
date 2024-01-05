package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import model.Order;
@WebServlet(urlPatterns = {"/editorder"})

public class EditOrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int id=Integer.parseInt(req.getParameter("id")); 
		int status=Integer.parseInt(req.getParameter("status")); 
		System.out.println(status);
		OrderDao orderDao=new OrderDao();
		Order order=new Order();
		order=orderDao.getById(id);
		order.setStatus(status);
		orderDao.update(order);
		resp.sendRedirect(req.getContextPath() + "/getallorder");

	}
}
