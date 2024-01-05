package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Galery;

public class GaleryDao {
	public static boolean addGalery(Galery galery) {
		try {
			Connection connection=DBConnection.connection();
			String sql="INSERT INTO galery (thumbail,product_id ) "
					+ "VALUES (?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,galery.getThumbnail());
			preparedStatement.setInt(2,galery.getProduct_id());
		
			return preparedStatement.executeUpdate()==1;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
}
