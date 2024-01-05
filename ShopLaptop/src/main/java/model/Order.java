package model;

import java.sql.Date;
import java.time.LocalDate;

public class Order {
	private int id;
	private String fullname;
	private String email;
	private String phonenumber;
	private String address;
	private String note;
	private LocalDate orderdate;
	private int status;
	private double total;
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Order(int id, String fullname, String email, String phonenumber, String address, String note, LocalDate orderdate,
			int status, double total, int user_id) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.note = note;
		this.orderdate = orderdate;
		this.status = status;
		this.total = total;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", fullname=" + fullname + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", address=" + address + ", note=" + note + ", orderdate=" + orderdate + ", status=" + status
				+ ", total=" + total + ", user_id=" + user_id + "]";
	}
	public Order() {
		super();
	}
	
}	