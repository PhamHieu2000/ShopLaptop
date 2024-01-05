package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
@WebServlet(urlPatterns = {"/edituser"})

public class EditUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		UserDao userDao=new UserDao();
		int id=Integer.parseInt(req.getParameter("id")) ;
		String fullname=req.getParameter("fullname");
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		int role=Integer.parseInt( req.getParameter("role"));
		User user= userDao.getUserById(id);
		user.setId(id);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setAddress(address);
		user.setPhonenumber(phonenumber);
		user.setRole_id(role);
		userDao.updateUser(user);
		resp.sendRedirect(req.getContextPath() + "/getalluser");


	}
}
