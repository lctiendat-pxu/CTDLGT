package Data;

import Common.Constant;

public class Product {
	private String ID, name, description, unit;

	static Constant ct = new Constant();

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private int price, quantity;
	public Product nextLink;

	public Product(String name, String description, String unit, int price, int quantity, String categoryID) {
		super();
		this.ID = ct.getSaltString();
		this.name = name;
		this.description = description;
		this.unit = unit;
		this.price = price;
		this.quantity = quantity;
		this.CategoryID = categoryID;
		this.nextLink = null;
	}

	private String CategoryID;

	public String getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}

	public Product() {
		super();
	}

}
