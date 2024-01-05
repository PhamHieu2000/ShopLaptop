package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import model.Category;

public class CategoryDao {
	public static List<Category> getAllCategory() {
		List<Category> listCategory=new ArrayList<>();
		try {
			Connection connection=DBConnection.connection();
			String sql="SELECT * FROM category";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				Category category=new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				listCategory.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listCategory;
		
	}
}
