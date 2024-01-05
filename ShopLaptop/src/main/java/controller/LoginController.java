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
import model.User;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session = req.getSession();
		UserDao userDao=new UserDao();
		List<User> listUser=userDao.getAllUser();
		for(User user: listUser) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				session.setAttribute("user", user);
		        session.setMaxInactiveInterval(1800);
				resp.sendRedirect(req.getContextPath() + "/home");
				
			}
		}
		

	}
}
