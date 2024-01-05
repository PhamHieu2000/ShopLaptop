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

import model.Cart;
@WebServlet(urlPatterns = {"/deleteProductToCart"})

public class DeleteProductToCart extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			  req.setCharacterEncoding("UTF-8");

		        int id = Integer.parseInt(req.getParameter("id"));
		        HttpSession httpSession = req.getSession();
		        List<Cart> listCart = (ArrayList<Cart>) httpSession.getAttribute("listCart");

		        if (listCart != null && listCart.size() > 0) {
		            List<Cart> updatedList = new ArrayList<>();

		            for (Cart cart : listCart) {
		                if (cart.getId() != id) {
		                    updatedList.add(cart);
		                }
		            }

		            httpSession.setAttribute("listCart", updatedList);
		            System.out.println("done");
		        }

		        resp.sendRedirect(req.getContextPath() + "/showcart");

		}
}
