package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Product;

@WebServlet(urlPatterns = {"/deleteById"})

public class DeleteProducByIdController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// TODO Auto-generated method stub
		 System.out.println(req.getParameter("id"));
		 System.out.println(req.getParameter("category_id"));
		 int id =Integer.parseInt(req.getParameter("id")); 
		 int category_id =Integer.parseInt(req.getParameter("category_id")); 
		

		 ProductDao productDao=new ProductDao();
		 productDao.delete(id);
		 
			resp.sendRedirect(req.getContextPath() + "/list_product?id=" + category_id);

	 }
}
