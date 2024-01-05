package controller;

import java.io.IOException;
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
import dto.OrderDetailDto;
import model.User;
@WebServlet(urlPatterns = {"/orderdetail"})

public class ShowOrderDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<OrderDetailDto> orderDetailDtos=new ArrayList<>();
		HttpSession httpSession=req.getSession();
		User user=(User) httpSession.getAttribute("user");
		OrderDetailDao orderDetailDao=new OrderDetailDao();
		orderDetailDtos=orderDetailDao.getOrderDetailByUser(user.getId());
		System.out.println(orderDetailDtos);
		req.setAttribute("orderdetail", orderDetailDtos);
		System.out.println(orderDetailDtos);
		req.getRequestDispatcher("/views/client/vieworder.jsp").forward(req, resp);

	}
}
