package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDetailDao;
import dto.OrderDetailDto;
@WebServlet(urlPatterns = {"/getallorder"})

public class GetAllOrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<OrderDetailDto> orderDetailDtos=new ArrayList<>();
		OrderDetailDao orderDetailDao=new OrderDetailDao();
		orderDetailDtos=orderDetailDao.getOrderDetailByUser(0);
		req.setAttribute("listOrder", orderDetailDtos);
		req.getRequestDispatcher("/views/admin/listorder.jsp").forward(req, resp);

	}
}
