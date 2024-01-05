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
@WebServlet(urlPatterns = {"/filterbyname"})

public class FilterProductByName extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String key=req.getParameter("key");
		ProductDao productDao=new ProductDao();
		List<Product> products=new ArrayList<>();
		products=productDao.getProductByName(key);
		req.setAttribute("listProduct", products);
		req.getRequestDispatcher("/views/client/listproduct.jsp").forward(req, resp);

	}
}
