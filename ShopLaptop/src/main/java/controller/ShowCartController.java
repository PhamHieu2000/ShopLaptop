package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
@WebServlet(urlPatterns = {"/showcart"})

public class ShowCartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		HttpSession httpSession = req.getSession();
		List<Cart> listCart = (List<Cart>) httpSession.getAttribute("listCart");
		req.setAttribute("listCart", listCart);
		req.getRequestDispatcher("/views/client/viewcart.jsp").forward(req, resp);

	}
}
