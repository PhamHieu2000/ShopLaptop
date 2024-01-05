package model;

import java.time.LocalDate;

public class Cart extends Product{
	private int quantityCart;//số lượng

	public Cart() {
	}

	public Cart(int id, String name, String short_description, long price, long discount, int quantity,
			String thumbnail, String description, int is_featured, int status, int category_id, LocalDate create_at,
			LocalDate update_at, int quantityCart) {
		super(id, name, short_description, price, discount, quantity, thumbnail, description, is_featured, status,
				category_id, create_at, update_at);
		this.quantityCart = quantityCart;
	}

	public int getQuantityCart() {
		return quantityCart;
	}

	public void setQuantityCart(int quantityCart) {
		this.quantityCart = quantityCart;
	}

	@Override
	public String toString() {
		return "Cart [quantityCart=" + quantityCart + ", product_id=" + getId() + ", name=" + getName()
				+ ", short_description=" + getShort_description() + ",price=" + getPrice()
				+ ",discount=" + getDiscount() + ",quantity=" + getQuantity() + ",thumbnail="
				+ getThumbnail() + ", description=" + getDescription() + ", is_featured=" + getIs_featured()
				+ ", status=" + getStatus() + ", category_id=" + getCategory_id() + ", create_at="
				+ getCreate_at() + ", update_at=" + getUpdate_at() + ", toString()=" + super.toString();
	}
	
	
}
