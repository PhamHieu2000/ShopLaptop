package model;

public class OrderDetail {
	private int id;
	private double price;
	private int quantity;
	private double total;
	private int product_id;
	private int order_id;
	private int status;
	public OrderDetail() {
		super();
	}
	public OrderDetail(int id, double price, int quantity, double total, int product_id, int order_id, int status) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.product_id = product_id;
		this.order_id = order_id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", price=" + price + ", quantity=" + quantity + ", total=" + total
				+ ", product_id=" + product_id + ", order_id=" + order_id + ", status=" + status + "]";
	}
	
	
}
