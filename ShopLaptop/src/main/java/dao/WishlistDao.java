package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.WishlistProductDto;
import model.Wishlist;

public class WishlistDao {
	//Phương thức lấy toàn bộ yêu thích
		public List<WishlistProductDto> getAllByUserId(int user_id){
			List<WishlistProductDto> wishlists = new ArrayList<>();
			Connection connection=DBConnection.connection();
			String sql = "select wl.id,wl.product_id,wl.user_id,p.name_product,p.price,p.discount,p.category_id,p.thumbail from wishlist as wl left join product as p on wl.product_id=p.product_id where wl.user_id="+user_id;
			try {
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					WishlistProductDto wishlist = new WishlistProductDto();
					wishlist.setWishlist_id(rs.getInt("id"));
					wishlist.setProduct_id(rs.getInt("product_id"));
					wishlist.setUser_id(rs.getInt("user_id"));
					wishlist.setName_product(rs.getString("name_product"));
					wishlist.setPrice(rs.getLong("price"));
					wishlist.setDiscount(rs.getLong("discount"));
					wishlist.setCategory_id(rs.getInt("category_id"));
					wishlist.setThumbnail(rs.getString("thumbail"));
					wishlists.add(wishlist);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return wishlists;
		}
		//Phương thức thêm mới yêu thích
		public boolean insert(Wishlist wishlist) {
			boolean check = false;
			Connection conn = DBConnection.connection();
			String sql = "INSERT INTO wishlist (product_id, user_id) VALUES (?, ?);";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, wishlist.getProduct_id());
				ps.setInt(2, wishlist.getUser_id());
				int row = ps.executeUpdate();
				if(row > 0) {
					check = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}


		public void delete(int id) {
			Connection conn = DBConnection.connection();
			String sql = "delete from wishlist where id = ?";
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
