package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.OrderDetailDto;
import model.OrderDetail;

public class OrderDetailDao {
	//Phương thức lấy toàn bộ orderdetail
		public List<OrderDetail> getAll(){
			List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
			Connection conn = DBConnection.connection();
			String sql = "select * from order_detail";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					OrderDetail orderdetail = new OrderDetail();
					orderdetail.setId(rs.getInt("id"));
					orderdetail.setPrice(rs.getDouble("price"));
					orderdetail.setQuantity(rs.getInt("quantity"));
					orderdetail.setTotal(rs.getDouble("total"));
					orderdetail.setProduct_id(rs.getInt("product_id"));
					orderdetail.setOrder_id(rs.getInt("order_id"));
					orderdetails.add(orderdetail);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orderdetails;
		}
		//Phương thức thêm mới orderdetail
		public boolean insert(OrderDetail orderdetail) {
			boolean check = false;
			Connection conn = DBConnection.connection();
			String sql = "insert into order_detail values (?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, orderdetail.getId());
				ps.setDouble(2, orderdetail.getPrice());
				ps.setInt(3, orderdetail.getQuantity());
				ps.setDouble(4, orderdetail.getTotal());
				ps.setInt(5, orderdetail.getProduct_id());
				ps.setInt(6, orderdetail.getOrder_id());
				ps.setInt(7, orderdetail.getStatus());

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
		//Phương thức lấy orderdetail theo id
		public OrderDetail getById(int id) {
			OrderDetail orderdetail = null;
			Connection conn = DBConnection.connection();
			String sql = "select * from order_detail where id = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					orderdetail = new OrderDetail();
					orderdetail.setId(rs.getInt("id"));
					orderdetail.setPrice(rs.getDouble("price"));
					orderdetail.setQuantity(rs.getInt("quantity"));
					orderdetail.setTotal(rs.getDouble("total"));
					orderdetail.setProduct_id(rs.getInt("product_id"));
					orderdetail.setOrder_id(rs.getInt("order_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orderdetail;
		}
		//Phương thức cập nhật orderdetail
		public boolean update(OrderDetail orderdetail) {
			boolean check = false;
			Connection conn =DBConnection.connection();
			String sql = "update order_detail set price = ?, quantity = ?, total= ?, product_id = ?, order_id = ? where id = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, orderdetail.getPrice());
				ps.setInt(2, orderdetail.getQuantity());
				ps.setDouble(3, orderdetail.getTotal());
				ps.setInt(4, orderdetail.getProduct_id());
				ps.setInt(5, orderdetail.getOrder_id());
				ps.setInt(6, orderdetail.getId());
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
		//Phương thức xoá orderdetail
		public void delete(int id) {
			Connection conn = DBConnection.connection();
			String sql = "delete from order_detail where id = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Phương thức lấy orderdetail theo id
				public List<OrderDetailDto> getOrderDetailByUser(int id) {
					List<OrderDetailDto> orderDetailDtos = new ArrayList<OrderDetailDto>();
					Connection conn = DBConnection.connection();
					String sql;
					if(id == 0) {
						 sql = "SELECT od.id,od.product_id,od.price,od.quantity,od.total,od.order_id,o.user_id,o.orderdate,o.`status`,o.fullname,o.phonenumber,o.address,o.email,o.total as total_order,p.name_product,p.thumbail\r\n"
						 		+ "FROM  order_detail as od\r\n"
						 		+ "LEFT JOIN orders as o ON o.order_id = od.order_id\r\n"
						 		+ "LEFT JOIN product as p ON od.product_id = p.product_id\r\n";
						 	
							}
					else {
						sql = "SELECT od.id,od.product_id,od.price,od.quantity,od.total,od.order_id,o.user_id,o.orderdate,o.`status`,o.fullname,o.phonenumber,o.address,o.email,o.total as total_order,p.name_product,p.thumbail\r\n"
								+ "FROM  order_detail as od\r\n"
								+ "LEFT JOIN orders as o ON o.order_id = od.order_id\r\n"
								+ "LEFT JOIN product as p ON od.product_id = p.product_id\r\n"
								+ "where o.user_id=?";
					}
				
					try {
						PreparedStatement ps = conn.prepareStatement(sql);
						if(id!=0) {						
							ps.setInt(1, id);
						};
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							OrderDetailDto orderDetailDto = new OrderDetailDto();
							orderDetailDto.setId(rs.getInt("id"));
							orderDetailDto.setPrice(rs.getLong("price"));
							orderDetailDto.setQuantity(rs.getInt("quantity"));
							orderDetailDto.setTotal(rs.getLong("total"));
							orderDetailDto.setProduct_id(rs.getInt("product_id"));
							orderDetailDto.setOrder_id(rs.getInt("order_id"));
							orderDetailDto.setUser_id(rs.getInt("user_id"));
							orderDetailDto.setName_product(rs.getString("name_product"));
							orderDetailDto.setOrderDate(LocalDate.parse((rs.getDate("orderdate")).toString()));
							orderDetailDto.setStatus_order(rs.getInt("status"));
							orderDetailDto.setFullname(rs.getString("fullname"));
							orderDetailDto.setNumberphone(rs.getString("phonenumber"));
							orderDetailDto.setAddress(rs.getString("address"));
							orderDetailDto.setEmail(rs.getString("email"));
							orderDetailDto.setTotal_order(rs.getLong("total_order"));
							orderDetailDto.setThumbail(rs.getString("thumbail"));
							orderDetailDtos.add(orderDetailDto);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return orderDetailDtos;
				}
}
