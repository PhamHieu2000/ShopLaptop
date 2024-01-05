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

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;
@WebServlet(urlPatterns = {"/list_product"})

public class ListProductController  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		List<Product> listProduct=new ArrayList<>();
		ProductDao productDao=new ProductDao();
		int category_id=Integer.parseInt(req.getParameter("id"));
		listProduct=productDao.getProductByCategoryId(category_id);
		req.setAttribute("listProduct", listProduct);
		req.getRequestDispatcher("/views/client/listproduct.jsp").forward(req, resp);
	}
}
