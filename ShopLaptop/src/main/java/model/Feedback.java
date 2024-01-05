package model;

import java.sql.Date;
import java.time.LocalDate;

public class Feedback {
	private int id;
	private String name;
	private String email;
	private String subject;
	private String message;
	private LocalDate created_at;
	private int status;
	private int rating;
	private int product_id;
	private int user_id;
	public Feedback() {
		super();
	}
	public Feedback(int id, String name, String email, String subject, String message, LocalDate created_at, int status,
			int rating, int product_id, int user_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.created_at = created_at;
		this.status = status;
		this.rating = rating;
		this.product_id = product_id;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + ", created_at=" + created_at + ", status=" + status + ", rating=" + rating + ", product_id="
				+ product_id + ", user_id=" + user_id + "]";
	}
	
}
