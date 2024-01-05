package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WishlistDao;
@WebServlet(urlPatterns = {"/deletewishlist"})

public class DeleteWishlistController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int id=Integer.parseInt(req.getParameter("id")); 
		WishlistDao wishlistDao=new WishlistDao();
		wishlistDao.delete(id);
		resp.sendRedirect(req.getContextPath() + "/wishlist");

	}
}
