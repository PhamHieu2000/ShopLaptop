package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.Cart;
import model.Product;
@WebServlet(urlPatterns = {"/add_cart"})

public class AddToCartController extends HttpServlet{
	int quantity=1;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			HttpSession httpSession = req.getSession();
			List<Cart> listCart = (List<Cart>) httpSession.getAttribute("listCart");
		    System.out.println(listCart);

			int product_id=Integer.parseInt(req.getParameter("product_id"));
			ProductDao productDao=new ProductDao();
			Product product= productDao.getProductById(product_id);
			Cart cart=new Cart();
			cart.setId(product.getId());
			cart.setName(product.getName());
			cart.setShort_description(product.getShort_description());
			cart.setThumbnail(product.getThumbnail());
			cart.setPrice(product.getPrice());
			cart.setDiscount(product.getDiscount());
			cart.setDescription(product.getDescription());
			System.out.println(cart);
			if (listCart == null) {
			    // Nếu giỏ hàng chưa tồn tại trong session, tạo mới
			    listCart = new ArrayList<>();
				

			}
			
			// Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
			boolean productExists = false;
			for (Cart existingCart : listCart) {
			    if (existingCart.getId() == product.getId()) {
			        // Sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng
			        existingCart.setQuantityCart(existingCart.getQuantityCart() + quantity);
			        productExists = true;
			        break;
			    }
			}

			if (!productExists) {
				cart.setQuantityCart(quantity);
			    listCart.add(cart);
			}
		    httpSession.setAttribute("listCart", listCart);
		    httpSession.setMaxInactiveInterval(1800);
		    
			resp.sendRedirect(req.getContextPath() + "/home");

		}
}
