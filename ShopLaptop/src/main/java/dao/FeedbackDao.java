package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Feedback;
import model.Order;
import model.Product;

public class FeedbackDao {

	//Phương thức lấy toàn bộ order
			public List<Feedback> getAll(){
				List<Feedback> feedbacks = new ArrayList<>();
				Connection conn = DBConnection.connection();
				String sql = "select * from feedback";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Feedback feedback = new Feedback();
						feedback.setId(rs.getInt("feedback_id"));
						feedback.setName(rs.getString("feedback_name"));
						feedback.setEmail(rs.getString("email"));
						feedback.setSubject(rs.getString("feedback_subject"));
						feedback.setCreated_at(LocalDate.parse(( rs.getDate("create_at").toString())));
						feedback.setMessage(rs.getString("message"));
						feedback.setStatus(rs.getInt("status"));
						feedback.setRating(rs.getInt("rating"));
						feedback.setUser_id(rs.getInt("user_id"));
						feedback.setProduct_id(rs.getInt("product_id"));
						feedbacks.add(feedback);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return feedbacks;
			}

			public static boolean addFeedback(Feedback feedback){
				try {
					Connection connection=DBConnection.connection();
					String sql="INSERT INTO feedback ( feedback_name,email, feedback_subject, message, rating, create_at,status, user_id,product_id) "
							+ "VALUES (?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setString(1,feedback.getName());
					preparedStatement.setString(2,feedback.getEmail());
					preparedStatement.setString(3,feedback.getSubject());
					preparedStatement.setString(4,feedback.getMessage());
					preparedStatement.setInt(5,feedback.getRating());
					preparedStatement.setDate(6, Date.valueOf(feedback.getCreated_at()));
					preparedStatement.setInt(7, feedback.getStatus());
					preparedStatement.setInt(8, feedback.getUser_id());
					preparedStatement.setInt(9, feedback.getProduct_id());


					return preparedStatement.executeUpdate()==1;			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return false;
				
				
			}

			//Phương thức lấy toàn bộ order
					public List<Feedback> getAllByProductId(int id){
						List<Feedback> feedbacks = new ArrayList<>();
						Connection conn = DBConnection.connection();
						String sql = "select * from feedback where product_id=? and status=1";
						try {
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, id);
							ResultSet rs = ps.executeQuery();
							while(rs.next()) {
								Feedback feedback = new Feedback();
								feedback.setId(rs.getInt("feedback_id"));
								feedback.setName(rs.getString("feedback_name"));
								feedback.setEmail(rs.getString("email"));
								feedback.setSubject(rs.getString("feedback_subject"));
								feedback.setCreated_at(LocalDate.parse(( rs.getDate("create_at").toString())));
								feedback.setMessage(rs.getString("message"));
								feedback.setStatus(rs.getInt("status"));
								feedback.setRating(rs.getInt("rating"));
								feedback.setUser_id(rs.getInt("user_id"));
								feedback.setProduct_id(rs.getInt("product_id"));

								feedbacks.add(feedback);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return feedbacks;
					}
			//Phương thức xoá order
			public void delete(int id) {
				Connection conn = DBConnection.connection();
				String sql = "delete from feedback where id = ?";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 * @Override public void delete(int id) { String sql =
			 * "DELETE FROM review WHERE id=?"; Connection con = connectDB.getConnect(); try
			 * { PreparedStatement ps = con.prepareStatement(sql); ps.setInt(1, id);
			 * ps.executeUpdate(); } catch (SQLException e) { e.printStackTrace(); } }
			 * 
			 * @Override public Review get(int id) { // TODO Auto-generated method stub
			 * return null; }
			 * 
			 * @Override public Review get(String name) { // TODO Auto-generated method stub
			 * return null; }
			 * 
			 * 
			 * 
			 * @Override public List<Review> getReviewById(int id) { List<Review> reviews =
			 * new ArrayList<Review>(); String sql =
			 * "SELECT * FROM review WHERE product_id=?"; Connection con =
			 * connectDB.getConnect(); try { PreparedStatement ps =
			 * con.prepareStatement(sql); ps.setInt(1, id); ResultSet rs =
			 * ps.executeQuery();
			 * 
			 * while(rs.next()) { Review review = new Review();
			 * review.setId(rs.getString("id")); review.setName(rs.getString("name"));
			 * review.setEmail(rs.getString("email"));
			 * review.setProduct_id(rs.getString("product_id"));
			 * review.setContent(rs.getString("content"));
			 * review.setCreated(rs.getString("created")); reviews.add(review); } } catch
			 * (SQLException e) { e.printStackTrace(); } return reviews; }
			 */
}
