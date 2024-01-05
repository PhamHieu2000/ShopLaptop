package dto;

import java.time.LocalDate;

public class OrderDetailDto {
	int id;
	int product_id;
	long price;
	int quantity;
	long total;
	int order_id;
	int user_id;
	LocalDate orderDate;
	int status_order;
	String name_product;
	String thumbail;
	String fullname;
	String numberphone;
	String address;
	String email;
	Long total_order;
	public OrderDetailDto() {
		super();
	}
	public OrderDetailDto(int id, int product_id, long price, int quantity, long total, int order_id, int user_id,
			LocalDate orderDate, int status_order, String name_product, String thumbail, String fullname,
			String numberphone, String address, String email, Long total_order) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.order_id = order_id;
		this.user_id = user_id;
		this.orderDate = orderDate;
		this.status_order = status_order;
		this.name_product = name_product;
		this.thumbail = thumbail;
		this.fullname = fullname;
		this.numberphone = numberphone;
		this.address = address;
		this.email = email;
		this.total_order = total_order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getStatus_order() {
		return status_order;
	}
	public void setStatus_order(int status_order) {
		this.status_order = status_order;
	}
	public String getName_product() {
		return name_product;
	}
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	public String getThumbail() {
		return thumbail;
	}
	public void setThumbail(String thumbail) {
		this.thumbail = thumbail;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNumberphone() {
		return numberphone;
	}
	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTotal_order() {
		return total_order;
	}
	public void setTotal_order(Long total_order) {
		this.total_order = total_order;
	}
	@Override
	public String toString() {
		return "OrderDetailDto [id=" + id + ", product_id=" + product_id + ", price=" + price + ", quantity=" + quantity
				+ ", total=" + total + ", order_id=" + order_id + ", user_id=" + user_id + ", orderDate=" + orderDate
				+ ", status_order=" + status_order + ", name_product=" + name_product + ", thumbail=" + thumbail
				+ ", fullname=" + fullname + ", numberphone=" + numberphone + ", address=" + address + ", email="
				+ email + ", total_order=" + total_order + "]";
	}
	
	
}
