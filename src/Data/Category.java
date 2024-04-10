package Data;

import java.io.Serializable;

import Common.Constant;

public class Category implements Serializable {

	public Category l, r;

	static Constant ct = new Constant();

	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String ID, name;
	public Category nextLink;

	public Category(String name) {
		super();
		this.ID = ct.getSaltString();
		this.name = name;
		this.nextLink = null;
		this.l = null;
		this.r = null;
	}

	public Category() {
		super();
	}
}
