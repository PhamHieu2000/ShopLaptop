package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.User;

public class UserDao {
	public static List<User> getAllUser() {
		List<User> users=new ArrayList<>();
		try {
			Connection connection=DBConnection.connection();
			String sql="SELECT * FROM user where user_status=1";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt(1));
				user.setFullname((rs.getString(2)));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhonenumber(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole_id(rs.getInt(8));
				user.setStatus(rs.getInt(9));
				users.add(user);
				
			}
			System.out.println(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		
	}
	
	
	public static boolean addUser(User user){
		try {
			Connection connection=DBConnection.connection();
			String sql="INSERT INTO user (fullname,user_name,user_password,user_email,phonenumber,address,role_id,user_status) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getFullname());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getPhonenumber());
			preparedStatement.setString(6,user.getAddress());
			preparedStatement.setInt(7,user.getRole_id());
			preparedStatement.setInt(8,user.getStatus());
		
			return preparedStatement.executeUpdate()==1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	public static User getUserById(int id) {
		User user=new User();
		try {
			Connection connection=DBConnection.connection();
			String sql="SELECT * FROM user where user_id=? and user_status=1";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFullname((rs.getString(2)));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhonenumber(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole_id(rs.getInt(8));
				user.setStatus(rs.getInt(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
		
	}
	public static boolean updateUser(User user){
		try {
			Connection connection=DBConnection.connection();
			String sql="UPDATE user SET fullname=?,user_name=?,user_password=?,user_email=?,phonenumber=?,address=?,role_id=?,user_status=? where user_id=? ";
				
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getFullname());
			preparedStatement.setString(2,user.getUsername());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setString(5,user.getPhonenumber());
			preparedStatement.setString(6,user.getAddress());
	        preparedStatement.setInt(7, user.getRole_id());
	        preparedStatement.setInt(8, user.getStatus());
	        preparedStatement.setInt(9, user.getId());

			return preparedStatement.executeUpdate()==1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}

	/*
	 * public static User getProductById(int id) { try { Connection
	 * connection=DBConnection.connection(); String
	 * sql="SELECT * FROM product where product_id="+id; PreparedStatement
	 * preparedStatement=connection.prepareStatement(sql); ResultSet
	 * rs=preparedStatement.executeQuery(); Product product=new Product();
	 * if(rs.next()) { product.setId(rs.getInt(1));
	 * product.setName(rs.getString(2));
	 * product.setShort_description(rs.getString(3));
	 * product.setPrice(rs.getLong(4)); product.setDiscount(rs.getLong(5));
	 * product.setQuantity(rs.getInt(6)); product.setDescription(rs.getString(7));
	 * product.setIs_featured(rs.getInt(8)); product.setStatus(rs.getInt(9));
	 * product.setCreate_at(LocalDate.parse((rs.getDate(10)).toString()));
	 * product.setUpdate_at(LocalDate.parse((rs.getDate(11)).toString()));
	 * product.setCategory_id(rs.getInt(12));
	 * product.setThumbnail(rs.getString(13));
	 * 
	 * } return product; } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return null;
	 * 
	 * }
	 */
	
	//Phương thức xóa loại sản phẩm
		public void delete(int id) {
			Connection conn = DBConnection.connection();
			String sql = "UPDATE user SET user_status=2 where user_id=3\r\n";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
