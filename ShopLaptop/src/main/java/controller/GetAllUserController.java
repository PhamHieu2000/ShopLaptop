package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet(urlPatterns = {"/getalluser"})

public class GetAllUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<User> listUser= new ArrayList<>();
		UserDao userDao =new UserDao();
		listUser=userDao.getAllUser();
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/views/admin/listuser.jsp").forward(req, resp);

	}
}
