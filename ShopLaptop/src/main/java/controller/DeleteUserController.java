package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
@WebServlet(urlPatterns = {"/deleteuser"})

public class DeleteUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int id=Integer.parseInt(req.getParameter("id"));
		UserDao userDao=new UserDao();
		User user=userDao.getUserById(id);
		user.setStatus(2);
		userDao.updateUser(user);
		resp.sendRedirect(req.getContextPath() + "/getalluser");

	}
}
