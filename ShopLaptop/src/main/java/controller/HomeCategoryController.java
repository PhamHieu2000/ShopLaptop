package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

@WebServlet(urlPatterns = {"/home"})
public class HomeCategoryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		CategoryDao categoryDao=new CategoryDao();
		ProductDao productDao=new ProductDao();
		List<Category> listCategory=new ArrayList<>();
		List<Product> listProduct =new ArrayList<>();
		List<Product> productBestseller =new ArrayList<>();
		List<Product> productNew =new ArrayList<>();
		List<Product> productBSCategory1 =new ArrayList<>();
		List<Product> productBSCategory2 =new ArrayList<>();
		List<Product> productBSCategory3 =new ArrayList<>();
		listProduct=productDao.getAllProduct();
		
		
		//Lọc sản phẩm mới nhất(7 ngày)
        LocalDate checkDate = LocalDate.now().minusDays(7);

		for(Product product: listProduct) {
			LocalDate date=product.getCreate_at();

            if (date.isAfter(checkDate) || date.isEqual(checkDate)) {
            	productNew.add(product);
            }
		}
		System.out.println(productNew);
		req.setAttribute("productnew", productNew);
		//Lọc từng sp bestseller
		productBSCategory1=productDao.getProductBestSeller(1);
		productBSCategory2=productDao.getProductBestSeller(2);
		productBSCategory3=productDao.getProductBestSeller(3);
		req.setAttribute("productBSCategory1", productBSCategory1);
		req.setAttribute("productBSCategory2", productBSCategory2);
		req.setAttribute("productBSCategory3", productBSCategory3);

////
		listCategory=categoryDao.getAllCategory();
		System.out.println("best seller");
		productBestseller=productDao.getProductBestSeller(0);
		req.setAttribute("bestSeller", productBestseller);

		req.setAttribute("listProduct", listProduct);
		HttpSession session = req.getSession();
		session.setAttribute("listCategory", listCategory);
		req.getRequestDispatcher("/views/client/index.jsp").forward(req, resp);
	}
}
