package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeedbackDao;
import model.Feedback;
import model.User;
@WebServlet(urlPatterns = {"/addreview"})

public class AddReviewController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		Feedback feedback=new Feedback();
		HttpSession httpSession=req.getSession();
		User user=(User)httpSession.getAttribute("user");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String review=req.getParameter("review");
		int rating=Integer.parseInt(req.getParameter("rating"));
		LocalDate  create_at= LocalDate.now();
		int status=1;
		int product_id=Integer.parseInt(req.getParameter("product_id"));
		int user_id=user.getId();
		feedback.setCreated_at(create_at);
		feedback.setEmail(email);
		feedback.setMessage(review);
		feedback.setProduct_id(product_id);
		feedback.setRating(rating);
		feedback.setStatus(status);
		feedback.setName(name);
		feedback.setUser_id(user_id);
		FeedbackDao feedbackDao=new FeedbackDao();
		feedbackDao.addFeedback(feedback);
		resp.sendRedirect(req.getContextPath() + "/product?id="+product_id);

		
		

	}
}	