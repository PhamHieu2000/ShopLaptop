package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.WishlistDao;
import model.User;
@WebServlet(urlPatterns = {"/adduser"})

public class AddUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String fullname=req.getParameter("register-fullname");
		String username=req.getParameter("register-username");
		String password=req.getParameter("register-password");
		String email=req.getParameter("register-email");
		String numberphone=req.getParameter("register-numberphone");
		String address=req.getParameter("register-address");
		int role=2;
		int status=1;
		User user=new User();
		user.setFullname(fullname);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhonenumber(numberphone);
		user.setAddress(address);
		user.setRole_id(role);
		user.setStatus(status);
		UserDao userDao=new UserDao();
		userDao.addUser(user);
		req.getRequestDispatcher("/views/client/index.jsp").forward(req, resp);

	}
}
