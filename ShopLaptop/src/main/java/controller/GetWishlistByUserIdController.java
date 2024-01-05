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

import dao.UserDao;
import dao.WishlistDao;
import dto.WishlistProductDto;
import model.User;
import model.Wishlist;
@WebServlet(urlPatterns = {"/wishlist"})

public class GetWishlistByUserIdController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// Lấy đối tượng HttpSession từ HttpServletRequest
	    HttpSession httpSession = req.getSession();

	    // Lấy giá trị từ HttpSession bằng cách sử dụng phương thức getAttribute
	    User user =(User)httpSession.getAttribute("user");
	    List<WishlistProductDto> Wishlist=new ArrayList<>();
	    WishlistDao wishlistDao=new WishlistDao();
	    Wishlist=wishlistDao.getAllByUserId(user.getId());
	    System.out.println(user.getId());
	    System.out.println(Wishlist);
	    req.setAttribute("Wishlist", Wishlist);
		req.getRequestDispatcher("/views/client/wishlist.jsp").forward(req, resp);

	    }
}
